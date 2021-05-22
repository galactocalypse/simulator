package simulator.scripts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import simulator.core.EntityId;
import simulator.core.Universe;
import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerStrategy;
import simulator.prisonersdilemma.PrisonersDilemmaUniverse;
import simulator.prisonersdilemma.Utils;

public class PrisonnersDilemmaRunner {

	public static void main(String[] args) {

		Map<EntityId, PrisonerEntity> prisoners = new HashMap<>();
		addPrisoner(prisoners, "prisoner-random", "RANDOM");
		addPrisoner(prisoners, "prisoner-echo", "ECHO");
		addPrisoner(prisoners, "prisoner-titfortat", "TIT_FOR_TAT");

		Universe<PrisonerEntity, PrisonerInteractionResponse> universe = new PrisonersDilemmaUniverse(new Date(), 20,
				prisoners, 50);

		universe.run();
	}

	private static void addPrisoner(Map<EntityId, PrisonerEntity> prisoners, String id, String strategyName) {
		EntityId entityId = EntityId.from(id);
		PrisonerStrategy strategy = Utils.strategyForName(strategyName);
		prisoners.put(entityId, new PrisonerEntity(entityId, strategy));
	}

}
