package com.db.tradestore.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import com.db.tradestore.dto.Trade;
import org.springframework.stereotype.Service;

@Service
public class CSVReaderService {

    public static final Map<Integer, String> carIdsInvalidList = new HashMap<Integer, String>();


    protected List<Trade> readCSVToBean() {
        List<Trade> tradeList = new ArrayList<>();
        BufferedReader fileReader = null;
        try {
            String line;
            String csvFilename = "trade-details.csv";
            ClassLoader classLoader = getClass().getClassLoader();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            int rowNum = 1;
            fileReader = new BufferedReader(new FileReader(classLoader.getResource(csvFilename).getFile()));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                if (tokens.length == 5) {
                    Trade trade = new Trade();
                    trade.setTradeId(tokens[0]);
                    trade.setVersion(Integer.parseInt(tokens[1]));
                    trade.setCounterPartyId(tokens[2]);
                    trade.setBookId(tokens[3]);
                    java.util.Date date = sdf1.parse(tokens[4]);
                    trade.setMaturityDate(new java.sql.Date(date.getTime()));
                    trade.setCreatedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                    if (trade.getMaturityDate().compareTo(trade.getCreatedDate()) > 0)
                        trade.setExpired('N');
                    else
                        trade.setExpired('Y');
                    tradeList.add(trade);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tradeList;
    }
}
