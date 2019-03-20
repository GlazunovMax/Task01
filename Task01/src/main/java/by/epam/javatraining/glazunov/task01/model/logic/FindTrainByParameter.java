package by.epam.javatraining.glazunov.task01.model.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.comparator.LuggageWeightComparator;
import by.epam.javatraining.glazunov.task01.model.comparator.PassengerNumberComparator;
import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class FindTrainByParameter implements Find {
	@Override
	public Train findTrainWithMaxPassengerSeats(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);
		
		//Train[] trains = ((TrainScheduleArray) schedule).getArrayTrains();
		Train[] trains = CheckIfArgumentIsNull.cheakArrayOnNull(schedule.getTrains());
		Arrays.sort(trains, new PassengerNumberComparator());
		return trains[0];
	}

	@Override
	public Train findTrainWithMinPassengerSeats(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);
		
		Train[] trains = CheckIfArgumentIsNull.cheakArrayOnNull(schedule.getTrains());
		
		Arrays.sort(trains, new PassengerNumberComparator());
		return trains[trains.length - 1];
	}

	@Override
	public Train findTrainWithMinLuggageWeight(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);
		
		//Train[] trains = null//schedule.getTrains();
				Train[] trains = CheckIfArgumentIsNull.cheakArrayOnNull(schedule.getTrains());
		Arrays.sort(trains, new LuggageWeightComparator());
		return trains[trains.length - 1];
	}

	@Override
	public Train findTrainWithMaxLuggageWeight(TrainSchedule schedule) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainSceduleNull(schedule);
		
		//Train[] trains = schedule.getTrains();
		Train[] trains = CheckIfArgumentIsNull.cheakArrayOnNull(schedule.getTrains());
		Arrays.sort(trains, new LuggageWeightComparator());
		return trains[0];
	}
	
	

}
