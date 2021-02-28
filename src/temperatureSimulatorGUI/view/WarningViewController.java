package temperatureSimulatorGUI.view;
// todo: stuff
import core.ViewHandler;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import temperatureSimulatorGUI.viewmodel.ViewModel;
import temperatureSimulatorGUI.viewmodel.WarningViewModel;

import java.io.IOException;

public class WarningViewController implements ViewController
{
    public TextField maxValueTextField;
    public TextField minValueTextField;

    private ViewHandler viewHandler;
    private WarningViewModel warningViewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel warningViewModel)
    {
        this.viewHandler = viewHandler;
        this.warningViewModel = (WarningViewModel) warningViewModel;


        DoubleProperty maxValueWarningModel = this.warningViewModel.maxWarningProperty();
        DoubleProperty minValueWarningModel = this.warningViewModel.minWarningProperty();

        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(maxValueTextField.textProperty(),maxValueWarningModel,converter);
        Bindings.bindBidirectional(minValueTextField.textProperty(),minValueWarningModel,converter);

    }

    public void temperatureViewButtonPressed(ActionEvent actionEvent) throws IOException {
        viewHandler.openView("temperature");
    }

    public void confirmValuesButton(ActionEvent actionEvent)
    {
        warningViewModel.updateAlarmValues();
    }

}
