package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.DaoException;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;

public interface TrainLogic {
	
	List<Train> createTrainSchedule(int numberOfTrains) throws DaoException;

	Map<String, BigDecimal> getLenghtTrain(List<Train> trains) throws DaoException;

	List<String> getNumberOfPassenger(List<Train> trains) throws DaoException;

	List<String> getWeightLuggage(List<Train> trains) throws DaoException;

	Train findMaxPassengerOnTrain(List<Train> trains) throws DaoException;

	Train findMaxWeightLuggageOnTrain(List<Train> trains) throws DaoException;

	Train findMinOrMaxPassengerOnTrain(List<Train> trains, TypeSearch typeSearch) throws DaoException;

}
