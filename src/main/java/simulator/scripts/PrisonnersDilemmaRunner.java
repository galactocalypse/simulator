package simulator.scripts;

import java.util.Date;

import simulator.core.Universe;
import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerId;
import simulator.prisonersdilemma.PrisonerStrategy;
import simulator.prisonersdilemma.PrisonersDilemmaUniverse;
import simulator.prisonersdilemma.Utils;

public class PrisonnersDilemmaRunner {

	public static void main(String[] args) {

		Universe universe = new PrisonersDilemmaUniverse(new Date(), 20, 0);

		for (int i = 1; i <= 10; i++) {
			universe.addEntity(prisoner("prisoner-random-" + i, "RANDOM"));
			universe.addEntity(prisoner("prisoner-echo-" + i, "ECHO"));
			universe.addEntity(prisoner("prisoner-titfortat-" + i, "TIT_FOR_TAT"));
			universe.addEntity(prisoner("prisoner-titfor2tats-" + i, "TIT_FOR_TWO_TATS"));
			universe.addEntity(prisoner("prisoner-titfor3tats-" + i, "TIT_FOR_THREE_TATS"));
			universe.addEntity(prisoner("prisoner-grudger-" + i, "GRUDGER"));
		}

		universe.run();
	}

	private static PrisonerEntity prisoner(String id, String strategyName) {
		PrisonerId entityId = new PrisonerId(id);
		PrisonerStrategy strategy = Utils.strategyForName(strategyName);
		return new PrisonerEntity(entityId, strategy);
	}

}
