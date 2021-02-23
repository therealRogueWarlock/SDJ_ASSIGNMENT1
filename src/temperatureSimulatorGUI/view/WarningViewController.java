package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import temperatureSimulatorGUI.viewmodel.ViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

public class WarningViewController
{
    public TextField highValueTextField;
    public TextField lowValueTextField;

    private ViewHandler viewHandler;
    private WarningViewModel warningViewModel;

    public void init(ViewHandler viewHandler, ViewModel warningViewModel)
    {
        this.viewHandler = viewHandler;
        this.warningViewModel = (WarningViewModel) warningViewModel;
    }

    public void temperatureViewButtonPressed(ActionEvent actionEvent)
    {
        //Switch to TemperatureView.fmxl
    }

    public void confirmValuesButton(ActionEvent actionEvent)
    {
    }
}
