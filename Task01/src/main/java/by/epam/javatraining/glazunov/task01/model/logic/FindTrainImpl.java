package by.epam.javatraining.glazunov.task01.model.logic;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.comparator.LuggageWeightComparator;
import by.epam.javatraining.glazunov.task01.model.comparator.PassengerNumberComparator;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class FindTrainImpl implements FindTrain {
	@Override
	public Train findTrainWithMaxPassengerSeats(Train[] trains) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionArrayTrainsNull(trains);

		Arrays.sort(trains, new PassengerNumberComparator());
		return trains[0];
	}

	@Override
	public Train findTrainWithMinPassengerSeats(Train[] trains) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionArrayTrainsNull(trains);

		Arrays.sort(trains, new PassengerNumberComparator());
		return trains[trains.length - 1];
	}

	@Override
	public Train findTrainWithMinWeightLuggage(Train[] trains) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionArrayTrainsNull(trains);

		Arrays.sort(trains, new LuggageWeightComparator());
		return trains[trains.length - 1];
	}

	@Override
	public Train findTrainWithMaxWeightLuggage(Train[] trains) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionArrayTrainsNull(trains);

		Arrays.sort(trains, new LuggageWeightComparator());
		return trains[0];
	}

}
