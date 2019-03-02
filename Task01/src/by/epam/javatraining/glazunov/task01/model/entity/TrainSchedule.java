package by.epam.javatraining.glazunov.task01.model.entity;

import java.util.ArrayList;
import java.util.List;

public class TrainSchedule {
	private List<Train> listTrains;

	public TrainSchedule() {
		listTrains = new ArrayList<Train>();
	}

	public TrainSchedule(List<Train> listTrains) {
		this.listTrains = listTrains;
	}

	public List<Train> getListTrains() {
		return listTrains;
	}
	
	public void addTrain(Train train) {
		listTrains.add(train);
	}
	
	public void removeTrain(Train train) {
		listTrains.remove(train);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listTrains == null) ? 0 : listTrains.hashCode());
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
		if (listTrains == null) {
			if (other.listTrains != null)
				return false;
		} else if (!listTrains.equals(other.listTrains))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainSchedule [listTrains=" + listTrains + "]";
	}
	
	
	

}
