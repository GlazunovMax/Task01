package by.epam.javatraining.glazunov.task01.controller;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.logic.LogicException;
import by.epam.javatraining.glazunov.task01.model.logic.LogicFactory;
import by.epam.javatraining.glazunov.task01.model.logic.TrainLogic;
import by.epam.javatraining.glazunov.task01.utill.BuildTrain;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;
import by.epam.javatraining.glazunov.task01.view.TrainInfo;

/* 
 *  (Railway Transport, Passenger Train). 
 */
public class Controller {

	private static final String TRAIN_NAME = "Train ";
	private static final String MARK_LOCOMOTIVE = "mark ";

	public static void main(String[] args) {

		List<Train> trainsEmpty = new ArrayList<>();
		List<Train> trains = new ArrayList<>();

		for (int i = 1; i < 9; i++) {
			trains.add(BuildTrain.createTrain(TRAIN_NAME + i, MARK_LOCOMOTIVE + i));
		}

		LogicFactory factory = LogicFactory.getInstance();
		TrainLogic logic = factory.getTrainLogicImpl();

		try {
			TrainInfo.printLenghtTrains(logic.getLenghtTrain(trains));

			TrainInfo.printNumberPassengerPlacesOrLuggage(logic.getNumberOfPassenger(trainsEmpty));

			TrainInfo.printNumberPassengerPlacesOrLuggage(logic.getWeightLuggage(trains));

			TrainInfo.printTrainMaxPassenger(logic.findMaxPassengerOnTrain(trains));

			TrainInfo.printTrainMaxLuggage(logic.findMaxWeightLuggageOnTrain(trains));

			TrainInfo.printTrainMaxPassenger(logic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MAX));

			TrainInfo.printTrainMinPassenger(logic.findMinOrMaxPassengerOnTrain(trains, TypeSearch.MIN));

		} catch (LogicException e) {
			System.out.println(e.getMessage());
		}

	}

}
