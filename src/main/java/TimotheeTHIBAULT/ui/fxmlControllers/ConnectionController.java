package TimotheeTHIBAULT.ui.fxmlControllers;

import TimotheeTHIBAULT.ui.stateMachines.StateMachineConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ConnectionController {
    @FXML
    public BorderPane mainContent;
    @FXML
    public Label connectionText;

    @FXML
    public VBox connectionForm;

    @FXML
    public TextField textFieldNickName;

    @FXML
    public PasswordField passwordFieldPassword;

    private StateMachineConnection delegatedStateMachine;

    public void setDelegatedStateMachine(StateMachineConnection stateMachine) {
        this.delegatedStateMachine = stateMachine;
    }

    public void clickButtonConnexion(ActionEvent actionEvent) {
        delegatedStateMachine.clickOnConnectionButton();
    }

    public void clickOnSignUp(ActionEvent actionEvent) {
        delegatedStateMachine.clickOnSignUpButton();
    }
}
