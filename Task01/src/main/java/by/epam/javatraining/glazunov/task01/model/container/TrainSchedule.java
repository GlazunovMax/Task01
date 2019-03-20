package by.epam.javatraining.glazunov.task01.model.container;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.IllegalIndexException;

public interface TrainSchedule {
	Train[] getTrains();
	
	boolean addTrain(Train train);

	Train get(int index) throws IllegalIndexException;

	int size();
	
	public boolean isEmpty();

	boolean set(int index, Train train) throws IllegalIndexException;

	boolean removeTrain(int index) throws IllegalIndexException;
}
