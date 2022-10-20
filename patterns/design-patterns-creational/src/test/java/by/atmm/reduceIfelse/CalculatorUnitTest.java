package by.atmm.reduceIfelse;

import by.atmm.reducingIfElse.AddCommand;
import by.atmm.reducingIfElse.Calculator;
import by.atmm.reducingIfElse.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorUnitTest {

    @Test
    void whenCalculateUsingStringOperator_thenReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(3, 4, "add");
        assertEquals(7, result);
    }

    @Test
    void whenCalculateUsingEnumOperator_thenReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(3, 4, Operator.valueOf("ADD"));
        assertEquals(7, result);
    }

    @Test
    void whenCalculateUsingCommand_thenReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new AddCommand(3, 7));
        assertEquals(10, result);
    }

    @Test
    void whenCalculateUsingFactory_thenReturnCorrectResult() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateUsingFactory(3, 4, "add");
        assertEquals(7, result);
    }
}
