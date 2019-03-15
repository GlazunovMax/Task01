package by.epam.javatraining.glazunov.task01.model.factory;

import by.epam.javatraining.glazunov.task01.model.logic.CalculateTrain;
import by.epam.javatraining.glazunov.task01.model.logic.CalculateTrainImpl;
import by.epam.javatraining.glazunov.task01.model.logic.FindTrain;
import by.epam.javatraining.glazunov.task01.model.logic.FindTrainImpl;
import by.epam.javatraining.glazunov.task01.model.logic.SortTrain;
import by.epam.javatraining.glazunov.task01.model.logic.SortTrainImpl;

public class LogicFactory {
	private static LogicFactory instance = new LogicFactory();;
	
	private final CalculateTrain trainCalculate = new CalculateTrainImpl();
	private final SortTrain sortTrain = new SortTrainImpl();
	private final FindTrain findTrain = new FindTrainImpl();

	private LogicFactory() {
	}

	public static LogicFactory getInstance() {
		return instance;
	}

	public SortTrain getSortTrainImpl() {
		return sortTrain;
	}

	public CalculateTrain getTrainCalculateImpl() {
		return trainCalculate;
	}

	public FindTrain getFindTrainImpl() {
		return findTrain;
	}

}