CREATE TABLE IF NOT EXISTS price
(
    id           bigserial,
    create_date  timestamp NOT NULL,
    update_date  timestamp NOT NULL,
    product_code varchar   NOT NULL,
    number       int       NOT NULL,
    depart       int       NOT NULL,
    begin_date    timestamp NOT NULL,
    end_date      timestamp NOT NULL,
    price        int       NOT NULL,
    PRIMARY KEY (id)
);