package by.epam.javatraining.glazunov.task01.controller;

import org.apache.log4j.Logger;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;
import by.epam.javatraining.glazunov.task01.model.factory.LogicFactory;
import by.epam.javatraining.glazunov.task01.model.logic.Find;
import by.epam.javatraining.glazunov.task01.model.logic.Sort;
import by.epam.javatraining.glazunov.task01.model.logic.Calculate;
import by.epam.javatraining.glazunov.task01.view.ConsoleTrainInfo;
import by.epam.javatraining.glazunov.task01.view.TrainInfo;

/* 
 *  (Railway Transport, Passenger Train). 
 */
public class Controller {
	private static final Logger lOGGER = Logger.getRootLogger();
	
	TrainInfo trainInfo = new ConsoleTrainInfo();
	LogicFactory factory = LogicFactory.getInstance();
	
	Find findTrain = factory.getFindTrainImpl();
	Sort sortTrain = factory.getSortTrainImpl();
	Calculate trainCalculate = factory.getTrainCalculateImpl();
	
	
	//finder
	public void findTrainWithMinPassengerSeats(TrainSchedule schedule){
		try {
			trainInfo.print(findTrain.findTrainWithMinPassengerSeats(schedule));
		} catch (TechnicalException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	public void findTrainWithMaxPassengerSeats(TrainSchedule schedule) {
		try {
			trainInfo.print(findTrain.findTrainWithMaxPassengerSeats(schedule));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
		
	}
	
	public void findTrainWithMaxLuggageWeight(TrainSchedule schedule) {
		try {
			trainInfo.print(findTrain.findTrainWithMaxLuggageWeight(schedule));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	public void findTrainWithMinLuggageWeight(TrainSchedule schedule) {
		try {
			trainInfo.print(findTrain.findTrainWithMinLuggageWeight(schedule));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	
	//sorter
	public void sortByTotalLuggageWeight(TrainSchedule schedule) {
		try {
			trainInfo.print(sortTrain.sortByTotalLuggageWeight(schedule));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	public void sortByTotalPassengerSeats(TrainSchedule schedule) {
		try {
			trainInfo.print(sortTrain.sortByTotalPassengerSeats(schedule));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	
	//calculater
	public void calculateTrainLenght (Train train) {
		try {
			trainInfo.print(trainCalculate.calculateTrainLenght(train));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	public void calculatePassengerSeatsOccupied (Train train) {
		try {
			trainInfo.print(trainCalculate.calculatePassengerSeatsOccupied(train));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	public void calculateLuggageWeightOccupied (Train train) {
		try {
			trainInfo.print(trainCalculate.calculateLuggageWeightOccupied(train));
		} catch (NullArgumentException e) {
			lOGGER.error(e.getMessage(), e);
		}
	}
	
	//printer
	public void printTrain(Train train) {
		trainInfo.print(train);
	}
	
	public void printScheduleTrain(TrainSchedule schedule) {
		trainInfo.print(schedule);
	}
	
}
