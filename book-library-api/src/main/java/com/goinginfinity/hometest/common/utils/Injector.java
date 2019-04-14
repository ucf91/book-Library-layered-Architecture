package com.goinginfinity.hometest.common.utils;

import com.goinginfinity.hometest.common.exceptions.AppException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// since Dependency injection is best practice, I managed to create my own basic injector
public class Injector{
    private static Logger logger = Logger.getLogger(Injector.class.getName());
    private static Map<String,Object> objects = new HashMap<>();

    private Injector() {
    }

    public static Object getObject(Class classType) throws AppException {
        if (!objects.containsKey(classType.getName())) {
            ServiceLoader<Object> loader = ServiceLoader.load(classType);
            try {
                Iterator<Object> instances = loader.iterator();
                while (instances.hasNext()) {
                    Object instance = instances.next();
                    if (instance != null) {
                        objects.put(classType.getName(),instance);
                        break;
                    }
                }
            } catch (ServiceConfigurationError serviceError) {
                logger.log(Level.ALL,serviceError.getMessage());
                throw new AppException("couldn't inject the class object");
            }
        }
      return objects.get(classType.getName());
    }
}
