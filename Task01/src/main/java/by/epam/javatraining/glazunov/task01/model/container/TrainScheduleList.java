package by.epam.javatraining.glazunov.task01.model.container;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class TrainScheduleList implements TrainSchedule {

	private List<Train> trains;

	public TrainScheduleList() {
		this.trains = new ArrayList<>();
	}

	public TrainScheduleList(List<Train> listTrains) {
		this.trains = listTrains;
	}

	@Override
	public void addTrain(Train train) {
		trains.add(train);
	}

	@Override
	public Train get(int index) {
		checkIndex(index);

		return trains.get(index);
	}
	
	@Override
	public Train[] getTrains() {
		return trains.toArray(new Train[trains.size()]);
	}

	@Override
	public int size() {
		return trains.size();
	}

	@Override
	public void set(int index, Train train) {
		checkIndex(index);
		trains.set(index, train);
	}

	@Override
	public boolean removeTrain(int index) {
		checkIndex(index);
		trains.remove(index);
		return true;
	}

	@Override
	public boolean isEmpty() {
		return trains.isEmpty();
	}

	public void checkIndex(int index) {
		if (index < 0 || index >= trains.size()) {
			throw new IllegalArgumentException();
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trains == null) ? 0 : trains.hashCode());
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
		TrainScheduleList other = (TrainScheduleList) obj;
		if (trains == null) {
			if (other.trains != null)
				return false;
		} else if (!trains.equals(other.trains))
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
