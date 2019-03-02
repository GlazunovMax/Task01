package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TrainSchedule;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.DaoException;
import by.epam.javatraining.glazunov.task01.utill.BuildTrain;
import by.epam.javatraining.glazunov.task01.utill.LuggageWeightComparator;
import by.epam.javatraining.glazunov.task01.utill.PassengerNumberComparator;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;

public class TrainLogicImpl implements TrainLogic {
	private static final String MESSAGE_OCCUPIED_PLACES = "Train name: %s. Total places - %d. Occupied places - %d.";
	private static final String MESSAGE_NO_BAGGAGE_WAGGON = "Train name %s has no baggage waggon!";
	private static final String MESSAGE_OCCUPIED_BAGGAGES = "Train name %s. Free baggage space - %.3f. Occupied baggage space - %.3f.";
	private static final String MESSAGE_EXCEPTION_EMPTY = "An empty list has been passed to the method arguments!";
	private static final String MESSAGE_EXCEPTION_NULL = "Null link has been passed to the method arguments!";
	

	@Override
	public Map<String, BigDecimal> getLenghtTrain(List<Train> trains) throws DaoException {
		isListEmptyOrNull(trains);

		Locomotive locomotive;
		List<Waggon> waggons;
		double lenWag = 0;
		BigDecimal lehght;
		BigDecimal lenghtAllWaggons;
		BigDecimal lehghtLocomotive;
		Map<String, BigDecimal> lenghtTrains = new TreeMap<>();

		for (Train train : trains) {
			locomotive = train.getLocomotive();
			waggons = train.getWaggons();

			lehghtLocomotive = new BigDecimal(locomotive.getTypeLocomotive().getLenght());

			for (Waggon waggon : waggons) {
				lenWag += waggon.getLehghtWaggon();
			}

			lenghtAllWaggons = new BigDecimal(lenWag);

			lehght = lehghtLocomotive.add(lenghtAllWaggons);

			lenghtTrains.put(train.getNameTrain(), lehght.setScale(3, BigDecimal.ROUND_HALF_DOWN));

		}
		return lenghtTrains;

	}

	@Override
	public List<String> getNumberOfPassenger(List<Train> trains) throws DaoException {
		isListEmptyOrNull(trains);

		List<String> listPlaces = new ArrayList<>();
		int totalPlaces = 0;
		int occupiedPlaces = 0;
		String answerTotalPlaces;

		for (Train train : trains) {
			totalPlaces = train.getTotalNumberPassengerSeats();
			occupiedPlaces = train.getOccupiedPlaces();

			answerTotalPlaces = String.format(MESSAGE_OCCUPIED_PLACES, train.getNameTrain(), totalPlaces,
					occupiedPlaces);

			listPlaces.add(answerTotalPlaces);

		}

		return listPlaces;
	}

	@Override
	public List<String> getWeightLuggage(List<Train> trains) throws DaoException {
		isListEmptyOrNull(trains);

		List<String> listLuggage = new ArrayList<>();
		BigDecimal totalLuggage;
		BigDecimal occupiedLuggage;
		String aboutLuggage;

		for (Train train : trains) {
			totalLuggage = train.getTotalWeightLuggage();
			occupiedLuggage = train.getOccupiedLuggage();

			if (totalLuggage.compareTo(BigDecimal.ZERO) == 0) {
				aboutLuggage = String.format(MESSAGE_NO_BAGGAGE_WAGGON, train.getNameTrain());
			} else {
				aboutLuggage = String.format(MESSAGE_OCCUPIED_BAGGAGES, train.getNameTrain(), totalLuggage,
						occupiedLuggage);
			}

			listLuggage.add(aboutLuggage);
		}

		return listLuggage;
	}

	@Override
	public Train findMinOrMaxPassengerOnTrain(List<Train> trains, TypeSearch typeSearch) throws DaoException {
		isListEmptyOrNull(trains);

		Train trainMaxPassenger;
		int index = 0;
		Collections.sort(trains, new PassengerNumberComparator());

		switch (typeSearch) {
		case MAX:
			index = 0;
			break;
		case MIN:
			index = trains.size() - 1;
			break;
		}

		trainMaxPassenger = trains.get(index);

		return trainMaxPassenger;
	}

	@Override
	public Train findMaxPassengerOnTrain(List<Train> trains) throws DaoException {
		isListEmptyOrNull(trains);

		Collections.sort(trains, new PassengerNumberComparator());

		Train trainMaxPassenger = trains.get(0);

		return trainMaxPassenger;
	}

	@Override
	public Train findMaxWeightLuggageOnTrain(List<Train> trains) throws DaoException {
		isListEmptyOrNull(trains);

		Collections.sort(trains, new LuggageWeightComparator());

		Train trainMaxLuggage = trains.get(0);

		return trainMaxLuggage;
	}
	 
	private static final String TRAIN_NAME = "Train ";
	private static final String MARK_LOCOMOTIVE = "mark ";
	private static final String MESSAGE_NUMBER_TRAIN_NEGATIVE = "Number of train should be >= 0 ";
	@Override
	public List<Train> createTrainSchedule(int numberOfTrains) throws DaoException {
		if(numberOfTrains < 0) {
			throw new DaoException(MESSAGE_NUMBER_TRAIN_NEGATIVE);
		}
		
		TrainSchedule trainSchedule = new TrainSchedule();
		
		 for (int i = 0; i < numberOfTrains; i++) {
			trainSchedule.addTrain(new BuildTrain().createTrain(TRAIN_NAME + i, MARK_LOCOMOTIVE + i));
		}
		
		return trainSchedule.getListTrains();
	}
	


	public static void isListEmptyOrNull(List<Train> trains) throws DaoException {
		if (trains == null) {
			throw new DaoException(MESSAGE_EXCEPTION_NULL);
		}else if(trains.isEmpty()) {
			throw new DaoException(MESSAGE_EXCEPTION_EMPTY);
		}
	}

	

}
