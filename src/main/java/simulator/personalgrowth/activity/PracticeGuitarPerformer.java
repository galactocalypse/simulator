package simulator.personalgrowth.activity;

import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public class PracticeGuitarPerformer extends ActivityPerformer {

	@Override
	public void perform(Person person, Score score) {

		double benefit = 0.01 * score.extractPercentage();
		double factor = 1 + benefit;

		person.getMindState().getFocus().updateByFactor(factor);
	}

}
