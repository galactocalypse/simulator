package simulator.prisonersdilemma;


public interface PrisonerStrategy {
	

	String getName();

	void seedResponse(PrisonerEntity entity, PrisonerInteractionResponse response);

	PrisonerInteractionResponse generateResponse(PrisonerEntity entity);

}
