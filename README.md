# BTG Pactual Software Engineer Challenge

## Overview

This project is developed as part of the BTG Pactual Software Engineer Challenge. The application processes orders and generates reports based on them.

## Instructions

- A work plan was created and submitted within the required timeframe.
- The application is developed using [YOUR TECHNOLOGY STACK HERE, e.g. Java, Spring Boot].
- The environment is Dockerized for easy setup, including services like RabbitMQ and MongoDB.
- The system consumes order messages from a RabbitMQ queue, stores the data, and exposes a REST API to query:
  - Total order value
  - Number of orders per customer
  - List of orders by customer

## Project Scope

- Process incoming orders from a message queue
- Store order data in a database (PostgreSQL, MySQL, or MongoDB)
- Provide an API to consult order information and generate reports

## Message Example

```json
{
  "codigoPedido": 1001,
  "codigoCliente": 1,
  "itens": [
    {
      "produto": "lápis",
      "quantidade": 100,
      "preco": 1.10
    },
    {
      "produto": "caderno",
      "quantidade": 10,
      "preco": 1.00
    }
  ]
}
