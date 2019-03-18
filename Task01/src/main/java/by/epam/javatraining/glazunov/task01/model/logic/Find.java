package by.epam.javatraining.glazunov.task01.model.logic;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;


public interface Find {
	
	Train findTrainWithMaxPassengerSeats(TrainSchedule schedule) throws NullArgumentException;

	Train findTrainWithMinPassengerSeats(TrainSchedule schedule) throws NullArgumentException;

	Train findTrainWithMinLuggageWeight(TrainSchedule schedule) throws NullArgumentException;

	Train findTrainWithMaxLuggageWeight(TrainSchedule schedule) throws NullArgumentException;
	
}
