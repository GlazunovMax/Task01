package by.epam.javatraining.glazunov.task01.model.entity;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalPlacesOccupiedException;

public class PassengerWaggon extends Waggon {
	private static final double LEHGHT_PASSENGER_WAGGONS = 24.5;
	private static final String MESSAGE_OCCUPIED_PLACES_NEGATIVE = "Places occupied can not be negative!";

	private PassengerWaggonType typeWaggon;
	private int placeOccupied;
	
	public PassengerWaggon() {
		typeWaggon = PassengerWaggonType.THIRD_CLASS;
	}
	
	public PassengerWaggon(PassengerWaggonType typeWaggon, int placeOccupied) {
		super(LEHGHT_PASSENGER_WAGGONS);
		this.typeWaggon = typeWaggon;
		this.placeOccupied = placeOccupied;
	}


	public PassengerWaggonType getTypeWaggon() {
		return typeWaggon;
	}


	public void setTypeWaggon(PassengerWaggonType typeWaggon) {
		this.typeWaggon = typeWaggon;
	}


	public int getPlaceOccupied() {
		return placeOccupied;
	}


	public void setOccupiedPlaces(int placeOccupied) throws IllegalPlacesOccupiedException {
		if (placeOccupied > 0) {
			this.placeOccupied = placeOccupied;
		} else {
			throw new IllegalPlacesOccupiedException(MESSAGE_OCCUPIED_PLACES_NEGATIVE);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + placeOccupied;
		result = prime * result + ((typeWaggon == null) ? 0 : typeWaggon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerWaggon other = (PassengerWaggon) obj;
		if (placeOccupied != other.placeOccupied)
			return false;
		if (typeWaggon != other.typeWaggon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerWaggon [typeWaggon=" + typeWaggon + ", placeOccupied=" + placeOccupied + ", " + super.toString() + "]";
	}

}
