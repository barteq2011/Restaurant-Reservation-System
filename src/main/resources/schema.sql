DROP TABLE IF EXISTS Tables;

CREATE TABLE Tables {
    id INT AUTO_INCREMENT PRIMARY KEY,
    available VARCHAR NOT NULL,
    description VARCHAR,
    capacity INT
};
