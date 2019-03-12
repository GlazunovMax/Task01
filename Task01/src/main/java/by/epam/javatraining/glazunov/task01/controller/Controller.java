package by.epam.javatraining.glazunov.task01.controller;

import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;
import by.epam.javatraining.glazunov.task01.model.logic.FindTrain;
import by.epam.javatraining.glazunov.task01.model.logic.LogicFactory;
import by.epam.javatraining.glazunov.task01.model.logic.SortTrain;
import by.epam.javatraining.glazunov.task01.model.logic.CalculateTrain;
import by.epam.javatraining.glazunov.task01.view.ConsoleTrainInfo;
import by.epam.javatraining.glazunov.task01.view.TrainInfo;

/* 
 *  (Railway Transport, Passenger Train). 
 */
public class Controller {
	TrainInfo trainInfo = new ConsoleTrainInfo();
	LogicFactory factory = LogicFactory.getInstance();
	
	FindTrain findTrain = factory.getFindTrainImpl();
	SortTrain sortTrain = factory.getSortTrainImpl();
	CalculateTrain trainCalculate = factory.getTrainCalculateImpl();
	
	
	//finder
	public void findTrainWithMinPassengerSeats(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(findTrain.findTrainWithMinPassengerSeats(schedule.getArrayTrains()));
	}
	
	public void findTrainWithMaxPassengerSeats(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(findTrain.findTrainWithMaxPassengerSeats(schedule.getArrayTrains()));
	}
	
	public void findTrainWithMaxWeightLuggage(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(findTrain.findTrainWithMaxWeightLuggage(schedule.getArrayTrains()));
	}
	
	public void findTrainWithMinWeightLuggage(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(findTrain.findTrainWithMinWeightLuggage(schedule.getArrayTrains()));
	}
	
	
	//sorter
	public void sortByTotalLuggageWeight(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(sortTrain.sortByTotalLuggageWeight(schedule));
	}
	
	public void sortByTotalPassengerSeats(TrainSchedule schedule) throws TechnicalException {
		trainInfo.print(sortTrain.sortByTotalPassengerSeats(schedule));
	}
	
	
	//calculater
	public void calculateLenghtTrain (Train train) throws TechnicalException {
		trainInfo.print(trainCalculate.calculateLenghtTrain(train));
	}
	
	public void calculateOccupiedPassengerSeats (Train train) throws TechnicalException {
		trainInfo.print(trainCalculate.calculateOccupiedPassengerSeats(train));
	}
	
	public void calculateWeightOccupiedLuggage (Train train) throws TechnicalException {
		trainInfo.print(trainCalculate.calculateWeightOccupiedLuggage(train));
	}
	
	//printer
	public void printTrain(Train train) {
		trainInfo.print(train);
	}
	
	public void printScheduleTrain(TrainSchedule schedule) {
		trainInfo.print(schedule);
	}
	
}
