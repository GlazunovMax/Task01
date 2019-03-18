package by.epam.javatraining.glazunov.task01.model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalPlacesOccupiedException;

public class PassengerWaggonTest {
	
	private PassengerWaggon passengerWaggon;
	
	@Before
	public void createPassangerWaggon() {
		passengerWaggon = new PassengerWaggon(PassengerWaggonType.COUPE, 22);
	}

	@Test
	public void testSetOccupiedPlaces() {
		int expected = 22;
		int actual = passengerWaggon.getPlaceOccupied();
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalPlacesOccupiedException.class)
	public void testShouldThrowExceptionIfOccupiedPlacesNegative() throws IllegalPlacesOccupiedException {
		passengerWaggon.setOccupiedPlaces(-5);
	}

}
