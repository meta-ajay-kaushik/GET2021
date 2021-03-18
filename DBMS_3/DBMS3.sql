create table productCategories(
productID int NOT NULL,
categoryID varchar(20) NOT NULL
);
/*
drop table productCategories;*/
insert into productCategories values(1,1);
insert into productCategories values(1,3);
insert into productCategories values(2,1);
insert into productCategories values(2,3);
insert into productCategories values(3,1);
insert into productCategories values(4,2);
insert into productCategories values(5,2);
insert into productCategories values(6,1);
insert into productCategories values(6,2);
select * from productCategories;
select * from product;
select * from category;

/* question2 */
/* query1 */

select pc.productID,p.productName from productCategories pc left join product p on
p.productID=pc.productID group by pc.productID having count(pc.categoryID)>1;


/* query2 */
SELECT '0 - 100' as 'Range in Rs.', count(product.productID) AS Count FROM product WHERE product.price BETWEEN 0 AND 100
UNION
SELECT '101 - 500' as 'Range in Rs.', count(product.productID) AS Count FROM product WHERE product.price BETWEEN 101 AND 500
UNION
SELECT 'Above 500' as 'Range in Rs.', count(product.productID) AS Count FROM product WHERE product.price > 500;


/* query3 */

select c.categoryID,c.categoryName,count(pc.categoryID) as productCount from category c left join 
productCategories pc on
pc.categoryID=c.categoryID group by c.CategoryID;



/* question3 */
/* query1 */

SELECT userName.firstName,COUNT(*) FROM user,userName,orders where user.
userID = userName.userID AND user.userID=orders.userID AND DATEDIFF(CURDATE(),orders.orderDate)<=30 GROUP BY user.userID;

/*query2 */ 
SELECT userName.firstName 
from userName INNER JOIN orders ON userName.userID=orders.userID  
WHERE DATEDIFF(CURDATE(),orders.orderDate)<=30
ORDER BY SUM(orders.totalBill) DESC LIMIT 10;

/*query3 */
select product.productName,COUNT(orders.productID) 
from product INNER JOIN orders ON product.productID=orders.productID
WHERE DATEDIFF(CURDATE(),orders.orderDate)<=60
GROUP BY product.productID 
DESC LIMIT 20;

/*query4 */
select MONTH(orders.orderDate) AS month,SUM(totalBill) AS salesRevenue
FROM  orders WHERE TIMESTAMPDIFF(MONTH,orderDate,CURDATE())<=6  
GROUP BY month;

/*query5 */
UPDATE product JOIN orders ON product.productID=orders.productID  
SET product.statusOfProduct='inactive' where DATEDIFF(CURDATE(),orders.orderDate) >=90;
select * from product;





/*query6 */
SELECT product.productID AS ID,
    product.productName AS Title
    FROM product WHERE product.categoryID IN(
    SELECT categoryID AS ID FROM productCategories 
    WHERE categoryID = (SELECT categoryID 
    FROM category WHERE categoryName='cloths')
);


/*query7 */
SELECT product.productID,product.productName AS "Product Title",
      count(status.productID) AS CancelTimes,
      status.cancelled
      FROM product INNER JOIN status
      ON status.productID=product.productID 
      GROUP BY status.productID HAVING status.cancelled='y'
      ORDER BY CancelTimes DESC LIMIT 10;



/* question4 */

CREATE TABLE zipcode
(
    zipcode INT NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY(zipcode)
);
DELETE FROM zipcode;
INSERT INTO zipcode VALUES
(313001, 'Udaipur', 'Rajasthan'),
(302019, 'Jaipur', 'Rajasthan'),
(302020, 'Mumbai', 'Maharashtra'), 
(302021, 'Noida', 'Delhi');

SELECT zipcode, city, state
FROM zipcode
ORDER BY state, city;

DROP TABLE zipcode;



/* question5 */


CREATE view orderInformation As 
select orders.orderID,product.productID,product.productName,orders.totalBill,userName.firstName,user.emailID,orders.
orderDate,product.statusOfProduct from orders JOIN product ON orders.productID=product.productID 
JOIN user ON user.userID=orders.userID JOIN userName ON user.userID=userName.userID 
where orders.orderDate > DATE_SUB(CURDATE(),INTERVAL 365 DAY) ORDER
BY orders.orderID DESC;
select * from orderInformation;

select productName from orderInformation where statusOfProduct='shipped';

select productName from orderInformation GROUP BY productID ORDER BY
productName DESC LIMIT 5;
DROP view orderInformation;