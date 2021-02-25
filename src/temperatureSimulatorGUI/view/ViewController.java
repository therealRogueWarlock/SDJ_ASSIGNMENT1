package temperatureSimulatorGUI.view;

import core.ViewHandler;
import temperatureSimulatorGUI.viewmodel.ViewModel;

public interface ViewController {
    void init(ViewHandler viewHandler, ViewModel viewModel);
}
