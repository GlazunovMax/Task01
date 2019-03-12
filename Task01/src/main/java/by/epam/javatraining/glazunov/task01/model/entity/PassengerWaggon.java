package by.epam.javatraining.glazunov.task01.model.entity;

public class PassengerWaggon extends Waggon {
	private static final double LEHGHT_PASSENGER_WAGGONS = 24.5;

	private PassengerWaggonType typeWaggon;
	private int occupiedPlaces;
	
	public PassengerWaggon() {
		super();
	}
	
	public PassengerWaggon(PassengerWaggonType typeWaggon, int occupiedPlaces) {
		super(LEHGHT_PASSENGER_WAGGONS);
		this.typeWaggon = typeWaggon;
		this.occupiedPlaces = occupiedPlaces;
	}


	public PassengerWaggonType getTypeWaggon() {
		return typeWaggon;
	}


	public void setTypeWaggon(PassengerWaggonType typeWaggon) {
		this.typeWaggon = typeWaggon;
	}


	public int getOccupiedPlaces() {
		return occupiedPlaces;
	}


	public void setOccupiedPlaces(int occupiedPlaces) {
		this.occupiedPlaces = occupiedPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + occupiedPlaces;
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
		if (occupiedPlaces != other.occupiedPlaces)
			return false;
		if (typeWaggon != other.typeWaggon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerWaggon [typeWaggon=" + typeWaggon + ", occupiedPlaces=" + occupiedPlaces + ", " + super.toString() + "]";
	}

}
