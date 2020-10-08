CREATE TABLE clients
(
    login    VARCHAR(255)   NOT NULL,
    password VARCHAR(255)   NOT NULL,
    balance  DECIMAL(20, 2) NOT NULL DEFAULT 0,
    PRIMARY KEY (login)
);
