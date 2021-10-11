package FWDrivers.views;

/**
 * Interface to specify if a view class is of the type that needs to handle string inputs from
 * the user rather than just single integers.
 */
public interface ITextField {

    void changeFooter(int i);

    String[] getTextFields();


    View getNextView();
}
