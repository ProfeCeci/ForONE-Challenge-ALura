CREATE TABLE users (
    id BIGSERIAL NOT NULL,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (login, password) VALUES ('admin', '$2a$10$3JDR.Lp1q.CdbJp2i.s2.O.s.g.g.g.g.g.g.g.g.g.g.g.g.g.g.g');
