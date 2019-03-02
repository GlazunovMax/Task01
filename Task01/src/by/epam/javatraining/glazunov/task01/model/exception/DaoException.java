package by.epam.javatraining.glazunov.task01.model.exception;

public class DaoException extends Exception{
	private static final long serialVersionUID = 4486657311944693403L;
	
	public DaoException() {
		super();
	}
	
	public DaoException(String message, Exception e) {
		super(message, e);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Exception e) {
		super(e);
	}
}
