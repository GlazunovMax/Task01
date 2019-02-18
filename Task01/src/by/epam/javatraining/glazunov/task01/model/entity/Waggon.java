package by.epam.javatraining.glazunov.task01.model.entity;

public class Waggon {
	private double lehghtWaggon;
	
	
	public Waggon() {}


	public Waggon(double lehghtWaggon) {
		this.lehghtWaggon = lehghtWaggon;
	}


	public double getLehghtWaggon() {
		return lehghtWaggon;
	}


	public void setLehghtWaggon(double lehghtWaggon) {
		if(lehghtWaggon < 0) this.lehghtWaggon = 0.0;
		this.lehghtWaggon = lehghtWaggon;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lehghtWaggon);
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
		if (Double.doubleToLongBits(lehghtWaggon) != Double.doubleToLongBits(other.lehghtWaggon))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Waggon [lehghtWaggon=" + lehghtWaggon + "]";
	}

	
}
