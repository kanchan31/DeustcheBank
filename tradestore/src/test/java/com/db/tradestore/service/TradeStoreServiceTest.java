package com.db.tradestore.service;

import com.db.tradestore.dto.Trade;
import com.db.tradestore.repository.TradeStoreRepository;
import com.db.tradestore.service.TradeStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TradeStoreServiceTest {

    @Autowired
    TradeStoreService tradeStoreService;
    @Autowired
    CSVReaderService csvReaderService;


    @Test
    public void checkVersion()
    {
        String tradeId="T1";
        int version=100;

        Boolean verValid= tradeStoreService.checkVersionValid("T1",version);
        Assert.assertTrue(verValid);

    }

    @Test
    public void checkVersion1()
    {
        String tradeId="T1";
        int version=1;

        Boolean verValid= tradeStoreService.checkVersionValid("T1",version);
        Assert.assertFalse(verValid);

    }

    @Test
    public void checkMaturityDate() throws ParseException {
        Trade trade=new Trade();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf1.parse("2025-05-10");
        trade.setMaturityDate( new java.sql.Date(date.getTime()));
        Boolean dateValid= tradeStoreService.checkMaturity(trade.getMaturityDate());
        Assert.assertTrue(dateValid);

    }
    @Test
    public void checkMaturityDate1() throws ParseException {
        Trade trade=new Trade();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf1.parse("2015-05-10");
        trade.setMaturityDate( new java.sql.Date(date.getTime()));
        Boolean dateValid= tradeStoreService.checkMaturity(trade.getMaturityDate());
        Assert.assertFalse(dateValid);

    }
}
