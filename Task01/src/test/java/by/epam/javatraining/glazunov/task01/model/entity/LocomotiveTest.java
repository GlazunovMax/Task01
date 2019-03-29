package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import by.epam.javatraining.glazunov.task01.model.exception.IllegalLocomotiveMarkException;

public class LocomotiveTest {
	private Locomotive locomotive;

	@Before
	public void createLocomotive() {
		locomotive = new Locomotive();
	}

	@Test(expected = Exception.class)
	public void testShouldThrowExceptionIfMarkIsEmpty() throws Exception {
		String mark = "";

		locomotive.setLocomotiveMark(mark);
	}

	@Test
	public void setMarkNotEmpty() throws Exception {
		String mark = "Mark";

		locomotive.setLocomotiveMark(mark);

		String actual = locomotive.getLocomotiveMark();
		String expected = "Mark";

		Assert.assertEquals(expected, actual);
	}

}
