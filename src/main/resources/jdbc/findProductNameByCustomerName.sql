SELECT ORDERS.product_name
FROM ORDERS
         INNER JOIN CUSTOMERS C on ORDERS.customer_id = C.id
WHERE LOWER(c.name) = :customer