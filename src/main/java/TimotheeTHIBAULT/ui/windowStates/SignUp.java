package TimotheeTHIBAULT.ui.windowStates;

import TimotheeTHIBAULT.ui.WindowStateManager;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineSignUp;
import TimotheeTHIBAULT.ui.views.SignUpView;

import java.util.Observable;

public class SignUp extends WindowState {
    public SignUp(WindowStateManager windowStateManager) {
        super(windowStateManager);
        this.stateMachine = new StateMachineSignUp(this);
        this.view = new SignUpView((StateMachineSignUp) stateMachine);

    }

    @Override
    public String getStateName() {
        return "Inscription";
    }

    @Override
    public boolean isMaximized() {
        return false;
    }

}
