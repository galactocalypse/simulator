package simulator.prisonersdilemma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import simulator.core.Response;

@Getter
@AllArgsConstructor(staticName = "from")
public class PrisonerInteractionResponse extends Response<PrisonerInteractionResponse> {

	private final PrisonerActionEnum action;

	
	public static enum PrisonerActionEnum {
		
		DEFECT,
		COOPERATE,
		
	};
	
}
