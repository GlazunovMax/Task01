package by.epam.javatraining.glazunov.task01.model.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.*;

public class LuggageWaggonTest {

private LuggageWaggon luggageWaggon;
	
	@Before
	public void createLuggageWaggon() {
		double luggage = 5.0;
		BigDecimal luggageOccupied = new BigDecimal(5);
		luggageWaggon = new LuggageWaggon(luggage, luggageOccupied);
	}

	@Test(expected = IllegalLuggageWeightException.class)
	public void testShouldThrowExceptionIfLuggageNegative() throws IllegalLuggageWeightException {
		double luggage = -5.0;

		luggageWaggon.setLuggageWeight(luggage);
	}
	
	@Test
	public void testSetLuggage()  {
		double expected = 5.0;
		double actual = luggageWaggon.getLuggageWeight();

		Assert.assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public final void testSetOccupiedLuggage() {
		BigDecimal expected = new BigDecimal(5);
		BigDecimal actual = luggageWaggon.getLuggageOccupied();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalLuggageOccupiedException.class)
	public void testShouldThrowExceptionIfLuggageOccupiedNegative() throws IllegalLuggageOccupiedException {
		BigDecimal luggageOccupied = new BigDecimal(-5);
		luggageWaggon.setLuggageOccupied(luggageOccupied);
	}

}
