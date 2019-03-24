package TimotheeTHIBAULT.ui.windowStates;

import TimotheeTHIBAULT.ui.WindowStateManager;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineHome;
import TimotheeTHIBAULT.ui.views.HomeView;

import java.util.Observable;

public class Home extends WindowState {

    public Home(WindowStateManager windowStateManager) {
        super(windowStateManager);
        this.stateMachine = new StateMachineHome(this);
        this.view = new HomeView((StateMachineHome) stateMachine);
    }

    @Override
    public String getStateName() {
        return "Page d'accueil";
    }

    @Override
    public boolean isMaximized() {
        return true;
    }

}
