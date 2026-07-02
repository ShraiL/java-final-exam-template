# OneCompiler Final Prompt

Use this prompt in the OneCompiler AI Agent after you receive the real ticket.

## Prompt

```text
Here is my Java final task. I already have a working example project open in OneCompiler.

My project name must be exactly:
Java_Lasha_Murgva_Lominadze_Shraieri

My name is:
Lasha Murgva Lominadze-Shraieri

My student code is:
2300892

Do not use the example name from the ticket.
Do not use Java_Nikoloz_Katsitadze.
Do not change my project name.

Please adapt/check the existing project exactly for this task.

If the task still says Product, keep Product.
If the task uses different model/database/table/field names, change all connected names everywhere:
- model class
- DAO class
- database name
- table name
- fields
- SQL columns
- JavaFX labels
- INSERT query
- PreparedStatement setters
- ResultSet getters
- Stream grouping
- PieChart labels

Keep it simple Java I level.
Use JavaFX, JDBC, MySQL/XAMPP, DAO, Stream API, and PieChart.
Do not use Spring, Hibernate, JPA, or packages.

Give me the final complete code for every file that must change:
- pom.xml
- schema.sql
- Main.java
- Product.java or the new model class file
- ProductDAO.java or the new DAO class file
- DBConnection.java

TASK:
[paste the full Georgian ticket here]
```

## After AI Answers

Check these manually before running:

```text
pom.xml project name = Java_Lasha_Murgva_Lominadze_Shraieri
schema.sql database name = DBConnection URL database name
schema.sql table name = DAO INSERT table name
SQL columns = Product/model fields
INSERT column order = PreparedStatement setter order
ResultSet column names = SQL column names
Stream grouping field = ticket group field
Stream numeric field = quantity or ticket quantity field
```

If the AI outputs this, fix it immediately:

```xml
<artifactId>Java_Nikoloz_Katsitadze</artifactId>
<name>Java_Nikoloz_Katsitadze</name>
```

Correct version:

```xml
<artifactId>Java_Lasha_Murgva_Lominadze_Shraieri</artifactId>
<name>Java_Lasha_Murgva_Lominadze_Shraieri</name>
```

## Real Product Mock Defaults

If the ticket is the same as the lecturer's Product mock, keep:

```text
Model class: Product
DAO class: ProductDAO
Database: productdb
Table: product
Fields: id, name, category, quantity, price
Stream: group by category, sum quantity
```

