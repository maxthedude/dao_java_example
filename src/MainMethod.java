import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class MainMethod extends Application {
  @FXML
  public ListView<String> userList;

  public static void main(String[] args) {
    System.out.println("Launching JavaFX application");
    launch(args);
  }

  @FXML
  @Override
  public void init() {
    System.out.println("init() method");

  }

  @Override
  public void start(Stage stage) {
    // Create the FXMLLoader
    FXMLLoader loader = new FXMLLoader();

    System.out.println(System.getProperty("user.dir"));
    // Path to the FXML File
    String fxmlDocPath = "MainWindow.fxml";
    try {
      FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

      // Create the Pane and all Details
      VBox root = (VBox) loader.load(fxmlStream);
      Pane myPane = (Pane) FXMLLoader.load(getClass().getResource
            ("MainWindow.fxml"));

      // Create the Scene
      Scene scene = new Scene(root);

      // Set the Scene to the Stage
      stage.setScene(scene);
      // Set the Title to the Stage
      stage.setTitle("A simple FXML Example");
      // Display the Stage
      stage.show();
    } catch (Exception e) {
      System.out.println("Something went wrong with the UI");
      e.printStackTrace();
    }
  }


}
