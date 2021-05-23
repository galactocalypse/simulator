package simulator.core;

import simulator.core.Universe.TimeElapse;

public abstract class AbstractEntity {

	public abstract EntityId extractId();

	public abstract void elapseTime(TimeElapse timeElapse);

	public abstract AbstractInteractionResponse interact(AbstractEntity entity);

	public abstract void receiveResponse(AbstractEntity entity, AbstractInteractionResponse receivedResponse);

}
