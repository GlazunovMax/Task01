package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;

public class TrainLogicImplTest {
	private static Train train;

	@BeforeClass
	public static void createTrain() {
		List<Waggon> waggons = new ArrayList<>();
		waggons.add(new PassengerWaggon(22.5, TypePassengerWaggon.COUPE));

		train = new Train("NameTrain", new Locomotive(), waggons);
	}

	@Test(expected = LogicException.class)
	public void isListShouldBeEmpty() throws LogicException {
		TrainLogicImpl.isListEmpty(new ArrayList<>());
	}

	@Test
	public void testGetLenghtTrain() throws LogicException {
		// actual
		TrainLogic trainLogic = new TrainLogicImpl();

		List<Train> trains = new ArrayList<>();
		trains.add(train);

		// expected
		BigDecimal expectedLehghtTrain = new BigDecimal(50.000);
		Map<String, BigDecimal> expectedMap = new TreeMap<>();
		expectedMap.put("NameTrain", expectedLehghtTrain.setScale(3, BigDecimal.ROUND_HALF_DOWN));

		Assert.assertEquals(expectedMap, trainLogic.getLenghtTrain(trains));
	}

	@Test
	public void testGetNumberOfPassenger() {
		// actual
		train.setOccupiedPlaces(42);

		int expected = 42;

		Assert.assertEquals(expected, train.getOccupiedPlaces());
	}
	
	@AfterClass
	public static void deleteTrain() {
		train = null;
	}
	

}
