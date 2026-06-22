# Student Variant

This variant demonstrates `counting()` instead of `summingInt()`.

## Ticket Map

```text
Model: Student
DAO: StudentDAO
Database: studentdb
Table: student
Fields: id, name, faculty, age, grade
Group by: faculty
Aggregate: count students
```

## Stream

```java
Map<String, Long> groupedStudents = students.stream()
        .collect(Collectors.groupingBy(
                Student::getFaculty,
                Collectors.counting()
        ));
```

The map value is `Long`, not `Integer`.

## PieChart

```java
ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();

groupedStudents.forEach((faculty, count) ->
        chartData.add(new PieChart.Data(faculty + " - " + count, count))
);
```

