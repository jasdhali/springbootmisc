Feature: Testing Book API
Users should be able to get and crate books.

	Scenario: Requesting a book from DataBase
		When user searches the API with id 1
		Then the server responds with response code 200