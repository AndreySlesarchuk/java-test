package by.atmm.gof.creational.singleton;

public class DatabaseDriver {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        System.out.println(db1.toString());

        Database2 db2 = Database2.getInstance();
        db2.insertData("1");
        db2.insertData("2");
        System.out.println("Database2 name: " + db2.getName() + db2);
        Database2 db3 = Database2.getInstance();
        db3.insertData("3");
        db3.insertData("4");
        System.out.println("Database3 name: " + db3.getName() + db3);
        for (String i: db3.getData()) {
            System.out.println(i);
        }
    }
}
