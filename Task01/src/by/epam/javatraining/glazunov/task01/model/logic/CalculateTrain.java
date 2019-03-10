package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public interface CalculateTrain {

	BigDecimal calculateLenghtTrain(Train train) throws TechnicalException;

	BigDecimal calculateWeightOccupiedLuggage(Train train) throws TechnicalException;

	int calculateOccupiedPassengerSeats(Train train) throws TechnicalException;


}

