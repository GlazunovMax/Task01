package by.epam.javatraining.glazunov.task01.model.entity;

import java.math.BigDecimal;

import by.epam.javatraining.glazunov.task01.model.exception.LuggageWeightNegativeException;

public class LuggageWaggon extends Waggon {
	private static final String MESSAGE_WEIGHT_LUGGAGE_NEGATIVE = "Baggage weight can not be negative";
	private static final double LEHGHT_LUGGAGE_WAGGONS = 29.3;
	//private static final double MAX_LUGGAGE_IN_LAGGAGE_WAGGONS = 3500;
	
	private double luggageWeight;
	private BigDecimal occupiedLuggage;

	public LuggageWaggon() {
		super();
	}

	public LuggageWaggon(double luggageWeight, BigDecimal occupiedLuggage) {
		super(LEHGHT_LUGGAGE_WAGGONS);
		this.luggageWeight = luggageWeight;
		this.occupiedLuggage = occupiedLuggage;
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

	public BigDecimal getOccupiedLuggage() {
		return occupiedLuggage;
	}

	public void setOccupiedLuggage(BigDecimal occupiedLuggage) {
		this.occupiedLuggage = occupiedLuggage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(luggageWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((occupiedLuggage == null) ? 0 : occupiedLuggage.hashCode());
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
		if (occupiedLuggage == null) {
			if (other.occupiedLuggage != null)
				return false;
		} else if (!occupiedLuggage.equals(other.occupiedLuggage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LuggageWaggon [luggageWeight=" + luggageWeight + ", occupiedLuggage=" + occupiedLuggage + ", " + super.toString() + "]";
	}

}
