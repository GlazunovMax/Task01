package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalLocomotiveMarkException;

public class LocomotiveTest {
	private Locomotive locomotive;

	@Before
	public void createLocomotive() {
		locomotive = new Locomotive();
	}

	@Test(expected = IllegalLocomotiveMarkException.class)
	public void testShouldThrowExceptionIfMarkIsEmpty() throws IllegalLocomotiveMarkException {
		String mark = "";

		locomotive.setLocomotiveMark(mark);
	}

	@Test
	public void setMarkNotEmpty() throws IllegalLocomotiveMarkException {
		String mark = "Mark";

		locomotive.setLocomotiveMark(mark);

		String actual = locomotive.getLocomotiveMark();
		String expected = "Mark";

		Assert.assertEquals(expected, actual);
	}

}
