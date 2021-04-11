package com.db.tradestore.service;
import com.db.tradestore.dto.Trade;
import com.db.tradestore.repository.TradeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan("com.db.tradestore.*")
public class TradeStoreServiceImpl implements TradeStoreService {

    @Autowired
    CSVReaderService cSVReaderService;
    @Autowired
    TradeStoreRepository tradeStoreRepository;
    @Override
    @Transactional
    public void processTradeStore()
    {
        List<Trade> tradeList=cSVReaderService.readCSVToBean();
        List<Trade> validTradeList=new ArrayList<>();
        List<Trade> invalidTradeList=new ArrayList<>();;
        for(Trade trade :tradeList) {
            if (checkVersionValid(trade.getTradeId(), trade.getVersion()) && checkMaturity(trade.getMaturityDate())) {
                validTradeList.add(trade);
            } else
                invalidTradeList.add(trade);
        }
      save(validTradeList);
        processTradeExpired();
        for(Trade t:invalidTradeList)
        System.out.println("Could not process Trade="+t.getTradeId()+" due to lower version or old maturity date");
    }
    @Override
    public Boolean checkVersionValid(String tradeId,int version)
    {
      int version1=tradeStoreRepository.findVersionByTradeId(tradeId);
        if(version>version1)
            return true;
        else
            return false;
    }

    @Override
    public Boolean checkMaturity(Date maturityDate)
    {
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
       if(maturityDate.compareTo(today)>0)
           return true;
       else
           return false;
    }
    @Override
    public void save(List<Trade> tradeList)
    {
            tradeStoreRepository.saveAll(tradeList);

    }

    @Override
    public void processTradeExpired()
    {
        java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        tradeStoreRepository.updateExpiredStatus(today);
    }
}
