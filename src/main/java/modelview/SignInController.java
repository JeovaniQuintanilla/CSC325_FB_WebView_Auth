package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author quint
 */
public class SignInController implements Initializable {

    @FXML
    private Button SignInBtn;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField PhoneField;
    @FXML
    private MenuItem closeProgram;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void verifyUser(ActionEvent event) throws IOException {
        UserRecord userRecord;

        {
            try {
                userRecord = FirebaseAuth.getInstance().getUserByEmail(EmailField.getText().trim());

                if (userRecord.getEmail().equals(EmailField.getText())) {
                    App.setRoot("AccessFBView.fxml");
                    // See the UserRecord reference doc for the contents of userRecord.
                    System.out.println("Successfully fetched user data: " + userRecord.getEmail());
                }

            } catch (FirebaseAuthException ex) {

            }

        }
    }

    @FXML
    private void toSignUpWindow(MouseEvent event) {
        try {
            App.setRoot("SignUp.fxml");
        } catch (IOException o) {

        }
    }

    @FXML
    private void closeProgram(ActionEvent event) {
        System.exit(0);
    }

}
