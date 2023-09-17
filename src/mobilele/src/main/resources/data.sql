INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'lachezar.balev@gmail.com', 'Lucho', 'Balev', null, 1,
        'cf0a19ad8dd509b105b77230c832cfb66541849cfeaf648cc88e5374734afee3774febc7cf6487fe');

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/a/a7/Ford_Fiesta_ST-Line_%28VII%2C_Facelift%29_%E2%80%93_f_30012023.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://upload.wikimedia.org/wikipedia/commons/e/e9/1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1200px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');
