package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.glazunov.task01.model.exception.MarkLocomotiveIsEmptyException;

public class LocomotiveTest {
	private static Locomotive locomotive;

	@BeforeClass
	public static void createLocomotive() {
		locomotive = new Locomotive();
	}

	@Test(expected = MarkLocomotiveIsEmptyException.class)
	public void setMarkShouldBeEmpty() throws MarkLocomotiveIsEmptyException {
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

	@AfterClass
	public static void deleteTrain() {
		locomotive = null;
	}

}
