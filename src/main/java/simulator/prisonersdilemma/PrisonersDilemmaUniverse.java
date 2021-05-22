package simulator.prisonersdilemma;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulator.core.EntityId;
import simulator.core.Universe;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;

public class PrisonersDilemmaUniverse extends Universe<PrisonerEntity, PrisonerInteractionResponse> {

	private final Map<String, Integer> strategyScore = new HashMap<>();

	public PrisonersDilemmaUniverse(Date currentTime, long maxIterations, Map<EntityId, PrisonerEntity> entities, long sleepMillis) {
		super(currentTime, maxIterations, entities, sleepMillis);
	}

	@Override
	public void addEntropy() {

		List<EntityId> entityIds = new ArrayList<>(entities.keySet());

		int size = entityIds.size();
		
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				
				simulateInteraction(entities.get(entityIds.get(i)), entities.get(entityIds.get(j)));
			}
		}
	}

	private void simulateInteraction(PrisonerEntity first, PrisonerEntity second) {

		PrisonerInteractionResponse firstResponse = first.interact(second);
		PrisonerInteractionResponse secondResponse = second.interact(first);
		
		evaluate(first, firstResponse, second, secondResponse);
		
		first.receiveResponse(second, secondResponse);
		second.receiveResponse(first, firstResponse);

	
		System.out.println(String.format("Iteration %s\t:\t%s (%s) - %s (%s)", getCurrentIteration(), first.extractId(), firstResponse.getAction(), second.extractId(), secondResponse.getAction()));
	}

	private void evaluate(PrisonerEntity first, PrisonerInteractionResponse firstResponse, PrisonerEntity second, PrisonerInteractionResponse secondResponse) {
		
		boolean firstDefected = firstResponse.getAction() == PrisonerActionEnum.DEFECT;
		boolean secondDefected = secondResponse.getAction() == PrisonerActionEnum.DEFECT;
		

		if (firstDefected && secondDefected) {
			addScore(first.getStrategy(), 1);
			addScore(second.getStrategy(), 1);
			return;
		}

		if (!firstDefected && !secondDefected) {
			addScore(first.getStrategy(), 2);
			addScore(second.getStrategy(), 2);
			return;
		}

		if (firstDefected) {
			addScore(first.getStrategy(), 3);
			addScore(second.getStrategy(), 0);
			return;
		}

		addScore(first.getStrategy(), 0);
		addScore(second.getStrategy(), 3);
	}

	private void addScore(PrisonerStrategy strategy, int score) {
		int newScore = strategyScore.getOrDefault(strategy.getName(), 0) + score;
		strategyScore.put(strategy.getName(), newScore);
	}

	@Override
	protected void endIteration() {

		System.out.println(String.format("Ending iteration %s", getCurrentIteration()));
		strategyScore.forEach((strategyName, score) -> {
			
			System.out.println(String.format("\t%s\t%s", strategyName, score));
		});
	}

}
