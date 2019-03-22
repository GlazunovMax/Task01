package by.epam.javatraining.glazunov.task01.model.exception;

public class MainProjectException extends Exception{
	
	public MainProjectException() {
		super();
	}
	
	public MainProjectException(String message, Exception e) {
		super(message, e);
	}

	public MainProjectException(String message) {
		super(message);
	}

	public MainProjectException(Exception e) {
		super(e);
	}
	

}
