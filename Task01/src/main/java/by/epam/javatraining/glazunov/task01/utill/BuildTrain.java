package by.epam.javatraining.glazunov.task01.utill;

import java.math.BigDecimal;
import java.util.Random;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.LocomotiveType;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggonType;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.IllegalMarkLocomotiveException;

public class BuildTrain {
	static Random random = new Random();

	public static Train createTrain(String nameTrain, String mark) {
		Train train = new Train(nameTrain, createLocomotie(mark), createWaggons());
		return train;
	}

	private static Locomotive createLocomotie(String markLocomotive) {
		Locomotive locomotive = new Locomotive();
		LocomotiveType[] type = LocomotiveType.values();

		try {
			locomotive.setMark(markLocomotive);
		} catch (IllegalMarkLocomotiveException e) {
			System.err.println(e.getMessage());
		}

		locomotive.setTypeLocomotive(type[random.nextInt(type.length)]);

		return locomotive;

	}

	private static final int MIN_COUNT_PASSENGER_WAGGONS = 2;
	private static final int MAX_COUNT_PASSENGER_WAGGONS = 8;
	private static final int MAX_COUNT_LUGGAGE_WAGGONS = 2;
	private static final double MAX_LUGGAGE_IN_LAGGAGE_WAGGON = 3500;

	private static Waggon[] createWaggons() {
		int countPassengerWaggon = random.nextInt(MAX_COUNT_PASSENGER_WAGGONS) + MIN_COUNT_PASSENGER_WAGGONS;
		int countLuggageWaggon = random.nextInt(MAX_COUNT_LUGGAGE_WAGGONS);
		int allWaggons = countLuggageWaggon + countPassengerWaggon;

		Waggon[] waggons = new Waggon[allWaggons];

		PassengerWaggonType typeWaggon;
		int occupiedPlaces;

		for (int i = 0; i < countPassengerWaggon; i++) {
			typeWaggon = PassengerWaggonType.values()[random.nextInt(PassengerWaggonType.values().length)];
			occupiedPlaces = random.nextInt(typeWaggon.getNumberSeats());

			waggons[i] = new PassengerWaggon(typeWaggon, occupiedPlaces);
		}

		BigDecimal occupiedLuggage;
		for (int i = countPassengerWaggon; i < waggons.length; i++) {
			occupiedLuggage = new BigDecimal(random.nextDouble() * MAX_LUGGAGE_IN_LAGGAGE_WAGGON).setScale(3,
					BigDecimal.ROUND_HALF_DOWN);

			waggons[i] = new LuggageWaggon(MAX_LUGGAGE_IN_LAGGAGE_WAGGON, occupiedLuggage);
		}

		return waggons;

	}

}
