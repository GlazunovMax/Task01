package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.MarkLocomotiveIsEmptyException;

public class LocomotiveTest {
	private Locomotive locomotive;

	@Before
	public void createLocomotive() {
		locomotive = new Locomotive();
	}

	@Test(expected = MarkLocomotiveIsEmptyException.class)
	public void testShouldThrowExceptionIfMarkIsEmpty() throws MarkLocomotiveIsEmptyException {
		String mark = "";

		locomotive.setMark(mark);
	}

	@Test
	public void setMarkNotEmpty() throws MarkLocomotiveIsEmptyException {
		String mark = "Mark";

		locomotive.setMark(mark);

		String actual = locomotive.getMark();
		String expected = "Mark";

		Assert.assertEquals(expected, actual);
	}

	/*@AfterClass
	public static void deleteTrain() {
		locomotive = null;
	}*/

}
