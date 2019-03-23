package by.epam.javatraining.glazunov.task01.utill.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javatraining.glazunov.task01.model.exception.FileReadException;


public class Reader {
	private final static Logger LOGGER = Logger.getRootLogger();
	private static final String MESSAGE_ERROR = "Error reading file";
	private static final Object MESSAGE_FILE_NOT_FOUND = "Initialization file is not exists";

	public static List<String> readFile(String fileName) throws FileReadException {
		File file = new File(fileName);
		List<String> list = new ArrayList<>();
		
		try(FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			
			String text = "";

			while ((text = bufferedReader.readLine()) != null) {
				list.add(text);
			}
			
		} catch (FileNotFoundException e) {
			LOGGER.error(MESSAGE_FILE_NOT_FOUND);
		} catch (IOException e1) {
			throw new FileReadException(MESSAGE_ERROR, e1);
		}
		return list;
	}
}
