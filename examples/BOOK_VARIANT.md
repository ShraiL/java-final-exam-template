# Book Variant

## Ticket Map

```text
Model: Book
DAO: BookDAO
Database: librarydb
Table: book
Fields: id, title, genre, quantity, price
Group by: genre
Sum: quantity
```

## SQL

```sql
CREATE DATABASE IF NOT EXISTS librarydb;
USE librarydb;

CREATE TABLE IF NOT EXISTS book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL
);
```

## INSERT

```java
String sql =
        "INSERT INTO book (title, genre, quantity, price) VALUES (?, ?, ?, ?)";

statement.setString(1, book.getTitle());
statement.setString(2, book.getGenre());
statement.setInt(3, book.getQuantity());
statement.setDouble(4, book.getPrice());
```

## Stream

```java
Map<String, Integer> groupedBooks = books.stream()
        .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summingInt(Book::getQuantity)
        ));
```

## Expected Chart

```text
Fiction - 12
Science - 7
```

