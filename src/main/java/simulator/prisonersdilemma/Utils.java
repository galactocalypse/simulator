package simulator.prisonersdilemma;

import simulator.prisonnersdilemma.strategies.EchoStrategy;
import simulator.prisonnersdilemma.strategies.GrudgerStrategy;
import simulator.prisonnersdilemma.strategies.RandomStrategy;
import simulator.prisonnersdilemma.strategies.TitForTatStrategy;
import simulator.prisonnersdilemma.strategies.TitForThreeTatsStrategy;
import simulator.prisonnersdilemma.strategies.TitForTwoTatsStrategy;

public class Utils {

	public static PrisonerStrategy strategyForName(String strategyName) {

		switch (strategyName) {

		case RandomStrategy.NAME:
			return new RandomStrategy();

		case EchoStrategy.NAME:
			return new EchoStrategy();

		case TitForTatStrategy.NAME:
			return new TitForTatStrategy();

		case TitForTwoTatsStrategy.NAME:
			return new TitForTwoTatsStrategy();

		case TitForThreeTatsStrategy.NAME:
			return new TitForThreeTatsStrategy();

		case GrudgerStrategy.NAME:
			return new GrudgerStrategy();
		}

		throw new IllegalArgumentException(String.format("Unknown strategy: %s", strategyName));
	}

}
