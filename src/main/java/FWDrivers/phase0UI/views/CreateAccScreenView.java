package FWDrivers.phase0UI.views;

public class CreateAccScreenView extends View{

    public CreateAccScreenView(){
        super.header = "Please input your username and password when prompted:";
        super.menuView = false;

    }

    @Override
    public String toString(){
        return super.header;
    }
}
