package by.epam.javatraining.glazunov.task01.model.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Train {
	private String nameTrain;
	private Locomotive locomotive;
	private List<Waggon> waggons;
	
	
	public Train(String nameTrain, Locomotive locomotive) {
		this.nameTrain = nameTrain;
		this.locomotive = locomotive;
		waggons = new ArrayList<Waggon>();
	}

	public void addWaggon(Waggon waggon){
		waggons.add(waggon);
	}
	
	public void removeWaggon(Waggon waggon) {
		waggons.remove(waggon);
	}
	

	public String getNameTrain() {
		return nameTrain;
	}

	public void setNameTrain(String nameTrain) {
		if(nameTrain.isEmpty()) this.nameTrain = "unknown";
		this.nameTrain = nameTrain;
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}

	public List<Waggon> getWaggons() {
		return waggons;
	}

	public void setWaggons(List<Waggon> waggons) {//valid
		this.waggons = waggons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locomotive == null) ? 0 : locomotive.hashCode());
		result = prime * result + ((nameTrain == null) ? 0 : nameTrain.hashCode());
		result = prime * result + ((waggons == null) ? 0 : waggons.hashCode());
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
		Train other = (Train) obj;
		if (locomotive == null) {
			if (other.locomotive != null)
				return false;
		} else if (!locomotive.equals(other.locomotive))
			return false;
		if (nameTrain == null) {
			if (other.nameTrain != null)
				return false;
		} else if (!nameTrain.equals(other.nameTrain))
			return false;
		if (waggons == null) {
			if (other.waggons != null)
				return false;
		} else if (!waggons.equals(other.waggons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Train [nameTrain=" + nameTrain + ", locomotive=" + locomotive + ", waggons=" + waggons + "]";//????
	}

	

	
	
	
	
	
}
