# Write your MySQL query statement below
# Write your MySQL query statement below
with total_bought as (select stock_name , sum(price) as spent
from Stocks 
where operation = 'Buy'
group by stock_name),

total_sold as (select stock_name , sum(price) as gained
from Stocks 
where operation = 'Sell'
group by stock_name)

select b.stock_name , (gained - spent ) as capital_gain_loss
from 
total_bought as b join total_sold as s on b.stock_name = s.stock_name 