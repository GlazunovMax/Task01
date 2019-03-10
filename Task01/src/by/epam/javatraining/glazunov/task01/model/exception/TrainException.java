package by.epam.javatraining.glazunov.task01.model.exception;

public class TrainException extends Exception{
	private static final long serialVersionUID = 1397838770535727980L;
	
	public TrainException() {
		super();
	}
	
	public TrainException(String message, TechnicalException e) {
		super(message, e);
	}

	public TrainException(String message) {
		super(message);
	}

	public TrainException(TechnicalException e) {
		super(e);
	}
	

}
