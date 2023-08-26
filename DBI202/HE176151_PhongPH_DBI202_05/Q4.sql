select s.id as studentId, s.name as StudentName, de.Code as department,se.code as SemesterCode, se.year,c.title as CourseTitle
from Students s
join enroll e on e.studentId=s.id
join Courses c on e.courseId=c.id
join semesters se on e.semesterId=se.id
join Departments de on  s.department=de.Code
where c.title='Operating Systems'
order by se.[YEAR],se.code, studentId 






