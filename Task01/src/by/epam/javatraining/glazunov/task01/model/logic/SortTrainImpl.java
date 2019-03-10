package by.epam.javatraining.glazunov.task01.model.logic;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.comparator.LuggageWeightComparator;
import by.epam.javatraining.glazunov.task01.model.comparator.PassengerNumberComparator;
import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class SortTrainImpl implements SortTrain {

	@Override
	public TrainSchedule sortByTotalPassengerSeats(TrainSchedule schedule) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);

		Train[] trains = schedule.getArrayTrains();

		Arrays.sort(trains, new PassengerNumberComparator());

		return schedule;
	}

	@Override
	public TrainSchedule sortByTotalLuggageWeight(TrainSchedule schedule) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);

		Train[] trains = schedule.getArrayTrains();

		Arrays.sort(trains, new LuggageWeightComparator());

		return schedule;
	}
}
