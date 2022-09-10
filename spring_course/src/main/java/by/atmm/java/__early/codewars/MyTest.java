package by.atmm.java.__early.codewars;

public class MyTest {

    public static void main(String[] args) {
        Watch watch = new Watch();
        watch.start();
        Maskify.maskify("4556364607935616");
        Maskify.maskify("64607935616");
        Maskify.maskify("1");
        Maskify.maskify("");

        // "What was the name of your first pet?"
        Maskify.maskify("Skippy");
        Maskify.maskify("Nananananananananananananananana Batman!");
        watch.totalTime("Collection time = ");

    }
}
