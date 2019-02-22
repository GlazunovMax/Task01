package by.epam.javatraining.glazunov.task01.model.entity;

public enum TypeLocomotive {
	ELECTRIC_LOCOMOTIVE(27.5), HEAT_LOCOMOTIVE(17.22);

	private double lenght;

	private TypeLocomotive(double lenght) {
		this.lenght = lenght;
	}

	public double getLenght() {
		return lenght;
	}

}
