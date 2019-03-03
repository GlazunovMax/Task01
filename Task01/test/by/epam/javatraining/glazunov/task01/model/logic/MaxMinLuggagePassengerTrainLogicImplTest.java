package by.epam.javatraining.glazunov.task01.model.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.DaoException;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;

public class MaxMinLuggagePassengerTrainLogicImplTest {
	private static Train train;
	private static Train train2;
	private static TrainLogic trainLogic;
	private static List<Train> trains;

	@BeforeClass
	public static void createListTrain() {
		List<Waggon> waggons = new ArrayList<>();
		waggons.add(new PassengerWaggon(22.5, TypePassengerWaggon.COUPE));
		waggons.add(new LuggageWaggon(29.3, 3500));

		List<Waggon> waggons2 = new ArrayList<>();
		waggons2.add(new PassengerWaggon(22.5, TypePassengerWaggon.THIRD_CLASS));
		waggons2.add(new LuggageWaggon(29.3, 3500));

		train = new Train("NameTrain", new Locomotive(), waggons);
		train.setOccupiedLuggage(new BigDecimal(2550));

		train2 = new Train("NameTrain2", new Locomotive(), waggons2);
		train2.setOccupiedLuggage(new BigDecimal(2250));

		trainLogic = new TrainLogicImpl();

		trains = new ArrayList<>();
		trains.add(train);
		trains.add(train2);
	}

	@Test
	public void TestFindMaxWeightLuggageOnTrain() throws DaoException {
		Train expectedTrain = train;
		Train actualTrain = trainLogic.findMaxWeightLuggageOnTrain(trains);

		assertEquals(expectedTrain, actualTrain);
	}

	@Test(expected = DaoException.class)
	public void TestFindMaxWeightLuggageOnTrainEmptyNull() throws DaoException {
		trainLogic.findMaxWeightLuggageOnTrain(new ArrayList<>());
	}

	@Test
	public void TestFindMinOrMaxPassengerOnTrainMAX() throws DaoException {
		Train expectedTrain = train2;
		Train actualTrain = trainLogic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MAX);
				
		assertEquals(expectedTrain, actualTrain);
	}
	
	@Test
	public void TestFindMinOrMaxPassengerOnTrainMIN() throws DaoException {
		Train expectedTrain = train;
		Train actualTrain = trainLogic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MIN);
				
		assertEquals(expectedTrain, actualTrain);
	}
	
	@Test(expected = DaoException.class)
	public void TestFindMinOrMaxPassengerOnTrainMinEmptyNull() throws DaoException {
		trainLogic.findMinOrMaxPassengerOnTrain(null, TypeSearch.MIN);
	}
	
	@Test(expected = DaoException.class)
	public void TestFindMinOrMaxPassengerOnTrainMaxEmptyNull() throws DaoException {
		trainLogic.findMinOrMaxPassengerOnTrain(new ArrayList<>(), TypeSearch.MAX);
	}

	@Test
	public void TestFindMaxPassengerOnTrain() throws DaoException {
		Train expectedTrain = train2;
		Train actualTrain = trainLogic.findMaxPassengerOnTrain(trains);
		
		assertEquals(expectedTrain, actualTrain);
	}
	
	@Test(expected = DaoException.class)
	public void TestFindMaxPassengerOnTrainNullEmpty() throws DaoException{
		trainLogic.findMaxWeightLuggageOnTrain(null);
	}
	
	
	@Test(expected = DaoException.class)
	public void TestCreateTrainScheduleByNegative() throws DaoException {
		trainLogic.createTrainSchedule(-12);
	}
	
	@AfterClass
	public static void deleteTrain() {
		train = null;
		train2 = null;
		trainLogic = null;
		trains = null;
	}

}
