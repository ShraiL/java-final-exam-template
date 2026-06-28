# Java I Final Exam Template

Dieses Repository ist eine lauffähige Vorlage für den erwarteten Final-Ticket-Typ:

```text
JavaFX form
Model class
MySQL/XAMPP
JDBC
DAO
INSERT
SELECT
Stream API
PieChart
```

Die Namen im echten Ticket können anders sein. Zum Beispiel kann aus `Product`
ein `Book`, `Medicine`, `Car` oder `Student` werden. Die Architektur bleibt gleich.

## Start Here

If you create the project manually in IntelliJ and copy files from GitHub, start
with the exact guide:

1. [COPY_PASTE_EXAM_TUTORIAL.md](COPY_PASTE_EXAM_TUTORIAL.md)
2. [INTELLIJ_SHORTCUTS_AND_RENAME_TIPS.md](INTELLIJ_SHORTCUTS_AND_RENAME_TIPS.md)
3. [CHANGE_MAP.md](CHANGE_MAP.md)

If you download the full GitHub ZIP instead:

1. Rename the downloaded folder and Maven project to the name required by the ticket.
2. Starte XAMPP: `Manage Servers` → `MySQL Database` → `Start`.
3. Öffne `http://localhost/phpmyadmin`.
4. Führe [schema.sql](schema.sql) aus.
5. Öffne das Repository als Maven project in IntelliJ.
6. Starte:

```bash
./mvnw javafx:run
```

## Project Structure

| File | Responsibility |
|---|---|
| `Product.java` | Model class: fields, constructors, getters and setters |
| `DBConnection.java` | JDBC connection to MySQL |
| `ProductDAO.java` | `INSERT` and `SELECT` database operations |
| `Main.java` | JavaFX form, event handler, Stream API and PieChart |
| `schema.sql` | MySQL database and table |
| `pom.xml` | JavaFX and MySQL JDBC dependencies |
| `screenshots/` | Proof that the form, insert, database and chart work |

## Reference Data

Insert these rows:

```text
Salmon | Fish   | 4  | 12.50
Tuna   | Fish   | 6  | 9.50
Bread  | Bakery | 20 | 2.00
```

The chart groups by `category` and sums `quantity`:

```text
Fish - 10
Bakery - 20
```

## Important Stream Choice

Group by category:

```java
Product::getCategory
```

Group by product name:

```java
Product::getName
```

Use the field explicitly requested in the ticket.

## Run Checks

Compile:

```bash
./mvnw clean compile
```

Run:

```bash
./mvnw javafx:run
```

Verify rows in phpMyAdmin:

```sql
SELECT * FROM product;
```

## Screenshots for Submission

Before creating the final ZIP, save the required screenshots inside:

```text
screenshots/
```

Open [screenshots/README.md](screenshots/README.md) for the exact screenshot list.

## Files to Read Before the Exam

- [CHANGE_MAP.md](CHANGE_MAP.md): exactly what must change for another ticket
- [COPY_PASTE_EXAM_TUTORIAL.md](COPY_PASTE_EXAM_TUTORIAL.md): exact IntelliJ/XAMPP/manual copy workflow
- [INTELLIJ_SHORTCUTS_AND_RENAME_TIPS.md](INTELLIJ_SHORTCUTS_AND_RENAME_TIPS.md): Mac shortcuts, Georgian ticket keywords and safe rename workflow
- [EXAM_CHECKLIST.md](EXAM_CHECKLIST.md): the 30-minute implementation order
- [TROUBLESHOOTING.md](TROUBLESHOOTING.md): common errors and fixes
- [screenshots/README.md](screenshots/README.md): required submission screenshots
- [examples/BOOK_VARIANT.md](examples/BOOK_VARIANT.md): complete rename example
- [examples/STUDENT_VARIANT.md](examples/STUDENT_VARIANT.md): example using `counting()`
