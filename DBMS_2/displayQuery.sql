/* query1 */
select orderID,orderDate,totalBill from orders ORDER BY orderDate DESC LIMIT 50;

/* query2 */
select * from orders ORDER BY totalBill DESC LIMIT 10;

/* query3 */
select * from orders where orderDate < DATE_SUB(NOW(), INTERVAL 10 DAY);

/* query4 */
select user.userID, userName.firstName,user.emailID 
from user,userName,orders 
WHERE user.userType='shopper' AND user.userID=userName.userID 
AND orders.userID=user.userID AND orders.orderID NOT IN(SELECT DISTINCT orders.orderID
FROM orders WHERE MONTH(orders.orderDate) >= (MONTH(NOW())-1) AND YEAR(orders.orderDate) = YEAR(NOW()));

/* query5 */
select user.userID, userName.firstName,user.emailID 
from user,userName,orders 
WHERE user.userType='shopper' AND user.userID=userName.userID 
AND orders.userID=user.userID AND orders.orderID IN
(SELECT DISTINCT orders.orderID FROM orders WHERE orders.orderDate > DATE_SUB(NOW(), INTERVAL 15 DAY));

/* query6 */
select product.productName from product,orders,status where product.productID=orders.productID AND 
orders.orderID=status.orderID AND orders.orderID=2 AND status.shipped='y';
 
 /* query7 */
SELECT product.productName, orders.orderDate FROM product
JOIN orders ON product.productID=orders.productID 
WHERE product.price BETWEEN 20 AND 50;