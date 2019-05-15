import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.htlleoben.dbmm.transferobjects.User;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
  @FXML
  public ListView<String> userList;
  private List<User> users;
  private ObservableList<String> names = FXCollections.observableArrayList(
        "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    userList.setItems(names);

  }

  @FXML
  private void closeProgram() {
    System.exit(0);
  }


}
