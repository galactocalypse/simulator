package simulator.core;

import simulator.core.Universe.TimeElapse;

public abstract class Entity {

	public abstract EntityId extractId();

	public abstract void elapseTime(TimeElapse timeElapse);

	public abstract InteractionResponse interact(Entity entity);

	public abstract void receiveResponse(Entity entity, InteractionResponse receivedResponse);

}
