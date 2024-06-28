DROP TABLE IF EXISTS USER_TABLE;

CREATE TABLE USER_TABLE (
    uid VARCHAR(255) PRIMARY KEY,
    guid VARCHAR(255) NOT NULL,
    juid VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    createdAt TIMESTAMP,
    lastModified TIMESTAMP
);

INSERT INTO USER_TABLE
    (uid, guid, juid, email, firstName, lastName, createdAt, lastModified)
VALUES 
    ('1', 'a', 'd', 'user1@example.com', 'John', 'Doe', '2024-06-28 10:00:00', '2024-06-28 10:00:00'),
    ('2', 'b', 'e', 'user2@example.com', 'Jane', 'Smith', '2024-06-28 11:00:00', '2024-06-28 11:00:00'),
    ('3', 'c', 'f', 'user3@example.com', 'Michael', 'Johnson', '2024-06-28 12:00:00', '2024-06-28 12:00:00');
