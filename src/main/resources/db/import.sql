INSERT INTO user_accounts (id, username, password, first_name, last_name, date, enabled) VALUES
('1', 'admin', '$2y$12$kjBEvSNH8oN9508Vi8gpLOxzxsfc7H/HLRTQatlR4z3JOzrC4YXB6', 'Ivan','Ivanov', '2021-05-31','1');
INSERT INTO user_accounts (id, username, password, first_name, last_name, date, enabled) VALUES
('2', 'user', '$2y$12$AhvCEcvgmaTNoupsdpUuNuCrmP6i.kdzb9iumHh14XSuUyCjHyjYW', 'Petr','Petrov', '2021-05-31', '1');

INSERT INTO roles (id, name) VALUES( '1', 'USER');
INSERT INTO roles (id, name) VALUES( '2', 'ADMIN');

INSERT INTO user_roles (user_id, role_id) VALUES('1', '2');
INSERT INTO user_roles (user_id, role_id) VALUES('2', '1');