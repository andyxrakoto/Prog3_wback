CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INTEGER REFERENCES author(id),
    topic topic_type NOT NULL,
    release_date DATE NOT NULL
);

INSERT INTO book (title, author_id, topic, release_date) VALUES
('The Little Prince', 1, 'ROMANCE', '2023-08-01'),
('Harry Potter and the Sorcerer''s Stone', 2, 'COMEDY', '2023-08-02'),
('Les Misérables', 3, 'OTHER', '2023-08-03')