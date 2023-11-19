CREATE TABLE IF NOT EXISTS author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    biography VARCHAR(255)
);

INSERT INTO author (name, biography) VALUES
('Antoine de Saint-Exupéry', 'French aviator, writer, poet and aviator'),
('J.K. Rowling', 'British author'),
('Victor Hugo', 'French writer, poet, playwright, novelist, essayist, academician and politician');