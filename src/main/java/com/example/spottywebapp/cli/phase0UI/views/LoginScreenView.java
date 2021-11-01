package com.example.spottywebapp.cli.phase0UI.views;

public class LoginScreenView extends View implements ITextField{
    private final String[] textFields;
    private final View nextView;

    /**
     * LoginScreenView constructor with parameters:
     */
    public LoginScreenView(){
        super.header = "Please input your username and password when prompted:";
        super.menuView = false;
        this.textFields = new String[]{"Username: ", "Password: "};
        super.footer = textFields[0];
        this.nextView = new HomeScreenView();

    }

    @Override
    public String toString() {
        return super.header + "\n" + super.footer;
    }
    @Override
    public void updateCurrentFooter(int i){
        super.footer = textFields[i];
    }
    @Override
    public String[] getTextFields(){
        return this.textFields;
    }

    @Override
    public void modifyFooter(String a) {

    }

    @Override
    public View getNextView(){
        return this.nextView;
    }
}
