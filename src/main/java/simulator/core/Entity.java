package simulator.core;

import java.util.concurrent.TimeUnit;

public interface Entity<T extends Entity<T, U>, U extends Response<U>> {
	
	EntityId extractId();
	
	void elapseTime(TimeUnit unit, int value);

	U interact(T entity);

	void receiveResponse(T entity, U receivedResponse);

}
