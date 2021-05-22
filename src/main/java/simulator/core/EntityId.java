package simulator.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "from")
public class EntityId {

	private final String entityId;

	
	public String toString() {
		return entityId;
	}

}
