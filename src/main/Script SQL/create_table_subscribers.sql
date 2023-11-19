CREATE TABLE IF NOT EXISTS subscribers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
);


INSERT INTO subscribers (email, name) VALUES('john.doe@example.com', 'John Doe'),
('jane.doe@example.com', 'Jane Doe'),('mary.doe@example.com', 'Mary Doe');