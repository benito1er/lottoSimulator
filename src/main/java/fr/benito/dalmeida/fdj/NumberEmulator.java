package fr.benito.dalmeida.fdj;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import fr.benito.dalmeida.fdj.domain.Border;
import fr.benito.dalmeida.fdj.domain.LotoType;
import fr.benito.dalmeida.fdj.domain.SimulationResult;

public class NumberEmulator {
	private int nbTirage;
	private LotoType lotoType;

	public NumberEmulator(int nbTirage, LotoType lotoType) {
		this.nbTirage = nbTirage;
		this.lotoType = lotoType;
	}

	public SimulationResult process() {
		int nbStandardNumber = lotoType.getNbStandarDNumber();
		int nbStarNumber = lotoType.getNbStarNumber();
		Border standarNumberInt = lotoType.getStandardNumberInterval();
		Border starNumberInt = lotoType.getStandardNumberInterval();

		return null;
	}

	protected List<Integer> getRandomNumberForCase(Border border) {
		List<Integer> standardResults = new ArrayList<Integer>();
		int index = 0;
		int limit = (int) (nbTirage * 1.3);
		int minBorder = border.getMinBorder();
		int maxBorder = border.getMaxBorder();
		int iteration = 0;
		for (; index <= nbTirage; index++) {
			iteration++;
			Integer randNum = new Random().nextInt(maxBorder);
			if (randNum < minBorder || randNum > maxBorder) {
				index--;
			} else {
				standardResults.add(randNum);
			}
			if (iteration > limit)
				break;
			/*System.out.print("limit : "+ limit);
			System.out.print(" iteration : "+iteration);
			System.out.println(" index  : "+index);*/
		}
		return standardResults;
	}

	
	protected Map<Integer, Integer> getMap(List<Integer> randomNumbers){
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for(Integer rand : randomNumbers){
			Integer count = countMap.get(rand);
			if(count== null){
				count =0;
			}else{
				count++;
			}
			countMap.put(rand, count);
		}
		return countMap;
	}
	
	protected Map<Integer, BigDecimal> getSortStats(Map<Integer, Integer>  randomNumberCounts){
		Map<Integer, BigDecimal> statMap = new HashMap<Integer, BigDecimal>();
		for(Map.Entry<Integer, Integer> entry :randomNumberCounts.entrySet()){
			Integer sortNumber = entry.getKey();
			Integer count = entry.getValue();
			statMap.put(sortNumber, new BigDecimal (count/nbTirage, MathContext.DECIMAL128));
		}
		return statMap;
	}
}
