package fr.benito.dalmeida.fdj;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import fr.benito.dalmeida.fdj.domain.LotoType;
import fr.benito.dalmeida.fdj.domain.SimulationResult;
import fr.benito.dalmeida.fdj.domain.StandardNumber;
import fr.benito.dalmeida.fdj.domain.StarNumber;

public class NumberEmulatorTest {
	private int nbTirage = (int)(Integer.MAX_VALUE * 0.70);
	LotoType euroLotoType = LotoType.EURO_MILLION;
	NumberEmulator emul;
	@Before
	public void init() {
		emul = new NumberEmulator(nbTirage, euroLotoType);
	}

	public void testProcess() {
		
		
		SimulationResult result = emul.process();
		StandardNumber standardNumber = result.getStandardNumber();
		StarNumber starNumber = result.getStarNumber();
	}

	@Test
	public void testGetRandomNumberForCase() {
		long start = new Date().getTime();
		List<Integer>  result =	emul.getRandomNumberForCase(euroLotoType.getStandardNumberInterval());
		long end = new Date().getTime();
		System.out.println("Size "+result.size());
		//System.out.println(result);
		System.out.println(end - start);

	}
	
	@Test
	public void testGetCountCase() {
		long start = new Date().getTime();
		List<Integer>  result =	emul.getRandomNumberForCase(euroLotoType.getStandardNumberInterval());
		Map<Integer, Integer > counts= emul.getMap(result);
		long end = new Date().getTime();
		System.out.println("Size "+counts.size());
		System.out.println(counts);
		System.out.println(end - start);

	}
	
	@Test
	public void testGetStatCase() {
		long start = new Date().getTime();
		List<Integer>  result =	emul.getRandomNumberForCase(euroLotoType.getStandardNumberInterval());
		Map<Integer, Integer > counts= emul.getMap(result);
		Map<Integer,BigDecimal> stats = emul.getSortStats(counts);
		long end = new Date().getTime();
		
		System.out.println(stats);
		System.out.println(end - start);
		
		for(Map.Entry<Integer,BigDecimal> statEntry : stats.entrySet() ){
			System.out.print(statEntry.getKey() +" ");
			System.out.println(statEntry.getValue());
		}

	}
}
