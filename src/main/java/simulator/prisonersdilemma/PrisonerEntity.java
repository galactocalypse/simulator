package simulator.prisonersdilemma;

import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import simulator.core.Entity;
import simulator.core.EntityId;


@AllArgsConstructor
public class PrisonerEntity implements Entity<PrisonerEntity, PrisonerInteractionResponse> {

	private final EntityId id;

	@Getter
	private final PrisonerStrategy strategy;
	
	@Override
	public void elapseTime(TimeUnit unit, int value) {
		// no impact of time		
	}

	@Override
	public PrisonerInteractionResponse interact(PrisonerEntity entity) {
		return strategy.generateResponse(entity);
	}

	@Override
	public EntityId extractId() {
		return id;
	}

	@Override
	public void receiveResponse(PrisonerEntity entity, PrisonerInteractionResponse receivedResponse) {
		strategy.seedResponse(entity, receivedResponse);
	}

}
