# Inventory Management System

The Inventory Management System is a Java-based application utilizing the Spring framework for managing product information. This system allows users to create, update, retrieve, and delete product data with a focus on details such as name, brand, category, available quantity, and package information.


## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
    - [API Usage Examples](#api-usage-examples)
- [API Endpoints](#api-endpoints)

## Features

- **Create, Read, Update, Delete (CRUD) Operations:** Manage product data with standard CRUD operations.
- **Retrieve Quantity by ID:** Find available quantity information for a product by its ID.
- **Update Quantity:** Modify available quantity information for a product.
- **Create, Read, Update, Delete (CRUD) Operations:** Manage brand and category information for products with standard CRUD operations.
- **Validation:** Ensure data integrity with validation constraints, such as requiring a non-blank name and a non-null category.
- **Relationships:** Utilize relationships with other entities, including Brand, Category, Quantity, and PackageInfo.
- **Cascade Operations:** Leverage cascade operations for persisting and removing associated entities.
- **Flexible Configuration:** Easily configure and extend the application with the Spring framework.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)
- MySQL database

### Installation

1. Clone the repository:

   ```
   git clone https://github.com/ProfsDev/Inventory-Management-System.git
   ```
2. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc)
3. Create a database instance with the name `Inventory_Management`
4. Build the project: 
    ```
    mvn clean install
    ```
    
5. Run the application: 
    ```
    mvn spring-boot:run
    ```

## Usage
You can use tools like Postman or curl to interact with the API. The base URL for the API is http://localhost:8080/products

### API Usage Examples
    
### 1.  Create a New Product (POST Request):

- **Endpoint:** `http://localhost:8080/product`
- **Method:** `POST`
- **Headers:**
  - `Content-Type: application/json`
- **Body:**
  ```json
  {
  "name": "Product Name",
  "brandId": brand id,
  "categoryId": category id,
  "quantity": {
      "box": 100,
      "pack": 21,
      "piece": 9
  },
  "packageInfo": {
            "numberOfPiecesInPack": 12,
            "numberOfPacksInBox": 6
        }
  }
  
 - **Expected Response:**
    ```
    product id
- **HTTP Status Code:** `201 Created`

### 2. Retrieve a Product by ID (GET Request):
- **Endpoint:** http://localhost:8080/product/{productID}
- **Method:** `GET`
- **Expected Response:**
    ```json
    {
    "id": 1,
    "name": "Product Name",
    "brand": {
        "id": 1,
        "name": "Brand Name"
    },
    "category": {
        "id": 1,
        "name": "Category Name"
    },
    "quantity": {
        "id": 1,
        "box": 2,
        "pack": 5,
        "piece": 9
    },
    "packageInfo": {
        "id": 1,
        "numberOfPiecesInPack": 12,
        "numberOfPacksInBox": 6
    }
}
- **HTTP Status Code:** `302 Found`

### 3. Update a Product (PUT Request):
- **Endpoint:** http://localhost:8080/product/{productID}
- **Method:** `PUT`
- **Headers:**
    - `Content-Type: application/json`
- **Body:**
    ```json
    {
  "name": "modified product name",
  "brandId": modified brand id,
  "categoryId": modified category id,
  "quantity": {
        "id": quantity id,
        "box": modified value,
        "pack": modified value,
        "piece": modified value
    },
    "packageInfo": {
        "id": packageInfo id,
        "numberOfPiecesInPack": modified value,
        "numberOfPacksInBox": modified value
    }
  }
  
 - **Expected Response**
    ```json
    {
    "id": 1,
    "name": "updated product name",
    "brand": {
        "id": updated brand id,
        "name": "updated brand name"
    },
    "category": {
        "id": updated category id,
        "name": "updated category name"
    },
    "quantity": {
        "id": 1,
        "box": updated value,
        "pack": updated value,
        "piece": updated value
    },
    "packageInfo": {
        "id": 1,
        "numberOfPiecesInPack": updated value,
        "numberOfPacksInBox": updated value
    }
}
- **Http Status Code:** `200 Ok`

### 4. Delete a Product (DELETE Request):
- **Endpoint:** http://localhost:8080/product/{productID}
- **Method:** `DELETE`
- **Expected Response:**
    ```json
- **HTTP Status Code:** `204 No Content`

## API Endpoints

- **GET /product:** Retrieve a list of all products.
- **GET /product/{productId}:** Find a specific product by its ID.
- **POST /product:** Add a new product.
- **PUT /product/{productId}:** Update an existing product.
- **DELETE /product/{productId}:** Delete a product by its ID.
- **GET /quantity/{quantityId}:** Retrieve available quantity information for a product by its ID.
- **PUT /quantity/{quantityId}:** Update available quantity information for a product.
- **GET /category:** Retrieve a list of all categories.
- **GET /category/{categoryId}:** Find a specific category by its ID.
- **POST /category:** Add a new category.
- **PUT /category/{categoryId}:** Update an existing category.
- **DELETE /category/{categoryId}:** Delete a category by its ID.
- **GET /brand:** Retrieve a list of all brands.
- **GET /brand/{brandId}:** Find a specific brand by its ID.
- **POST /brand:** Add a new brand.
- **PUT /brand/{brandId}:** Update an existing brand.
- **DELETE /brand/{brandId}:** Delete a brand by its ID.
