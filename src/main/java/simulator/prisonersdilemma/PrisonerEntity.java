package simulator.prisonersdilemma;

import lombok.Getter;
import simulator.core.Entity;
import simulator.core.InteractionResponse;
import simulator.core.Universe.TimeElapse;

public class PrisonerEntity extends Entity {

	private final PrisonerId id;

	@Getter
	private final PrisonerStrategy strategy;

	public PrisonerEntity(PrisonerId id, PrisonerStrategy strategy) {
		this.id = id;
		this.strategy = strategy;
	}

	@Override
	public void elapseTime(TimeElapse timeElapse) {
		// no impact of time
	}

	@Override
	public PrisonerId extractId() {
		return id;
	}

	@Override
	public InteractionResponse interact(Entity entity) {
		return strategy.generateResponse((PrisonerEntity) entity);
	}

	@Override
	public void receiveResponse(Entity entity, InteractionResponse receivedResponse) {
		strategy.seedResponse((PrisonerEntity) entity, (PrisonerInteractionResponse) receivedResponse);
	}

}
