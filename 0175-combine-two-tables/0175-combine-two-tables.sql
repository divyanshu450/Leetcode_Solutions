# Write your MySQL query statement below
select firstName, lastName, city, state from Person p Left Join Address a on p.personId=a.personId;