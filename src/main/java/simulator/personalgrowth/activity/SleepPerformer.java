package simulator.personalgrowth.activity;

import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public class SleepPerformer extends ActivityPerformer {

	@Override
	public void perform(Person person, Score score) {

		double percentage = score.extractPercentage();
		double factor = 0;

		if (percentage < 0.5) {
			double harm = 0.01 * percentage;
			factor = 1 - harm;
		} else {
			double benefit = 0.01 * percentage;
			factor = 1 + benefit;
		}

		person.getPhysicalState().getStrength().updateByFactor(factor);
		person.getMindState().getFocus().updateByFactor(factor);
	}

}
