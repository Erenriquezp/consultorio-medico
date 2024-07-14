package org.uce.app.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.uce.app.utilities.Paths;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //-- Me sale error cuando quiero iniciar el login :(
        //FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.Ingresar));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.pantallaPrincipal));

        VBox root = loader.load();
        Scene scene = new Scene(root);

        // Cargar el archivo CSS
        scene.getStylesheets().add(getClass().getResource(Paths.stylesheet).toExternalForm());


        primaryStage.setTitle("Sistema de Gestión de Consultorio Médico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
