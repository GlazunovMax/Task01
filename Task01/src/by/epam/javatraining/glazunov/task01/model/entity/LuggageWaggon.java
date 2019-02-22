package by.epam.javatraining.glazunov.task01.model.entity;

public class LuggageWaggon extends Waggon {
	private double luggage;

	public LuggageWaggon() {
		super();
	}

	public LuggageWaggon(double lehghtWaggon, double luggage) {
		super(lehghtWaggon);
		this.luggage = luggage;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		if (luggage < 0)
			this.luggage = 0.0;
		this.luggage = luggage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(luggage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LuggageWaggon other = (LuggageWaggon) obj;
		if (Double.doubleToLongBits(luggage) != Double.doubleToLongBits(other.luggage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LuggageWaggon [luggage=" + luggage + "]";
	}

}
