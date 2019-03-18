package by.epam.javatraining.glazunov.task01.model.entity;

import java.math.BigDecimal;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalLuggageWeightException;
import by.epam.javatraining.glazunov.task01.model.exception.IllegalLuggageOccupiedException;

public class LuggageWaggon extends Waggon {
	private static final String MESSAGE_WEIGHT_LUGGAGE_NEGATIVE = "Baggage weight can not be negative";
	private static final String MESSAGE_OCCUPIED_LUGGAGE_NEGATIVE = "Baggage occupied can not be negative";
	private static final double LEHGHT_LUGGAGE_WAGGONS = 29.3;
	
	private double luggageWeight;
	private BigDecimal luggageOccupied;

	public LuggageWaggon() {
		super();
	}

	public LuggageWaggon(double luggageWeight, BigDecimal luggageOccupied) {
		super(LEHGHT_LUGGAGE_WAGGONS);
		this.luggageWeight = luggageWeight;
		this.luggageOccupied = luggageOccupied;
	}

	public double getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(double luggageWeight) throws IllegalLuggageWeightException {
		if (luggageWeight > 0.0) {
			this.luggageWeight = luggageWeight;
		} else {
			throw new IllegalLuggageWeightException(MESSAGE_WEIGHT_LUGGAGE_NEGATIVE);
		}
	}

	public BigDecimal getLuggageOccupied() {
		return luggageOccupied;
	}

	public void setLuggageOccupied(BigDecimal luggageOccupied) throws IllegalLuggageOccupiedException {
		if (luggageOccupied.compareTo(BigDecimal.ZERO) > 0) {
			this.luggageOccupied = luggageOccupied;
		} else {
			throw new IllegalLuggageOccupiedException(MESSAGE_OCCUPIED_LUGGAGE_NEGATIVE);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(luggageWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((luggageOccupied == null) ? 0 : luggageOccupied.hashCode());
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
		if (luggageOccupied == null) {
			if (other.luggageOccupied != null)
				return false;
		} else if (!luggageOccupied.equals(other.luggageOccupied))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LuggageWaggon [luggageWeight=" + luggageWeight + ", luggageOccupied=" + luggageOccupied + ", " + super.toString() + "]";
	}

}
