select a.id, a.type, a.name,a.[percent], c.title as CourseTitle
from Assessments a
join Courses c on a.courseId=c.id
where c.title='Introduction to Databases'


