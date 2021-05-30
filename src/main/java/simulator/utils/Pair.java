package simulator.utils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Pair<T, U> {

	private final T left;
	private final U right;

}