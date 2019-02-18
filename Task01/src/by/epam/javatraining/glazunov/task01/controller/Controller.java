package by.epam.javatraining.glazunov.task01.controller;


import by.epam.javatraining.glazunov.task01.model.entity.Locomotive;
import by.epam.javatraining.glazunov.task01.model.entity.LuggageWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.PassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Train;
import by.epam.javatraining.glazunov.task01.model.entity.TypeLocomotive;
import by.epam.javatraining.glazunov.task01.model.entity.TypePassengerWaggon;
import by.epam.javatraining.glazunov.task01.model.entity.Waggon;
import by.epam.javatraining.glazunov.task01.model.logic.TrainLogic;
import by.epam.javatraining.glazunov.task01.utill.LogicException;
import by.epam.javatraining.glazunov.task01.utill.LogicFactory;
import by.epam.javatraining.glazunov.task01.view.TrainInfo;
/* 
 * Пассажирский железнодорожный транспорт (Railway Transport, Passenger Train). 
 * Определить иерархию подвижного состава железнодорожного транспорта.  
 */
public class Controller {

	public static void main(String[] args) {
		
		Locomotive locomotive = new Locomotive("ЧС2т", TypeLocomotive.ELECTRIC_LOCOMOTIVE);
		
		Train t = new Train("Киев-МИнск", locomotive);
		t.addWaggon(new PassengerWaggon(22.3, TypePassengerWaggon.COUPE));
		t.addWaggon(new PassengerWaggon(22.3, TypePassengerWaggon.COUPE));
		t.addWaggon(new PassengerWaggon(24.3, TypePassengerWaggon.RESERVED_BERTH));
		
		TrainInfo.print(t);
		
		Locomotive locomotive2 = new Locomotive("ЧС4т", TypeLocomotive.HEAT_LOCOMOTIVE);
		
		
		Train t2 = new Train("Кишинев-Минск", locomotive2);
		t2.addWaggon(new PassengerWaggon(2, TypePassengerWaggon.COUPE));
		t2.addWaggon(new PassengerWaggon(25, TypePassengerWaggon.RESERVED_BERTH));
		
		
		TrainInfo.print(t2);
		
		
		
		
		
		LogicFactory factory = LogicFactory.getInstance();
		TrainLogic train = factory.getTrainLogicImpl();
		String s = null;
			try {
				s = train.findMaxPassengerOnTrain(t, t2);
			} catch (LogicException e) {
				System.out.println("search error");//log
			}
		System.out.println(s);
		
		
		 
	}

}
