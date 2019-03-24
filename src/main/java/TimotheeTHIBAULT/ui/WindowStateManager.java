package TimotheeTHIBAULT.ui;

import TimotheeTHIBAULT.ui.windowStates.Connection;
import TimotheeTHIBAULT.ui.windowStates.Home;
import TimotheeTHIBAULT.ui.windowStates.SignUp;
import TimotheeTHIBAULT.ui.windowStates.WindowState;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowStateManager extends Application implements Observer {
    static final String APP_NAME = "My app";
    private Stage window;
    private State state;
    private BackHistory backHistory = BackHistory.getInstance();

    private WindowState currentWindowState;

    public static String getAppName() {
        return APP_NAME;
    }

    public Stage getWindow() {
        return window;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //Start with connection
        connectionState();
    }

    private void connectionState() {
        removeCurrentWindowState();
        state = State.CONNECTION;
        currentWindowState = new Connection(this);
        changeState();
    }

    private void signUpState() {
        removeCurrentWindowState();
        state = State.SIGN_UP;
        currentWindowState = new SignUp(this);
        changeState();
    }

    private void homeState() {
        removeCurrentWindowState();
        state = State.HOME;
        currentWindowState = new Home(this);
        changeState();
    }

    private void changeState() {
        currentWindowState.addObserver(this);
        setWindowTitle();
        setMaximized();
        refreshScene();
    }


    private void setMaximized() {
        if (currentWindowState != null) {
            window.setMaximized(currentWindowState.isMaximized());
        }
    }

    private void setWindowTitle() {
        if (currentWindowState != null) {
            window.setTitle(APP_NAME + " -- " + currentWindowState.getStateName());
        }
    }

    private void refreshScene() {
        if (currentWindowState != null) {
            window.setScene(currentWindowState.getScene());
        }
        window.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        refreshScene();
    }

    public void revertLastState() {
        BackHistoryNode backHistoryNode = backHistory.lastWindowState();
        if (backHistoryNode == null) {
            return;
        }

        state = (State) backHistoryNode.getState();
        currentWindowState = backHistoryNode.getWindowState();
        changeState();
    }

    public void changeStateToDesired(State desiredState) {
        switch (state) {
            case CONNECTION:
                switch (desiredState) {
                    case CONNECTION:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                    case SIGN_UP:
                        saveState();
                        signUpState();
                        break;
                    case HOME:
                        backHistory.clear();
                        homeState();
                        break;
                    default:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                }
                break;
            case SIGN_UP:
                switch (desiredState) {
                    case CONNECTION:
                        backHistory.clear();
                        connectionState();
                        break;
                    case SIGN_UP:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                    case HOME:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                    default:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                }
                break;
            case HOME:
                switch (desiredState) {
                    case CONNECTION:
                        backHistory.clear();
                        connectionState();
                        break;
                    case SIGN_UP:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                    case HOME:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                    default:
                        Logger.getLogger("logger").log(Level.WARNING,
                                "Changing " + state + " into " + desiredState + " is forbidden.");
                        break;
                }
            default:
                Logger.getLogger("logger").log(Level.WARNING,
                        "Changing " + state + " into " + desiredState + " " +
                                " is forbidden.");
                break;
        }
    }

    private void saveState() {
        backHistory.addInHisory(new BackHistoryNode(state, currentWindowState));
    }

    private void removeCurrentWindowState() {
        if (currentWindowState != null) {
            currentWindowState.deleteObserver(this);
            currentWindowState = null;
        }
    }

    public enum State {
        CONNECTION,
        SIGN_UP,
        HOME
    }

}
