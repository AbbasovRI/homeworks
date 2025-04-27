CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    fio VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES users(id),
    order_date TIMESTAMP NOT NULL,
    total_orders BIGINT NOT NULL,
    discount DECIMAL(5,2)
);