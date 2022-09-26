package by.atmm.gof.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class Database2 {
    private String name = "main2.db";

    private List<String> data = new ArrayList<>();
    private static Database2 instance = null;

    private Database2() {
    }

    public void insertData(String str) {
        data.add(str);
    }

    public static Database2 getInstance() {
        if (instance == null) instance = new Database2();
        return instance;
    }

    public List<String> getData() {
        return data;
    }

    public String getName() {
        return name;
    }

}
