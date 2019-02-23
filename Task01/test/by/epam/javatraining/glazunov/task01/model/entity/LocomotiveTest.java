package by.epam.javatraining.glazunov.task01.model.entity;

import org.junit.Assert;
import org.junit.Test;

public class LocomotiveTest {
	
	@Test
	public void setMarkShouldBeEmpty() {
		String mark = "";
		
		Locomotive locomotive = new Locomotive();
		if(mark.isEmpty()) {
			mark = "Not assigned";
		}
		locomotive.setMark(mark);

		Assert.assertEquals("Not assigned", locomotive.getMark());
	}
	

}
