package com.db.tradestore.dto;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="TRADE")
public class Trade{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="trade_Id")
    private String tradeId;

    @Column(name="version")
    private int version;
    @Column(name="counter_Party_Id")
    private String counterPartyId;
    @Column(name="book_Id")
    private String bookId;
    @Column(name="maturity_Date")
    private Date maturityDate;
    @Column(name="created_Date")
    private Date createdDate;
    @Column(name="expired")
    private char Expired;


    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public char getExpired() {
        return Expired;
    }

    public void setExpired(char expired) {
        Expired = expired;
    }
}
