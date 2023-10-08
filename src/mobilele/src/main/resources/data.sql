INSERT INTO users (id, email, first_name, last_name, image_url, active, password)
VALUES (1, 'lachezar.balev@gmail.com', 'Lucho', 'Balev', null, 1,
        '26bf518d364cf1df9426e6c6f8d2f56b862f9d1d6e2a285dc5512be4f97c2dde5dded32ebb6dad0abd1c0db3c0502576');

INSERT INTO brands (id, name)
VALUES (1, 'Toyota'),
       (2, 'Ford');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/a/a7/Ford_Fiesta_ST-Line_%28VII%2C_Facelift%29_%E2%80%93_f_30012023.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 2, 'https://upload.wikimedia.org/wikipedia/commons/e/e9/1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1200px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');
