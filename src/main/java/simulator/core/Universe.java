package simulator.core;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lombok.AccessLevel;
import lombok.Getter;
import simulator.utils.DateUtils;

public abstract class Universe<T extends Entity<T, U>, U extends Response<U>> implements Runnable {

	private static final TimeUnit TIME_UNIT = TimeUnit.DAYS;

	@Getter
	protected Date currentTime;
	protected long maxIterations;
	protected Map<EntityId, T> entities;
	private long sleepMillis;
	
	@Getter(AccessLevel.PROTECTED)
	private long currentIteration = 1;

	protected Universe(Date currentTime, long maxIterations, Map<EntityId, T> entities) {
		this(currentTime, maxIterations, entities, DateUtils.MILLIS_PER_SECOND);
	}

	protected Universe(Date currentTime, long maxIterations, Map<EntityId, T> entities, long sleepMillis) {
		this.currentTime = currentTime;
		this.maxIterations = maxIterations;
		this.entities = entities;
		this.sleepMillis = sleepMillis;
	}

	@Override
	public void run() {

		while (true) {

			try {

				if (currentIteration > maxIterations) {
					System.out.println("Max iterations reached; exiting...");
					break;
				}

				System.out.println(String.format("Starting iteration %s...", currentIteration));
				
				addEntropy();
				endIteration();
				elapseTime();
			
				Thread.sleep(sleepMillis);

			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// simulate interactions between entities
	protected abstract void addEntropy();

	protected abstract void endIteration();

	private void elapseTime() {

		currentIteration ++;
		currentTime = DateUtils.add(currentTime, TIME_UNIT, 1);
		
		entities.forEach((entityId, entity) -> {
			entity.elapseTime(TIME_UNIT, 1);
		});
	}
	
}
