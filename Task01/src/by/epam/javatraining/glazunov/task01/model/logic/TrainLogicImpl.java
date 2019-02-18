package by.epam.javatraining.glazunov.task01.model.logic;

import java.math.BigDecimal;
import java.util.List;

import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.utill.LogicException;

public class TrainLogicImpl implements TrainLogic {

	@Override
	public BigDecimal getLenghtTrain(Train train) throws LogicException{
		
		Locomotive locomotive = train.getLocomotive();
		List<Waggon> waggons = train.getWaggons();
		
		double lenWag = 0;
		BigDecimal lehght;
		BigDecimal lenghtAllWaggons;
		BigDecimal lehghtLocomotive = new BigDecimal(locomotive.getTypeLocomotive().getLenght());
		
		
		for (Waggon waggon : waggons) {
			lenWag += waggon.getLehghtWaggon();
		}
		
		lenghtAllWaggons = new BigDecimal(lenWag);
		
		lehght = lehghtLocomotive.add(lenghtAllWaggons);
		
		return lehght.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}
	

	@Override
	public int getNumberOfPassenger(Train train) {
		
		List<Waggon> waggons = train.getWaggons();
		int countPassenger = 0;
		
		for (Waggon waggon : waggons) {
			if(waggon instanceof PassengerWaggon) {
				countPassenger += ((PassengerWaggon) waggon).getTypeWaggon().getNumberSeats();
			}
		}
		return countPassenger;
	}
	

	@Override
	public BigDecimal getWeightLuggage(Train train) {
	
		List<Waggon> waggons = train.getWaggons();
		BigDecimal weightLuggage = new BigDecimal(0);
		BigDecimal weightLug;
		
		for (Waggon waggon : waggons) {
			if(waggon instanceof LuggageWaggon) {
				weightLug = new BigDecimal(((LuggageWaggon) waggon).getLuggage());
				
				weightLuggage = weightLuggage.add(weightLug);
			}
		}

		return weightLuggage.setScale(3, BigDecimal.ROUND_HALF_DOWN);
	}
	
	
	

	@Override
	public String findMaxPassengerOnTrain(Train train1, Train train2) throws LogicException {
		TrainLogicImpl logicImpl = new TrainLogicImpl();
		
		int train1Pass;
		int train2Pass;
		String answer = "";
		
		 train1Pass = logicImpl.getNumberOfPassenger(train1);
		 train2Pass = logicImpl.getNumberOfPassenger(train2);
		
		if(train1Pass > train2Pass) {
			answer = "Train " + train1.getNameTrain() + " has max passenger seats";
		}else if(train1Pass < train2Pass) {
			answer = "Train " + train2.getNameTrain() + " has max passenger seats ";
		}else {
			answer = "Trains " + train1.getNameTrain() + train2.getNameTrain() + " have the same number of passenger seats ";
		}

		return answer;
	}

	
	@Override
	public String findMinPassengerOnTrain(Train... trains) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public String findMaxWeightLuggage(String maxOrMin, Train... trains) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findMinWeightLuggage(Train train1, Train train2) {
		TrainLogicImpl logicImpl = new TrainLogicImpl();
		
		BigDecimal train1Luggage = logicImpl.getWeightLuggage(train1);
		BigDecimal train2Luggage = logicImpl.getWeightLuggage(train2);
		String answer = "";
		
		
		if(train1Luggage.compareTo(train2Luggage) == -1) {
			answer = "Train " + train1.getNameTrain() + " has min luggage";
		}else if(train1Luggage.compareTo(train2Luggage) == 1) {
			answer = "Train " + train2.getNameTrain() + " has min luggage";
		}else {
			answer = "Trains " + train1.getNameTrain() + train2.getNameTrain() + " have the same luggage";
		}

		return answer;

	}

}
