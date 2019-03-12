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

public class FindTrainImplTest {

	private Train train;
	private Train train2;
	private Train[] trains;
	private FindTrain findTrain;

	@Before
	public void createTrain() {
		Waggon[] waggons = new Waggon[3];

		waggons[0] = new PassengerWaggon(TypePassengerWaggon.COUPE, 26);// 36
		waggons[1] = new PassengerWaggon(TypePassengerWaggon.THIRD_CLASS, 54);// 81
		waggons[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		Waggon[] waggons2 = new Waggon[4];

		waggons2[0] = new PassengerWaggon(TypePassengerWaggon.COUPE, 22); // 36
		waggons2[1] = new PassengerWaggon(TypePassengerWaggon.RESERVED_BERTH, 50);// 54
		waggons2[2] = new LuggageWaggon(3500, new BigDecimal(2550));
		waggons2[3] = new LuggageWaggon(3500, new BigDecimal(2500));

		train = new Train("Mинск-Брест", new Locomotive(), waggons);
		train2 = new Train("Москва-Минск", new Locomotive(), waggons2);

		findTrain = new FindTrainImpl();

		trains = new Train[2];
		trains[0] = train;
		trains[1] = train2;
	}

	@Test
	public final void testFindTrainWithMaxPassengerSeats() throws TechnicalException {
		// actual
		Train actual = findTrain.findTrainWithMaxPassengerSeats(trains);

		// expected
		Train expected = train;

		assertEquals(expected, actual);
	}

	@Test
	public final void testFindTrainWithMinPassengerSeats() throws TechnicalException {
		// actual
		Train actual = findTrain.findTrainWithMinPassengerSeats(trains);

		// expected
		Train expected = train2;

		assertEquals(expected, actual);
	}

	@Test(expected = TechnicalException.class)
	public void testMaxPassengerSeatsShouldThrowExceptionIfArgumentNull() throws TechnicalException {
		findTrain.findTrainWithMaxPassengerSeats(null);
	}

	@Test(expected = TechnicalException.class)
	public void testMinPassengerSeatsShouldThrowExceptionIfArgumentNull() throws TechnicalException {
		findTrain.findTrainWithMinPassengerSeats(null);
	}

	@Test
	public final void testFindTrainWithMinWeightLuggage() throws TechnicalException {
		// actual
		Train actual = findTrain.findTrainWithMinWeightLuggage(trains);
		
		// expected
		Train expected = train;
				
		assertEquals(expected, actual);
	}

	@Test
	public final void testFindTrainWithMaxWeightLuggage() throws TechnicalException {
		// actual
		Train actual = findTrain.findTrainWithMaxWeightLuggage(trains);
		
		// expected
		Train expected = train2;
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = TechnicalException.class)
	public void testMaxWeightLuggageShouldThrowExceptionIfArgumentNull() throws TechnicalException {
		findTrain.findTrainWithMaxWeightLuggage(null);
	}
	
	
	@Test(expected = TechnicalException.class)
	public void testMinWeightLuggageShouldThrowExceptionIfArgumentNull() throws TechnicalException {
		findTrain.findTrainWithMinWeightLuggage(null);
	}

}
