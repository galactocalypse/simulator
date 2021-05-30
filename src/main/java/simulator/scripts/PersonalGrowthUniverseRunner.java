package simulator.scripts;

import java.util.Date;

import simulator.core.Universe;
import simulator.personalgrowth.PersonalGrowthUniverse;

public class PersonalGrowthUniverseRunner {

	public static void main(String[] args) {

		Universe universe = new PersonalGrowthUniverse(new Date(), 30);
		universe.run();
	}

}
