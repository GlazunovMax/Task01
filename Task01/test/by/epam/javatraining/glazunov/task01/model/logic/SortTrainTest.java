package by.epam.javatraining.glazunov.task01.model.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class SortTrainImplTest {

	private Train train;
	private Train train2;
	private Train train3;
	private TrainSchedule schedule;
	private SortTrain sortTrain;

	@Before
	public void createScheduleTrain() {
		Waggon[] waggons = new Waggon[3];

		waggons[0] = new PassengerWaggon(TypePassengerWaggon.COUPE, 26);// 36
		waggons[1] = new PassengerWaggon(TypePassengerWaggon.THIRD_CLASS, 54);// 81
		waggons[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		Waggon[] waggons2 = new Waggon[4];

		waggons2[0] = new PassengerWaggon(TypePassengerWaggon.COUPE, 22); // 36
		waggons2[1] = new PassengerWaggon(TypePassengerWaggon.RESERVED_BERTH, 50);// 54
		waggons2[2] = new LuggageWaggon(3500, new BigDecimal(2550));
		waggons2[3] = new LuggageWaggon(3500, new BigDecimal(2500));

		Waggon[] waggons3 = new Waggon[5];

		waggons3[0] = new PassengerWaggon(TypePassengerWaggon.THIRD_CLASS, 22); // 81 всего мест в THIRD_CLASS,22занятых
		waggons3[1] = new PassengerWaggon(TypePassengerWaggon.RESERVED_BERTH, 50);// 54
		waggons3[2] = new LuggageWaggon(3500, new BigDecimal(2550));
		waggons3[3] = new LuggageWaggon(3500, new BigDecimal(2500));
		waggons3[4] = new LuggageWaggon(3500, new BigDecimal(2000));

		train = new Train("Mинск-Брест", new Locomotive(), waggons);
		train2 = new Train("Москва-Минск", new Locomotive(), waggons2);
		train3 = new Train("Витебск-Гомель", new Locomotive(), waggons3);

		sortTrain = new SortTrainImpl();

		schedule = new TrainSchedule();
		schedule.addTrain(train);
		schedule.addTrain(train2);
		schedule.addTrain(train3);
		
	}

	@Test
	public final void testSortByTotalPassengerSeats() throws TechnicalException {
		// actual
		TrainSchedule actual = sortTrain.sortByTotalPassengerSeats(schedule);

		// expected
		TrainSchedule expected = new TrainSchedule();
		expected.addTrain(train3);
		expected.addTrain(train);
		expected.addTrain(train2);

		assertEquals(expected, actual);

	}

	@Test
	public final void testSortByTotalLuggageWeight() throws TechnicalException {
		// actual
		TrainSchedule actual = sortTrain.sortByTotalLuggageWeight(schedule);

		// expected
		TrainSchedule expected = new TrainSchedule();
		expected.addTrain(train3);
		expected.addTrain(train2);
		expected.addTrain(train);

		assertEquals(expected, actual);
	}

	@Test(expected = TechnicalException.class)
	public void testSortByLuggageShouldThrowExceptionIfArgumentsNull() throws TechnicalException {
		 sortTrain.sortByTotalLuggageWeight(null);
	}
	
	@Test(expected = TechnicalException.class)
	public void testSortByPassengerShouldThrowExceptionIfArgumentsNull() throws TechnicalException {
		sortTrain.sortByTotalPassengerSeats(null);
	}
}
