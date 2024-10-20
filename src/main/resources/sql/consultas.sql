CREATE TABLE public.brands (
	id varchar(255) NOT NULL,
	created_date timestamp(6) NOT NULL,
	description varchar(255) NULL,
	is_active bool NOT NULL,
	logo_url varchar(255) NULL,
	website_url varchar(255) NULL,
	"name" varchar(255) NOT NULL,
	updated_date timestamp(6) NULL,
	CONSTRAINT brands_pkey PRIMARY KEY (id)
);

INSERT INTO brands (id, name, description, logo_url, website_url, created_date, updated_date, is_active) VALUES
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C0-9B88-E27252E7685A::DES', 'Nike', 'Nike Sportswear', 'http://www.nike.com/logo.png', 'http://www.nike.com', '2024-10-01 10:00:00', '2024-10-10 12:00:00', true),
('PRODUCTSERVICE::BRAND::B715044B-26C2-44C1-9B88-E27252E7685A::DES', 'Adidas', 'Adidas Sportswear', 'http://www.adidas.com/logo.png', 'http://www.adidas.com', '2024-09-25 08:30:00', '2024-10-08 14:45:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C2-9B88-E27252E7685A::DES', 'Puma', 'Puma Activewear', 'http://www.puma.com/logo.png', 'http://www.puma.com', '2024-08-12 09:15:00', '2024-10-05 11:30:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C3-9B88-E27252E7685A::DES', 'Reebok', 'Reebok Sports Equipment', 'http://www.reebok.com/logo.png', 'http://www.reebok.com', '2024-07-18 14:20:00', '2024-10-01 15:10:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C4-9B88-E27252E7685A::DES', 'Under Armour', 'Under Armour Performance Apparel', 'http://www.underarmour.com/logo.png', 'http://www.underarmour.com', '2024-06-01 10:10:00', '2024-09-25 13:20:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C5-9B88-E27252E7685A::DES', 'New Balance', 'New Balance Athletic Shoes', 'http://www.newbalance.com/logo.png', 'http://www.newbalance.com', '2024-05-25 12:00:00', '2024-09-20 11:50:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C6-9B88-E27252E7685A::DES', 'Asics', 'Asics Running Gear', 'http://www.asics.com/logo.png', 'http://www.asics.com', '2024-05-10 16:45:00', '2024-09-15 10:30:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C7-9B88-E27252E7685A::DES', 'Columbia', 'Columbia Outdoor Apparel', 'http://www.columbia.com/logo.png', 'http://www.columbia.com', '2024-04-30 09:00:00', '2024-09-10 09:50:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C8-9B88-E27252E7685A::DES', 'North Face', 'North Face Outdoor Equipment', 'http://www.northface.com/logo.png', 'http://www.northface.com', '2024-03-25 13:15:00', '2024-09-05 14:00:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C9-9B88-E27252E7685A::DES', 'Patagonia', 'Patagonia Outdoor Clothing', 'http://www.patagonia.com/logo.png', 'http://www.patagonia.com', '2024-03-10 11:30:00', '2024-09-01 08:20:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C1-44C1-9B88-E27252E7685A::DES', 'Vans', 'Vans Skate Shoes', 'http://www.vans.com/logo.png', 'http://www.vans.com', '2024-02-01 15:40:00', '2024-08-25 09:10:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C2-44C1-9B88-E27252E7685A::DES', 'Converse', 'Converse Athletic Shoes', 'http://www.converse.com/logo.png', 'http://www.converse.com', '2024-01-15 10:50:00', '2024-08-20 13:30:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C3-44C1-9B88-E27252E7685A::DES', 'Fila', 'Fila Sportswear', 'http://www.fila.com/logo.png', 'http://www.fila.com', '2023-12-20 09:00:00', '2024-08-15 12:00:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C4-44C1-9B88-E27252E7685A::DES', 'Champion', 'Champion Athletic Apparel', 'http://www.champion.com/logo.png', 'http://www.champion.com', '2023-11-05 11:10:00', '2024-08-10 15:20:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C5-44C1-9B88-E27252E7685A::DES', 'Brooks', 'Brooks Running Shoes', 'http://www.brooks.com/logo.png', 'http://www.brooks.com', '2023-10-12 08:50:00', '2024-08-05 14:40:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C6-44C1-9B88-E27252E7685A::DES', 'Saucony', 'Saucony Running Gear', 'http://www.saucony.com/logo.png', 'http://www.saucony.com', '2023-09-27 13:00:00', '2024-08-01 10:30:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C7-44C1-9B88-E27252E7685A::DES', 'Hoka One One', 'Hoka Running Shoes', 'http://www.hoka.com/logo.png', 'http://www.hoka.com', '2023-08-15 10:10:00', '2024-07-25 11:45:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C8-44C1-9B88-E27252E7685A::DES', 'Salomon', 'Salomon Trail Running Gear', 'http://www.salomon.com/logo.png', 'http://www.salomon.com', '2023-07-30 12:20:00', '2024-07-20 09:30:00', true),
('PRODUCTSERVICE::BRAND::B615044B-26C9-44C1-9B88-E27252E7685A::DES', 'Merrell', 'Merrell Hiking Shoes', 'http://www.merrell.com/logo.png', 'http://www.merrell.com', '2023-06-25 09:40:00', '2024-07-15 08:20:00', true),
('PRODUCTSERVICE::BRAND::B615041B-26C2-44C1-9B88-E27252E7685A::DES', 'Timberland', 'Timberland Outdoor Apparel', 'http://www.timberland.com/logo.png', 'http://www.timberland.com', '2023-06-10 14:30:00', '2024-07-10 10:50:00', true),
('PRODUCTSERVICE::BRAND::B615042B-26C2-44C1-9B88-E27252E7685A::DES', 'Levis', 'Levi Strauss & Co Jeans', 'http://www.levis.com/logo.png', 'http://www.levis.com', '2023-05-05 11:50:00', '2024-07-05 09:10:00', true),
('PRODUCTSERVICE::BRAND::B615043B-26C2-44C1-9B88-E27252E7685A::DES', 'Wrangler', 'Wrangler Denim', 'http://www.wrangler.com/logo.png', 'http://www.wrangler.com', '2023-04-15 10:00:00', '2024-07-01 12:00:00', true),
('PRODUCTSERVICE::BRAND::B615045B-26C2-44C1-9B88-E27252E7685A::DES', 'Lee', 'Lee Jeans', 'http://www.lee.com/logo.png', 'http://www.lee.com', '2023-03-20 13:00:00', '2024-06-25 14:30:00', true),
('PRODUCTSERVICE::BRAND::B615046B-26C2-44C1-9B88-E27252E7685A::DES', 'Guess', 'Guess Fashion Apparel', 'http://www.guess.com/logo.png', 'http://www.guess.com', '2023-02-10 09:30:00', '2024-06-20 11:50:00', true),
('PRODUCTSERVICE::BRAND::B615047B-26C2-44C1-9B88-E27252E7685A::DES', 'Calvin Klein', 'Calvin Klein Fashion', 'http://www.calvinklein.com/logo.png', 'http://www.calvinklein.com', '2023-01-05 10:50:00', '2024-06-15 08:00:00', true);

