package by.atmm.java.__topics.objects.finalize;

import by.atmm.java.__topics.utils.MyLog;

public class ExampleFinalizeClass {

  private String value = "Hello World";

  @Override
  protected void finalize() throws Throwable {
    try {
      // Releasing resources or other finalization
      MyLog.log("Finalization of object resources");
    } finally {
      super.finalize();
    }
  }

  // 'finalize()' is deprecated since version 9 and marked for removal
  public static void main(String[] args) {
    ExampleFinalizeClass obj = new ExampleFinalizeClass();
    obj = null;

    // Advice to JVM to execute garbage collector
    System.gc();

    MyLog.log("Main method completed");
  }
}
