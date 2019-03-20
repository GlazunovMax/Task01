package by.epam.javatraining.glazunov.task01.model.container;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.exception.IllegalIndexException;

public class TrainScheduleArray implements TrainSchedule {
	private static final int SIZE_ARRAY = 10;

	protected Train[] trains;
	
	protected int indexArray;
	protected int size;

	public TrainScheduleArray() {
		trains = new Train[SIZE_ARRAY];
	}

	public TrainScheduleArray(int capacity) {
		if(capacity > 0) {
			size = capacity;
		}else {
			size = SIZE_ARRAY;
		}
		trains = new Train[size];
	}

	public TrainScheduleArray(Train[] masTrains) {
		this.trains = masTrains;
	}
	
	// copy constructor 
	public TrainScheduleArray(TrainScheduleArray trainArraySchedule) {
		this.indexArray = trainArraySchedule.indexArray;
		this.size = trainArraySchedule.size;
		this.trains = new Train[size];
	}

	public Train[] getArrayTrains() {
		return trains;
	}

	public void setArrayTrains(Train[] arrayTrains) {
		this.trains = arrayTrains;
	}

	public boolean addTrain(Train train) {
		if(train != null) {
			if (indexArray == trains.length) {
				Train[] newArrayTrains = new Train[trains.length + 1];
				System.arraycopy(trains, 0, newArrayTrains, 0, indexArray);
				trains = newArrayTrains;
			}
			trains[indexArray] = train;
			indexArray++;
			size++;
			return true;
		}
		return false;
		
	}
	
	@Override
	public Train[] getTrains() {
		return trains;
	}

	public Train get(int index) throws IllegalIndexException {
		if (index >= 0 && index < indexArray) {
			return trains[index];
		}else {
			throw new IllegalIndexException();
		}
	}

	public int size() {
		return size;
	}

	public boolean set(int index, Train train) throws IllegalIndexException {
		if(train != null) {
			if (index >= 0 && index < indexArray) {
				trains[index] = train;
				return true;
			}else {
				throw new IllegalIndexException();
			}
		}
		return false;	
	}

	public boolean removeTrain(int index) throws IllegalIndexException {
		if (index >= 0 && index < indexArray) {
			System.arraycopy(trains, index + 1, trains, index, indexArray - index);
			size--;
			indexArray--;

			return true;
		}else {
			throw new IllegalIndexException();
		}
		
	}

	@Override
	public boolean isEmpty() {
		return trains.length == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(trains);
		result = prime * result + indexArray;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TrainScheduleArray other = (TrainScheduleArray) obj;
		if (!Arrays.equals(trains, other.trains)) {
			return false;
		}
		if (indexArray != other.indexArray) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Train schedule: \n");

		for (Train train : trains) {
			if(train != null) {
				builder.append(train).append("\n");
			}
		}

		return builder.toString();
	}

	

}
