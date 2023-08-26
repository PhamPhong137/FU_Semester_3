create proc P1 @studentId int, @courseId int, @numberOfEnrollmentTimes int output
as
begin 
	set @numberOfEnrollmentTimes=(
		select count(*)
		from Students s
		join enroll e on s.id=e.studentId
		join Courses c on c.id=e.courseId
		where s.id=@studentId and c.id=@courseId
		)	
end
