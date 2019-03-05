package by.epam.javatraining.glazunov.task01.model.exception;

public class LuggageWeightNegativeException extends LogicException {
	private static final long serialVersionUID = -5245923355723678790L;
	
	public LuggageWeightNegativeException() {
		super();
	}

	public LuggageWeightNegativeException(String message) {
		super(message);
	}

}
