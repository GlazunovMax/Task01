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
import by.epam.javatraining.glazunov.task01.model.exception.FileReadException;
import by.epam.javatraining.glazunov.task01.model.exception.NoValidDataException;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;

public class Parser {

	public static List<Train> parseTrainFromFile() throws NullArgumentException {
		List<Train> listTrain = new ArrayList<>();

		List<String> dataList;
		List<String> validData = null;
		try {
			dataList = Reader.readFile("src/main/java/train.txt");
			validData = Validator.getValidData(dataList);
		} catch (FileReadException e) {
			e.getMessage();
		} catch (NoValidDataException e) {
			e.getMessage();
		}

		if (validData != null) {

			for (String string : validData) {

				String[] trainData = string.split(SomeConstant.DELIMETR);

				// Create Locomotive
				String nameTrain = trainData[SomeConstant.POSITION_NAME_TRAIN];

				String locomotiveMark = trainData[SomeConstant.POSITION_LOCOMOTIVE_MARK];
				LocomotiveType type = LocomotiveType
						.valueOf(trainData[SomeConstant.POSITION_LOCOMOTIVE_TYPE].toUpperCase());

				Locomotive locomotive = new Locomotive(locomotiveMark, type);

				// Find count passenger and luggage waggons
				int countPassengerWaggons = Integer.parseInt(trainData[SomeConstant.POSITION_COUNT_PASSENGER_WAGGON]);
				int countLuggageWaggons = Integer.parseInt(trainData[SomeConstant.POSITION_COUNT_LUGGAGE_WAGGON]);

				// Create array all waggons
				Waggon[] waggons = new Waggon[countPassengerWaggons + countLuggageWaggons];

				// add passenger waggons in array
				for (int i = 0; i < countPassengerWaggons; i++) {
					int indexWaggonType = SomeConstant.POSITION_PASSENGER_WAGGON_TYPE;
					int indexPlaceOccupied = SomeConstant.POSITION_PLACE_OCCUPIED;

					PassengerWaggonType typeWaggon = PassengerWaggonType.valueOf(trainData[indexWaggonType]);
					int placeOccupied = Integer.parseInt(trainData[indexPlaceOccupied]);

					waggons[i] = new PassengerWaggon(typeWaggon, placeOccupied);

					indexWaggonType += SomeConstant.INDEX_FOR_GET_NEXT_WAGGON_TYPE;
					indexPlaceOccupied += SomeConstant.INDEX_FOR_GET_NEXT_PLACE_OCCUPIED;
				}

				// add luggage waggons in array
				for (int i = countPassengerWaggons; i < waggons.length; i++) {
					int indexLuggageWeight = countPassengerWaggons * SomeConstant.INDEX_FOR_GET_LUGGAGE_WAGGON
							+ SomeConstant.POSITION_PASSENGER_WAGGON_TYPE;
					int indexLuggageOccupied = countLuggageWaggons * SomeConstant.INDEX_FOR_GET_LUGGAGE_WAGGON
							+ SomeConstant.POSITION_PLACE_OCCUPIED;

					double luggageWeight = Double.parseDouble(trainData[indexLuggageWeight]);
					BigDecimal luggageOccupied = new BigDecimal(trainData[indexLuggageOccupied]);

					waggons[i] = new LuggageWaggon(luggageWeight, luggageOccupied);

					indexLuggageWeight += SomeConstant.INDEX_FOR_GET_LUGGAGE_WAGGON;
					indexLuggageOccupied += SomeConstant.INDEX_FOR_GET_LUGGAGE_WAGGON;
				}

				// Create Train
				Train train = new Train(nameTrain, locomotive, waggons);

				listTrain.add(train);
			}
		} else {
			throw new NullArgumentException(SomeConstant.MESSAGE_EXCEPTION_NULL);
		}
		return listTrain;
	}

}
