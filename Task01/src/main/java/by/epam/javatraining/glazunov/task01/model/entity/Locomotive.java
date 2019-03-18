package by.epam.javatraining.glazunov.task01.model.entity;

import org.apache.log4j.Logger;

import by.epam.javatraining.glazunov.task01.model.exception.IllegalLocomotiveMarkException;

public class Locomotive {
	private static final String MESSAGE_NAME_MARK_EMPTY = "Mark Locomotive is not assigned or null link has been passed";
	   
	private String locomotiveMark;
	private LocomotiveType locomotiveType;

	public Locomotive() {
		this.locomotiveType = LocomotiveType.HEAT_LOCOMOTIVE;
	}

	public Locomotive(String locomotiveMark, LocomotiveType locomotiveType) {
		this.locomotiveMark = locomotiveMark;
		this.locomotiveType = locomotiveType;
	}

	public String getLocomotiveMark() {
		return locomotiveMark;
	}

	public void setLocomotiveMark(String locomotiveMark) throws IllegalLocomotiveMarkException {
		if (locomotiveMark != null) {
			this.locomotiveMark = locomotiveMark;
		}else {
			throw new IllegalLocomotiveMarkException(MESSAGE_NAME_MARK_EMPTY);
		}
	}

	public LocomotiveType getLocomotiveType() {
		return locomotiveType;
	}

	public void setLocomotiveType(LocomotiveType typeLocomotive) {
		this.locomotiveType = typeLocomotive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locomotiveMark == null) ? 0 : locomotiveMark.hashCode());
		result = prime * result + ((locomotiveType == null) ? 0 : locomotiveType.hashCode());
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
		Locomotive other = (Locomotive) obj;
		if (locomotiveMark == null) {
			if (other.locomotiveMark != null)
				return false;
		} else if (!locomotiveMark.equals(other.locomotiveMark))
			return false;
		if (locomotiveType != other.locomotiveType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "locomotiveMark = " + locomotiveMark + ", typeLocomotive = " + locomotiveType;
	}

}
