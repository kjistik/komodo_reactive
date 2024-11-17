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
        active BOOLEAN,
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
CREATE OR REPLACE FUNCTION insert_price_history()
RETURNS TRIGGER AS $$
BEGIN
    -- Insert into price_history with the newly inserted item's ID
    INSERT INTO price_history (id, item_id)
    VALUES (uuid_generate_v4(), NEW.id);  -- `NEW.id` is the ID of the newly inserted item
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_price_history_trigger
AFTER INSERT ON item
FOR EACH ROW
EXECUTE FUNCTION insert_price_history();

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
