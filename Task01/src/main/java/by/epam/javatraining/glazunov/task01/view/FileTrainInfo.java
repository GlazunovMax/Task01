package by.epam.javatraining.glazunov.task01.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class FileTrainInfo implements TrainInfo {
	private static final String MESSAGE_EXCEPTION_FILE = "Initialization file is not exists";
	private final static Logger LOGGER = Logger.getRootLogger();
	
	private String path;
	
	public FileTrainInfo(String path) {
		this.path = path;
	}

	@Override
	public void print(Object msg) {
		File file = new File(path);
		try(PrintWriter printWriter = new PrintWriter(file);) {
			printWriter.println(msg);
		} catch (FileNotFoundException e) {
			LOGGER.error(MESSAGE_EXCEPTION_FILE);
		}	
	}
}
