package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public interface Calculate {

	BigDecimal calculateTrainLenght(Train train) throws NullArgumentException;

	BigDecimal calculateLuggageWeightOccupied(Train train) throws NullArgumentException;

	int calculatePassengerSeatsOccupied(Train train) throws NullArgumentException;


}

