package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import temperatureSimulatorGUI.view.TemperatureViewController;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView("temperature");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene;
        Parent root;

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("../view/"+viewToOpen.toLowerCase()+"/" + viewToOpen + "View.fxml"));
        root = loader.load();

        TemperatureViewController viewController = loader.getController();
        viewController.init(this);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}