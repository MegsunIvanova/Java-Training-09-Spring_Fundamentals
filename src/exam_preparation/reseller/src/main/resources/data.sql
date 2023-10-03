INSERT INTO users (id, username, email, password)
    VALUES (1, 'miglena', 'miglena@mail.bg', 'db0e03077d84a3be6e8d8aafb0e3e2f7618ecd23eb8200e288353bb4ae36b3c433e199729e3d81a3'),
           (2, 'pesho', 'pesho@mail.bg', 'ea44eab6cc2b85ba1ae579f6149de379f8f80d34ab16a90567cfb70fb4e33d4df219b2105c91a8bf'),
           (3, 'ivan', 'ivan@abv.bg', 'fc0c30581bca1136faa8205ab7e81f2892cb1024071c36b9ee64b99ad19a8787e991bffd738015e9');

INSERT INTO offers (id, description, price, buyer_id, seller_id, condition_id)
    VALUES (1, 'Falcon Coffee Table', 1117.99, null, 1, 1),
           (2, 'GoPro Hero 12', 1300.00, null, 2, 2),
           (3, 'HotWheels Audi RS/2', 45.00, null, 2, 3),
           (4, 'Samsung A54', 520.00, null, 3, 1);


