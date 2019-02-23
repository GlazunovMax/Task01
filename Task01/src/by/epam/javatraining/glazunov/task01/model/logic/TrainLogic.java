package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.utill.TypeSearch;

public interface TrainLogic {

	Map<String, BigDecimal> getLenghtTrain(List<Train> trains) throws LogicException;

	List<String> getNumberOfPassenger(List<Train> trains) throws LogicException;

	List<String> getWeightLuggage(List<Train> trains) throws LogicException;

	Train findMaxPassengerOnTrain(List<Train> trains) throws LogicException;

	Train findMaxWeightLuggageOnTrain(List<Train> trains) throws LogicException;

	Train findMinOrMaxPassengerOnTrain(List<Train> trains, TypeSearch typeSearch) throws LogicException;

}
