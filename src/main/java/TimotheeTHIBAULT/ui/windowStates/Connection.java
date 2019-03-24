package TimotheeTHIBAULT.ui.windowStates;

import TimotheeTHIBAULT.ui.WindowStateManager;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineConnection;
import TimotheeTHIBAULT.ui.views.ConnectionView;

import java.util.Observable;

public class Connection extends WindowState {

    public Connection(WindowStateManager windowStateManager) {
        super(windowStateManager);
        this.stateMachine = new StateMachineConnection(this);
        this.view = new ConnectionView((StateMachineConnection) stateMachine);
        view.addObserver(this);
    }

    @Override
    public String getStateName() {
        return "Connexion";
    }

    @Override
    public boolean isMaximized() {
        return false;
    }

}
