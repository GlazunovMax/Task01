package by.epam.javatraining.glazunov.task01.model.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalTrainNameException;
import by.epam.javatraining.glazunov.task01.model.exception.NullLocomotiveException;
import by.epam.javatraining.glazunov.task01.model.exception.NullWaggonException;

public class TrainTest {
	private Train trainAct;
	private Locomotive locomotive;
	private Waggon[] waggonsAct;

	@Before
	public void createTrain() {
		locomotive = new Locomotive("Mark12", LocomotiveType.ELECTRIC_LOCOMOTIVE);

		waggonsAct = new Waggon[3];
		waggonsAct[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 26);
		waggonsAct[1] = new PassengerWaggon(PassengerWaggonType.THIRD_CLASS, 54);
		waggonsAct[2] = new LuggageWaggon(3500, new BigDecimal(2550));

		trainAct = new Train("NameTrain", locomotive, waggonsAct);

	}

	@Test
	public void testSetNameTrain() throws IllegalTrainNameException {
		String expected = "NameTrain";

		trainAct.setNameTrain("NameTrain");
		String actual = trainAct.getNameTrain();

		assertEquals(expected, actual);
	}

	@Test(expected = IllegalTrainNameException.class)
	public void testShouldThrowExceptionIfNameTrainEmpty() throws IllegalTrainNameException {
		trainAct.setNameTrain(null);
	}

	@Test
	public void testSetLocomotive() throws NullLocomotiveException {
		Locomotive expected = new Locomotive("Mark11", LocomotiveType.ELECTRIC_LOCOMOTIVE);

		Locomotive locomotiveAct = new Locomotive("Mark11", LocomotiveType.ELECTRIC_LOCOMOTIVE);
		trainAct.setLocomotive(locomotiveAct);
		Locomotive actual = trainAct.getLocomotive();

		assertEquals(expected, actual);
	}

	@Test(expected = NullLocomotiveException.class)
	public void testShouldThrowExceptionIfLocomotiveNull() throws NullLocomotiveException {
		trainAct.setLocomotive(null);
	}

	@Test
	public void testSetWaggons() throws NullWaggonException {
		Waggon[] waggonsExp = new Waggon[2];
		waggonsExp[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 26);
		waggonsExp[1] = new LuggageWaggon(3500, new BigDecimal(2550));

		waggonsAct = new Waggon[2];
		waggonsAct[0] = new PassengerWaggon(PassengerWaggonType.COUPE, 26);
		waggonsAct[1] = new LuggageWaggon(3500, new BigDecimal(2550));
		trainAct.setWaggons(waggonsAct);

		assertArrayEquals(waggonsExp, trainAct.getWaggons());
	}

	@Test(expected = NullWaggonException.class)
	public void testShouldThrowExceptionIfWaggonsNull() throws NullWaggonException {
		trainAct.setWaggons(null);
	}

	@Test(expected = NullWaggonException.class)
	public void testShouldThrowExceptionIfWaggonsEmpty() throws NullWaggonException {
		waggonsAct = new Waggon[0];
		trainAct.setWaggons(waggonsAct);
	}

}
