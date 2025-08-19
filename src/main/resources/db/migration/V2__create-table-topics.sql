CREATE TABLE topics (
    id BIGSERIAL NOT NULL,
    title VARCHAR(100) NOT NULL,
    message VARCHAR(300) NOT NULL,
    creation_date VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL,
    author VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);
