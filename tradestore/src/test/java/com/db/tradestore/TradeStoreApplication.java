package com.db.tradestore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@EnableAutoConfiguration
@DataJpaTest
class TradeStoreApplication {

    @Test
    void contextLoads() {
    }

}