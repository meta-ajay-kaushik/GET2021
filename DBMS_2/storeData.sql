
DELETE FROM userName;
DELETE FROM userAddress;
DELETE FROM contactNumber;
DELETE FROM productImages;
DELETE FROM cart;
DELETE FROM status;
DELETE FROM orders;
DELETE FROM product;
DELETE FROM category;
DELETE FROM user;
INSERT INTO user VALUES(1,'xyz@gmail.com','hello123','2000-09-09','m','admin');
INSERT INTO user VALUES(2,'abc@gmail.com','hello123','1999-03-09','m','shopper');
INSERT INTO user VALUES(3,'hello@gmail.com','hello1234','1998-06-05','m','shopper');
INSERT INTO user VALUES(4,'pqr@gmail.com','test123','1998-04-06','f','shopper');
INSERT INTO user VALUES(5,'ajay@gmail.com','hello123','1997-04-09','m','shopper');
INSERT INTO userName(userID,firstName,lastName) VALUES(1,'Ajay','Kaushik');
INSERT INTO userName(userID,firstName,lastName) VALUES(2,'jay','kumar');
INSERT INTO userName(userID,firstName,lastName) VALUES(3,'akshay','sharma');
INSERT INTO userName(userID,firstName,lastName) VALUES(4,'priya','kohli');
INSERT INTO userName(userID,firstName,lastName) VALUES(5,'virat','Kohli');
INSERT INTO contactNumber(userID,contactNo) VALUES(1,9799478765);
INSERT INTO contactNumber(userID,contactNo) VALUES(2,9745674565);
INSERT INTO contactNumber(userID,contactNo) VALUES(3,8999472365);
INSERT INTO contactNumber(userID,contactNo) VALUES(4,7877360971);
INSERT INTO contactNumber(userID,contactNo) VALUES(5,9783431270);
INSERT INTO userAddress(userID,plotNo,pinCode,state) VALUES(1,13,302015,'Rajasthan');
INSERT INTO userAddress(userID,plotNo,pinCode,state) VALUES(2,5,202015,'Rajasthan');
INSERT INTO userAddress(userID,plotNo,pinCode,state) VALUES(3,8,407015,'TamilNadu');
INSERT INTO userAddress(userID,plotNo,pinCode,state) VALUES(4,22,305014,'Gujrat');
INSERT INTO userAddress(userID,plotNo,pinCode,state) VALUES(5,9,205078,'Karnatak');
/*
INSERT INTO category(categoryID,categoryName,parentID) values(2,'bat',1);
INSERT INTO category(categoryID,categoryName,parentID) values(3,'ball',1);
INSERT INTO category(categoryID,categoryName,parentID) values(4,'badminton',1);
INSERT INTO category(categoryID,categoryName,parentID) values(6,'tshirt',5);
INSERT INTO category(categoryID,categoryName,parentID) values(7,'cap',5);
INSERT INTO category(categoryID,categoryName,parentID) values(8,'shoe',5);
*/
INSERT INTO category(categoryID,categoryName,parentID) values(1,'sports',NULL);
INSERT INTO category(categoryID,categoryName,parentID) values(2,'cloths',NULL);
INSERT INTO category(categoryID,categoryName,parentID) values(3,'cricket',1);
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(1,'Ball',50,15,1,'shipped','This is a Ball');
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(2,'Bat',1000,10,1,'shipped','This is a Bat');
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(3,'Badinton',200,20,1,'cancelled','This is a Badminton');
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(4,'TShirt',500,30,2,'cancelled','This is a TShirt');
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(5,'Cap',100,20,2,'delivered','This is a Cap');
INSERT INTO product(productID,productName,price,stocks,categoryID,statusOfProduct,description) values(6,'Shoe',1500,10,2,'shipped','This is a Shoe');
INSERT INTO productImages values(1,'ball.jpg');
INSERT INTO productImages values(2,'bat.jpg');
INSERT INTO productImages values(3,'badminton.jpg');
INSERT INTO productImages values(4,'tshirt.png');
INSERT INTO productImages values(5,'cap.png');
INSERT INTO productImages values(6,'');
INSERT INTO cart(productID,userID,quantity,totalPrice) VALUES(1,1,2,400);
INSERT INTO cart(productID,userID,quantity,totalPrice) VALUES(2,1,3,1150);
INSERT INTO cart(productID,userID,quantity,totalPrice) VALUES(3,2,2,4000);
INSERT INTO cart(productID,userID,quantity,totalPrice) VALUES(4,3,2,400);
INSERT INTO cart(productID,userID,quantity,totalPrice) VALUES(5,3,10,12900);
INSERT INTO orders(orderID,shippingAddress,orderDate,deliveryDate,totalBill,userID,productID) values(1,'xyz','2020-5-25','2020-5-30',1150,1,1);
INSERT INTO orders(orderID,shippingAddress,orderDate,deliveryDate,totalBill,userID,productID) values(2,'abc','2020-9-12','2020-9-18',4000,2,2);
INSERT INTO orders(orderID,shippingAddress,orderDate,deliveryDate,totalBill,userID,productID) values(3,'any','2020-6-15','2020-6-22',12900,3,3);
INSERT INTO orders(orderID,shippingAddress,orderDate,deliveryDate,totalBill,userID,productID) values(4,'newOrder','2020-6-6','2020-6-12',1200,4,4);
INSERT INTO orders(orderID,shippingAddress,orderDate,deliveryDate,totalBill,userID,productID) values(6,'pqr','2021-3-3','2021-3-3',1290,3,5);
INSERT INTO status(orderID,productID,deliveredSuccessfully,returned,cancelled,shipped) values(1,2,'y','n','n','y');
INSERT INTO status(orderID,productID,deliveredSuccessfully,returned,cancelled,shipped) values(2,3,'y','y','n','y');
INSERT INTO status(orderID,productID,deliveredSuccessfully,returned,cancelled,shipped) values(3,5,'n','n','y','y');
/* query2 */
select product.productID, product.productName,category.categoryName,product.price from product JOIN category ON 
product.categoryID=category.categoryID where product.stocks>0 ORDER BY product.productID DESC LIMIT 10;


/* query3 */ 
SELECT productName
FROM product
WHERE productID NOT IN (SELECT productID FROM productImages);

/* query4 */
SELECT Cat.categoryID, Cat.categoryName as Title, IF(Parent.categoryName IS NULL, 'TOP CATEGORY', Parent.categoryName) as 'Parent Category Title'
FROM category Cat LEFT JOIN category Parent
ON Cat.parentID = Parent.categoryID
ORDER BY Parent.categoryName, Cat.categoryName ASC;

/* query5 */
SELECT Cat.categoryID, Cat.categoryName as Title, IF(Parent.categoryName IS NULL, 'TOP CATEGORY', Parent.categoryName) as 'Parent Category Title'
FROM category Cat LEFT JOIN category Parent
ON Cat.parentID = Parent.categoryID
where Cat.categoryID NOT IN (SELECT DISTINCT(parentID) FROM category where parentID IS NOT NULL);

/* query6 */
SELECT p.productName,p.price,p.description 
FROM product p JOIN category c ON c.categoryID=p.categoryID 
WHERE c.categoryID=(SELECT categoryID from product where productName='bat');

/* query7 */
SELECT productName FROM product WHERE stocks<50;