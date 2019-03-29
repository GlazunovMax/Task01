package by.epam.javatraining.glazunov.task01.utill.data;

public class SomeConstant {
	//reader
	public static final String MESSAGE_ERROR = "Error reading file";
	public static final Object MESSAGE_FILE_NOT_FOUND = "Initialization file is not exists";
	
	//parser
	public static final String DELIMETR = ",";
	public static final int POSITION_NAME_TRAIN = 0;
	public static final int POSITION_LOCOMOTIVE_MARK = 1;
	public static final int POSITION_LOCOMOTIVE_TYPE = 2;
	public static final int POSITION_COUNT_PASSENGER_WAGGON = 3;
	public static final int POSITION_COUNT_LUGGAGE_WAGGON = 4;
	public static final int POSITION_PASSENGER_WAGGON_TYPE = 5;
	public static final int POSITION_PLACE_OCCUPIED = 6;
	public static final int INDEX_FOR_GET_NEXT_WAGGON_TYPE = 2;
	public static final int INDEX_FOR_GET_NEXT_PLACE_OCCUPIED = 2;
	public static final int INDEX_FOR_GET_LUGGAGE_WAGGON = 2;
	public static final String MESSAGE_EXCEPTION_NULL = "Null link has been passed to the method arguments!";
	
	//validator
	public static final String REGEX_TRAIN_NAME = "\\w+-\\w+";
	public static final String REGEX_LOCOMOTIVE_MARK = "(\\d)?\\w+\\d{1,3}(\\w)?";
	public static final String REGEX_LOCOMOTIVE_TYPE = "(HEAT_LOCOMOTIVE|ELECTRIC_LOCOMOTIVE)";
	public static final String REGEX_COUNT_PASSENGER_WAGGON = "\\d{1,2}";
	public static final String REGEX_COUNT_LUGGAGE_WAGGON = "\\d";
	public static final String REGEX_PASSENGER_WAGGON_TYPE = "(THIRD_CLASS|COUPE|RESERVED_BERTH)";
	public static final String REGEX_PLACE_OCCUPIED = "\\d{1,2}";
	public static final String REGEX_LUGGAGE_WEIGHT = "(3500.0)";
	public static final String REGEX_LUGGAGE_OCCUPIED = "\\d{1,4}\\.\\d{1,3}";
	public static final String MESSAGE_NO_VALID_DATA = "The list has no valid data";

}
