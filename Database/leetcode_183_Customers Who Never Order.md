<img src="https://user-images.githubusercontent.com/76995452/124286988-7cc22480-db8a-11eb-82ef-294cf0c1f16a.png">  

# Code
```
select name "Customers"
from customers c
where id not in (
select customerid 
from orders);
```
