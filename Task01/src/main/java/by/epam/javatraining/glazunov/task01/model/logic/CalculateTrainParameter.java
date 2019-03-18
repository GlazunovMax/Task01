package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.exception.NullArgumentException;
import by.epam.javatraining.glazunov.task01.model.exception.TechnicalException;

public class CalculateTrainParameter implements Calculate {

	@Override
	public BigDecimal calculateTrainLenght(Train train) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		Locomotive locomotive = train.getLocomotive();
		Waggon[] waggons = train.getWaggons();

		double lenWag = 0;
		BigDecimal trainLenght;
		BigDecimal allWaggonsLenght;
		BigDecimal locomotiveLehght = new BigDecimal(locomotive.getLocomotiveType().getLenght());

		for (Waggon waggon : waggons) {
			lenWag += waggon.getWaggonLenght();
		}

		allWaggonsLenght = new BigDecimal(lenWag);

		trainLenght = locomotiveLehght.add(allWaggonsLenght);

		return trainLenght.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}

	@Override
	public BigDecimal calculateLuggageWeightOccupied(Train train) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		BigDecimal luggageWeight = new BigDecimal(0);
		Waggon[] waggons = train.getWaggons();

		for (Waggon waggon : waggons) {
			if (waggon instanceof LuggageWaggon) {
				luggageWeight = luggageWeight.add(((LuggageWaggon) waggon).getLuggageOccupied());
			}
		}

		return luggageWeight.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}

	@Override
	public int calculatePassengerSeatsOccupied(Train train) throws NullArgumentException {
		CheckIfArgumentIsNull.exceptionTrainNull(train);

		int countOccuoiedSeats = 0;
		Waggon[] waggons = train.getWaggons();

		for (Waggon waggon : waggons) {
			if (waggon instanceof PassengerWaggon) {
				countOccuoiedSeats += ((PassengerWaggon) waggon).getPlaceOccupied();
			}
		}

		return countOccuoiedSeats;
	}

}
