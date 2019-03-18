package by.epam.javatraining.glazunov.task01.model.container;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class TrainScheduleArray implements TrainSchedule {
	private static final int SIZE_ARRAY = 1;

	private Train[] trains;
	private int indexArray;
	private int size;

	public TrainScheduleArray() {
		trains = new Train[SIZE_ARRAY];
	}

	public TrainScheduleArray(int capacity) {
		trains = new Train[capacity];
	}

	public TrainScheduleArray(Train[] masTrains) {
		this.trains = masTrains;
	}

	public TrainScheduleArray(TrainScheduleArray trainArraySchedule) {
		this.trains = trainArraySchedule.trains;
	}

	public Train[] getArrayTrains() {
		return trains;
	}

	public void setArrayTrains(Train[] arrayTrains) {
		this.trains = arrayTrains;
	}

	public void addTrain(Train train) {
		if (indexArray == trains.length) {
			Train[] newArrayTrains = new Train[trains.length + 1];
			System.arraycopy(trains, 0, newArrayTrains, 0, indexArray);
			trains = newArrayTrains;
		}
		trains[indexArray] = train;
		indexArray++;
		size++;
	}
	
	@Override
	public Train[] getTrains() {
		return trains;
	}

	public Train get(int index) {
		checkIndex(index);
		return trains[index];
	}

	public int size() {
		return size;
	}

	public void set(int index, Train train) {
		checkIndex(index);
		trains[index] = train;
	}

	public boolean removeTrain(int index) {
		checkIndex(index);

		System.arraycopy(trains, index + 1, trains, index, indexArray - index);
		size--;
		indexArray--;

		return true;
	}

	@Override
	public boolean isEmpty() {
		return trains.length == 0;
	}

	public void checkIndex(int index) {
		if (index < 0 || index >= indexArray) {
			throw new IllegalArgumentException();
		}
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainScheduleArray other = (TrainScheduleArray) obj;
		if (!Arrays.equals(trains, other.trains))
			return false;
		if (indexArray != other.indexArray)
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Train schedule: \n");

		for (Train train : trains) {
			builder.append(train).append("\n");
		}

		return builder + "";
	}

	

}
