INSERT INTO users (id, email, first_name, last_name, image_url, active, password)
VALUES (1, 'lachezar.balev@gmail.com', 'Lucho', 'Balev', null, 1,
        '26bf518d364cf1df9426e6c6f8d2f56b862f9d1d6e2a285dc5512be4f97c2dde5dded32ebb6dad0abd1c0db3c0502576');

INSERT INTO brands (id, name)
VALUES (1, 'Toyota'),
       (2, 'Ford');

INSERT INTO models (id, name, category, brand_id)
VALUES (1, 'Camry', 'CAR', 1),
       (2, 'Corolla', 'CAR', 1),
       (3, 'Focus', 'CAR', 2),
       (4, 'Fiesta', 'CAR', 2);