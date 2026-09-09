CREATE TABLE recruiters
(
    id         VARCHAR(255) NOT NULL,
    email      VARCHAR(255),
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    password   VARCHAR(255),
    role_id    BIGINT,
    CONSTRAINT pk_recruiters PRIMARY KEY (id)
);

ALTER TABLE recruiters
    ADD CONSTRAINT uc_recruiters_email UNIQUE (email);

ALTER TABLE recruiters
    ADD CONSTRAINT FK_RECRUITERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);