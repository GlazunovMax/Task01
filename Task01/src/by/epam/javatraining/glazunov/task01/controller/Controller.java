package by.epam.javatraining.glazunov.task01.controller;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.DaoException;
import by.epam.javatraining.glazunov.task01.model.logic.LogicFactory;
import by.epam.javatraining.glazunov.task01.model.logic.TrainLogic;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;
import by.epam.javatraining.glazunov.task01.view.TrainInfo;

/* 
 *  (Railway Transport, Passenger Train). 
 */
public class Controller {
	private static final int NUMBER_OF_TRAIN_IN_SCHEDULE = 6;

	public static void main(String[] args) {

		List<Train> trainsNull = null;
		List<Train> trainsEmpty = new ArrayList<>();
		List<Train> trains = new ArrayList<>();

		LogicFactory factory = LogicFactory.getInstance();
		TrainLogic logic = factory.getTrainLogicImpl();
		
		try {
			trains = logic.createTrainSchedule(NUMBER_OF_TRAIN_IN_SCHEDULE);
		} catch (DaoException e1) {
			System.err.println(e1.getMessage());
		}
		
		

		try {
			TrainInfo.printLenghtTrains(logic.getLenghtTrain(trainsNull));

			TrainInfo.printNumberPassengerPlacesOrLuggage(logic.getNumberOfPassenger(trainsEmpty));

			TrainInfo.printNumberPassengerPlacesOrLuggage(logic.getWeightLuggage(trains));

			TrainInfo.printTrainMaxPassenger(logic.findMaxPassengerOnTrain(trains));

			TrainInfo.printTrainMaxLuggage(logic.findMaxWeightLuggageOnTrain(trains));

			TrainInfo.printTrainMaxPassenger(logic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MAX));

			TrainInfo.printTrainMinPassenger(logic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MIN));

		} catch (DaoException e) {
			System.err.println(e.getMessage());
		}

	}

}
