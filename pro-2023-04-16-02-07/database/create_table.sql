USE pro_2023_04_16_02_07;

CREATE TABLE role(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
code VARCHAR(255) NOT NULL,
createdDate TIMESTAMP NULL,
modifiedDate TIMESTAMP NULL,
createdBy VARCHAR(255) NULL,
modifiedBy VARCHAR(255) NULL
);

CREATE TABLE user(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NULL,
email VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
address VARCHAR(1000) NULL,
phone int NULL,
status int NOT NULL,
createdDate TIMESTAMP NULL,
modifiedDate TIMESTAMP NULL,
createdBy VARCHAR(255) NULL,
modifiedBy VARCHAR(255) NULL
);

CREATE TABLE user_role(
roleId bigint NOT NULL,
userId bigint NOT NULL
);

ALTER TABLE user_role ADD CONSTRAINT fk_userrole_role FOREIGN KEY (roleId) REFERENCES role(id);
ALTER TABLE user_role ADD CONSTRAINT fk_userrole_user FOREIGN KEY (userId) REFERENCES user(id);

CREATE TABLE category(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NULL,
createdDate TIMESTAMP NULL,
modifiedDate TIMESTAMP NULL,
createdBy VARCHAR(255) NULL,
modifiedBy VARCHAR(255) NULL
);

CREATE TABLE product(
id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NULL,
categoryId bigint NOT NULL,
price int NOT NULL,
status int NULL,
createdDate TIMESTAMP NULL,
modifiedDate TIMESTAMP NULL,
createdBy VARCHAR(255) NULL,
modifiedBy VARCHAR(255) NULL
);

ALTER TABLE product ADD CONSTRAINT fk_product_category FOREIGN KEY (categoryId) REFERENCES category(id);