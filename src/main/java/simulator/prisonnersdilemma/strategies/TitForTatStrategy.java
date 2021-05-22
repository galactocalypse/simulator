package simulator.prisonnersdilemma.strategies;

import java.util.HashMap;
import java.util.Map;

import simulator.core.EntityId;
import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;

public class TitForTatStrategy extends TitForNTatsStrategy {

	public static final String NAME = "TIT_FOR_TAT";
	private final Map<EntityId, PrisonerActionEnum> lastResponse = new HashMap<>();

	public TitForTatStrategy() {
		super(1);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response) {
		lastResponse.put(entity.extractId(), response.getAction());
	}

	@Override
	public PrisonerInteractionResponse generateResponse(PrisonerEntity entity) {

		PrisonerActionEnum action = lastResponse.get(entity.extractId());
		if (action == null) {
			action = PrisonerActionEnum.COOPERATE;
		}

		return PrisonerInteractionResponse.from(action);
	}

}
