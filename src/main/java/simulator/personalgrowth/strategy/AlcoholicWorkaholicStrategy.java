package simulator.personalgrowth.strategy;

import simulator.personalgrowth.DailyActivity;
import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;

public class AlcoholicWorkaholicStrategy extends MemoizedStrategy {

	public AlcoholicWorkaholicStrategy(Person person) {
		super(person);
	}

	@Override
	protected Score getPerformanceScore(DailyActivity activity, long currentIteration) {

		switch (activity) {

		case DRINK_WHISKEY: {

			if (hadPerformedLastNDays(activity, currentIteration, 3)) {
				return Score.from(0, 10, 0);
			}

			return Score.from(0, 10, 10);
		}

		case SLEEP: {

			if (hadPerformedLastNDays(DailyActivity.DRINK_WHISKEY, currentIteration, 1)) {
				return Score.from(0, 10, 8);
			}

			return Score.from(0, 10, 2);
		}

		case PRACTICE_GUITAR:
		case READ_BOOK:
		case WRITE_BLOG:
		case EXERCISE:
			return Score.from(0, 10, 0);
		}

		throw new IllegalArgumentException(String.format("Unknown activity: %s", activity));
	}

}
