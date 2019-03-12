package by.epam.javatraining.glazunov.task01.view;

public class ConsoleTrainInfo implements TrainInfo {

	@Override
	public void print(Object msg) {
		System.out.println(msg);
	}
}
