package by.atmm.reduceIfelse;

import by.atmm.reducingIfElse.Expression;
import by.atmm.reducingIfElse.Operator;
import by.atmm.reducingIfElse.Result;
import by.atmm.reducingIfElse.RuleEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RuleEngineUnitTest {

    @Test
    public void whenNumbersGivenToRuleEngine_thenReturnCorrectResult() {
        Expression expression = new Expression(5, 5, Operator.ADD);
        RuleEngine engine = new RuleEngine();
        Result result = engine.process(expression);

        assertNotNull(result);
        assertEquals(10, result.getValue());
    }
}
