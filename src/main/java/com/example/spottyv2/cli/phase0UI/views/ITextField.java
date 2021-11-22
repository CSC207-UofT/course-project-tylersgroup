package com.example.spottyv2.cli.phase0UI.views;

/**
 * Interface to specify if a view class is of the type that needs to handle string inputs from
 * the user rather than just single integers.
 */
public interface ITextField {


    void updateCurrentFooter(int i);

    String[] getTextFields();

    void modifyFooter(String newFooter);

    View getNextView();
}
