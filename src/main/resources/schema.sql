DROP TABLE if EXISTS application_users;
DROP TABLE IF EXISTS Assets;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS  assignment;
CREATE TABLE application_users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    pesel      VARCHAR(255),
    CONSTRAINT pk_application_users PRIMARY KEY (id)
);
ALTER TABLE application_users
    ADD CONSTRAINT uc_application_users_pesel UNIQUE (pesel);
CREATE TABLE Assets
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(40),
    description   VARCHAR(255),
    serial_number VARCHAR(20),
    category_id   BIGINT,
    PRIMARY KEY (id)
);
CREATE TABLE category
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(40),
    description VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER TABLE Assets
    ADD CONSTRAINT FK_INVENTORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);
CREATE TABLE assignment
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    start_of_assignment TIMESTAMP,
    end_of_assignment   TIMESTAMP,
    user_id             BIGINT,
    asset_id            BIGINT,
    CONSTRAINT pk_assignment PRIMARY KEY (id)
);

ALTER TABLE assignment
    ADD CONSTRAINT FK_ASSIGNMENT_ON_ASSET FOREIGN KEY (asset_id) REFERENCES assets (id);

ALTER TABLE assignment
    ADD CONSTRAINT FK_ASSIGNMENT_ON_USER FOREIGN KEY (user_id) REFERENCES application_users (id);

