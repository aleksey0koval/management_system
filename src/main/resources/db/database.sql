CREATE TABLE user_accounts(
id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(45) NOT NULL,
password VARCHAR(255) NOT NULL,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
date DATE NOT NULL,
enabled TINYINT(1) NOT NULL,
PRIMARY KEY (id)
)
ENGINE = InnoDB;

INSERT INTO user_accounts VALUES
(1, 'admin', '$2y$12$kjBEvSNH8oN9508Vi8gpLOxzxsfc7H/HLRTQatlR4z3JOzrC4YXB6', 'Ivan','Ivanov', '2021-05-31','1');
INSERT INTO user_accounts VALUES
(2, 'user', '$2y$12$AhvCEcvgmaTNoupsdpUuNuCrmP6i.kdzb9iumHh14XSuUyCjHyjYW', 'Petr','Petrov', '2021-05-31', '1');


CREATE TABLE roles(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
PRIMARY KEY (id)
)
ENGINE = InnoDB;

INSERT INTO roles VALUES( 1, 'USER');
INSERT INTO roles VALUES( 2, 'ADMIN');


CREATE TABLE user_roles(
user_id INT NOT NULL,
role_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_accounts (id),
FOREIGN KEY (role_id) REFERENCES roles (id)
)
ENGINE = InnoDB;

INSERT INTO user_roles VALUES(1, 2);
INSERT INTO user_roles VALUES(2, 1);