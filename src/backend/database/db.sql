CREATE DATABASE inventoryManagement;
USE inventoryManagement;
CREATE TABLE inventory(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    stock INT NOT NULL
);
DESCRIBE inventory;