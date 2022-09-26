package by.atmm.gof.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private String name = "main.db";
    private List<String> data = new ArrayList<>();

    private Database() {
    }

    private static class DatabaseHolder {
        public static final Database instance = new Database();
    }

    public static Database getInstance() {
        return DatabaseHolder.instance;
    }
}
