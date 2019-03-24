package TimotheeTHIBAULT.ui;

import TimotheeTHIBAULT.ui.windowStates.WindowState;

public class BackHistoryNode<T extends Enum> {
    private T state;
    private WindowState windowState;

    public BackHistoryNode(T state, WindowState windowState) {
        this.state = state;
        this.windowState = windowState;
    }

    public T getState() {
        return state;
    }

    public void setState(T state) {
        this.state = state;
    }

    public WindowState getWindowState() {
        return windowState;
    }

    public void setWindowState(WindowState windowState) {
        this.windowState = windowState;
    }
}
