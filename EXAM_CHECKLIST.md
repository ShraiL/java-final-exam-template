# 30-Minute Exam Checklist

## Minutes 0-3: Parse the Ticket

- [ ] Identify model class.
- [ ] Choose at least four useful fields plus `id`.
- [ ] Identify group field.
- [ ] Identify sum/count field.
- [ ] Write database and table names.

## Minutes 3-7: XAMPP and SQL

- [ ] Start `MySQL Database` in XAMPP.
- [ ] Open phpMyAdmin.
- [ ] Create database.
- [ ] Create table.
- [ ] Confirm every column and type.

## Minutes 7-12: Model and Connection

- [ ] Create model fields.
- [ ] Create empty constructor.
- [ ] Create full constructor.
- [ ] Generate getters and setters.
- [ ] Set JDBC URL, user and password.

## Minutes 12-18: DAO

- [ ] Write `insert...()` with `PreparedStatement`.
- [ ] Check JDBC positions start at `1`.
- [ ] Call `executeUpdate()`.
- [ ] Write `getAll...()` with `ResultSet`.
- [ ] Use `while (resultSet.next())`.
- [ ] Call `executeQuery()`.

## Minutes 18-24: JavaFX

- [ ] Create one `TextField` per user input.
- [ ] Add labels and fields to `GridPane`.
- [ ] Add button event handler.
- [ ] Parse numeric fields.
- [ ] Create model object.
- [ ] Call DAO insert.
- [ ] Clear fields.

## Minutes 24-27: Stream and PieChart

- [ ] Call DAO select method.
- [ ] Use correct group field.
- [ ] Use `summingInt` or `counting`.
- [ ] Convert map entries into `PieChart.Data`.
- [ ] Add chart to layout.
- [ ] Refresh chart after insert.

## Minutes 27-30: Verify and Submit

- [ ] Compile.
- [ ] Insert at least two records.
- [ ] Verify rows in phpMyAdmin.
- [ ] Verify chart totals.
- [ ] Save JavaFX form/PieChart screenshot in `screenshots/`.
- [ ] Save phpMyAdmin table screenshot in `screenshots/`.
- [ ] Check screenshots do not expose passwords or unrelated private content.
- [ ] Check project name.
- [ ] Remove `target`, `out`, `.idea`.
- [ ] Create ZIP with required student-code filename.
