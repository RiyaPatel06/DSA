# Write your MySQL query statement below
select Employee.name ,Bonus.bonus
from Employee 
left join Bonus 
on Employee.empid=Bonus.empid 
where Bonus.bonus<1000 or Bonus.bonus is null;

