/* Assignment1*/
/*query 1*/
select * from orders;
DELIMITER $$
CREATE FUNCTION findNoOfOrders(month int,year int)
returns int
BEGIN
DECLARE noOfOrders int;
select count(*) into noOfOrders from orders where MONTH(orderDate) in (month) and YEAR(orderDate)
in (year);
return (noOfOrders);
END$$

select findNoOfOrders(5,2020);

DROP FUNCTION findNoOfOrders;


/*query 2*/

select * from orders;
DELIMITER $$
CREATE FUNCTION findMostOrdersMonth(year int)
returns varchar(10)
BEGIN
DECLARE MostOrdersMonth varchar(10);
select MONTHNAME(orderDate) into MostOrdersMonth from orders where YEAR(orderDate)
in (year) group by MONTH(orderDate) order by count(*) DESC limit 1;
return (MostOrdersMonth);
END$$

select findMostOrdersMonth(2020);

DROP FUNCTION findMostOrdersMonth;


/* Assignment 2*/
/*query 1*/
select * from orders;
select * from product;
DELIMITER $$
CREATE PROCEDURE getAverageSales(month int, year int)
BEGIN
select product.productName, count(product.productID) as averageSales from orders
join product on orders.productID=product.productID where MONTH(orders.orderDate)=month
and YEAR(orders.orderDate)=year group by orders.productID;
END$$
DELIMITER ;

CALL getAverageSales(6,2020);
DROP PROCEDURE getAverageSales;


/*query 2*/
select * from orders;
select * from product;
select * from status;
DELIMITER $$
CREATE PROCEDURE getOrderDetails(startDate DATE, endDate DATE)
BEGIN
if startDate>endDate then
set startDate=endDate-Interval DAY(endDate) DAY;
end if;
select orders.orderID,orders.orderDate, orders.totalBill,orders.productID,status.shipped as Shipped,
status.deliveredSuccessfully as Delivered from orders join status on orders.orderID=status.orderID where
orders.orderDate>=startDate and orders.orderDate<=endDate;
END$$
DELIMITER ;

CALL getOrderDetails('2020-1-1',CURDATE());
DROP PROCEDURE getOrderDetails;





/* Assignment 3*/

ALTER TABLE product ADD INDEX productID (productID);
ALTER TABLE category ADD INDEX parentCategoryID (categoryName);
ALTER TABLE orders ADD INDEX orderIndex (orderDate);