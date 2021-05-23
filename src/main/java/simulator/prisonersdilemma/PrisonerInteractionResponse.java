package simulator.prisonersdilemma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import simulator.core.InteractionResponse;

@Getter
@AllArgsConstructor(staticName = "from")
public class PrisonerInteractionResponse extends InteractionResponse {

	private final PrisonerActionEnum action;

	public static enum PrisonerActionEnum {

		DEFECT, COOPERATE,

	};

}
