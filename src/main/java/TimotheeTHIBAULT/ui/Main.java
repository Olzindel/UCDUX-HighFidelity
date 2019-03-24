package TimotheeTHIBAULT.ui;

import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        SvgImageLoaderFactory.install();
        Application.launch(WindowStateManager.class, args);
    }
}
