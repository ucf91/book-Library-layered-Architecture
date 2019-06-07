package com.booklibrary.repositories;

import com.booklibrary.common.dtos.Book;
import com.booklibrary.common.exceptions.AppException;
import com.booklibrary.common.utils.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleBookRepository implements BookRepository {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private String getDbFileName() throws AppException {
        Properties properties = Util.getConfiguration(this.getClass(), "database.properties");
        return properties.getProperty("dbfile.name");
    }
    private String getFullDbFileName() throws AppException{
        Properties properties = Util.getConfiguration(this.getClass(), "database.properties");
        return properties.getProperty("dbfile.path")+getDbFileName();
    }

    @Override
    public Map<Integer, Book> loadAllBooks() throws AppException {
        Map<Integer,Book> books = new LinkedHashMap<>();

        String dbfileName = getFullDbFileName();

        BufferedReader bufferedReader = Util.getBufferedReaderOfFile(this.getClass(),dbfileName);
        String st;
        try {
            while ((st = bufferedReader.readLine()) != null && !st.equals("")) {
                String[] fileRecord = st.split(",");
                Book readedBook = new Book(Integer.valueOf(fileRecord[0]),fileRecord[1],fileRecord[2],fileRecord[3]);
                books.put(readedBook.getId(),readedBook);
            }
        }catch (IOException e){
            logger.log(Level.ALL,e.getMessage()+" - Error reading db txt file");
            throw new AppException("Error reading db txt file");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new AppException("Error reading db txt file");
            }
        }
        return books;
    }

    @Override
    public void saveBooks(Map<Integer, Book> books) throws AppException {
        String dbfileName = getFullDbFileName();

        BufferedWriter bufferedWriter = Util.getBufferedWriteOfFile(this.getClass(),dbfileName);
        try {
            for(Book book:books.values()){
                bufferedWriter.write(book.toString());
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            logger.log(Level.ALL,e.getMessage()+" - Error Saving data !");
            throw new AppException("Error Saving data !");
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new AppException("Error saving db txt file");
            }
        }
    }

}
