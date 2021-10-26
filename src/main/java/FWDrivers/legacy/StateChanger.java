
package FWDrivers.legacy;


import Controllers.createPlaylistHandler;
import FWDrivers.legacy.views.View;
/**
public class StateChanger {


     * Empty Constructor for stateChanger class.
     * This is a driver class that does not yet have any parameters.

    public StateChanger() {
    }

    public void changeState(String input, AppState state) {
        // Exits the program if the user types "exit".

        if (!input.equals("exit")) {

            View currentView = state.getCurrView();
            //TODO: ADD bad user input handling.
            if (currentView.isMenuView()) {
                View newView = (View) currentView.getMenuOptions().values().toArray()[Integer.parseInt(input)];
                state.changeCurView(newView);
            }
            //TODO: MAYBE could split the not menu and menu view changes into different classes.
            if (!currentView.isMenuView()) {
                // Handles user input in non-menu views
                createPlaylistHandler playlistHandler = new createPlaylistHandler();
                String out = playlistHandler.makePlaylist(input);

                //((GenPlaylistView) currentView).modifyFooter(out);
                // Type cast to ITextField that has the textField methods necessary for text input.
                //ITextField currentView1 = (ITextField) currentView;
                // Check what footer was last print to screen, if no more footers to parse, pass to next view.

//                String[] footers = currentView1.getTextFields();
//                for (int i = 0; i < footers.length;){
//                    if (currentView.getFooter().equals(footers[i]) && i < footers.length - 1){
//                        currentView1.updateCurrentFooter(i + 1);
//                        state.changeCurView((View)currentView1);
//                    }
//                    i++;
//                }
                System.out.println(out);
                //state.changeCurView(currentView);
//                if (currentView.getFooter().equals(footers[footers.length - 1]) && playlistHandler.getComplete()){
//                    state.changeCurView(currentView1.getNextView());
//                }
                //((GenPlaylistView) currentView).updateNextView(new HomeScreenView());
            }
        } else{
            state.stopProgram();
        }
    }
}
*/