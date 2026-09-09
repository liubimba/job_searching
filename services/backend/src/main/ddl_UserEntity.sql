CREATE TABLE users
(
    id         BIGINT NOT NULL,
    email      VARCHAR(255),
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    password   VARCHAR(255),
    role_id    BIGINT,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);