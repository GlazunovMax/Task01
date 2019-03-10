package by.epam.javatraining.glazunov.task01.model.logic;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public interface SortTrain {
	
	TrainSchedule sortByTotalPassengerSeats(TrainSchedule schedule) throws TechnicalException;

	TrainSchedule sortByTotalLuggageWeight(TrainSchedule schedule) throws TechnicalException;
	
}
