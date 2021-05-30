package simulator.personalgrowth;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Strategy {

	protected final Person person;

	public abstract void performActivities(long currentIteration);

}
