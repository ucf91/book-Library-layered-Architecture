package com.goinginfinity.hometest;

import com.goinginfinity.hometest.common.exceptions.AppException;
import com.goinginfinity.hometest.common.utils.Injector;

public class HomeTest {
    private Application application;
    public HomeTest(){
        try {
            application = (Application)Injector.getObject(Application.class);
        } catch (AppException e) {
            System.out.println("Application couldn't start!!");
        }
    }

    public Application getApplication() {
        return application;
    }
}
