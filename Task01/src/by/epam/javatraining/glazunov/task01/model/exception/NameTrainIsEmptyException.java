package by.epam.javatraining.glazunov.task01.model.exception;

public class NameTrainIsEmptyException extends Exception {
	private static final long serialVersionUID = 4739461751503906271L;

	public NameTrainIsEmptyException() {
		super();
	}
	
	public NameTrainIsEmptyException(String message, Exception e) {
		super(message, e);
	}

	public NameTrainIsEmptyException(String message) {
		super(message);
	}

	public NameTrainIsEmptyException(Exception e) {
		super(e);
	}

}
