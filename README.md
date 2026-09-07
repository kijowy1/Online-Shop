
# E-Commerce Spring Boot API

It is my first Spring api, im learning Springboot framework while creating it, feel free to write me some ideas or point bugs in it, ill be satisfied to learn from it, beacuse i focus on backend, all the index.html was created by AI.


## Acknowledgements

 - [Tutorial i have started with (PeachezProgramming)](https://youtube.com/playlist?list=PL7TZZ2ip0DRCmJ57pzkc3EChRTJ6pm_bH&si=4ZXNbds5xQJuStSo) - Currently i have ended on lesson 10, because i wanted to make some things by myself.
 - [The website i used to write readme](https://readme.so)


## Tech Stack

**Backend:** Java, Spring Boot, Spring Data JPA, Hibernate, JUnit 5, Mockito

**Frontend:** JavaScript, HTML

##  Instalation

* **Java JDK 17** (or higher)
* **IDE Setup (Lombok):** Ensure **Annotation Processing** is enabled in your IDE settings (e.g., IntelliJ IDEA: *Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors*).
* **Database:** Make sure your local database is running and credentials match `src/main/resources/application.properties`.

### Clone the repository

```bash
git clone [https://github.com/kijowy1/Online-Shop.git](https://github.com/kijowy1/Online-Shop.git)
cd Online-Shop
```

### Run Linux/macOS
```bash
./mvnw clean spring-boot:run
```
### Run Windows
```bash
mvnw.cmd clean spring-boot:run
```
The server will start on http://localhost:8080
To acces index http://localhost:8080/index.html
## Features

- Switching roles between admin and 3 users.
- Buying products and having history of every product that user bought.
- Admin can edit, delete, create product with: Name, price, quantity, description.
- Search bar where user and admin can search thorugh all products in data base.

## API Reference

#### Get all items

### Products

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/products` | Retrieves a paginated list of products (`?page=0&size=10`) |
| `GET` | `/product/{id}` | Retrieves details for a specific product by ID |
| `GET` | `/product/search?keyword={text}` | Searches products matching the given keyword |
| `POST` | `/product` | Creates a new product (requires JSON body) |
| `PUT` | `/product/{id}` | Updates an existing product by ID |
| `DELETE` | `/product/{id}` | Deletes a product by ID |

### Orders

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/order` | Retrieves a paginated list of all orders |
| `GET` | `/order/{id}` | Retrieves details for a specific order by ID |
| `GET` | `/order/customer/{id}` | Retrieves all orders for a specific customer ID |
| `POST` | `/order` | Places a new order |



## Screenshots

![App Screenshot](https://snipboard.io/hWBjiD.jpg)
![App Screenshot](https://snipboard.io/PGrMUH.jpg)

## Authors

- [@kijowy1](https://github.com/kijowy1)

