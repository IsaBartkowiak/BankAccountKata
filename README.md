# BANK ACCOUNT KATA



This is a sample Java / Maven / Spring Boot (version 2.1) application as my bank account kata.
The service is a simple web service using a in-memory base. It allows:
- to display accounts
- to make a deposit on account
- to make a withdrawal on an account


# How to run project

You can launch by typing in terminal this command
`mvn spring-boot:run` 


# How to test project

You can find an export of my postman requests in the postman_test.json file

`
GET localhost:8080/accounts`
=> Display all accounts

`
PUT localhost:8080/accounts/1/deposit ({"amount": 50})
`
=> Make a deposit of 50 on account 1

`
PUT localhost:8080/accounts/1/withdrawal ({"amount": 50})`
=> Make a deposit of 50 on account 1

Here 's a response example

```json
{
    "id": 1,
    "name": "Isa account",
    "balance": 1170.7,
    "history": [
        {
            "localDate": "2018-11-12T09:18:33.415",
            "amount": -30,
            "balance": 970,
            "operationType": "WITHDRAWAL"
        },
        {
            "localDate": "2018-11-12T09:18:37.704",
            "amount": 200.7,
            "balance": 1170.7,
            "operationType": "DEPOSIT"
        }
    ]
}`







