# IntelliJ Shortcuts and Rename Tips

Use this file during practice when the Georgian ticket has the same structure but
different model names, field names, database names, or table names.

## Georgian Ticket Keywords

| Georgian text | Meaning for the code |
|---|---|
| `შექმენით JavaFX აპლიკაცია` | Create a JavaFX application |
| `პროექტს დაარქვით Java_ ...` | Project name must start with `Java_` |
| `მოდელ კლასი` | Model class, for example `Product` |
| `ველები` | Fields |
| `FX ფორმა` | JavaFX form |
| `layout` | JavaFX layout, for example `GridPane`, `VBox` |
| `დამატების ღილაკი` | Add button |
| `MySQL მონაცემთა ბაზა` | MySQL database |
| `წინასწარ შექმნილ ცხრილში` | Table must already exist in phpMyAdmin |
| `JDBC დრაივერი` | Use JDBC, not Hibernate/JPA |
| `PieChart` | JavaFX PieChart |
| `ბაზიდან წამოიღებს ყველა ჩანაწერს` | Select all records from database |
| `Java Stream API` | Use `stream()`, `groupingBy`, `summingInt` or `counting` |
| `დააჯგუფებს` | Group data |
| `რაოდენობასთან` | Usually sum the `quantity` field |
| `XAMP` | XAMPP |

## Your Default Ticket Map

For the common Product ticket, keep this exact map:

```text
PROJECT_NAME = Java_Lasha_Murgva_Lominadze_Shraieri
MODEL_CLASS  = Product
DAO_CLASS    = ProductDAO
DATABASE     = productdb
TABLE        = product
FIELDS       = id, name, category, quantity, price
GROUP_BY     = category
SUM_FIELD    = quantity
```

This is the safest field set because it works naturally with the PieChart task.

## Mac Shortcuts

| Shortcut | Use |
|---|---|
| `Shift + F6` | Rename class, file, variable, method safely |
| `Command + R` | Replace text in the current file |
| `Command + Shift + R` | Replace text in the whole project |
| `Command + Shift + F` | Find text in the whole project |
| `Command + N` | Generate constructor, getters and setters |
| `Option + Enter` | Quick fix or add missing import |
| `Command + B` | Go to declaration |
| `Command + /` | Comment or uncomment selected line |
| `Command + D` | Duplicate current line |
| `Command + Backspace` | Delete current line |
| `Command + Shift + A` | Search any IntelliJ action |

## Best Rename Method

If the ticket changes `Product` to `Book`, do not start with blind replace.

Use IntelliJ rename first:

```text
Product.java    -> Shift + F6 -> Book
ProductDAO.java -> Shift + F6 -> BookDAO
```

Then search the whole project:

```text
Command + Shift + F
```

Search for:

```text
Product
product
category
productdb
```

Fix remaining names one by one.

## Safe Replace List

These replacements are usually safe:

```text
ProductDAO -> BookDAO
Product    -> Book
productDAO -> bookDAO
```

These replacements require attention:

```text
product   -> book
productdb -> librarydb
category  -> genre
name      -> title
```

Reason: lowercase names appear in SQL, method names, variables, labels, and the
JDBC URL. If one place is wrong, the app may compile but not insert into MySQL.

## Exact Places to Change for a New Model

When `Product` becomes another model, change all of these:

```text
1. Java file name
2. class name
3. DAO class name
4. private fields
5. constructor name and parameters
6. getters and setters
7. SQL database name
8. SQL table name
9. SQL column names
10. JDBC URL in DBConnection.java
11. INSERT query in DAO
12. PreparedStatement setter order
13. SELECT query in DAO
14. ResultSet getter column names
15. JavaFX TextField variable names
16. JavaFX Label text
17. model constructor call in Main.java
18. Stream grouping field
19. Stream sum/count field
20. PieChart label text
```

## Final Search Checklist

Before submitting, use:

```text
Command + Shift + F
```

Search these:

```text
org.example
TODO
Product
product
productdb
INSERT INTO
SELECT *
getCategory
getQuantity
```

What to check:

```text
org.example  -> should not be in Java files unless all files use the same package
TODO         -> should not remain
Product      -> okay only if the ticket is Product
product      -> table/method names must match the ticket
productdb    -> must match phpMyAdmin database
INSERT INTO  -> column order must match PreparedStatement order
SELECT *     -> table name must be correct
getCategory  -> group field must be correct
getQuantity  -> sum field must be correct
```

## SQL and PreparedStatement Order Rule

This is one of the easiest places to lose points.

SQL:

```java
INSERT INTO product (name, category, quantity, price) VALUES (?, ?, ?, ?)
```

Bindings:

```java
statement.setString(1, product.getName());
statement.setString(2, product.getCategory());
statement.setInt(3, product.getQuantity());
statement.setDouble(4, product.getPrice());
```

Rule:

```text
First SQL column  -> statement position 1
Second SQL column -> statement position 2
Third SQL column  -> statement position 3
Fourth SQL column -> statement position 4
```

JDBC positions start at `1`, not `0`.

## Stream Patterns

Use this when the ticket asks for total quantity by group:

```java
Map<String, Integer> groupedProducts = products.stream()
        .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.summingInt(Product::getQuantity)
        ));
```

Use this when the ticket asks how many objects are in each group:

```java
Map<String, Long> groupedProducts = products.stream()
        .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.counting()
        ));
```

For your expected Product ticket, use `summingInt`, because the ticket gives
examples like:

```text
Fish - 10 pieces
Bread - 20 pieces
```

## Fast IntelliJ Maven Run

If Terminal says:

```text
zsh: command not found: mvn
```

use IntelliJ instead:

```text
Right side "m" icon
-> Reload All Maven Projects
-> Plugins
-> javafx
-> javafx:run
```

If the `m` icon is hidden:

```text
View -> Tool Windows -> Maven
```

## Fast XAMPP Reminder

Open XAMPP:

```text
Finder -> Applications -> XAMPP -> manager-osx
```

Start:

```text
Manage Servers -> MySQL Database -> Start
Manage Servers -> Apache Web Server -> Start
```

Open phpMyAdmin:

```text
http://localhost/phpmyadmin
```

## What to Explain if Asked

For OneCompiler AI, open:

```text
ONECOMPILER_FINAL_PROMPT.md
```

Short explanation:

```text
Product is the model class. DBConnection creates the JDBC connection.
ProductDAO contains database operations: insert and select.
Main is the JavaFX class. It creates the form, reads input, creates a Product,
calls the DAO, loads all records, groups them with Stream API, and shows the
result in a PieChart.
```

For Stream API:

```text
I use groupingBy to group products by category and summingInt to calculate the
total quantity for each category. Then I convert the map into PieChart.Data.
```

For JDBC:

```text
I use PreparedStatement because it safely inserts values into the SQL query.
The question marks are placeholders, and setString/setInt/setDouble fill them
in the same order as the SQL columns.
```
