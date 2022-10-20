package by.atmm.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.awt.Color;


/**
 * Unit test for {@link VehicleFactory}.
 *
 * @author Donato Rimenti
 */
public class FlyweightUnitTest {

    /**
     * Checks that when the {@link VehicleFactory} is asked to provide two
     * vehicles of different colors, the objects returned are different.
     */
    @Test
    public void givenDifferentFlyweightObjects_whenEquals_thenFalse() {
        Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
        Vehicle blueVehicle = VehicleFactory.createVehicle(Color.BLUE);

        assertNull(blackVehicle, "Object returned by the factory is null!");
        assertNotNull(blueVehicle, "Object returned by the factory is null!");
        assertNotEquals(blackVehicle, blueVehicle, "Objects returned by the factory are equals!");
    }

    /**
     * Checks that when the {@link VehicleFactory} is asked to provide two
     * vehicles of the same colors, the same object is returned twice.
     */
    @Test
    public void givenSameFlyweightObjects_whenEquals_thenTrue() {
        Vehicle blackVehicle = VehicleFactory.createVehicle(Color.BLACK);
        Vehicle anotherBlackVehicle = VehicleFactory.createVehicle(Color.BLACK);

        assertNotNull(blackVehicle, "Object returned by the factory is null!");
        assertNotNull(anotherBlackVehicle, "Object returned by the factory is null!");
        assertEquals(blackVehicle, anotherBlackVehicle, "Objects returned by the factory are not equals!");
    }
}
