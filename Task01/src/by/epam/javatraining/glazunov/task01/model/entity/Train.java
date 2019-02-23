package by.epam.javatraining.glazunov.task01.model.entity;

import java.math.BigDecimal;
import java.util.List;

public class Train {
	private static final String MESSAGE_NAMETRAIN_EMPTY = "Not assigned";
	
	private String nameTrain;
	private Locomotive locomotive;
	private List<Waggon> waggons;
	private int occupiedPlaces;
	private BigDecimal occupiedLuggage;

	public Train() {
	}

	public Train(String nameTrain, Locomotive locomotive, List<Waggon> waggons) {
		this.nameTrain = nameTrain;
		this.locomotive = locomotive;
		this.waggons = waggons;
		this.occupiedPlaces = 0;
		this.occupiedLuggage = new BigDecimal(0);
	}

	public int getTotalNumberPassengerSeats() {
		int countPassengerSeats = 0;

		for (Waggon waggon : waggons) {
			if (waggon instanceof PassengerWaggon) {
				countPassengerSeats += ((PassengerWaggon) waggon).getTypeWaggon().getNumberSeats();
			}
		}
		return countPassengerSeats;
	}

	public BigDecimal getTotalWeightLuggage() {
		BigDecimal weightLuggage = new BigDecimal(0);
		BigDecimal weightLug;

		for (Waggon waggon : waggons) {
			if (waggon instanceof LuggageWaggon) {
				weightLug = new BigDecimal(((LuggageWaggon) waggon).getLuggage());

				weightLuggage = weightLuggage.add(weightLug);
			}
		}

		return weightLuggage.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}
	

	public String getNameTrain() {
		return nameTrain;
	}

	public void setNameTrain(String nameTrain) {
		if (nameTrain.isEmpty()) {
			this.nameTrain = MESSAGE_NAMETRAIN_EMPTY;
		}
		this.nameTrain = nameTrain;
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}

	public List<Waggon> getWaggons() {
		return waggons;
	}

	public void setWaggons(List<Waggon> waggons) {
		this.waggons = waggons;
	}

	public int getOccupiedPlaces() {
		return occupiedPlaces;
	}

	public void setOccupiedPlaces(int occupiedPlaces) {
		this.occupiedPlaces = occupiedPlaces;
	}

	public BigDecimal getOccupiedLuggage() {
		return occupiedLuggage;
	}

	public void setOccupiedLuggage(BigDecimal occupiedLuggage) {
		this.occupiedLuggage = occupiedLuggage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locomotive == null) ? 0 : locomotive.hashCode());
		result = prime * result + ((nameTrain == null) ? 0 : nameTrain.hashCode());
		result = prime * result + ((occupiedLuggage == null) ? 0 : occupiedLuggage.hashCode());
		result = prime * result + occupiedPlaces;
		result = prime * result + ((waggons == null) ? 0 : waggons.hashCode());
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
		if (occupiedLuggage == null) {
			if (other.occupiedLuggage != null)
				return false;
		} else if (!occupiedLuggage.equals(other.occupiedLuggage))
			return false;
		if (occupiedPlaces != other.occupiedPlaces)
			return false;
		if (waggons == null) {
			if (other.waggons != null)
				return false;
		} else if (!waggons.equals(other.waggons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Train [nameTrain=" + nameTrain + ", locomotive=" + locomotive + ", waggons=" + waggons
				+ ", occupiedPlaces=" + occupiedPlaces + ", occupiedLuggage=" + occupiedLuggage + "]";
	}

}
