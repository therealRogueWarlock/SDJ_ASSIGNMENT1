package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

public class WarningViewController
{
    public TextField highValueTextField;
    public TextField lowValueTextField;

    private ViewHandler viewHandler;
    private WarningViewModel warningViewModel;

    public void init(ViewHandler viewHandler, WarningViewModel warningViewModel)
    {
        this.viewHandler = viewHandler;
        this.warningViewModel = warningViewModel;
    }

    public void highValueButton(ActionEvent actionEvent)
    {
       // warningViewModel.
    }

    public void lowValueButton(ActionEvent actionEvent)
    {
       // warningViewModel.
    }
}
