DROP TABLE Trade IF EXISTS;

CREATE TABLE Trade (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       Trade_Id VARCHAR(20)  NOT NULL ,
                       Version int,
                       Counter_Party_Id VARCHAR(20),
                       Book_Id VARCHAR(20),
                       Maturity_Date date,
                       Created_Date date,
                       Expired char(1)
);
