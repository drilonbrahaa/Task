This is an application that accepts a JSON with data about products as a request and returns an order with a list of invoices as a response.
It is made with Spring Boot.
It is a backend application.
To run, download repository and run TaskApplication.java, then send a request with a JSON list of products using Postman. Request URL: localhost:8080/api/generateInvoices
JSON request body:
[
  { "product": "Water", "quantity": 240, "price": 0.25, "discount": 0, "vat": 8 },
  { "product": "Chips", "quantity": 38, "price": 2.40, "discount": 0, "vat": 8 },
  { "product": "TV", "quantity": 1, "price": 760, "discount": 0, "vat": 22 },
  { "product": "Coca Cola", "quantity": 77, "price": 0.50, "discount": 0.10, "vat": 18 },
  { "product": "Chocolate Bar", "quantity": 38, "price": 1.25, "discount": 0, "vat": 22 },
  { "product": "Hand Soap", "quantity": 92, "price": 3.78, "discount": 0, "vat": 8 },
  { "product": "Fish Meat", "quantity": 49, "price": 8.30, "discount": 0, "vat": 18 },
  { "product": "Humus", "quantity": 16, "price": 2.66, "discount": 0, "vat": 18 },
  { "product": "White Wine", "quantity": 18, "price": 9.20, "discount": 0.02, "vat": 18 },
  { "product": "Bananas", "quantity": 8, "price": 1.25, "discount": 0, "vat": 22 },
  { "product": "Wine", "quantity": 22, "price": 9.78, "discount": 0, "vat": 22 },
  { "product": "Oil", "quantity": 10, "price": 8.30, "discount": 0, "vat": 18 },
  { "product": "Cigarettes", "quantity": 89, "price": 5.46, "discount": 0, "vat": 22 },
  { "product": "Cookies", "quantity": 33, "price": 1.34, "discount": 0, "vat": 8 },
  { "product": "Yogurt", "quantity": 14, "price": 0.66, "discount": 0, "vat": 18 },
  { "product": "Bleach", "quantity": 11, "price": 1.23, "discount": 0, "vat": 22 },
  { "product": "Napkins", "quantity": 85, "price": 0.21, "discount": 0, "vat": 8 },
  { "product": "Eggs", "quantity": 104, "price": 0.16, "discount": 0, "vat": 18 },
  { "product": "Plastic Bags", "quantity": 398, "price": 0.05, "discount": 0, "vat": 18 },
  { "product": "Aluminum Foil", "quantity": 21, "price": 1.12, "discount": 0, "vat": 8 },
  { "product": "Razors", "quantity": 51, "price": 8.10, "discount": 0, "vat": 8 },
  { "product": "Lotions", "quantity": 205, "price": 12, "discount": 0, "vat": 22 }
]
The application will return a JSON list of invoices as a response
