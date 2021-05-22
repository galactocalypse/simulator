package simulator.prisonnersdilemma.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulator.core.EntityId;
import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;
import simulator.prisonersdilemma.PrisonerStrategy;

public class TitForTwoTatsStrategy implements PrisonerStrategy {

	public static final String NAME = "TIT_FOR_TWO_TATS";
	private static final int TAT_THRESHOLD = 2;

	private final Map<EntityId, List<PrisonerActionEnum>> lastResponses = new HashMap<>();

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response) {

		EntityId key = entity.extractId();
		lastNResponses.putIfAbsent(key, new ArrayList<>());

		List<PrisonerActionEnum> lastResponses = lastNResponses.get(key);
		if (lastResponses.size() == MEMORY) {
			lastResponses.remove(0);
		}

		lastResponses.add(response.getAction());
	}

	@Override
	public PrisonerInteractionResponse generateResponse(PrisonerEntity entity) {

		return null;
	}

}
