package by.epam.javatraining.glazunov.task01.model.exception;

public class MarkLocomotiveIsEmptyException extends Exception {
	private static final long serialVersionUID = -4653894030829540327L;
	
	public MarkLocomotiveIsEmptyException() {
		super();
	}
	
	public MarkLocomotiveIsEmptyException(String message, Exception e) {
		super(message, e);
	}

	public MarkLocomotiveIsEmptyException(String message) {
		super(message);
	}

	public MarkLocomotiveIsEmptyException(Exception e) {
		super(e);
	}

}
