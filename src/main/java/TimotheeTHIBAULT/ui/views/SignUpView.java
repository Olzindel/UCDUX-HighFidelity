package TimotheeTHIBAULT.ui.views;

import TimotheeTHIBAULT.ui.ActionOnController;
import TimotheeTHIBAULT.ui.BackHistory;
import TimotheeTHIBAULT.ui.LoadFXML;
import TimotheeTHIBAULT.ui.fxmlControllers.SignUpController;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineSignUp;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpView extends AbstractView<StateMachineSignUp> {
    public SignUpView(StateMachineSignUp stateMachine) {
        super(stateMachine);
    }

    @Override
    protected Scene refreshView() {
        Scene newScene = null;
        switch (stateMachine.getState()) {
            case SIGN_UP:
                try {
                    newScene = new Scene(LoadFXML.getResource(Parent.class,
                            "/fxmls/Connection/SignUp",
                            new ActionOnController<SignUpController>() {
                                @Override
                                public void actionOnController(SignUpController controller) {
                                    controller.setDelegatedStateMachine(stateMachine);
                                    if (BackHistory.getInstance().isEmpty()) {
                                        controller.backButton.setDisable(true);
                                    } else {
                                        controller.backButton.setDisable(false);
                                    }
                                }
                            }));
                } catch (IOException e) {
                    Logger.getLogger("logger").log(Level.SEVERE,
                            "Loading sign-up page : " + e.getMessage());
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return newScene;
    }
}
