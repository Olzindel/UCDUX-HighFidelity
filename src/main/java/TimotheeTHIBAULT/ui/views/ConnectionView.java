package TimotheeTHIBAULT.ui.views;

import TimotheeTHIBAULT.ui.ActionOnController;
import TimotheeTHIBAULT.ui.LoadFXML;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineConnection;
import TimotheeTHIBAULT.ui.fxmlControllers.ConnectionController;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionView extends AbstractView<StateMachineConnection> {

    public ConnectionView(StateMachineConnection stateMachine) {
        super(stateMachine);
    }

    @Override
    protected final Scene refreshView() {
        Scene newScene = null;
        switch (stateMachine.getState()) {
            case CONNECTION:
                try {
                    newScene = new Scene(LoadFXML.getResource(Parent.class,
                            "/fxmls/Connection/Connection",
                            new ActionOnController<ConnectionController>() {
                                @Override
                                public void actionOnController(ConnectionController controller) {
                                    controller.setDelegatedStateMachine(stateMachine);
                                }
                            }));
                } catch (IOException e) {
                    Logger.getLogger("logger").log(Level.SEVERE,
                            "Loading connection page : " + e.getMessage());
                }
                break;
            default:
                break;
        }
        return newScene;
    }
}
