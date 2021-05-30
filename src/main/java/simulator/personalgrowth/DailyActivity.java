package simulator.personalgrowth;

import simulator.personalgrowth.activity.ActivityPerformer;
import simulator.personalgrowth.activity.DrinkWhiskeyPerformer;
import simulator.personalgrowth.activity.ExercisePerformer;
import simulator.personalgrowth.activity.PracticeGuitarPerformer;
import simulator.personalgrowth.activity.ReadBookPerformer;
import simulator.personalgrowth.activity.SleepPerformer;
import simulator.personalgrowth.activity.WriteBlogPerformer;

public enum DailyActivity {

	EXERCISE(new ExercisePerformer()),

	SLEEP(new SleepPerformer()),

	DRINK_WHISKEY(new DrinkWhiskeyPerformer()),

	READ_BOOK(new ReadBookPerformer()),

	WRITE_BLOG(new WriteBlogPerformer()),

	PRACTICE_GUITAR(new PracticeGuitarPerformer()),

	;

	public final ActivityPerformer performer;

	private DailyActivity(ActivityPerformer impact) {
		this.performer = impact;
	}

}
