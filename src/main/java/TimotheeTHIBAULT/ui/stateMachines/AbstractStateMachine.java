package TimotheeTHIBAULT.ui.stateMachines;

import TimotheeTHIBAULT.ui.windowStates.WindowState;

import java.util.Observable;

public abstract class AbstractStateMachine<T extends Enum> extends Observable {
    protected T state;
    protected WindowState windowState;

    public AbstractStateMachine(WindowState windowState) {
        this.windowState = windowState;
        init();
    }

    public T getState() {
        return state;
    }

    protected abstract void init();
}
