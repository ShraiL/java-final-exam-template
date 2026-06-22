# Troubleshooting

## Communications Link Failure

Cause: MySQL is not running.

Fix:

```text
XAMPP -> Manage Servers -> MySQL Database -> Start
```

## Unknown Database

Cause: JDBC URL uses a database that does not exist.

Fix:

```sql
CREATE DATABASE productdb;
```

## Table Does Not Exist

Cause: table name in DAO differs from phpMyAdmin.

Check:

```java
SELECT * FROM product
```

against:

```sql
CREATE TABLE product (...)
```

## Access Denied for root

XAMPP usually uses:

```java
USER = "root";
PASSWORD = "";
```

If you set a MySQL password, use the same password in `DBConnection`.

## No Suitable Driver

Reload the Maven project and check `pom.xml` contains:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
</dependency>
```

## NumberFormatException

Cause: quantity or price contains invalid text.

Correct parsing:

```java
int quantity = Integer.parseInt(quantityField.getText());
double price = Double.parseDouble(priceField.getText());
```

## Data Inserts but Chart Does Not Change

Call:

```java
updatePieChart();
```

immediately after:

```java
productDAO.insertProduct(product);
```

## Chart Shows Wrong Groups

Check the method reference:

```java
Product::getCategory
```

versus:

```java
Product::getName
```

## Red JavaFX Imports

Reload Maven. The project needs:

```xml
org.openjfx:javafx-controls
```

## Run Command

```bash
./mvnw javafx:run
```

