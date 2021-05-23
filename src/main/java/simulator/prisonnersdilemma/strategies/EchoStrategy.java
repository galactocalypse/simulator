package simulator.prisonnersdilemma.strategies;

import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;
import simulator.prisonersdilemma.PrisonerStrategy;

public class EchoStrategy implements PrisonerStrategy {

	public static final String NAME = "ECHO";

	private PrisonerActionEnum nextResponse = PrisonerActionEnum.COOPERATE;

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response) {
		nextResponse = ((PrisonerInteractionResponse) response).getAction();
	}

	@Override
	public PrisonerInteractionResponse generateResponse(PrisonerEntity entity) {
		return PrisonerInteractionResponse.from(nextResponse);
	}

}
