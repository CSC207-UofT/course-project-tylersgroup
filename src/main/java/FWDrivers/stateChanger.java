package FWDrivers;


import FWDrivers.views.ITextField;
import FWDrivers.views.View;

public class stateChanger {

    /**
     * Empty Constructor for stateChanger class.
     * This is a driver class that does not yet have any parameters.
     */
    public stateChanger() {
    }

    public void changeState(String input, appState state) {
        // Exits the program if the user types "exit".

        if (!input.equals("exit")) {
            
            View currentView = state.getCurrView();
            
            if (currentView.isMenuView()) {
                View newView = (View) currentView.getMenuOptions().values().toArray()[Integer.parseInt(input)];
                state.changeCurView(newView);
            }
            //TODO: MAYBE could split the not menu and menu view changes into different classes.
            if (!currentView.isMenuView()) {
                // Handles user input in non-menu views
                textInHandler textHandler = new textInHandler();
                textHandler.handleText(input, currentView);
                // Type cast to ITextField that has the textField methods necessary for text input.
                ITextField currentView1 = (ITextField) currentView;
                // Check what footer was last print to screen, if no more footers to parse, pass to next view.

                String[] footers = currentView1.getTextFields();
                for (int i = 0; i < footers.length;){
                    if (currentView.getFooter().equals(footers[i]) && i < footers.length - 1){
                        currentView1.changeFooter(i + 1);
                        state.changeCurView((View)currentView1);
                    }
                    i++;
                }

                if (currentView.getFooter().equals(footers[footers.length - 1]) && textHandler.getComplete()){
                    state.changeCurView(currentView1.getNextView());
                }
            }
        } else{
            state.stopProgram();
        }
    }
}