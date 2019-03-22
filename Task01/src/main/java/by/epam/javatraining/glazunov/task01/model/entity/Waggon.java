package by.epam.javatraining.glazunov.task01.model.entity;

public class Waggon {
	private double waggonLenght;

	public Waggon() {
	}

	public Waggon(double waggonLenght) {
		this.waggonLenght = waggonLenght;
	}
	
	public double getWaggonLenght() {
		return waggonLenght;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(waggonLenght);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Waggon other = (Waggon) obj;
		if (Double.doubleToLongBits(waggonLenght) != Double.doubleToLongBits(other.waggonLenght))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "lehghtWaggon=" + waggonLenght;
	}

}
