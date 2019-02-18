package by.epam.javatraining.glazunov.task01.model.entity;

public enum TypePassengerWaggon {	
	COUPE(36), RESERVED_BERTH(54), THIRD_CLASS(81);
	
	private int numberSeats;

	private TypePassengerWaggon(int numberSeats) {
		this.numberSeats = numberSeats;
	}
	
	public int getNumberSeats() {
		return numberSeats;
	}

}
