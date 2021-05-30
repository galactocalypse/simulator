package simulator.personalgrowth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

	private final MindState mindState;
	private final PhysicalState physicalState;
	private final FinancialState financialState;

	public static Person createDefault() {
		return new Person(MindState.defaultState(), PhysicalState.defaultState(), FinancialState.defaultState());
	}

	public String toString() {
		return String.format("Person(%s, %s, %s)", mindState.toString(), physicalState.toString(),
				financialState.toString());
	}

	@Getter
	@Setter
	@AllArgsConstructor(staticName = "from")
	public static class MindState {

		private final Score focus;

		public String toString() {
			return String.format("mind=%.2f", focus.getCurrent());
		}

		static MindState defaultState() {
			return MindState.from(Score.defaultScore());
		}

	}

	@Getter
	@Setter
	@AllArgsConstructor(staticName = "from")
	public static class FinancialState {

		private final Score money;

		public String toString() {
			return String.format("financials=%.2f", money.getCurrent());
		}

		static FinancialState defaultState() {
			return FinancialState.from(Score.defaultScore());
		}

	}

	@Getter
	@Setter
	@AllArgsConstructor(staticName = "from")
	public static class PhysicalState {

		private final Score strength;

		public String toString() {
			return String.format("body=%.2f", strength.getCurrent());
		}

		static PhysicalState defaultState() {
			return PhysicalState.from(Score.defaultScore());
		}

	}

	@Getter
	@Setter
	@AllArgsConstructor(staticName = "from")
	public static class Score {

		private final double min;
		private final double max;
		private double current;

		static Score defaultScore() {
			return Score.from(0, 100, 50);
		}

		public boolean isMinimum() {
			return current == min;
		}

		public double extractPercentage() {

			if (max - min == 0) {
				return 0;
			}

			return current / (max - min);
		}

		public void update(double value) {
			current += value;
			current = Math.max(min, current);
			current = Math.min(max, current);
		}

		public void updateByFactor(double value) {
			current *= value;
			current = Math.max(min, current);
			current = Math.min(max, current);
		}

	}

}
