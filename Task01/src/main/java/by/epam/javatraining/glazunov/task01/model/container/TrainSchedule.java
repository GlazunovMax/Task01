package by.epam.javatraining.glazunov.task01.model.container;

import by.epam.javatraining.glazunov.task01.model.entity.Train;

public interface TrainSchedule {
	Train[] getTrains();
	
	void addTrain(Train train);

	Train get(int index);

	int size();
	
	public boolean isEmpty();

	void set(int index, Train train);

	boolean removeTrain(int index);
}
