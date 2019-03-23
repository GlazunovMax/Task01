package by.epam.javatraining.glazunov.task01.utill;

import by.epam.javatraining.glazunov.task01.controller.Controller;
import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.container.TrainScheduleArray;
import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class TrainCreatorMain {

	public static void main(String[] args) {
		Controller controller = new Controller();

		Train train = BuildTrain.createTrain("NmaTRain", "mark");

		TrainSchedule schedule = new TrainScheduleArray();
		schedule.addTrain(BuildTrain.createTrain("N1", "M1"));
		schedule.addTrain(BuildTrain.createTrain("N2", "M2"));
		schedule.addTrain(BuildTrain.createTrain("N3", "M3"));
		schedule.addTrain(BuildTrain.createTrain("N4", "M4"));

		//printer
		controller.printTrain(train);
		controller.printScheduleTrain(schedule);

		//finder
		controller.findTrainWithMinPassengerSeats(schedule);
		controller.findTrainWithMaxPassengerSeats(schedule);
		controller.findTrainWithMaxLuggageWeight(schedule);
		controller.findTrainWithMinLuggageWeight(schedule);
				
		//sorter
		controller.sortByTotalLuggageWeight(schedule);
		controller.sortByTotalPassengerSeats(schedule);

		//calculate
		controller.calculateTrainLenght(train);
		controller.calculatePassengerSeatsOccupied(train);
		controller.calculateLuggageWeightOccupied(train);

	}

}
