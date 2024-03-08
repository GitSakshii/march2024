CREATE TABLE Sales (
    sale_id INT PRIMARY KEY,
    product_name VARCHAR(255),
    sale_date DATE
);
INSERT INTO Sales (sale_id, product_name, sale_date) VALUES
(1, 'LCPHONE', '2000-01-16'),
(2, 'LCPhone', '2000-01-17'),
(3, 'LcPhOnE', '2000-02-18'),
(4, 'LCKeyCHAiN', '2000-02-19'),
(5, 'LCKeyChain', '2000-02-28'),
(6, 'Matryoshka', '2000-03-31');
SELECT product_name, sale_date, COUNT(*) AS total
FROM (
    SELECT LOWER(TRIM(product_name)) AS product_name,
           DATE_FORMAT(sale_date, '%Y-%m') AS sale_date
    FROM Sales
) AS trimmed_sales
GROUP BY product_name, sale_date
ORDER BY product_name ASC, sale_date ASC;