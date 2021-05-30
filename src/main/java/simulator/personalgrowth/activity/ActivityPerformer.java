package simulator.personalgrowth.activity;

import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public abstract class ActivityPerformer {

	public abstract void perform(Person person, Score score);

}
