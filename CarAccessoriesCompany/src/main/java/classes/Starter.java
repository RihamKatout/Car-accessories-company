package classes;

import database.DatabaseConnection;
import database.RetrievingData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class Starter extends Application {
    public static final Logger logger = Logger.getLogger(Starter.class.getName());
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        DBConnector.setConnector(new DatabaseConnection());
        logger.info(DBConnector.getConnector().getStatus());

        RetrievingData dataRetriever = new RetrievingData(DBConnector.getConnector().getCon());
        List<Product> products = dataRetriever.selectFromProductsTable("");
        for (Product p: products) {
            System.out.println(p);
        }

//        FXMLLoader fxmlLoader = new FXMLLoader(Starter.class.getResource("/FXMLFiles/login.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 608, 837);
//        stage.setTitle("Car Zone Company");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}