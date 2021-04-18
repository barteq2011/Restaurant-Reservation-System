INSERT INTO User(authority, is_credentials_non_expired, is_enabled, is_non_blocked,
is_not_expired, password, username) VALUES
('aced0005737200426f72672e737072696e676672616d65776f726b2e73656375726974792e636f72652e617574686f726974792e53696d706c654772616e746564417574686f72697479000000000000021c0200014c0004726f6c657400124c6a6176612f6c616e672f537472696e673b787074000541444d494e',
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