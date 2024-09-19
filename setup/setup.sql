DROP TABLE IF EXISTS price;

DROP TABLE IF EXISTS variety;

DROP TABLE IF EXISTS price_history;

DROP TABLE IF EXISTS item;

DROP TABLE IF EXISTS unit;

CREATE TABLE
    unit (id BIGINT PRIMARY KEY, name varchar(255) NOT NULL);

CREATE TABLE
    item (
        id BIGINT PRIMARY KEY,
        unit_id BIGINT,
        name varchar(255) NOT NULL,
        FOREIGN KEY (unit_id) REFERENCES unit (id)
    );

CREATE TABLE
    price_history (
        id BIGINT PRIMARY KEY,
        item_id BIGINT UNIQUE NOT NULL,
        FOREIGN KEY (item_id) REFERENCES item (id)
    );

CREATE TABLE
    variety (
        id BIGINT PRIMARY KEY,
        price_history BIGINT,
        active BOOLEAN DEFAULT TRUE,
        amount FLOAT,
        color VARCHAR,
        name VARCHAR,
        FOREIGN KEY (price_history) REFERENCES price_history (id)
    );

CREATE TABLE
    price (
        id BIGINT PRIMARY KEY,
        variety BIGINT,
        value FLOAT,
        since DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (variety) REFERENCES variety (id)
    );