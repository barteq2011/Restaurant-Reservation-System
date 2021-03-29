DROP TABLE IF EXISTS Tables;

CREATE TABLE Tables (
    id INT AUTO_INCREMENT PRIMARY KEY,
    available VARCHAR NOT NULL,
    description VARCHAR,
    capacity INT
);


INSERT INTO Tables VALUES
(1, 'AVAILABLE',
'Czteroosobowy stolik przy oknie, w lewym rogu stali',
 4),
(2, 'NOT_AVAILABLE',
 'Dwuosobowy stolik przy oknie po lewej stronie sali',
 2),
(3, 'AVAILABLE',
'Dwuosobowy stolik przy oknie po lewej stronie sali',
 2);