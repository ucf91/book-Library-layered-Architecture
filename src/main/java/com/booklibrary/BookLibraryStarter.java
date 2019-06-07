package com.booklibrary;

import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Injector;

public class BookLibraryStarter {
    private Application application;
    public BookLibraryStarter(){
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
