# Change Map

Use this file when the real ticket changes `Product` to another model.

## Rule

Never rename only one class. These parts must agree:

```text
Java model fields
SQL columns
INSERT column order
PreparedStatement setters
ResultSet getters
JavaFX TextFields
constructor argument order
Stream grouping field
Stream numeric aggregation
```

## Step 0: Rename the Project

After downloading the GitHub ZIP:

```text
java-final-exam-template-preview
```

rename the folder to:

```text
Java_Lasha_Murgva_Lominadze_Shraieri
```

Also update `pom.xml`:

```xml
<artifactId>Java_Lasha_Murgva_Lominadze_Shraieri</artifactId>
<name>Java_Lasha_Murgva_Lominadze_Shraieri</name>
```

## Step 1: Write the Ticket Map

Example Product ticket:

```text
MODEL_CLASS     = Product
DAO_CLASS       = ProductDAO
DATABASE        = productdb
TABLE           = product
TEXT_FIELD_1    = name
GROUP_FIELD     = category
SUM_FIELD       = quantity
DECIMAL_FIELD   = price
```

Do this before editing code.

## Step 2: Rename the Model

If `Product` becomes `Book`:

```text
Product.java        -> Book.java
class Product       -> class Book
Product()           -> Book()
ProductDAO.java     -> BookDAO.java
class ProductDAO    -> class BookDAO
Product references  -> Book references
```

The public class name must match the filename.

## Step 3: Change Fields Everywhere

Product:

```text
id, name, category, quantity, price
```

Book:

```text
id, title, genre, quantity, price
```

Change these locations:

1. private fields in the model
2. constructor parameters
3. constructor assignments
4. getters and setters
5. SQL table columns
6. DAO `INSERT` columns
7. `PreparedStatement` setter calls
8. `ResultSet` column names
9. JavaFX `TextField` variables
10. JavaFX labels
11. button event local variables
12. model constructor call

## Step 4: Change Database and Table

Product:

```java
"jdbc:mysql://localhost:3306/productdb?useSSL=false&serverTimezone=UTC"
```

Book:

```java
"jdbc:mysql://localhost:3306/librarydb?useSSL=false&serverTimezone=UTC"
```

Product query:

```java
INSERT INTO product (...)
SELECT * FROM product
```

Book query:

```java
INSERT INTO book (...)
SELECT * FROM book
```

The JDBC database name must match phpMyAdmin.

## Step 5: Keep SQL and Java Types Compatible

| Java | MySQL | Read | Write |
|---|---|---|---|
| `String` | `VARCHAR(100)` | `getString` | `setString` |
| `int` | `INT` | `getInt` | `setInt` |
| `double` | `DOUBLE` | `getDouble` | `setDouble` |

## Step 6: Keep Parameter Order Identical

SQL:

```java
INSERT INTO product (name, category, quantity, price)
VALUES (?, ?, ?, ?)
```

Bindings:

```java
statement.setString(1, product.getName());
statement.setString(2, product.getCategory());
statement.setInt(3, product.getQuantity());
statement.setDouble(4, product.getPrice());
```

Position `1` belongs to the first SQL column, position `2` to the second, and so on.
JDBC positions begin at `1`.

## Step 7: Choose the Stream Operation

### Group and sum

Use when the ticket asks for total quantity or stock:

```java
Map<String, Integer> grouped = items.stream()
        .collect(Collectors.groupingBy(
                Item::getGroupField,
                Collectors.summingInt(Item::getNumericField)
        ));
```

Product by category:

```java
Product::getCategory
Collectors.summingInt(Product::getQuantity)
```

Book by genre:

```java
Book::getGenre
Collectors.summingInt(Book::getQuantity)
```

### Group and count

Use when the ticket asks how many objects belong to each group:

```java
Map<String, Long> grouped = items.stream()
        .collect(Collectors.groupingBy(
                Item::getGroupField,
                Collectors.counting()
        ));
```

Notice the value type changes from `Integer` to `Long`.

## Step 8: Update PieChart Labels

For an integer total:

```java
grouped.forEach((label, total) ->
        chartData.add(new PieChart.Data(label + " - " + total, total))
);
```

## Step 9: Search Before Running

After adapting `Product` to `Book`, search the whole project for:

```text
Product
product
productdb
name
category
quantity
price
```

Every remaining occurrence must be intentional.

## Optional ProductContract

`ProductContract` can store table and column names as constants:

```java
public class ProductContract {
    public static final String TABLE = "product";
    public static final String ID = "id";
}
```

It is optional. The original sample repository and final ticket do not require it.
Use it only if you understand it and have enough time.
