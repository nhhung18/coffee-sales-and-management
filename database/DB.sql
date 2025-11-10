CREATE DATABASE coffee_SnM_db;
USE coffee_SnM_db;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  userName VARCHAR(255) UNIQUE NOT NULL,
  fullName VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  addressId INT,
  roleId INT,
  phoneNum VARCHAR(20) NOT NULL,
  avatarUrl VARCHAR(255),
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE users ADD UNIQUE (phoneNum);
ALTER TABLE users MODIFY roleId INT NOT NULL;
ALTER TABLE users DROP COLUMN addressId;


CREATE TABLE roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  roleName ENUM('STAFF', 'CUSTOMER', 'ADMIN') NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  unitNum INT NOT NULL,
  streetNum INT NOT NULL,
  address_line VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL,
  postalCode VARCHAR(50) NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE address 
CHANGE COLUMN address_line addressLine VARCHAR(255) NOT NULL;


CREATE TABLE userAddress (
  id INT AUTO_INCREMENT PRIMARY KEY,
  userId INT NOT NULL,
  addressId INT NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (addressId) REFERENCES address(id) ON DELETE CASCADE
);
	
CREATE TABLE category (
  id INT AUTO_INCREMENT PRIMARY KEY,
  categoryName VARCHAR(255) NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255),
  stockQuantity INT DEFAULT 0,
  imageUrl VARCHAR(255) NOT NULL,
  categoryId INT NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (categoryId) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE productDetail (
  id INT AUTO_INCREMENT PRIMARY KEY,
  productId INT NOT NULL,
  origin VARCHAR(255),
  roastLevel ENUM('Light', 'Medium', 'Dark'),
  flavorNotes TEXT,
  varietal VARCHAR(255),
  processingMethod VARCHAR(255),
  grindOptions VARCHAR(255),
  basicUser BOOLEAN DEFAULT FALSE,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (productId) REFERENCES product(id) ON DELETE CASCADE
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  userId INT NOT NULL,
  orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  totalAmount DECIMAL(12,2) DEFAULT 0.00,
  `status` ENUM('Pending', 'Processing', 'Shipped', 'Completed', 'Cancelled') DEFAULT 'Pending',
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE orderItem (
  id INT AUTO_INCREMENT PRIMARY KEY,
  orderId INT NOT NULL,
  productId INT NOT NULL,
  quantity INT DEFAULT 1,
  unitPrice DECIMAL(10,2) DEFAULT 0.00,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (orderId) REFERENCES orders(id) ON DELETE CASCADE,
  FOREIGN KEY (productId) REFERENCES product(id) ON DELETE CASCADE
);

CREATE TABLE discount (
  id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(255),
  discount_type ENUM('Percentage', 'Fixed Amount') NOT NULL,
  discount_value DECIMAL(5,2) DEFAULT 0.00,
  start_date DATETIME,
  end_date DATETIME,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CHECK (start_date < end_date)
);

CREATE TABLE applyDiscount (
  orderId INT NOT NULL,
  discountId INT NOT NULL,
  updateAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  createAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (orderId, discountId),
  FOREIGN KEY (orderId) REFERENCES orders(id) ON DELETE CASCADE,
  FOREIGN KEY (discountId) REFERENCES discount(id) ON DELETE CASCADE
);

-- INSERT DATA

INSERT INTO roles (roleName) VALUES 
('ADMIN'),
('STAFF'),
('CUSTOMER');

INSERT INTO address (unitNum, streetNum, addressline, city, postalCode) VALUES
(10, 25, 'Le Loi', 'Ha Noi', '100000'),
(15, 8, 'Nguyen Van Cu', 'Ho Chi Minh', '700000'),
(7, 33, 'Tran Hung Dao', 'Da Nang', '550000');
SELECT * FROM address

INSERT INTO users (userName, fullName, email, `password`, roleId, phoneNum, avatarUrl) VALUES
('hungnguyen184', 'Nguyen Huy Hung', 'nguyenhung18042005@gmail.com', '123456', 1, '0909123456', 'https://example.com/admin.jpg'),
('ducnguyen005', 'Nguyen Van Duc', 'nguyenduc2005@gmail.com', '123456', 2, '0909123455', 'https://example.com/admin.jpg'),
('ngoctran123', 'Tran Thi Ngoc', 'ngoctran123@gmail.com', '123456', 3, '0909123457', 'https://example.com/admin.jpg');

INSERT INTO userAddress (userId, addressId) VALUES
(4, 1),
(5, 2),
(6, 3);

INSERT INTO category (categoryName) VALUES
('Loai hat'),
('Xuat xu'),
('Muc rang'),
('Cach pha');

INSERT INTO product (name, description, stockQuantity, imageUrl, categoryId) VALUES
('Arabica Da Lat', 'Huong thom nhe, vi chua thanh', 120, 'https://example.com/arabica.jpg', 4),
('Robusta Dak Lak', 'Dam da, nhieu caffeine', 90, 'https://example.com/robusta.jpg', 5),
('Blend Nha Lam', 'Ket hop hai loai Arabica va Robusta', 60, 'https://example.com/blend.jpg', 6);

INSERT INTO productDetail (productId, origin, roastLevel, flavorNotes, varietal, processingMethod, grindOptions) VALUES
(7, 'Da Lat', 'Medium', 'Huong hoa, chua nhe', 'Arabica Bourbon', 'Washed', 'Whole bean'),
(8, 'Buon Ma Thuot', 'Dark', 'Dam, hau ngot', 'Robusta', 'Natural', 'Fine grind'),
(9, 'Son La', 'Light', 'Can bang giua chua va dang', 'Arabica-Robusta Blend', 'Honey', 'Medium grind');

INSERT INTO orders (userId, totalAmount, status) VALUES
(6, 250000, 'Processing'),
(6, 150000, 'Completed');

INSERT INTO orderItem (orderId, productId, quantity, unitPrice) VALUES
(5, 7, 2, 100000),
(6, 8, 1, 50000),
(6, 9, 1, 150000);

INSERT INTO discount (description, discount_type, discount_value, start_date, end_date) VALUES
('Giam 10 phan tram cho don tren 200k', 'Percentage', 10.00, '2025-01-01 00:00:00', '2025-12-31 23:59:59'),
('Giam 30000 cho don hang dau tien', 'Fixed Amount', 30.00, '2025-01-01 00:00:00', '2025-12-31 23:59:59');

INSERT INTO applyDiscount (orderId, discountId) VALUES
(5, 1),
(6, 2);

SELECT * FROM users;
SELECT * FROM roles;
SELECT * FROM address;
SELECT * FROM userAddress;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM productDetail;
SELECT * FROM orders;
SELECT * FROM orderItem;
SELECT * FROM discount;
SELECT * FROM applyDiscount;


