package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Test;

public class LuggageWaggonTest {

	@Test
	public void testSetLuggage() {
		double luggage = -5.0;

		LuggageWaggon luggageWaggon = new LuggageWaggon();
		if (luggage < 0) {
			luggage = 0.0;
		}

		luggageWaggon.setLuggage(luggage);

		Object expected = 0.0;

		Assert.assertEquals(expected, luggageWaggon.getLuggage());

	}

}
