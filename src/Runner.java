import org.htlleoben.dbmm.Interfaces.UserDao;
import org.htlleoben.dbmm.daoimplementations.UserDaoFile;
import org.htlleoben.dbmm.daoimplementations.UserDaoRelational;
import org.htlleoben.dbmm.transferobjects.User;


public class Runner {

  public static void main(String[] args) {
    int auswahl = 1;
    User myUser = new User("Markus", "asdf1234", "mailme@mail.com");
    UserDao userData = null;

    // Verbindung zu relationaler DB
    if (auswahl == 1) {
      userData = new UserDaoRelational();
    }
    // Daten in datei schreiben und lesen
    if (auswahl == 2) {
      userData = new UserDaoFile();
    }
    userData.save(myUser);
  }

}
