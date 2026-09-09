CREATE TABLE roles
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE roles_privileges
(
    privilege_id VARCHAR(255) NOT NULL,
    role_id      BIGINT       NOT NULL
);

ALTER TABLE roles_privileges
    ADD CONSTRAINT fk_rolpri_on_privilege_entity FOREIGN KEY (privilege_id) REFERENCES privileges (id);

ALTER TABLE roles_privileges
    ADD CONSTRAINT fk_rolpri_on_role_entity FOREIGN KEY (role_id) REFERENCES roles (id);