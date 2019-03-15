package by.epam.javatraining.glazunov.task01.model.exception;

public class ProjectException extends Exception{
	
	public ProjectException() {
		super();
	}
	
	public ProjectException(String message, TechnicalException e) {
		super(message, e);
	}

	public ProjectException(String message) {
		super(message);
	}

	public ProjectException(TechnicalException e) {
		super(e);
	}
	

}
