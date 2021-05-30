package simulator.personalgrowth.strategy;

import simulator.personalgrowth.DailyActivity;
import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public class BalancedStrategy extends MemoizedStrategy {

	public BalancedStrategy(Person person) {
		super(person);
	}

	@Override
	protected Score getPerformanceScore(DailyActivity activity, long currentIteration) {
		return Score.from(0, 10, 5);
	}

}
