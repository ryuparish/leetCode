# Write your MySQL query statement below
# LEFT JOIN means left joins right on all matching columns
SELECT FirstName, LastName, City, State from Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;
