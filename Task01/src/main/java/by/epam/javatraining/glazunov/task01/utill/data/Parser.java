package by.epam.javatraining.glazunov.task01.utill.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LocomotiveType;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggonType;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;

public class Parser {

	private static final String DELIMETR = ",";
	private static final int POSITION_NAME_TRAIN = 0;
	private static final int POSITION_LOCOMOTIVE_MARK = 1;
	private static final int POSITION_LOCOMOTIVE_TYPE = 2;
	private static final int POSITION_COUNT_PASSENGER_WAGGON = 3;
	private static final int POSITION_COUNT_LUGGAGE_WAGGON = 4;
	private static final int POSITION_PASSENGER_WAGGON_TYPE = 5;
	private static final int POSITION_PLACE_OCCUPIED = 6;
	private static final int INDEX_FOR_GET_NEXT_WAGGON_TYPE = 2;
	private static final int INDEX_FOR_GET_NEXT_PLACE_OCCUPIED = 2;
	private static final int INDEX_FOR_GET_LUGGAGE_WAGGON = 2;
	private static final String MESSAGE_EXCEPTION_NULL = "Null link has been passed to the method arguments!";

	public static List<Train> parseTrainFromFile(List<String> list) throws NullArgumentException {
		List<Train> listTrain = new ArrayList<>();

		if (list != null) {

			for (String string : list) {

				String[] trainData = string.split(DELIMETR);

				//Create Locomotive
				String nameTrain = trainData[POSITION_NAME_TRAIN];

				String locomotiveMark = trainData[POSITION_LOCOMOTIVE_MARK];
				LocomotiveType type = LocomotiveType.valueOf(trainData[POSITION_LOCOMOTIVE_TYPE].toUpperCase());

				Locomotive locomotive = new Locomotive(locomotiveMark, type);

				
				//Find count passenger and luggage waggons
				int countPassengerWaggons = Integer.parseInt(trainData[POSITION_COUNT_PASSENGER_WAGGON]);
				int countLuggageWaggons = Integer.parseInt(trainData[POSITION_COUNT_LUGGAGE_WAGGON]);
				
				//Create array all waggons
				Waggon[] waggons = new Waggon[countPassengerWaggons + countLuggageWaggons];

				
				//add passenger waggons in array
				for (int i = 0; i < countPassengerWaggons; i++) {
					int indexWaggonType = POSITION_PASSENGER_WAGGON_TYPE;
					int indexPlaceOccupied = POSITION_PLACE_OCCUPIED;

					PassengerWaggonType typeWaggon = PassengerWaggonType.valueOf(trainData[indexWaggonType]);
					int placeOccupied = Integer.parseInt(trainData[indexPlaceOccupied]);

					waggons[i] = new PassengerWaggon(typeWaggon, placeOccupied);

					indexWaggonType += INDEX_FOR_GET_NEXT_WAGGON_TYPE;
					indexPlaceOccupied += INDEX_FOR_GET_NEXT_PLACE_OCCUPIED;
				}
				
				
				//add luggage waggons in array
				for (int i = countPassengerWaggons; i < waggons.length; i++) {
					int indexLuggageWeight = countPassengerWaggons * INDEX_FOR_GET_LUGGAGE_WAGGON
							+ POSITION_PASSENGER_WAGGON_TYPE;
					int indexLuggageOccupied = countLuggageWaggons * INDEX_FOR_GET_LUGGAGE_WAGGON
							+ POSITION_PLACE_OCCUPIED;

					double luggageWeight = Double.parseDouble(trainData[indexLuggageWeight]);
					BigDecimal luggageOccupied = new BigDecimal(trainData[indexLuggageOccupied]);

					waggons[i] = new LuggageWaggon(luggageWeight, luggageOccupied);

					indexLuggageWeight += INDEX_FOR_GET_LUGGAGE_WAGGON;
					indexLuggageOccupied += INDEX_FOR_GET_LUGGAGE_WAGGON;
				}
				
				
				//Create Train
				Train train = new Train(nameTrain, locomotive, waggons);

				listTrain.add(train);
			}
		} else {
			throw new NullArgumentException(MESSAGE_EXCEPTION_NULL);
		}
		return listTrain;
	}

}
