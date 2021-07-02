<img src = "https://user-images.githubusercontent.com/76995452/124287790-65d00200-db8b-11eb-8346-8310b015ff53.png">

  
# Code
```
select MAX(salary) "SecondHighestSalary"
from employee
where salary<(select MAX(salary) from employee);
```
