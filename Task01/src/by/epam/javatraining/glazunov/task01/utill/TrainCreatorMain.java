package by.epam.javatraining.glazunov.task01.utill;

import by.epam.javatraining.glazunov.task01.controller.Controller;
import by.epam.javatraining.glazunov.task01.model.container.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;


public class TrainCreatorMain {

	public static void main(String[] args) {
		Controller controller = new Controller();

		Train train = BuildTrain.createTrain("NmaTRain", "mark");

		TrainSchedule schedule = new TrainSchedule();
		schedule.addTrain(BuildTrain.createTrain("N1", "M1"));
		schedule.addTrain(BuildTrain.createTrain("N2", "M2"));
		schedule.addTrain(BuildTrain.createTrain("N3", "M3"));
		schedule.addTrain(BuildTrain.createTrain("N4", "M4"));
		
		controller.printTrain(train);
		controller.printScheduleTrain(schedule);

		try {
			/*controller.findTrainWithMinPassengerSeats(schedule);
			controller.findTrainWithMaxPassengerSeats(schedule);
			controller.findTrainWithMaxWeightLuggage(schedule);
			controller.findTrainWithMinWeightLuggage(schedule);*/

			/*controller.sortByTotalLuggageWeight(schedule);
			controller.sortByTotalPassengerSeats(schedule);*/
			

			controller.calculateLenghtTrain(train);
			/*controller.calculateOccupiedPassengerSeats(train);
			controller.calculateWeightOccupiedLuggage(train);*/

		} catch (TechnicalException e) {
			System.err.println(e.getMessage());
		}

	}

}
