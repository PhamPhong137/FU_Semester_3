with tempHE176151 as(
select c.id, c.code,c.title,se.[year],count(distinct s.id) as NumberOfEnrolledStudents
from enroll e
full join Students s on e.studentId = s.id
full join Courses c on e.courseId = c.id
full join semesters se on e.semesterId = se.id 
Group by c.id, c.code,c.title,se.[year]
having se.[year]=2019
)
select t.id, t.code,t.title,t.NumberOfEnrolledStudents
from tempHE176151 t


