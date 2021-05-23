package simulator.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class EntityId {

	private final String entityId;

	public String toString() {
		return entityId;
	}

}
