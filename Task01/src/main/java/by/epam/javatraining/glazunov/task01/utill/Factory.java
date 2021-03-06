package by.epam.javatraining.glazunov.task01.utill;

import by.epam.javatraining.glazunov.task01.model.logic.Calculate;
import by.epam.javatraining.glazunov.task01.model.logic.CalculateTrainParameter;
import by.epam.javatraining.glazunov.task01.model.logic.Find;
import by.epam.javatraining.glazunov.task01.model.logic.FindTrainByParameter;
import by.epam.javatraining.glazunov.task01.model.logic.Sort;
import by.epam.javatraining.glazunov.task01.model.logic.SortTrainByParameter;

public class Factory {
	private static Factory instance;
	
	private final Calculate trainCalculate = new CalculateTrainParameter();
	private final Sort sortTrain = new SortTrainByParameter();
	private final Find findTrain = new FindTrainByParameter();

	private Factory() {
	}

	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public Sort getSortTrainImpl() {
		return sortTrain;
	}

	public Calculate getTrainCalculateImpl() {
		return trainCalculate;
	}

	public Find getFindTrainImpl() {
		return findTrain;
	}

}
