package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class CalculateTrainImpl implements CalculateTrain {

	@Override
	public BigDecimal calculateLenghtTrain(Train train) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		Locomotive locomotive = train.getLocomotive();
		Waggon[] waggons = train.getWaggons();

		double lenWag = 0;
		BigDecimal trainLenght;
		BigDecimal lenghtAllWaggons;
		BigDecimal lehghtLocomotive = new BigDecimal(locomotive.getTypeLocomotive().getLenght());

		for (Waggon waggon : waggons) {
			lenWag += waggon.getLehghtWaggon();
		}

		lenghtAllWaggons = new BigDecimal(lenWag);

		trainLenght = lehghtLocomotive.add(lenghtAllWaggons);

		return trainLenght.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}

	@Override
	public BigDecimal calculateWeightOccupiedLuggage(Train train) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		BigDecimal weightLuggage = new BigDecimal(0);
		Waggon[] waggons = train.getWaggons();

		for (Waggon waggon : waggons) {
			if (waggon instanceof LuggageWaggon) {
				weightLuggage = weightLuggage.add(((LuggageWaggon) waggon).getOccupiedLuggage());
			}
		}

		return weightLuggage.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}

	@Override
	public int calculateOccupiedPassengerSeats(Train train) throws TechnicalException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		int countOccuoiedSeats = 0;
		Waggon[] waggons = train.getWaggons();

		for (Waggon waggon : waggons) {
			if (waggon instanceof PassengerWaggon) {
				countOccuoiedSeats += ((PassengerWaggon) waggon).getOccupiedPlaces();
			}
		}

		return countOccuoiedSeats;
	}

}
