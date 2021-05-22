package simulator.prisonnersdilemma.strategies;

public class TitForThreeTatsStrategy extends TitForNTatsStrategy {

	public static final String NAME = "TIT_FOR_THREE_TATS";

	public TitForThreeTatsStrategy() {
		super(3);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
