DROP TABLE Trade IF EXISTS;

CREATE TABLE Trade (
                       TradeId VARCHAR(20)  NOT NULL PRIMARY KEY,
                       Version int,
                       CounterPartId VARCHAR(20),
                       BookId VARCHAR(20),
                       MaturityDate date,
                       CreatedDate date,
                       Expired char(1)
);

INSERT INTO Trade(TradeId,Version,CounterPartId,BookId,MaturityDate,CreatedDate,Expired)
VALUES ('T1',1,'CP-1','B1','2020-05-20',sysdate,'N');