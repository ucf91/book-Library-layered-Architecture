package com.goinginfinity.hometest;

import com.goinginfinity.hometest.common.dtos.Book;
import com.goinginfinity.hometest.common.exceptions.AppException;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            new HomeTest().getApplication().run();
        } catch (AppException e) {
            System.out.println(e.getMessage());
        }

//        String ff = "ffffffff";
//        System.out.println(ff.contains("ffdf"));
//        HashMap<String,Book> hashMap = new HashMap<>();
//        hashMap.put("1",new Book(1,"hahah","test","yarab"));
//        hashMap.put("2",new Book(2,"aydam","test","yarab"));
//        hashMap.put("3",new Book(3,"aykalam","test","yarab"));
//        hashMap.put("4",new Book(4,"kalabal","test","yarab"));
//        hashMap.containsValue("d");
//        String list = hashMap.values().stream().filter(book->book.toString().contains("kal"))
//                .map(book->book.printBookAsItem())
//                .collect(Collectors.joining("\n"));
//
//        System.out.println(list);
    }
}
