import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.htlleoben.dbmm.Interfaces.UserDao;
import org.htlleoben.dbmm.daoimplementations.UserDaoFile;
import org.htlleoben.dbmm.daoimplementations.UserDaoRelational;
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
  private UserDao userData = null;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    userList.setItems(names);
    int auswahl = 1;
    User sampleUser = new User("Markus", "asdf1234", "mailme@mail.com");

    // Verbindung zu relationaler DB
    if (auswahl == 1) {
      userData = new UserDaoRelational();
    }
    // Daten in datei schreiben und lesen
    if (auswahl == 2) {
      userData = new UserDaoFile();
    }
    /* Write the Sample User to the according storage */
    //userData.save(myUser);
    //get all users from the database - the typecast is necessary as we want our list to update when the userlist changes
    users = userData.getAllUsers();
    //update the data in the observable list - currently we can only use strings
    for (User u : users) {
      names.add(u.getUserName());
    }
  }

  @FXML
  private void closeProgram() {
    System.exit(0);
  }


}
