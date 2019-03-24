package TimotheeTHIBAULT.ui;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LoadFXML {
    public static <T> T getResource(Class<T> type, String name,
                                    ActionOnController actionOnController) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoadFXML.class.getResource(name + ".fxml"));

        T returned = loader.load();
        actionOnController.actionOnController(loader.getController());

        return returned;
    }

    public static <T> T getResource(Class<T> type, String name) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoadFXML.class.getResource(name + ".fxml"));

        T returned = loader.load();

        return returned;
    }
}
