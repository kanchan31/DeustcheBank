package com.db.tradestore.repository;

import com.db.tradestore.dto.Trade;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TradeStoreRepository extends JpaRepository<Trade,String> {

public Optional<Trade> findByTradeId(String TradeId);
@Query("select max(t.version) from Trade t where t.tradeId=?1")
public int findVersionByTradeId( String tradeId);

@Transactional
@Modifying
@Query("update Trade t set t.Expired='Y' where t.maturityDate<?1")
public void updateExpiredStatus(Date today);
}