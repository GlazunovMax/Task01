package by.epam.javatraining.glazunov.task01.utill.data;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.exception.NoValidDataException;

public class Validator {
	private static final String REGEX_TRAIN_NAME = "\\w+-\\w+";
	private static final String REGEX_LOCOMOTIVE_MARK = "(\\d)?\\w+\\d{1,3}(\\w)?";
	private static final String REGEX_LOCOMOTIVE_TYPE = "(HEAT_LOCOMOTIVE|ELECTRIC_LOCOMOTIVE)";
	private static final String REGEX_COUNT_PASSENGER_WAGGON = "\\d{1,2}";
	private static final String REGEX_COUNT_LUGGAGE_WAGGON = "\\d";
	private static final String REGEX_PASSENGER_WAGGON_TYPE = "(THIRD_CLASS|COUPE|RESERVED_BERTH)";
	private static final String REGEX_PLACE_OCCUPIED = "\\d{1,2}";
	private static final String REGEX_LUGGAGE_WEIGHT = "(3500.0)";
	private static final String REGEX_LUGGAGE_OCCUPIED = "\\d{1,4}\\.\\d{1,3}";
	private static final String DELIMETR = ",";
	private static final String MESSAGE_NO_VALID_DATA = "The list has no valid data";

	public static List<String> getValidData(List<String> dataList) throws NoValidDataException {
		if (!dataList.isEmpty()) {
			List<String> list = new ArrayList<>();

			for (String string : dataList) {
				String[] dataStrings = string.split(DELIMETR);

				if (dataStrings[0].matches(REGEX_TRAIN_NAME) && dataStrings[1].matches(REGEX_LOCOMOTIVE_MARK)
						&& dataStrings[2].matches(REGEX_LOCOMOTIVE_TYPE)
						&& dataStrings[3].matches(REGEX_COUNT_PASSENGER_WAGGON)
						&& dataStrings[4].matches(REGEX_COUNT_LUGGAGE_WAGGON) && validPassengerWaggons(dataStrings)
						&& validLuggageWaggons(dataStrings)) {

					list.add(string);
				}
			}

			if (list.isEmpty()) {
				throw new NoValidDataException(MESSAGE_NO_VALID_DATA);
			}

			return list;

		}
		return dataList;

	}

	public static boolean validPassengerWaggons(String[] dataStrings) {

		for (int i = 0; i < Integer.parseInt(dataStrings[3]); i++) {
			int indexWag = 5;
			int indexPla = 6;
			if (!(dataStrings[indexWag].matches(REGEX_PASSENGER_WAGGON_TYPE)
					&& dataStrings[indexPla].matches(REGEX_PLACE_OCCUPIED))) {
				return false;
			}

			indexWag += 2;
			indexPla += 2;
		}
		return true;
	}

	public static boolean validLuggageWaggons(String[] dataStrings) {
		int countLuggageWaggon = Integer.parseInt(dataStrings[4]);
		int countPassengerWaggon = Integer.parseInt(dataStrings[3]);

		for (int i = 0; i < countLuggageWaggon; i++) {
			int indexLugggage = countPassengerWaggon * 2 + 5;
			int indexOccupied = countPassengerWaggon * 2 + 6;
			if (!(dataStrings[indexLugggage].matches(REGEX_LUGGAGE_WEIGHT)
					&& dataStrings[indexOccupied].matches(REGEX_LUGGAGE_OCCUPIED))) {
				return false;
			}

			indexLugggage += 2;
			indexOccupied += 2;
		}
		return true;
	}
}
