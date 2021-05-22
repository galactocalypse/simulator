package simulator.prisonnersdilemma.strategies;

public class TitForTwoTatsStrategy extends TitForNTatsStrategy {

	public static final String NAME = "TIT_FOR_TWO_TATS";

	public TitForTwoTatsStrategy() {
		super(2);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
