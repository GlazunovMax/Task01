package by.epam.javatraining.glazunov.task01.model.comparator;

import java.util.Comparator;
import by.epam.javatraining.glazunov.task01.model.entity.Train;

public class LuggageWeightComparator implements Comparator<Train> {

	@Override
	public int compare(Train train1, Train train2) {
		return Integer.compare(train2.getTotalWeightLuggage().intValue(), train1.getTotalWeightLuggage().intValue());
	}
}
