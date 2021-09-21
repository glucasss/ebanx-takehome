DROP TABLE IF EXISTS account;

CREATE TABLE account (
  account_id INT PRIMARY KEY,
  balance DECIMAL(20,2)
);

INSERT INTO account VALUES (1, 1.100);