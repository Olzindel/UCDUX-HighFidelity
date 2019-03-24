package TimotheeTHIBAULT.ui.fxmlControllers;

import TimotheeTHIBAULT.ui.BackHistory;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineSignUp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class SignUpController {
    @FXML
    public Button backButton;

    private StateMachineSignUp delegatedStateMachine;

    public SignUpController() {
    }

    public void setDelegatedStateMachine(StateMachineSignUp stateMachine) {
        this.delegatedStateMachine = stateMachine;
    }


    public void clickOnBack() {
        delegatedStateMachine.clickOnBack();
    }
}
