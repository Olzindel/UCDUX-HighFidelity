package TimotheeTHIBAULT.ui.stateMachines;

import TimotheeTHIBAULT.ui.windowStates.WindowState;

public class StateMachineSignUp extends AbstractStateMachine<SignUpStates> {
    public StateMachineSignUp(WindowState windowState) {
        super(windowState);
    }

    @Override
    protected void init() {
        signUpState();
    }

    private void signUpState() {
        state = SignUpStates.SIGN_UP;
        setChanged();
        notifyObservers(state);
    }

    public void clickOnBack() {
        windowState.revertLastWindowState();
    }
}
