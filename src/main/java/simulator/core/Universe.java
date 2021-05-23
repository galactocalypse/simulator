package simulator.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import simulator.utils.DateUtils;
import simulator.utils.ThreadUtils;

public abstract class Universe implements Runnable {

	private static final TimeUnit TIME_UNIT = TimeUnit.DAYS;

	@Getter
	protected Date currentTime;
	protected long maxIterations;
	private long sleepMillis;

	protected final Map<EntityId, Entity> entities = new HashMap<>();
	private final List<Consumer<TimeElapse>> timeElapseListeners = new ArrayList<>();

	@Getter(AccessLevel.PROTECTED)
	private long currentIteration = 1;

	protected Universe(Date currentTime, long maxIterations) {
		this(currentTime, maxIterations, DateUtils.MILLIS_PER_SECOND);
	}

	protected Universe(Date currentTime, long maxIterations, long sleepMillis) {
		this.currentTime = currentTime;
		this.maxIterations = maxIterations;
		this.sleepMillis = sleepMillis;
	}

	public <T extends Entity> void addEntity(T entity) {
		entities.put(entity.extractId(), entity);
		registerTimeElapseListener(entity::elapseTime);
	}

	public void registerTimeElapseListener(Consumer<TimeElapse> listener) {
		timeElapseListeners.add(listener);
	}

	@Override
	public void run() {

		while (true) {

			if (currentIteration > maxIterations) {
				System.out.println("Max iterations reached; exiting...");
				break;
			}

			addEntropy();
			endIteration();
		}
	}

	// simulate interactions between entities
	protected abstract void addEntropy();

	private void endIteration() {
		endIterationInternal();
		elapseTime();
	}

	protected abstract void endIterationInternal();

	private void elapseTime() {

		currentIteration++;
		currentTime = DateUtils.add(currentTime, TIME_UNIT, 1);

		timeElapseListeners.forEach((listener) -> listener.accept(TimeElapse.from(TIME_UNIT, 1)));

		ThreadUtils.sleepMillis(sleepMillis);
	}

	@Getter
	@AllArgsConstructor(staticName = "from")
	public static class TimeElapse {

		private TimeUnit timeUnit;
		private long value;

	}

}
