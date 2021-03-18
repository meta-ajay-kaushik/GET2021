DROP DATABASE storeFront;
CREATE DATABASE storeFront;
use storeFront;
create table user(
    userID INT AUTO_INCREMENT PRIMARY KEY,
    emailID VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL,
    dob DATE,
    gender CHAR(1),
    userType CHAR(7)
);
create table userName(
    userID INT NOT NULL,
    firstName CHAR(10),
    lastName CHAR(10),
    FOREIGN KEY(userID) REFERENCES user(userID)
);
create table contactNumber(
    userID INT NOT NULL,
    contactNo DOUBLE NOT NULL,
    FOREIGN KEY(userID) REFERENCES user(userID)
);
create table userAddress(
    userID INT NOT NULL,
    plotNo INT NOT NULL,
    pinCode INT NOT NULL,
    state CHAR(20) NOT NULL,
    FOREIGN KEY(userID) REFERENCES user(userID)
);
create table category(
    categoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(20),
    parentID INT
);
create table product(
    productID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(20) NOT NULL, 
    price INT NOT NULL,
    stocks INT NOT NULL,
    categoryID INT,
    statusOfProduct VARCHAR(20),
    description VARCHAR(100),
    FOREIGN KEY(categoryID) REFERENCES category(categoryID)
);
create table productImages(
    productID INT NOT NULL,
    imageSrc VARCHAR(50) DEFAULT NULL,
    FOREIGN KEY(productID) REFERENCES product(productID)
);
create table cart(
    productID INT NOT NULL,
    userID INT NOT NULL,
    quantity INT NOT NULL,
    totalPrice DOUBLE DEFAULT 0,
    FOREIGN KEY(productID) REFERENCES product(productID),
    FOREIGN KEY(userID) REFERENCES user(userID)
);
create table orders(
    orderID INT NOT NULL AUTO_INCREMENT,
    shippingAddress VARCHAR(100) NOT NULL,
    orderDate DATE,
    deliveryDate DATE,
    totalBill DOUBLE NOT NULL,
    userID INT NOT NULL,
    productID INT NOT NULL,
    PRIMARY KEY(orderID),
    FOREIGN KEY(userID) REFERENCES user(userID),
    FOREIGN KEY(productID) REFERENCES product(productID)
);
create table status(
    orderID INT,
    productID INT,
    deliveredSuccessfully CHAR(1),
    returned CHAR(1),
    cancelled CHAR(1),
    shipped CHAR(1),
    FOREIGN KEY(orderID) REFERENCES orders(orderID),
    FOREIGN KEY(productID) REFERENCES product(productID)
);
SHOW TABLES;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE product;
SET FOREIGN_KEY_CHECKS=1;
create table product(
    productID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productName VARCHAR(20) NOT NULL, 
    price INT NOT NULL,
    stocks INT NOT NULL,
    categoryID INT,
    statusOfProduct VARCHAR(20),
    description VARCHAR(100),
    FOREIGN KEY(categoryID) REFERENCES category(categoryID)
);
SHOW TABLES;