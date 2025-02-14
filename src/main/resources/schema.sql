CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DOUBLE,
    category VARCHAR(255),
    stockQuantity INT
);

CREATE TABLE customer (
    id BIGINT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(255)
);

CREATE TABLE order_table (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT,
    orderStatus VARCHAR(255),
    totalAmount DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE product_order (
    order_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES order_table(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
