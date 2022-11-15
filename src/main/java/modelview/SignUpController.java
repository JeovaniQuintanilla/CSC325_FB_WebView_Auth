
package modelview;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author quint
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField EmailField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField phoneNumField;
    @FXML
    private TextField nameField;
    @FXML
    private Button registerBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private void regRecord(ActionEvent event) {
        registerUser();
        try {
            App.setRoot("SignIn.fxml");
        } catch (IOException ex) {
          
        }
       
    }
    
    @FXML
     public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(EmailField.getText().trim())
                .setEmailVerified(false)
                .setPassword(passwordField.getText().trim())
                .setPhoneNumber("+1" + phoneNumField.getText().trim())
                .setDisplayName(nameField.getText())
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());
            return true;

        } catch (FirebaseAuthException ex) {
           // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @FXML
    private void closeProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void returnToSignIn(ActionEvent event) {
         try{
            App.setRoot("SignIn.fxml");
        }catch(IOException o){
            
        }
    }
    
}
