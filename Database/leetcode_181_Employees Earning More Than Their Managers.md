<img src="https://user-images.githubusercontent.com/76995452/124285611-07098900-db89-11eb-8afe-91b3fe9a389c.JPG">  



# Code
```
select A.name "Employee"
from Employee A, Employee B
where A.ManagerId = B.Id
and A.salary>B.salary;
```
