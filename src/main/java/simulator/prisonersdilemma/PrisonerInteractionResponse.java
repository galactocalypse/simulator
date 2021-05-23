package simulator.prisonersdilemma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import simulator.core.AbstractInteractionResponse;

@Getter
@AllArgsConstructor(staticName = "from")
public class PrisonerInteractionResponse extends AbstractInteractionResponse {

	private final PrisonerActionEnum action;

	public static enum PrisonerActionEnum {

		DEFECT, COOPERATE,

	};

}
