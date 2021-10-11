package FWDrivers.views;

public class genPlaylistView extends View{

    public genPlaylistView(){
        super.header = "Please type in a sentence or word below:";
        super.menuView = false;
    }

    @Override
    public String toString(){
        return super.header;

    }
}
