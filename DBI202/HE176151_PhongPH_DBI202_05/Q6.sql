
select top 1 c.id as courseID,c.code,c.title, count(*) as NumberOfAssessments
from Courses c
join Assessments a on a.courseId=c.id
group by c.id,c.code,c.title
order by count(*) desc











