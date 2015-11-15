package fr.benito.dalmeida.fdj.domain;

public enum LotoType {
	EURO_MILLION(5,2,new Border(1, 49),new Border(1,11)), LOTO(5,1,new Border(1, 49),new Border(1, 10));
	
	private int nbStandarDNumber;
	private int nbStarNumber;
	private Border standardNumberInterval;
	private Border starNumberInterval;
	
	private LotoType(int nbStandarDNumber, int nbStarNumber, Border standardNumberInterval, Border starNumberInterval) {
		this.nbStandarDNumber = nbStandarDNumber;
		this.nbStarNumber = nbStarNumber;
		this.standardNumberInterval = standardNumberInterval;
		this.starNumberInterval = starNumberInterval;
	}

	public int getNbStandarDNumber() {
		return nbStandarDNumber;
	}

	public int getNbStarNumber() {
		return nbStarNumber;
	}

	public Border getStandardNumberInterval() {
		return standardNumberInterval;
	}

	public Border getStarNumberInterval() {
		return starNumberInterval;
	}
	
	
}

