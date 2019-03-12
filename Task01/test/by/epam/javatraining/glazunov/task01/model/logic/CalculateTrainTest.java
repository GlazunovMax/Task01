package by.epam.javatraining.glazunov.task01.model.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class CalculateTrainImplTest {
	private Train train;
	private CalculateTrain calculateTrain;

	@Before
	public void createTrain() {
		Waggon[] waggons = new Waggon[3];

		waggons[0] = new PassengerWaggon(TypePassengerWaggon.COUPE, 26);
		waggons[1] = new PassengerWaggon(TypePassengerWaggon.THIRD_CLASS, 54);
		waggons[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		train = new Train("NameTrain", new Locomotive(), waggons);

		calculateTrain = new CalculateTrainImpl();
	}

	@Test
	public final void calculateLenghtTrain() throws TechnicalException {
		// actual
		BigDecimal actual = calculateTrain.calculateLenghtTrain(train);

		// expected
		BigDecimal expected = new BigDecimal(95.52).setScale(3, BigDecimal.ROUND_HALF_DOWN);

		assertEquals(expected, actual);
	}
	
	@Test(expected = TechnicalException.class)
	public void testLenghtTrainShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculateLenghtTrain(null);
	}

	@Test
	public final void testCalculateWeightOccupiedLuggage() throws TechnicalException {
		// actual
		BigDecimal actual = calculateTrain.calculateWeightOccupiedLuggage(train);

		// expected
		BigDecimal expected = new BigDecimal(2550).setScale(3, BigDecimal.ROUND_HALF_DOWN);

		assertEquals(expected, actual);

	}
	
	@Test(expected = TechnicalException.class)
	public void testWeightLuggageShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculateWeightOccupiedLuggage(null);
	}

	@Test
	public final void testCalculateOccupiedPassengerSeats() throws TechnicalException {
		// actual
		int actual = calculateTrain.calculateOccupiedPassengerSeats(train);

		// expected
		int expected = 80;

		assertEquals(expected, actual);

	}
	
	@Test(expected = TechnicalException.class)
	public void testOccupiedSeatsShouldThrowExceptionIfArgumentIsNull() throws TechnicalException {
		calculateTrain.calculateOccupiedPassengerSeats(null);
	}

}
