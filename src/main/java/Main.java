import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main extends Application {
    private final ProductDAO productDAO = new ProductDAO();
    private final PieChart pieChart = new PieChart();

    @Override
    public void start(Stage stage) {
        TextField nameField = new TextField();
        TextField categoryField = new TextField();
        TextField quantityField = new TextField();
        TextField priceField = new TextField();
        Button addButton = new Button("Add Product");

        GridPane form = new GridPane();
        form.setPadding(new Insets(15));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Name:"), 0, 0);
        form.add(nameField, 1, 0);
        form.add(new Label("Category:"), 0, 1);
        form.add(categoryField, 1, 1);
        form.add(new Label("Quantity:"), 0, 2);
        form.add(quantityField, 1, 2);
        form.add(new Label("Price:"), 0, 3);
        form.add(priceField, 1, 3);
        form.add(addButton, 1, 4);

        addButton.setOnAction(event -> {
            try {
                String name = nameField.getText();
                String category = categoryField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                Product product = new Product(0, name, category, quantity, price);
                productDAO.insertProduct(product);
                updatePieChart();

                nameField.clear();
                categoryField.clear();
                quantityField.clear();
                priceField.clear();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
            }
        });

        VBox root = new VBox(20, form, pieChart);
        root.setPadding(new Insets(15));

        updatePieChart();

        Scene scene = new Scene(root, 550, 550);
        stage.setTitle("Product Application");
        stage.setScene(scene);
        stage.show();
    }

    private void updatePieChart() {
        List<Product> products = productDAO.getAllProducts();

        Map<String, Integer> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingInt(Product::getQuantity)
                ));

        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();

        groupedProducts.forEach((category, totalQuantity) ->
                chartData.add(
                        new PieChart.Data(category + " - " + totalQuantity, totalQuantity)
                )
        );

        pieChart.setData(chartData);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

