package by.epam.javatraining.glazunov.task01.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileTrainInfo implements TrainInfo {
	private String pathname;
	
	public FileTrainInfo(String pathname) {
		this.pathname = pathname;
	}

	@Override
	public void print(Object msg) {
		File file = new File(pathname);
		try(PrintWriter printWriter = new PrintWriter(file);) {
			printWriter.println(msg);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //log
		}	
	}
}
