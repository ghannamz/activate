CREATE TABLE IF NOT EXISTS products(
    id varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    brand varchar(50) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS shopper_personalized_info(
    shopper_id varchar(50) NOT NULL,
	product_id varchar(50) NOT NULL,
    relevancy_score decimal(20, 17) NOT NULL,
    PRIMARY KEY (shopper_id, product_id)
);
