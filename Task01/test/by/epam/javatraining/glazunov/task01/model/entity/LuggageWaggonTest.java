package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.LuggageWeightNegativeException;

public class LuggageWaggonTest {
	private static LuggageWaggon luggageWaggon;
	
	@BeforeClass
	public static void createLuggageWaggon() {
		luggageWaggon = new LuggageWaggon();
	}

	@Test(expected = LuggageWeightNegativeException.class)
	public void testSetLuggageNegative() throws LuggageWeightNegativeException {
		double luggage = -5.0;

		luggageWaggon.setLuggageWeight(luggage);
	}
	
	@Test()
	public void testSetLuggage() throws LuggageWeightNegativeException  {
		double luggage = 5.0;

		luggageWaggon.setLuggageWeight(luggage);

		double expected = 5.0;
		double actual = luggageWaggon.getLuggageWeight();

		Assert.assertEquals(expected, actual, 0.001);
	}

	@AfterClass
	public static void deleteLuggageWaggon() {
		luggageWaggon = null;
	}
}
