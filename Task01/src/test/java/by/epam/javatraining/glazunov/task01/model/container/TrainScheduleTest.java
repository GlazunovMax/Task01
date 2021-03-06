package by.epam.javatraining.glazunov.task01.model.container;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggonType;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.IllegalIndexException;

public class TrainScheduleTest {

	private TrainSchedule schedule;
	private Train train;
	private Train train2;
	private Train train3;
	
	@Before
	public void createSchedule() {
		
		schedule = new TrainScheduleArray();
		Waggon[] waggons = new Waggon[3];

		waggons[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 26);// 36
		waggons[1] = new PassengerWaggon(PassengerWaggonType.RESERVED_BERTH, 50);// 54
		waggons[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		Waggon[] waggons2 = new Waggon[4];

		waggons2[0] = new PassengerWaggon(PassengerWaggonType.THIRD_CLASS, 22); // 81 всего мест в THIRD_CLASS,22занятых
		waggons2[1] = new PassengerWaggon(PassengerWaggonType.RESERVED_BERTH, 50);// 54
		waggons2[2] = new LuggageWaggon(3500, new BigDecimal(2050));
		waggons2[3] = new LuggageWaggon(3500, new BigDecimal(2500));

		Waggon[] waggons3 = new Waggon[5];

		waggons3[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 22); // 36
		waggons3[1] = new PassengerWaggon(PassengerWaggonType.THIRD_CLASS, 54);// 81
		waggons3[2] = new LuggageWaggon(3500, new BigDecimal(2550));
		waggons3[3] = new LuggageWaggon(3500, new BigDecimal(2100));
		waggons3[4] = new LuggageWaggon(3500, new BigDecimal(2000));

		train = new Train("Mинск-Брест", new Locomotive(), waggons);
		train2 = new Train("Москва-Минск", new Locomotive(), waggons2);
		train3 = new Train("Витебск-Гомель", new Locomotive(), waggons3);
		
	}

	@Test
	public final void testAddTrain() {
		Assert.assertTrue(schedule.addTrain(train2));
	}
	
	@Test
	public final void testAddNullTrain() {
		Assert.assertFalse(schedule.addTrain(null));
	}
	

	@Test
	public void testGet() {
		Train expected = train;
		
		schedule.addTrain(train);
		Train actual = null;
		try {
			actual = schedule.get(0);
		} catch (IllegalIndexException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalIndexException.class)
	public void testShouldThrowExceptionIfGetIndexNegative() throws IllegalIndexException {
		schedule.get(-5);
	}

	@Test
	public void testSize() {
		schedule.addTrain(train);
		schedule.addTrain(train2);
		schedule.addTrain(train3);
		Assert.assertEquals(schedule.size(), 3);
	}

	@Test
	public void testSet() throws Exception {
		Train expected = train2;
		
		schedule.addTrain(train);
		schedule.addTrain(train3);
		schedule.set(1, train2);
	
		Train actual = schedule.get(1);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalIndexException.class)
	public void testShouldThrowExceptionIfSetIndexNegative() throws Exception {
		schedule.set(-5, train);
	}
	
	@Test
	public void testShouldThrowExceptionIfSetTrainNull() throws Exception {
		Assert.assertFalse(schedule.set(1, null));
	}
	

	@Test
	public void testRemoveTrain() throws Exception {
		schedule.addTrain(train);
		schedule.addTrain(train2);
		
		Assert.assertTrue(schedule.removeTrain(1));
	}
	
	@Test(expected = IllegalIndexException.class)
	public void testShouldThrowExceptionIfRemoveIndexNegative() throws Exception {
		schedule.removeTrain(-2);
	}

}
