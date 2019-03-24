package TimotheeTHIBAULT.ui.fxmlControllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomeController {
    @FXML
    public TopBarController topBarController;

    @FXML
    public BorderPane windowContainer;

    @FXML
    public VBox mealsPropositions;

    @FXML
    public ScrollPane mealsSrollBar;
    public VBox center;

    @FXML
    public void initialize() {
        topBarController.root.prefWidthProperty().bind(windowContainer.widthProperty());
        mealsPropositions.prefWidthProperty().bind(mealsSrollBar.widthProperty());
        center.prefHeightProperty().bind(windowContainer.heightProperty());
    }
}
