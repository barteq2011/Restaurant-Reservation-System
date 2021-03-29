DROP TABLE IF EXISTS Tables;
DROP TABLE IF EXISTS Orders;

CREATE TABLE Tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    available VARCHAR NOT NULL,
    description VARCHAR,
    capacity INT
);
CREATE TABLE Orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    city VARCHAR NOT NULL,
    zip_code VARCHAR NOT NULL,
    number_of_people INT NOT NULL
);


INSERT INTO Tables(available, description, capacity) VALUES
('AVAILABLE',
'Czteroosobowy stolik przy oknie, w lewym rogu stali',
 4),
('NOT_AVAILABLE',
 'Dwuosobowy stolik przy oknie po lewej stronie sali',
 2),
('AVAILABLE',
'Dwuosobowy stolik przy oknie po lewej stronie sali',
 2);