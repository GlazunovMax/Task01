package by.epam.javatraining.glazunov.task01.utill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypeLocomotive;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;

public class BuildTrain {
	private static final String MESSAGE_MARK_LOCO_IS_EMPTY = "Mark not specified!";
	static Random random = new Random();

	public static Train createTrain(String nameTrain, String mark) {
		Train train = null;

		train = new Train(nameTrain, createLocomotie(mark), createWaggons());

		train.setOccupiedPlaces(fillPassengerSeats(train));

		train.setOccupiedLuggage(fillLuggagePassenger(train));

		return train;
	}

	private static Locomotive createLocomotie(String markLocomotive) {
		if (markLocomotive.isEmpty()) {
			markLocomotive = MESSAGE_MARK_LOCO_IS_EMPTY;
		}

		Locomotive locomotive = new Locomotive();
		TypeLocomotive[] type = TypeLocomotive.values();

		locomotive.setMark(markLocomotive);
		locomotive.setTypeLocomotive(type[random.nextInt(type.length)]);

		return locomotive;

	}

	private static final int MIN_COUNT_PASSENGER_WAGGONS = 2;
	private static final int MAX_COUNT_PASSENGER_WAGGONS = 18;
	private static final int MAX_COUNT_LUGGAGE_WAGGONS = 2;
	private static final double LEHGHT_PASSENGER_WAGGONS = 24.5;
	private static final double LEHGHT_LUGGAGE_WAGGONS = 29.3;
	private static final double MAX_LUGGAGE_IN_LAGGAGE_WAGGONS = 3500;

	private static List<Waggon> createWaggons() {
		List<Waggon> waggons = new ArrayList<>();

		for (int i = 0; i < random.nextInt(MAX_COUNT_PASSENGER_WAGGONS) + MIN_COUNT_PASSENGER_WAGGONS; i++) {
			waggons.add(new PassengerWaggon(LEHGHT_PASSENGER_WAGGONS,
					TypePassengerWaggon.values()[random.nextInt(TypePassengerWaggon.values().length)]));
		}

		for (int i = 0; i < random.nextInt(MAX_COUNT_LUGGAGE_WAGGONS); i++) {
			waggons.add(new LuggageWaggon(LEHGHT_LUGGAGE_WAGGONS, MAX_LUGGAGE_IN_LAGGAGE_WAGGONS));
		}

		return waggons;

	}

	public static BigDecimal fillLuggagePassenger(Train train) {
		List<Waggon> waggons = train.getWaggons();

		BigDecimal rank = train.getTotalWeightLuggage();

		BigDecimal occupiedLuggage = new BigDecimal(0);

		for (Waggon waggon : waggons) {
			if (waggon instanceof LuggageWaggon) {
				occupiedLuggage = occupiedLuggage.add(new BigDecimal(random.nextDouble() * rank.doubleValue()));
			}
		}

		return occupiedLuggage.setScale(3, BigDecimal.ROUND_HALF_DOWN);

	}

	private static int fillPassengerSeats(Train train) {
		List<Waggon> waggons = train.getWaggons();
		int countOccupiedPassengerSeats = 0;

		for (Waggon waggon : waggons) {
			if (waggon instanceof PassengerWaggon) {
				countOccupiedPassengerSeats += random
						.nextInt(((PassengerWaggon) waggon).getTypeWaggon().getNumberSeats());
			}
		}
		return countOccupiedPassengerSeats;
	}

}
