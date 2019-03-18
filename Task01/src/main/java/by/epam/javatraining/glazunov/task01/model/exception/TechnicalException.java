package by.epam.javatraining.glazunov.task01.model.exception;

public class TechnicalException extends MainProjectException {

	public TechnicalException() {
		super();
	}
	
	public TechnicalException(String message, TechnicalException e) {
		super(message, e);
	}

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(TechnicalException e) {
		super(e);
	}
}
