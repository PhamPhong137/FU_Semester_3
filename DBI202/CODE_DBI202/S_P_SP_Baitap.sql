USE S_P_SP
GO

/*
SELECT PID FROM SP
SELECT DISTINCT PID FROM SP
*/

SELECT SID, Quantity FROM SP

SELECT DISTINCT PID FROM SP

SELECT * FROM SP

--26
SELECT SID 
FROM SP
WHERE PID ='P2'

--27
SELECT DISTINCT SID
FROM SP
WHERE Quantity BETWEEN 10 AND 20

--28
SELECT *
FROM S
WHERE Sname LIKE '%Sant%'

--29
SELECT *
FROM S
WHERE Sname LIKE '%ikes'

--30
/*SELECT Sname
FROM S FULL JOIN SP ON S.SID=SP.SID
WHERE PID='P2'*/
SELECT Sname
FROM S,SP 
WHERE (S.SID=SP.SID) AND PID='P2'

--32
SELECT Sname,City
FROM S
WHERE Status>100

--33
SELECT T1.SID
FROM  SP AS T1, SP AS T2
WHERE (T1.SID=T2.SID) AND T1.PID = 'P1' AND T2.PID='P2'

--34
SELECT P.Pname, P.PID 
FROM P
WHERE P.Color='RED'
ORDER BY PID DESC

--35
SELECT SP.SID
FROM SP
GROUP BY SID
HAVING COUNT( DISTINCT PID)>=2

--36
SELECT S.SID FROM S
EXCEPT
SELECT SP.SID FROM SP

--37
SELECT SID, Sname
FROM S
WHERE SID IN(
	SELECT SID
	FROM SP
	WHERE PID='P2'
	)

--37-2
SELECT Sname
FROM S
WHERE Status= (SELECT MAX(Status) FROM S )

--38(Đua ra danh sach hang chua ban mat hang nao)
SELECT * 
FROM S
WHERE SID <>ALL( SELECT SID FROM SP)

--39(SName cac hang ban it nhat 1 mat hang)
SELECT Sname
FROM S
WHERE EXISTS( SELECT * FROM SP WHERE SP.SID=S.SID)

--40
SELECT AVG(Weight) AS AVG_Weight
FROM P
WHERE Color = 'RED'

--42(Đưa ra thông tin 3 lần bán hàng đầu tiên)
SELECT TOP 3 * FROM SP

--43
ALTER TABLE SP 
ADD Price real; -- ADD Tax real; 

--44
SELECT SID, PID, Quantity, Price , Quantity*Price As AmountFROM SP
--45
SELECT SID AS MãĐạilý, PID AS MãSảnphẩm, Quantity AS Sốlượng, 
Price AS Giábán, Quantity*Price AS Thànhtiền FROM SP

--46







