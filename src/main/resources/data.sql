-- Test data for h2 testing database


INSERT INTO User(authority, is_credentials_non_expired, is_enabled, is_non_blocked,
is_not_expired, password, username) VALUES
('ADMIN',
TRUE,
TRUE,
TRUE,
TRUE,
'$2y$12$f8JojEU14QJGvGgyx3Mtt.XuWYkIo8YUTfavhpClML2uNAm2EPXD.',
'admin');

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

 INSERT INTO Orders(address, city, client_name, email, number_of_people, zip_code, table_id) VALUES
 ('Ludowa 12', 'Kraków', 'Marek Jakubiak', 'marek@gmail.com', 2, '42-800', 2);