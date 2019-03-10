package by.epam.javatraining.glazunov.task01.model.entity;

import java.math.BigDecimal;
import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.exception.NameTrainIsEmptyException;

public class Train {
	private static final String MESSAGE_NAMETRAIN_EMPTY = "Name Train is not assigned or null link has been passed";

	private String nameTrain;
	private Locomotive locomotive;
	private Waggon[] waggons;

	public Train() {
	}

	public Train(String nameTrain, Locomotive locomotive, Waggon[] waggons) {
		this.nameTrain = nameTrain;
		this.locomotive = locomotive;
		this.waggons = waggons;
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

	public String getNameTrain() {
		return nameTrain;
	}

	public void setNameTrain(String nameTrain) throws NameTrainIsEmptyException {
		if (nameTrain == null || nameTrain.isEmpty()) {
			throw new NameTrainIsEmptyException(MESSAGE_NAMETRAIN_EMPTY);
		} else {
			this.nameTrain = nameTrain;
		}

	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}

	public Waggon[] getWaggons() {
		return waggons;
	}

	public void setWaggons(Waggon[] waggons) {
		this.waggons = waggons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locomotive == null) ? 0 : locomotive.hashCode());
		result = prime * result + ((nameTrain == null) ? 0 : nameTrain.hashCode());
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
		if (nameTrain == null) {
			if (other.nameTrain != null)
				return false;
		} else if (!nameTrain.equals(other.nameTrain))
			return false;
		if (!Arrays.equals(waggons, other.waggons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Train [nameTrain=" + nameTrain + ", locomotive=" + locomotive + ", waggons=" + Arrays.toString(waggons)
				+ "]";
	}

}
