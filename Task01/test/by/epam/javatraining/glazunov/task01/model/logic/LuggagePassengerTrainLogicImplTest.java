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
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.DaoException;

public class LuggagePassengerTrainLogicImplTest {
	private static Train train;
	private static TrainLogic trainLogic;
	private static List<Train> trains;
	
	@BeforeClass
	public static void createTrain() {
		List<Waggon> waggons = new ArrayList<>();
		waggons.add(new PassengerWaggon(22.5, TypePassengerWaggon.COUPE));
		waggons.add(new LuggageWaggon(29.3, 3500));
		
		train = new Train("NameTrain", new Locomotive(), waggons);
		train.setOccupiedLuggage(new BigDecimal(2550));
		
		trainLogic = new TrainLogicImpl();

		trains = new ArrayList<>();
		trains.add(train);
	}
	

	@Test(expected = DaoException.class)
	public void isListByEmpty() throws DaoException {
		TrainLogicImpl.isListEmptyOrNull(new ArrayList<>());
	}
	
	@Test(expected = DaoException.class)
	public void isListByNull() throws DaoException {
		TrainLogicImpl.isListEmptyOrNull(null);
	}
	

	@Test
	public void testGetLenghtTrain() throws DaoException {
		// actual
		Map<String, BigDecimal> actualMap = trainLogic.getLenghtTrain(trains);
		
		// expected
		BigDecimal expectedLehghtTrain = new BigDecimal(79.300);
		Map<String, BigDecimal> expectedMap = new TreeMap<>();
		expectedMap.put("NameTrain", expectedLehghtTrain.setScale(3, BigDecimal.ROUND_HALF_DOWN));

		Assert.assertEquals(expectedMap, actualMap);
	}
	
	@Test(expected = DaoException.class)
	public void testGetLenghtTrainEmptyNull() throws DaoException {
		trainLogic.getLenghtTrain(null);
	}
	

	@Test
	public void testGetNumberOfPassenger() throws DaoException {
		// actual
		List<String> actualList = trainLogic.getNumberOfPassenger(trains);	
		
		//expected
		List<String> expectedList = new ArrayList<>();
		expectedList.add("Train name: NameTrain. Total places - 36. Occupied places - 0.");
		
		Assert.assertEquals(expectedList, actualList);	
	}
	
	@Test(expected = DaoException.class)
	public void testGetNumberOfPassengerEmptyNull() throws DaoException {
		trainLogic.getNumberOfPassenger(new ArrayList<>());	
	}
	
	
	@Test
	public void testGetWeightLuggage() throws DaoException {
		// actual
		List<String> actualList = trainLogic.getWeightLuggage(trains);
		System.out.println(actualList);
		
		// expected
		List<String> expectedList = new ArrayList<>();
		expectedList.add("Train name NameTrain. Free baggage space - 3500,000. Occupied baggage space - 2550,000.");

		Assert.assertEquals(expectedList, actualList);
	}
	
	@Test(expected = DaoException.class)
	public void testGetWeightLuggageEmptyNull() throws DaoException {
		trainLogic.getWeightLuggage(null);
	}
	
	
	@AfterClass
	public static void deleteTrain() {
		train = null;
		trainLogic = null;
		trains = null;
	}
	

}
