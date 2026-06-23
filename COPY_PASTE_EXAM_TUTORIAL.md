# Copy/Paste Exam Tutorial

Use this when you must create the project manually in IntelliJ and copy the code
from GitHub file by file.

GitHub repository:

```text
https://github.com/ShraiL/java-final-exam-template/tree/preview
```

## Goal

Create this chain:

```text
JavaFX form
-> Product object
-> ProductDAO
-> JDBC INSERT
-> MySQL table in XAMPP
-> JDBC SELECT
-> Stream grouping
-> PieChart
```

## Step 1: Start XAMPP

Open XAMPP:

```text
Finder -> Applications -> XAMPP -> manager-osx
```

If you cannot find it, use Spotlight:

```text
Command + Space
XAMPP
```

Inside XAMPP:

1. Open `Manage Servers`.
2. Select `MySQL Database`.
3. Click `Start`.
4. Select `Apache Web Server`.
5. Click `Start`.

Then open phpMyAdmin in the browser:

```text
http://localhost/phpmyadmin
```

## Step 2: Create the Database

In GitHub, open:

```text
schema.sql
```

Copy all SQL code.

In phpMyAdmin:

1. Click `SQL` at the top.
2. Paste the SQL code.
3. Click `Go` / `OK`.

For the Product version the SQL is:

```sql
CREATE DATABASE IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL
);
```

If phpMyAdmin says the database or table already exists, that is okay.

## Step 3: Create Maven Project in IntelliJ

In IntelliJ:

1. `File` -> `New` -> `Project`.
2. Choose `Maven`.
3. Project name:

```text
Java_Lasha_Murgva_Lominadze_Shraieri
```

4. Choose a JDK that IntelliJ already has.
5. Click `Create`.

Use this project structure:

```text
Java_Lasha_Murgva_Lominadze_Shraieri/
  pom.xml
  src/
    main/
      java/
        Product.java
        DBConnection.java
        ProductDAO.java
        Main.java
```

Important: create the Java files directly in `src/main/java`.
Do not put them inside `org.example` for this template.

If IntelliJ creates a line like this at the top of a Java file:

```java
package org.example;
```

delete that line from all files.

## Step 4: Copy `pom.xml`

In IntelliJ, open:

```text
pom.xml
```

In GitHub, open:

```text
pom.xml
```

Copy the whole GitHub file and paste it over the whole IntelliJ `pom.xml`.

This file is important because it adds:

```text
javafx-controls
mysql-connector-j
javafx-maven-plugin
```

Without these dependencies, JavaFX and MySQL will not work.

If the real ticket requires your project name, change only these two lines:

```xml
<artifactId>Java_Lasha_Murgva_Lominadze_Shraieri</artifactId>
<name>Java_Lasha_Murgva_Lominadze_Shraieri</name>
```

## Step 5: Create and Copy Java Files

In IntelliJ, right-click `src/main/java`:

```text
New -> Java Class
```

Create these files exactly:

```text
Product
DBConnection
ProductDAO
Main
```

Then copy the code from GitHub:

```text
src/main/java/Product.java      -> Product.java
src/main/java/DBConnection.java -> DBConnection.java
src/main/java/ProductDAO.java   -> ProductDAO.java
src/main/java/Main.java         -> Main.java
```

Copy the whole file each time.

## Step 6: Reload Maven

If JavaFX imports are red, reload Maven.

The Maven button is on the right side of IntelliJ. It looks like:

```text
m
```

If you cannot see it:

```text
View -> Tool Windows -> Maven
```

Then click:

```text
Reload All Maven Projects
```

The reload button looks like two circular arrows.

## Step 7: Run the App

Best exam method:

1. Open the Maven window on the right.
2. Open your project.
3. Open `Plugins`.
4. Open `javafx`.
5. Double-click `javafx:run`.

If `mvn` says this:

```text
zsh: command not found: mvn
```

that is not a Java code problem. Use the IntelliJ Maven window instead.

If you downloaded the full ZIP from GitHub, this command also works:

```bash
./mvnw javafx:run
```

But if you created the project manually, `./mvnw` may not exist.

## Step 8: Test Insert

In the JavaFX window enter:

```text
Name: Fish
Category: Food
Quantity: 10
Price: 8.5
```

Click:

```text
Add Product
```

Add another row:

```text
Name: Bread
Category: Food
Quantity: 5
Price: 2.5
```

The PieChart should show:

```text
Food - 15
```

## Step 9: Check phpMyAdmin

In phpMyAdmin:

```text
productdb -> product -> Browse / Anzeigen
```

You must see the inserted rows.

This proves:

```text
JavaFX button works
JDBC connection works
INSERT query works
database table is correct
```

## Step 10: Screenshots

Create a folder in the project:

```text
screenshots
```

Save these screenshots:

```text
screenshots/01-javafx-form-piechart.png
screenshots/02-phpmyadmin-table.png
```

The first screenshot should show the JavaFX form and PieChart.
The second screenshot should show phpMyAdmin with inserted table rows.

## Step 11: If Ticket Names Are Different

If the ticket says `Book` instead of `Product`, change:

```text
Product.java    -> Book.java
ProductDAO.java -> BookDAO.java
productdb       -> librarydb
product         -> book
name            -> title
category        -> genre
```

Also change the Stream grouping:

```java
Product::getCategory
```

to:

```java
Book::getGenre
```

For the full rename guide, open:

```text
CHANGE_MAP.md
```

## Files You Must Copy

For the normal Product ticket, copy exactly these files:

```text
pom.xml
schema.sql
src/main/java/Product.java
src/main/java/DBConnection.java
src/main/java/ProductDAO.java
src/main/java/Main.java
```

You do not need to copy:

```text
.git
.idea
target
out
README.md
CHANGE_MAP.md
EXAM_CHECKLIST.md
TROUBLESHOOTING.md
```

Those markdown files are only for studying.

## Common Mistakes

Mistake:

```text
The Java files are inside package org.example.
```

Fix:

```text
Put all files directly in src/main/java and remove package lines.
```

Mistake:

```text
The database is productdb but DBConnection uses another name.
```

Fix:

```java
jdbc:mysql://localhost:3306/productdb?useSSL=false&serverTimezone=UTC
```

Mistake:

```text
The SQL column order and PreparedStatement order are different.
```

Fix:

```java
INSERT INTO product (name, category, quantity, price) VALUES (?, ?, ?, ?)
statement.setString(1, product.getName());
statement.setString(2, product.getCategory());
statement.setInt(3, product.getQuantity());
statement.setDouble(4, product.getPrice());
```

Mistake:

```text
The chart does not update after clicking Add Product.
```

Fix:

```java
productDAO.insertProduct(product);
updatePieChart();
```

