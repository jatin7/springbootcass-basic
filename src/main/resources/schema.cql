CREATE KEYSPACE IF NOT EXISTS springbootcass WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE IF NOT EXISTS springbootcass.book (
    id bigint PRIMARY KEY,
    author text,
    title text
);