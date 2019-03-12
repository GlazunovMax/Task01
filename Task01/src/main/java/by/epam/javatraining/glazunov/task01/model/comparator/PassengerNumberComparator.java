package by.epam.javatraining.glazunov.task01.model.comparator;

import java.util.Comparator;
import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class PassengerNumberComparator implements Comparator<Train> {

	@Override
	public int compare(Train train1, Train train2) {
		if (train1.getTotalNumberPassengerSeats() < train2.getTotalNumberPassengerSeats()) {
			return 1;
		} else if (train1.getTotalNumberPassengerSeats() > train2.getTotalNumberPassengerSeats()) {
			return -1;
		} else {
			return 0;
		}
		
		//return Integer.compare(train2.getTotalNumberPassengerSeats(), train1.getTotalNumberPassengerSeats());
	}
}
