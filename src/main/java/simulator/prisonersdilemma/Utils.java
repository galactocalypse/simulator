package simulator.prisonersdilemma;

import simulator.prisonnersdilemma.strategies.EchoStrategy;
import simulator.prisonnersdilemma.strategies.RandomStrategy;
import simulator.prisonnersdilemma.strategies.TitForTatStrategy;

public class Utils {

	
	public static PrisonerStrategy strategyForName(String strategyName) {

		switch (strategyName) {
		
			case RandomStrategy.NAME:
				return new RandomStrategy();
			
			case EchoStrategy.NAME:
				return new EchoStrategy();
	
			case TitForTatStrategy.NAME:
				return new TitForTatStrategy();
		}

		throw new IllegalArgumentException(String.format("Unknown strategy: %s", strategyName));
	}

}
