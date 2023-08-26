--use PE_Demo_S2019

SELECT SubCategory.ID, SubCategoryName, 
COUNT(*) AS NumberOfProducts 
FROM Product 
JOIN SubCategory ON Product.SubCategoryID = SubCategory.ID
GROUP BY 
SubCategory.ID, 
SubCategory.SubCategoryName 
HAVING 
COUNT(*) > 100 
ORDER BY 
NumberOfProducts DESC;