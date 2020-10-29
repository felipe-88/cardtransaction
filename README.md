# Card Transaction
Demo for Card Transaction with Spring Boot
	
	
## Endpoint: create account

	`{URL}/api/accounts}`
	
	JSON request example:
	
	`{
		"document_number": "12345678901"		
	}`
	
	JSON response example:
	
	`{
    	"accountId": 31,
    	"documentNumber": "12345678901"
	}`

## Endpoint: get account

	`{URL}/api/accounts/{account_id}`	
	
## Endpoint: create transaction

	`{URL}/api/accounts/transactions`	
	
	JSON request example:
	
	`{
    	"account": {
        	"account_id": 1
    },
    	"operation_type_id": 4,
    	"amount": 123.45
	}`
	
	JSON response example:
	
	`{
    	"accounts": {
        	"accountId": 1,
        	"documentNumber": "83909198340"
    },
    	"operationsTypes": "PAGAMENTO",
    	"amount": 123.45
	}`

## Build
```bash
mvn clean package
```

## Run
```bash
mvn spring-boot:run
```
