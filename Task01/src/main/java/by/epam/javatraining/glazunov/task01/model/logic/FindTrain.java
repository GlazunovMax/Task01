package by.epam.javatraining.glazunov.task01.model.logic;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public interface FindTrain {
	
	Train findTrainWithMaxPassengerSeats(Train[] trains) throws TechnicalException;

	Train findTrainWithMinPassengerSeats(Train[] trains) throws TechnicalException;

	Train findTrainWithMinWeightLuggage(Train[] trains) throws TechnicalException;

	Train findTrainWithMaxWeightLuggage(Train[] trains) throws TechnicalException;
	
}
