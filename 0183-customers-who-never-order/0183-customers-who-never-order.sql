select 
   name as Customers
from customers e
left join orders o
on e.id = o.customerId
where o.id is null;