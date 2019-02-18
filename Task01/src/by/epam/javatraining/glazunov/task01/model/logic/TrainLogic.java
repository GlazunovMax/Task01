package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;

import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.utill.LogicException;

public interface TrainLogic {
	
	BigDecimal getLenghtTrain(Train train) throws LogicException;
	int getNumberOfPassenger(Train train); 
	BigDecimal getWeightLuggage(Train train);
	
	String findMaxPassengerOnTrain(Train train, Train train2) throws LogicException;
	String findMinPassengerOnTrain(Train... trains);
	
	String findMaxWeightLuggage (String maxOrMin, Train... trains);
	String findMinWeightLuggage (Train train, Train train2);
}
