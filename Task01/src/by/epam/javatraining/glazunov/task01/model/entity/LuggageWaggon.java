package by.epam.javatraining.glazunov.task01.model.entity;

import by.epam.javatraining.glazunov.task01.model.exception.LuggageWeightNegativeException;

public class LuggageWaggon extends Waggon {
	private static final String MESSAGE_WEIGHT_LUGGAGE_NEGATIVE = "Baggage weight can not be negative";
	private double luggageWeight;

	public LuggageWaggon() {
		super();
	}

	public LuggageWaggon(double lehghtWaggon, double luggageWeight) {
		super(lehghtWaggon);
		this.luggageWeight = luggageWeight;
	}

	public double getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(double luggageWeight) throws LuggageWeightNegativeException {
		if (luggageWeight < 0.0) {
			throw new LuggageWeightNegativeException(MESSAGE_WEIGHT_LUGGAGE_NEGATIVE);
		} else {
			this.luggageWeight = luggageWeight;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(luggageWeight);
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
		if (Double.doubleToLongBits(luggageWeight) != Double.doubleToLongBits(other.luggageWeight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LuggageWaggon [luggageWeight=" + luggageWeight + "]";
	}

	/*
	 * public double getLuggage() { return luggageWeight; }
	 * 
	 * public void setLuggage(double luggage) { if (luggage < 0.0) {
	 * 
	 * this.luggageWeight = 0.0; }else { this.luggageWeight = luggage; }
	 * 
	 * }
	 */

}
