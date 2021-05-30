package simulator.personalgrowth.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulator.personalgrowth.DailyActivity;
import simulator.personalgrowth.Person;
import simulator.personalgrowth.Person.Score;
import simulator.personalgrowth.Strategy;

public abstract class MemoizedStrategy extends Strategy {

	private final List<Map<DailyActivity, Score>> memory = new ArrayList<>();

	public MemoizedStrategy(Person person) {
		super(person);
	}

	public void performActivities(long currentIteration) {

		Map<DailyActivity, Score> scores = new HashMap<>();
		for (DailyActivity activity : DailyActivity.values()) {

			Score score = getPerformanceScore(activity, currentIteration);
			activity.performer.perform(person, score);

			scores.put(activity, score);
		}

		memory.add(scores);
	}

	protected abstract Score getPerformanceScore(DailyActivity activity, long currentIteration);

	public boolean hadPerformedLastNDays(DailyActivity activity, long currentIteration, int n) {

		for (int i = 1; i <= n; i++) {

			long iteration = currentIteration - i - 1;
			if (iteration <= 0) {
				return true;
			}

			Map<DailyActivity, Score> scoresForDay = memory.get((int) iteration);

			if (scoresForDay.get(activity).isMinimum()) {
				return false;
			}
		}

		return true;
	}

	public double avgScoreForLastNDays(DailyActivity activity, long currentIteration, int n) {

		double total = 0;

		for (int i = 1; i <= n; i++) {

			long iteration = currentIteration - i;
			if (iteration < 0) {
				return total / (n - 1);
			}

			Map<DailyActivity, Score> scoresForDay = memory.get((int) iteration);

			total += scoresForDay.get(activity).getCurrent();
		}

		return total / n;
	}

}
