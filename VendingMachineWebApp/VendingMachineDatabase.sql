DROP DATABASE IF EXISTS VendingMachine;
CREATE DATABASE VendingMachine;
USE VendingMachine;

CREATE TABLE IF NOT EXISTS Items(
id INT NOT NULL,
item_name VARCHAR(30) NOT NULl,
number_available INT NOT NULL,
price DOUBLE NOT NULL,
PRIMARY KEY (id)

);

INSERT INTO Items(id, item_name, price, number_available) 
VALUES (1, "Coke", 1.50, 1); 

INSERT INTO Items(id, item_name, price, number_available) 
VALUES (2, "Diet Coke", 1.50, 20); 

INSERT INTO Items(id, item_name, price, number_available) 
VALUES (3, "Dr Pepper", 1.50, 20); 

INSERT INTO Items(id, item_name, price, number_available) 
VALUES (4, "7UP", 1.00, 20); 

INSERT INTO Items(id, item_name, price, number_available) 
VALUES (5, "Sprite", 1.50, 20); 
 	
   