package by.epam.javatraining.glazunov.task01.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class TrainInfo {
	private static final String MESSAGE_LENGHT_TRAIN = "Train name - %s has lehght = %.3f\n";
	private static final String MESSAGE_MAX_PASSENGER = "Train name: %s. Has the maximum number of passengers - %d\n";
	private static final String MESSAGE_MIN_PASSENGER = "Train name: %s. Has the minimum number of passengers - %d\n";
	private static final String MESSAGE_MAX_LUGGAGE = "Train name - %s has lehght = %.3f\n";

	public static void print(Train train) {
		System.out.println(train.toString());
	}

	public static void printLenghtTrains(Map<String, BigDecimal> map) {
		for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
			System.out.printf(MESSAGE_LENGHT_TRAIN, entry.getKey(), entry.getValue());
		}
	}

	public static void printNumberPassengerPlacesOrLuggage(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void printTrainMaxPassenger(Train train) {
		System.out.printf(MESSAGE_MAX_PASSENGER, train.getNameTrain(), train.getTotalNumberPassengerSeats());
	}

	public static void printTrainMaxLuggage(Train train) {
		System.out.printf(MESSAGE_MAX_LUGGAGE, train.getNameTrain(), train.getOccupiedLuggage());
	}

	public static void printTrainMinPassenger(Train train) {
		System.out.printf(MESSAGE_MIN_PASSENGER, train.getNameTrain(), train.getTotalNumberPassengerSeats());
	}

}
