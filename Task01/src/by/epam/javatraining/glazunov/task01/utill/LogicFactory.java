package by.epam.javatraining.glazunov.task01.utill;

import by.epam.javatraining.glazunov.task01.model.logic.TrainLogic;
import by.epam.javatraining.glazunov.task01.model.logic.TrainLogicImpl;

public class LogicFactory {
	private static final LogicFactory instance = new LogicFactory();
	
	private final TrainLogic trainLogicImpl = new TrainLogicImpl();

	private LogicFactory() {
	}
	
	public static LogicFactory getInstance() {
		return instance;
	}
	
	public TrainLogic getTrainLogicImpl() {
		return trainLogicImpl;
	}

}
