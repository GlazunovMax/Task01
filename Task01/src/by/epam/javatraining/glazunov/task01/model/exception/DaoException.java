package by.epam.javatraining.glazunov.task01.model.exception;

public class DaoException extends TechnicalException{
	private static final long serialVersionUID = 4486657311944693403L;
	
	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

}
