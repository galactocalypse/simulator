package simulator.prisonnersdilemma.strategies;

public class GrudgerStrategy extends TitForNTatsStrategy {

	public static final String NAME = "GRUDGER";

	public GrudgerStrategy() {
		super(1, true);
	}

	@Override
	public String getName() {
		return NAME;
	}

}
