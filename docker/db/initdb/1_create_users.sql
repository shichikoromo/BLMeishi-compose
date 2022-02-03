CREATE TABLE users (
                       id SERIAL,
                       name VARCHAR(255) NOT NULL,
                       twitter_id VARCHAR(15) NOT NULL,
                       access_token VARCHAR(100) NOT NULL,
                       acces_secret VARCHAR(100) NOT NULL
                       PRIMARY KEY (id)
);