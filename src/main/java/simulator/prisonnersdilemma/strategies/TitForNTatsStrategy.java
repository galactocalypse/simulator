package simulator.prisonnersdilemma.strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import simulator.core.EntityId;
import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;
import simulator.prisonersdilemma.PrisonerStrategy;

@RequiredArgsConstructor
public abstract class TitForNTatsStrategy implements PrisonerStrategy {

	public static final int UNBOUNDED_MEMORY = -1;

	private final Map<EntityId, List<PrisonerActionEnum>> lastResponses = new HashMap<>();
	private final int memory;
	private final int tatThreshold;
	private final boolean grudge;

	protected TitForNTatsStrategy(int tatThreshold) {
		this(UNBOUNDED_MEMORY, tatThreshold, false);
	}

	protected TitForNTatsStrategy(int tatThreshold, boolean grudge) {
		this(UNBOUNDED_MEMORY, tatThreshold, grudge);
	}

	@Override
	public void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response) {

		EntityId key = entity.extractId();
		lastResponses.putIfAbsent(key, new ArrayList<>());

		List<PrisonerActionEnum> responses = lastResponses.get(key);
		if (responses.size() == memory) {
			responses.remove(0);
		}

		responses.add(response.getAction());
	}

	@Override
	public PrisonerInteractionResponse generateResponse(PrisonerEntity entity) {

		EntityId entityId = entity.extractId();

		int defectionCount = countDefects(entityId);
		PrisonerActionEnum action = (defectionCount >= tatThreshold) ? PrisonerActionEnum.DEFECT
				: PrisonerActionEnum.COOPERATE;

		return PrisonerInteractionResponse.from(action);
	}

	private int countDefects(EntityId entityId) {

		int count = 0;

		List<PrisonerActionEnum> actionsList = lastResponses.getOrDefault(entityId, Collections.emptyList());
		for (int i = actionsList.size() - 1; i >= 0; i--) {

			PrisonerActionEnum action = actionsList.get(i);
			if (action == PrisonerActionEnum.DEFECT) {
				count++;
				continue;
			}

			if (!grudge) {
				break;
			}
		}

		return count;
	}

}
