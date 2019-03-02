package by.epam.javatraining.glazunov.task01.model.entity;

import by.epam.javatraining.glazunov.task01.model.exception.MarkLocomotiveIsEmptyException;

public class Locomotive {
	private static final String MESSAGE_NAME_MARK_EMPTY = "Mark Locomotive is not assigned or null link has been passed";
	
	private String mark;
	private TypeLocomotive typeLocomotive;

	public Locomotive() {
		this.typeLocomotive = TypeLocomotive.ELECTRIC_LOCOMOTIVE;
	}

	public Locomotive(String mark, TypeLocomotive typeLocomotive) {
		this.mark = mark;
		this.typeLocomotive = typeLocomotive;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) throws MarkLocomotiveIsEmptyException {
		if (mark == null || mark.isEmpty()) {
			throw new MarkLocomotiveIsEmptyException(MESSAGE_NAME_MARK_EMPTY);
		}else {
			this.mark = mark;
		}
		
	}

	public TypeLocomotive getTypeLocomotive() {
		return typeLocomotive;
	}

	public void setTypeLocomotive(TypeLocomotive typeLocomotive) {
		this.typeLocomotive = typeLocomotive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((typeLocomotive == null) ? 0 : typeLocomotive.hashCode());
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
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (typeLocomotive != other.typeLocomotive)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Locomotive [mark=" + mark + ", typeLocomotive=" + typeLocomotive + "]";
	}

}
