package by.epam.javatraining.glazunov.task01.model.logic;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public interface Sort {
	
	TrainSchedule sortByTotalPassengerSeats(TrainSchedule schedule) throws NullArgumentException;

	TrainSchedule sortByTotalLuggageWeight(TrainSchedule schedule) throws NullArgumentException;
	
}
