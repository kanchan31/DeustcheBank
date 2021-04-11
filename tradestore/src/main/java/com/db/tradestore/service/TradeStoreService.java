package com.db.tradestore.service;

import com.db.tradestore.dto.Trade;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public interface TradeStoreService {

    public void processTradeStore();
    public Boolean checkVersionValid(String tradeId,int version);
    public Boolean checkMaturity(Date maturityDate);
    public void save(List<Trade> tradeList);
    public void processTradeExpired();
}
