package by.epam.javatraining.glazunov.task01.model.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.entity.*;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;


public class CalculateTrainTest {
	private Train train;
	private Calculate calculateTrain;

	@Before
	public void createTrain() {
		Waggon[] waggons = new Waggon[3];

		waggons[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 26);
		waggons[1] = new PassengerWaggon(PassengerWaggonType.THIRD_CLASS, 54);
		waggons[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		train = new Train("NameTrain", new Locomotive(), waggons);

		calculateTrain = new CalculateTrainParameter();
	}

	@Test
	public final void calculateLenghtTrain() throws TechnicalException {
		// actual
		BigDecimal actual = calculateTrain.calculateTrainLenght(train);

		// expected
		BigDecimal expected = new BigDecimal(95.52).setScale(3, BigDecimal.ROUND_HALF_DOWN);

		assertEquals(expected, actual);
	}
	
	@Test(expected = TechnicalException.class)
	public void testLenghtTrainShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculateTrainLenght(null);
	}

	@Test
	public final void testCalculateWeightOccupiedLuggage() throws TechnicalException {
		// actual
		BigDecimal actual = calculateTrain.calculateLuggageWeightOccupied(train);

		// expected
		BigDecimal expected = new BigDecimal(2550).setScale(3, BigDecimal.ROUND_HALF_DOWN);

		assertEquals(expected, actual);

	}
	
	@Test(expected = TechnicalException.class)
	public void testWeightLuggageShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculateLuggageWeightOccupied(null);
	}

	@Test
	public final void testCalculateOccupiedPassengerSeats() throws TechnicalException {
		// actual
		int actual = calculateTrain.calculatePassengerSeatsOccupied(train);

		// expected
		int expected = 80;

		assertEquals(expected, actual);

	}
	
	@Test(expected = TechnicalException.class)
	public void testOccupiedSeatsShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculatePassengerSeatsOccupied(null);
	}

}
