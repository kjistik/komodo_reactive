DROP TABLE IF EXISTS price;

DROP TABLE IF EXISTS variety;

DROP TABLE IF EXISTS price_history;

DROP TABLE IF EXISTS item;

DROP TABLE IF EXISTS unit;

CREATE TABLE
    unit (id UUID PRIMARY KEY, name varchar(255) NOT NULL);

CREATE TABLE
    item (
        id UUID PRIMARY KEY,
        unit_id UUID,
        name varchar(255) NOT NULL,
        FOREIGN KEY (unit_id) REFERENCES unit (id)
    );

CREATE TABLE
    price_history (
        id UUID PRIMARY KEY,
        item_id UUID UNIQUE NOT NULL,
        FOREIGN KEY (item_id) REFERENCES item (id)
    );

CREATE TABLE
    variety (
        id UUID PRIMARY KEY,
        price_history UUID,
        active BOOLEAN DEFAULT TRUE,
        amount FLOAT,
        color VARCHAR,
        name VARCHAR,
        FOREIGN KEY (price_history) REFERENCES price_history (id)
    );

CREATE TABLE
    price (
        id UUID PRIMARY KEY,
        variety UUID,
        value FLOAT,
        since DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (variety) REFERENCES variety (id)
    );