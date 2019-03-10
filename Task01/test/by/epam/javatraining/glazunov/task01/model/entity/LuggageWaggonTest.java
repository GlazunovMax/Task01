package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.LuggageWeightNegativeException;

public class LuggageWaggonTest {
	private LuggageWaggon luggageWaggon;
	
	@Before
	public void createLuggageWaggon() {
		luggageWaggon = new LuggageWaggon();
	}

	@Test(expected = LuggageWeightNegativeException.class)
	public void testShouldThrowExceptionIfLuggageNegative() throws LuggageWeightNegativeException {
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

	/*@AfterClass
	public static void deleteLuggageWaggon() {
		luggageWaggon = null;
	}*/
}
