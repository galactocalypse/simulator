package simulator.prisonersdilemma;

import lombok.Getter;
import simulator.core.AbstractEntity;
import simulator.core.AbstractInteractionResponse;
import simulator.core.Universe.TimeElapse;

public class PrisonerEntity extends AbstractEntity {

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
	public AbstractInteractionResponse interact(AbstractEntity entity) {
		return strategy.generateResponse((PrisonerEntity) entity);
	}

	@Override
	public void receiveResponse(AbstractEntity entity, AbstractInteractionResponse receivedResponse) {
		strategy.seedResponse((PrisonerEntity) entity, (PrisonerInteractionResponse) receivedResponse);
	}

}
