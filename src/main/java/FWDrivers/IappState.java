package FWDrivers;

import FWDrivers.views.View;

/**
 * Interface to structure what the appState class needs to implement.
 * Can extend functionality to appState by adding new methods here.
 */
public interface IappState {

    boolean isRunning();

    void stopProgram();

    View getCurrView();

    void changeCurView(View view);
}
