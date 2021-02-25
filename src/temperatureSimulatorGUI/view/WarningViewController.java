package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import temperatureSimulatorGUI.viewmodel.ViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

import java.io.IOException;

public class WarningViewController implements ViewController
{
    public TextField highValueTextField;
    public TextField lowValueTextField;

    private ViewHandler viewHandler;
    private WarningViewModel warningViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel warningViewModel)
    {
        this.viewHandler = viewHandler;
        this.warningViewModel = (WarningViewModel) warningViewModel;
    }

    public void temperatureViewButtonPressed(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("temperature");
    }

    public void confirmValuesButton(ActionEvent actionEvent)
    {
    }
}
