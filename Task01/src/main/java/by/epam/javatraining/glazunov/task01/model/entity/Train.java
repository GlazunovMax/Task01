package by.epam.javatraining.glazunov.task01.model.entity;

import java.math.BigDecimal;
import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalTrainNameException;
import by.epam.javatraining.glazunov.task01.model.exception.NullLocomotiveException;
import by.epam.javatraining.glazunov.task01.model.exception.NullWaggonException;

public class Train {
	private static final String MESSAGE_NAMETRAIN_EMPTY = "Name Train is not assigned or null link has been passed";
	private static final String MESSAGE_LOCOMOTIVE_EMPTY = "There must be at least one Lokomotivе";
	private static final String MESSAGE_WAGGON_EMPTY = "There must be at least two waggons";

	private String trainName;
	private Locomotive locomotive;
	private Waggon[] waggons;

	public Train() {
	}

	public Train(String nameTrain, Locomotive locomotive, Waggon[] waggons) {
		this.trainName = nameTrain;
		this.locomotive = locomotive;
		this.waggons = waggons;
	}

	public String getNameTrain() {
		return trainName;
	}

	public void setNameTrain(String nameTrain) throws IllegalTrainNameException {
		if (!(nameTrain == null || nameTrain.isEmpty())) {
			this.trainName = nameTrain;
		} else {
			throw new IllegalTrainNameException(MESSAGE_NAMETRAIN_EMPTY);
		}
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) throws NullLocomotiveException {
		if (locomotive != null) {
			this.locomotive = locomotive;
		} else {
			throw new NullLocomotiveException(MESSAGE_LOCOMOTIVE_EMPTY);
		}

	}

	public Waggon[] getWaggons() {
		return waggons;
	}

	public void setWaggons(Waggon[] waggons) throws NullWaggonException {
		if (waggons != null && waggons.length != 0 ) {
			this.waggons = waggons;
		} else {
			throw new NullWaggonException(MESSAGE_WAGGON_EMPTY);
		}

	}

	public int getTotalNumberPassengerSeats() {
		int countPassengerSeats = 0;

		for (int i = 0; i < waggons.length; i++) {
			if (waggons[i] instanceof PassengerWaggon) {
				countPassengerSeats += ((PassengerWaggon) waggons[i]).getTypeWaggon().getNumberSeats();
			}
		}

		return countPassengerSeats;
	}

	public BigDecimal getTotalWeightLuggage() {
		BigDecimal weightLuggage = new BigDecimal(0);
		BigDecimal weightLug;

		for (int i = 0; i < waggons.length; i++) {
			if (waggons[i] instanceof LuggageWaggon) {
				weightLug = new BigDecimal(((LuggageWaggon) waggons[i]).getLuggageWeight());

				weightLuggage = weightLuggage.add(weightLug);
			}
		}

		return weightLuggage.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locomotive == null) ? 0 : locomotive.hashCode());
		result = prime * result + ((trainName == null) ? 0 : trainName.hashCode());
		result = prime * result + Arrays.hashCode(waggons);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (locomotive == null) {
			if (other.locomotive != null)
				return false;
		} else if (!locomotive.equals(other.locomotive))
			return false;
		if (trainName == null) {
			if (other.trainName != null)
				return false;
		} else if (!trainName.equals(other.trainName))
			return false;
		if (!Arrays.equals(waggons, other.waggons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Train [trainName=" + trainName + ", locomotive=" + locomotive + ", waggons=" + Arrays.toString(waggons)
				+ "]";
	}

}
