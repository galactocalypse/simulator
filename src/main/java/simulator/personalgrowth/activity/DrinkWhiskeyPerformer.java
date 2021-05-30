package simulator.personalgrowth.activity;

import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public class DrinkWhiskeyPerformer extends ActivityPerformer {

	@Override
	public void perform(Person person, Score score) {

		double damage = 0.01 * score.extractPercentage();
		double factor = 1 - damage;

		person.getPhysicalState().getStrength().updateByFactor(factor);
	}

}
