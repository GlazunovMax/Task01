package by.epam.javatraining.glazunov.task01.model.logic;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class CheckIfArgumentIsNull {

	private static final String MESSAGE_EXCEPTION_NULL = "Null link has been passed to the method arguments!";

	public static void exceptionTrainNull(Train train) throws TechnicalException {
		if (train == null) {
			throw new TechnicalException(MESSAGE_EXCEPTION_NULL);
		}
	}

	public static void exceptionArrayTrainsNull(Train[] trains) throws TechnicalException {
		if (trains == null || trains.length == 0) {
			throw new TechnicalException(MESSAGE_EXCEPTION_NULL);
		}
	}

	public static void exceptionTrainSceduleNull(TrainSchedule schedule) throws TechnicalException {
		if (schedule == null || schedule.size() == 0) {
			throw new TechnicalException(MESSAGE_EXCEPTION_NULL);
		}
	}
}
