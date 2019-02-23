package by.epam.javatraining.glazunov.task01.model.logic;

public class LogicFactory {
	private static LogicFactory instance;

	private final TrainLogic trainLogicImpl = new TrainLogicImpl();

	private LogicFactory() {
	}

	public static LogicFactory getInstance() {
		if (instance == null) {
			instance = new LogicFactory();
		}
		return instance;
	}

	public TrainLogic getTrainLogicImpl() {
		return trainLogicImpl;
	}

}
