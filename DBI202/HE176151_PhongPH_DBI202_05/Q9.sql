create trigger Tr1 on enroll
for insert 
as
begin
	update marks 
	set mark = 0.0	
	select i.enrollId,a.id, mark 
	from inserted i 
	join marks m on i.enrollId=m.enrollId
	join Assessments a on m.assessmentId=a.id
		
end