package TimotheeTHIBAULT.ui.views;

import TimotheeTHIBAULT.ui.stateMachines.AbstractStateMachine;
import javafx.scene.Scene;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractView<S extends AbstractStateMachine> extends Observable implements Observer {
    protected S stateMachine;
    protected Scene scene = null;

    public AbstractView(S stateMachine) {
        this.stateMachine = stateMachine;
        stateMachine.addObserver(this);
        refreshScene();
    }

    protected void refreshScene() {
        scene = refreshView();
        setChanged();
        notifyObservers();
    }

    protected abstract Scene refreshView();

    public Scene getScene() {
        return scene;
    }

    @Override
    public void update(Observable o, Object arg) {
        refreshScene();
    }
}
