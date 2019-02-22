package by.epam.javatraining.glazunov.task01.model.entity;

public class PassengerWaggon extends Waggon {

	private TypePassengerWaggon typeWaggon;

	public PassengerWaggon() {
		super();
	}

	public PassengerWaggon(double lehghtWaggon, TypePassengerWaggon typeWaggon) {
		super(lehghtWaggon);
		this.typeWaggon = typeWaggon;
	}

	public TypePassengerWaggon getTypeWaggon() {
		return typeWaggon;
	}

	public void setTypeWaggon(TypePassengerWaggon typeWaggon) {
		this.typeWaggon = typeWaggon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((typeWaggon == null) ? 0 : typeWaggon.hashCode());
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
		PassengerWaggon other = (PassengerWaggon) obj;
		if (typeWaggon != other.typeWaggon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerWaggon [typeWaggon=" + typeWaggon + "]";
	}

}
