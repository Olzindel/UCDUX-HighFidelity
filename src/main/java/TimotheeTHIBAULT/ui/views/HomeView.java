package TimotheeTHIBAULT.ui.views;

import TimotheeTHIBAULT.ui.ActionOnController;
import TimotheeTHIBAULT.ui.BackHistory;
import TimotheeTHIBAULT.ui.LoadFXML;
import TimotheeTHIBAULT.ui.fxmlControllers.HomeController;
import TimotheeTHIBAULT.ui.fxmlControllers.SignUpController;
import TimotheeTHIBAULT.ui.stateMachines.StateMachineHome;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeView extends AbstractView<StateMachineHome> {

    public HomeView(StateMachineHome stateMachine) {
        super(stateMachine);
    }

    @Override
    protected Scene refreshView() {
        Scene newScene = null;
        try {
            newScene = new Scene(LoadFXML.getResource(Parent.class, "/fxmls" +
                    "/Main/HomePage", new ActionOnController<HomeController>() {
                @Override
                public void actionOnController(HomeController controller) {
                    if (BackHistory.getInstance().isEmpty()) {
                        controller.topBarController.backButton.setDisable(true);
                    } else {
                        controller.topBarController.backButton.setDisable(false);
                    }
                }
            }));
        } catch (IOException e) {
            Logger.getLogger("logger").log(Level.SEVERE, "Unable to load the " +
                    "view : " + e.getMessage());
            e.printStackTrace();
        }

        return newScene;
    }
}
