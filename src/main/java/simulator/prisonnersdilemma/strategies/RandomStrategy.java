package simulator.prisonnersdilemma.strategies;

import simulator.prisonersdilemma.PrisonerEntity;
import simulator.prisonersdilemma.PrisonerInteractionResponse;
import simulator.prisonersdilemma.PrisonerStrategy;
import simulator.prisonersdilemma.PrisonerInteractionResponse.PrisonerActionEnum;

public class RandomStrategy implements PrisonerStrategy{

	public static final String NAME = "RANDOM";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response) {
		// do nothing
	}

	@Override
	public PrisonerInteractionResponse generateResponse(PrisonerEntity entity) {

		int random = (int) (Math.random() * 1000);
		
		PrisonerActionEnum action = (random % 2 == 0) ? PrisonerActionEnum.COOPERATE : PrisonerActionEnum.DEFECT;

		return PrisonerInteractionResponse.from(action);
	}

}
