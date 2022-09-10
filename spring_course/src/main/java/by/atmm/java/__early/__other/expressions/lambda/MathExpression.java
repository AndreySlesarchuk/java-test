package by.atmm.java.__early.__other.expressions.lambda;

import java.util.logging.Logger;

/**
 * Created by Andrey Slesarchuk on 10/19/2020.
 */
public class MathExpression {

  static Logger log = Logger.getLogger(String.valueOf(MathExpression.class));

  public static void main(String[] args) {

    MathExpression tester = new MathExpression();

    // with type declaration
    MathOperation addition = (int a, int b) -> a + b;

    // with out type declaration
    MathOperation subtraction = (a, b) -> a - b;

    // with return statement along with curly braces
    MathOperation multiplication = (int a, int b) -> {
      int n = a * b;
      return n;
    };

    // without return statement and without curly braces
    MathOperation division = (int a, int b) -> a / b;

    log.info("10 + 5 = " + tester.operate(10, 5, addition));
    log.info("10 - 5 = " + tester.operate(10, 5, subtraction));
    log.info("10 x 5 = " + tester.operate(10, 5, multiplication));
    log.info("10 / 5 = " + tester.operate(10, 5, division));

    // without parenthesis
    GreetingService greetService1 = message -> log.info("Hello " + message);

    // with parenthesis
    GreetingService greetService2 = message -> log.info("Hello " + message);

    greetService1.sayMessage("Mike");
    greetService2.sayMessage("Andrey");
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  interface GreetingService {
    void sayMessage(String message);
  }

  private int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }

}