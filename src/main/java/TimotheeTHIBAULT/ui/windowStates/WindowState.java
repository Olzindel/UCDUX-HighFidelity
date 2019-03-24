package TimotheeTHIBAULT.ui.windowStates;

import TimotheeTHIBAULT.ui.WindowStateManager;
import TimotheeTHIBAULT.ui.stateMachines.AbstractStateMachine;
import TimotheeTHIBAULT.ui.views.AbstractView;
import javafx.scene.Scene;

import java.util.Observable;
import java.util.Observer;

public abstract class WindowState extends Observable implements Observer {
    protected AbstractStateMachine stateMachine;
    protected AbstractView view;
    protected WindowStateManager windowStateManager;

    public WindowState(WindowStateManager windowStateManager) {
        this.windowStateManager = windowStateManager;
    }

    public void changeWindowState(WindowStateManager.State desiredState) {
        windowStateManager.changeStateToDesired(desiredState);
    }

    public void revertLastWindowState() {
        windowStateManager.revertLastState();
    }

    public abstract String getStateName();

    public abstract boolean isMaximized();

    public Scene getScene() {
        return view.getScene();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
