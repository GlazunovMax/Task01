package by.epam.javatraining.glazunov.task01.model.container;

import java.util.Arrays;

import by.epam.javatraining.glazunov.task01.model.entity.Train;

/**
 * 
 * @author Maxim Glazunov
 * @version 
 */
public class TrainSchedule {
	private static final int SIZE_ARRAY  = 1;
	
	//Массив обьектов
	private Train [] arrayTrains;
	
	//в какой индекс добавляет элемент
	private int indexArray;
	
	//Сколько обьектов в данный момент в массиве
	private int size;
	
	public TrainSchedule() {
		arrayTrains = new Train[SIZE_ARRAY];
	}
	
	public TrainSchedule(int capacity) {
		arrayTrains = new Train[capacity];
	}
	
	//constructor
	public TrainSchedule(Train[] masTrains) {
		this.arrayTrains = masTrains;
	}
	
	//copy constructor
	public TrainSchedule(TrainSchedule trainArraySchedule) {
		this.arrayTrains = trainArraySchedule.arrayTrains;
	}
	


	public Train[] getArrayTrains() {
		return arrayTrains;
	}

	public void setArrayTrains(Train[] arrayTrains) {
		this.arrayTrains = arrayTrains;
	}

	public void addTrain(Train train) {
		if(indexArray == arrayTrains.length) {
			growArray();
		}
		arrayTrains[indexArray] = train;
		indexArray++;
		size++;
	}
	
	//увеличивает размер массива если закончилось  место
	private void growArray() {
		Train [] newArrayTrains = new Train[arrayTrains.length + 1];
		System.arraycopy(arrayTrains, 0, newArrayTrains, 0, indexArray );
		arrayTrains = newArrayTrains;
	}
	
	public void  checkIndex(int index) {
		if(index < 0 || index >= indexArray) {
			throw new IllegalArgumentException();
		}
	}
	

	public Train get(int index) {
		checkIndex(index);
		return arrayTrains[index];
	}
	
	public int size() {
		return size;
	}
	
	public void set(int index, Train train) {
		checkIndex(index);
		arrayTrains[index] = train;
	}

	
	public boolean removeTrain(int index) {
		checkIndex(index);
		
		System.arraycopy(arrayTrains, index + 1, arrayTrains, index, indexArray - index);
		size--;
		indexArray--;
		
		return true;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arrayTrains);
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
		TrainSchedule other = (TrainSchedule) obj;
		if (!Arrays.equals(arrayTrains, other.arrayTrains))
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

		for (Train trainArray : arrayTrains) {
			builder.append(trainArray).append("\n");
		}
		
		return builder + "";
	}
	
	
	
}
