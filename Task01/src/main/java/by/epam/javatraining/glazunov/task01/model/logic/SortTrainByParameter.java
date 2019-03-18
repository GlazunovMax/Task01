package by.epam.javatraining.glazunov.task01.model.logic;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.comparator.LuggageWeightComparator;
import by.epam.javatraining.glazunov.task01.model.comparator.PassengerNumberComparator;
import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;

public class SortTrainByParameter implements Sort {

	@Override
	public TrainSchedule sortByTotalPassengerSeats(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);

		Train[] trains = schedule.getTrains();

		Arrays.sort(trains, new PassengerNumberComparator());

		return schedule;
	}

	@Override
	public TrainSchedule sortByTotalLuggageWeight(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);

		Train[] trains = schedule.getTrains();

		Arrays.sort(trains, new LuggageWeightComparator());

		return schedule;
	}
}
