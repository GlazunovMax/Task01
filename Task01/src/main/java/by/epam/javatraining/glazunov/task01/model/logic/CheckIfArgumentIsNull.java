package by.epam.javatraining.glazunov.task01.model.logic;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class CheckIfArgumentIsNull {

	private static final String MESSAGE_EXCEPTION_NULL = "Null link has been passed to the method arguments!";

	public static void exceptionTrainNull(Train train) throws NullArgumentException {
		if (train == null) {
			throw new NullArgumentException(MESSAGE_EXCEPTION_NULL);
		}
	}

	public static void exceptionTrainSceduleNull(TrainSchedule schedule) throws NullArgumentException {
		if (schedule == null || schedule.size() == 0) {
			throw new NullArgumentException(MESSAGE_EXCEPTION_NULL);
		}
	}
	
	public static Train[] cheakArrayOnNull(Train[] trains) {
		List<Train> removedNull = new ArrayList<>();

		for (Train train : trains) {
			if(train != null) {
				removedNull.add(train);
			}
		}
		
		trains = removedNull.toArray(new Train[removedNull.size()]);
		return trains;
	}
}
