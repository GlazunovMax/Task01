package by.epam.javatraining.glazunov.task01.model.exception;

public class TechnicalException extends TrainException {
	private static final long serialVersionUID = 987858967855346867L;

	public TechnicalException() {
		super();
	}
	
	public TechnicalException(String message) {
		super(message);
	}
}
