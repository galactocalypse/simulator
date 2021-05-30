package simulator.personalgrowth;

import java.util.Date;

import simulator.core.Universe;
import simulator.personalgrowth.strategy.AlcoholicWorkaholicStrategy;

public class PersonalGrowthUniverse extends Universe {

	private final Person person = Person.createDefault();
	private final Strategy strategy = new AlcoholicWorkaholicStrategy(person);

	public PersonalGrowthUniverse(Date currentTime, long maxIterations) {
		super(currentTime, maxIterations, 0);
	}

	@Override
	protected void addEntropy() {
		strategy.performActivities(getCurrentIteration());
	}

	@Override
	protected void endIterationInternal() {
		System.out.println(person.toString());
	}

}
