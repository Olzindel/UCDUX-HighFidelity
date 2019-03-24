package TimotheeTHIBAULT.ui.stateMachines;

import TimotheeTHIBAULT.ui.WindowStateManager;
import TimotheeTHIBAULT.ui.windowStates.WindowState;

/**
 * Hello world!
 */
public class StateMachineConnection extends AbstractStateMachine<ConnectionStates> {

    public StateMachineConnection(WindowState windowState) {
        super(windowState);
    }

    @Override
    protected final void init() {
        /**
         * Start with connection page.
         */
        connectionState();

    }

    private void connectionState() {
        state = ConnectionStates.CONNECTION;
        setChanged();
        notifyObservers(state);

//        currentStage.setScene(newScene);
    }

    public void clickOnConnectionButton() {
        switch (state) {
            case CONNECTION:
                windowState.changeWindowState(WindowStateManager.State.HOME);
                break;
            default:
                //Forbidden
                break;
        }
    }

    public void clickOnSignUpButton() {
        switch (state) {
            case CONNECTION:
                windowState.changeWindowState(WindowStateManager.State.SIGN_UP);
                break;
            default:
                //Forbidden
                break;
        }
    }
}
