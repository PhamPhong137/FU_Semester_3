
--1
SELECT s.SID, s.FullName
FROM Students s
JOIN Participation p ON s.SID = p.SID
GROUP BY s.SID, s.FullName
HAVING COUNT(p.PID) >= 2;

--2
SELECT *
FROM Projects
WHERE Cost = (SELECT MIN(Cost) FROM Projects);

--3
SELECT s.FullName
FROM Students s
JOIN Participation p ON s.SID = p.SID
JOIN Projects pr ON p.PID = pr.PID
WHERE s.DOB < '2002-01-01' AND pr.Title = 'Text Clustering';

--4
SELECT s.SID, s.FullName, SUM(p.Duration) AS TotalDuration
FROM Students s
JOIN Participation p ON s.SID = p.SID
GROUP BY s.SID, s.FullName;

--5

DELETE FROM Participation
WHERE SID = 'SV02';
DELETE FROM Students
WHERE SID = 'SV02';


