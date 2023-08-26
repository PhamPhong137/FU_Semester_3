create proc pr1
@store_id int, 
@numberOfStaff int output 
as
begin
	set @numberOfStaff = (select COUNT(s.staff_id) NumberOfStaff
	from staffs s, stores st 
	where (s.store_id = st.store_id) and st.store_id = @store_id)
end

