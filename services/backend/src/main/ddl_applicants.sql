CREATE TABLE applicants
(
    id         VARCHAR(255) NOT NULL,
    email      VARCHAR(255),
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    password   VARCHAR(255),
    role_id    BIGINT,
    CONSTRAINT pk_applicants PRIMARY KEY (id)
);

ALTER TABLE applicants
    ADD CONSTRAINT uc_applicants_email UNIQUE (email);

ALTER TABLE applicants
    ADD CONSTRAINT FK_APPLICANTS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (id);