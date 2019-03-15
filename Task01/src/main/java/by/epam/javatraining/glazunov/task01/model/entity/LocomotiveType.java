package by.epam.javatraining.glazunov.task01.model.entity;

public enum LocomotiveType {
	ELECTRIC_LOCOMOTIVE(27.5), HEAT_LOCOMOTIVE(17.22);

	private double lenght;
	
	
	private LocomotiveType(double lenght) {
		this.lenght = lenght;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
	
	

}
