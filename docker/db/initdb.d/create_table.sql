DROP TABLE IF EXISTS user_service.users;

CREATE TABLE user_service.users
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL ,

    PRIMARY KEY (id)
);