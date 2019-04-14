package com.goinginfinity.hometest.common.utils;

import com.goinginfinity.hometest.common.exceptions.AppException;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
    private static Logger logger = Logger.getLogger(Util.class.getName());
    public static BufferedWriter getBufferedWriteOfFile(Class myClass,String fileName) throws AppException{
        File file = getFile(myClass, fileName);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            logger.log(Level.ALL,e.getMessage()+" - Error saving data");
            throw new AppException("Error saving data");
        }
        return writer;
    }
    public static BufferedReader getBufferedReaderOfFile(Class myClass,String fileName) throws AppException{
        File file = getFile(myClass, fileName);
        BufferedReader reader=null;
        try {
            reader= new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            logger.log(Level.ALL,e.getMessage()+" - configuration file not found");
            throw new AppException("configuration file not found");
        }
        return reader;
    }
    private static File getFile(Class myClass,String fileName) throws AppException {
        File myFile = new File(fileName);
        if(!myFile.isFile()){
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                throw new AppException("Error reading db file");
            }
        }
        return myFile;
    }
    public static Properties getConfiguration(Class myClass,String propertyFileName) throws AppException {
        final Properties configProperties = new Properties();

        // Attempt to read internal configuration
        InputStream configStream = null;

        // Attempt to read external configuration (overriding as necessary)
        try {
            final File configFile = new File(myClass.getClassLoader().getResource(propertyFileName).getFile());
            if(configFile.isFile()) {
                configStream = new FileInputStream(configFile);

                configProperties.load(configStream);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ALL,e.getMessage()+" - configuration file not found");
            throw new AppException("configuration file not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(configStream != null) {
                try {
                    configStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configProperties;
    }
    public static String readAlphaInput(){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        if(!userInput.matches("[A-Za-z0-9 ]+") && !userInput.equals("")) {
            System.out.println("please enter alphanumeric letters");
            readAlphaInput();
        }
        return userInput;
    }
    public static int readNumericInput(){
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        int userChoice=0;
        try {
            if(userInput.equals(""))
                userChoice=-15;
            else
                userChoice =  Integer.parseInt(userInput);
        } catch(NumberFormatException e ) {
            System.out.println("please enter a valid number");
            readNumericInput();
        }
        return userChoice;
    }
}
