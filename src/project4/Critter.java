package project4;

import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */
public abstract class Critter {

	private static java.util.Random rand = new java.util.Random();

	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}

	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}

	/*
	 * a one-character long string that visually depicts your critter in the
	 * ASCII interface
	 */
	public String toString() {
		return "";
	}

	private boolean fighting;
	private boolean walked;

	private int energy = 0;

	protected int getEnergy() {
		return energy;
	}

	private int x_coord;
	private int y_coord;

	protected final void walk(int direction) {
		if (this.walked == false) {
			int tempX = this.x_coord;
			int tempY = this.y_coord;
			switch (direction) {
			case 0:
				int xPos0 = this.x_coord + 1;
				this.x_coord = xPos0;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 1:
				int xPos1 = this.x_coord + 1;
				int yPos1 = this.y_coord - 1;
				this.x_coord = xPos1;
				this.x_coord = yPos1;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 2:
				int yPos2 = this.y_coord - 1;
				this.y_coord = yPos2;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 3:
				int xPos3 = this.x_coord - 1;
				int yPos3 = this.y_coord - 1;
				this.x_coord = xPos3;
				this.x_coord = yPos3;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 4:
				int xPos4 = this.x_coord - 1;
				this.x_coord = xPos4;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 5:
				int xPos5 = this.x_coord - 1;
				int yPos5 = this.y_coord + 1;
				this.x_coord = xPos5;
				this.y_coord = yPos5;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 6:
				int yPos6 = this.y_coord + 1;
				this.y_coord = yPos6;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 7:
				int xPos7 = this.x_coord + 1;
				int yPos7 = this.y_coord + 1;
				this.x_coord = xPos7;
				this.y_coord = yPos7;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			}
			int e = this.getEnergy();
			this.energy = e - Params.walk_energy_cost;
			this.walked = true;
		} else {
			int e = this.getEnergy();
			this.energy = e - Params.walk_energy_cost;
		}
	}

	protected final void run(int direction) {
		if (this.walked == false) {
			int tempX = this.x_coord;
			int tempY = this.y_coord;
			switch (direction) {
			case 0:
				int xPos0 = this.x_coord + 2;
				this.x_coord = xPos0;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 1:
				int xPos1 = this.x_coord + 2;
				int yPos1 = this.y_coord - 2;
				this.x_coord = xPos1;
				this.y_coord = yPos1;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 2:
				int yPos2 = this.y_coord - 2;
				this.y_coord = yPos2;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 3:
				int xPos3 = this.x_coord - 2;
				int yPos3 = this.y_coord - 2;
				this.x_coord = xPos3;
				this.y_coord = yPos3;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 4:
				int xPos4 = this.x_coord - 2;
				this.x_coord = xPos4;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 5:
				int xPos5 = this.x_coord - 2;
				int yPos5 = this.y_coord + 2;
				this.x_coord = xPos5;
				this.y_coord = yPos5;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 6:
				int yPos6 = this.y_coord + 2;
				this.y_coord = yPos6;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			case 7:
				int xPos7 = this.x_coord + 2;
				int yPos7 = this.y_coord + 2;
				this.x_coord = xPos7;
				this.y_coord = yPos7;
				if (this.fighting && isInSharedSpot(this)) {
					this.x_coord = tempX;
					this.y_coord = tempY;
				}
				break;
			}
			int e = this.getEnergy();
			this.energy = e - Params.run_energy_cost;
			this.walked = true;
		} else {
			int e = this.getEnergy();
			this.energy = e - Params.run_energy_cost;
		}
	}

	private boolean isInSharedSpot(Critter critter) {
		int x = critter.x_coord;
		int y = critter.y_coord;
		for (int index = 0; index < population.size(); index++) {
			int checkX = population.get(index).x_coord;
			int checkY = population.get(index).y_coord;
			if (x == checkX && y == checkY) {
				return true;
			}
		}
		return false;
	}

	protected final void reproduce(Critter offspring, int direction) {
		if (this.getEnergy() / 2 < Params.min_reproduce_energy)
			return;
		offspring.energy = this.energy / 2;
		int postBirthEnergy = this.getEnergy() - offspring.getEnergy();
		this.energy = postBirthEnergy;
		offspring.x_coord = this.x_coord;
		offspring.y_coord = this.y_coord;
		offspring.walk(direction);
		babies.add(offspring);
	}

	public abstract void doTimeStep();

	public abstract boolean fight(String oponent);

	/*
	 * create and initialize a Critter subclass critter_class_name must be the
	 * name of a concrete subclass of Critter, if not an InvalidCritterException
	 * must be thrown
	 */
	public static void makeCritter(String critter_class_name)
			throws InvalidCritterException, InstantiationException, IllegalAccessException {
		Class<?> critclass;
		try {
			critclass = Class.forName(critter_class_name);
		} catch (ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		Critter newCritter = (Critter) critclass.newInstance();
		newCritter.energy = Params.start_energy;
		newCritter.x_coord = getRandomInt(Params.world_width - 1);
		newCritter.y_coord = getRandomInt(Params.world_height - 1);
		population.add(newCritter);

	}

	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		Class<?> critclass;
		try {
			critclass = Class.forName(critter_class_name);
		} catch (ClassNotFoundException e) {
			throw new InvalidCritterException(critter_class_name);
		}
		for (Critter crit : population) {
			if (critclass.isInstance(crit)) {
				result.add(crit);
			}
		}
		return result;
	}

	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string, 1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();
	}

	/*
	 * the TestCritter class allows some critters to "cheat". If you want to
	 * create tests of your Critter model, you can create subclasses of this
	 * class and then use the setter functions contained here.
	 * 
	 * NOTE: you must make sure that the setter functions work with your
	 * implementation of Critter. That means, if you're recording the positions
	 * of your critters using some sort of external grid or some other data
	 * structure in addition to the x_coord and y_coord functions, then you MUST
	 * update these setter functions so that they correctly update your
	 * grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}

		protected void setXCoord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}

		protected void setYCoord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
	}

	private static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();

	public static void worldTimeStep() {
		for (int i = 0; i < population.size(); i++) {
			population.get(i).walked = false;
			population.get(i).doTimeStep();
		}
		for (int i = 0; i < population.size(); i++) {
			population.get(i).fighting = false;
			int firstX = population.get(i).x_coord;
			for (int j = i + 1; j < population.size(); j++) {
				population.get(j).fighting = false;
				int secondX = population.get(j).x_coord;
				if (firstX == secondX) {
					int firstY = population.get(i).y_coord;
					int secondY = population.get(j).y_coord;
					if (firstY == secondY) {
						population.get(i).fighting = true;
						population.get(j).fighting = true;
						boolean firstFight = population.get(i).fight(population.get(j).toString());
						boolean secondFight = population.get(j).fight(population.get(i).toString());
						boolean samePos = (population.get(i).x_coord == population.get(j).x_coord)
								&& (population.get(i).y_coord == population.get(j).y_coord);
						int firstStrength;
						int secondStrength;
						if (samePos) {
							if (population.get(i).getEnergy() > 0 && firstFight) {
								firstStrength = Critter.getRandomInt(population.get(i).getEnergy());
							} else if (population.get(j).getEnergy() <= 0) {
								firstStrength = -1;
							} else {
								firstStrength = 0;
							}
							if (population.get(j).getEnergy() > 0 && secondFight) {
								secondStrength = Critter.getRandomInt(population.get(j).getEnergy());
							} else if (population.get(j).getEnergy() <= 0) {
								secondStrength = -1;
							} else {
								secondStrength = 0;
							}
							if (firstStrength == -1 && secondStrength == -1) {
								population.remove(i);
								population.remove(j - 1);
							}
							if (firstStrength > secondStrength) {
								int newEnergy = population.get(i).getEnergy();
								newEnergy += (population.get(j).getEnergy() / 2);
								population.remove(j);
								population.get(i).energy = newEnergy;
							}
							if (firstStrength < secondStrength) {
								int newEnergy = population.get(j).getEnergy();
								newEnergy += (population.get(i).getEnergy() / 2);
								population.remove(i);
								population.get(j).energy = newEnergy;
							}
							if (firstStrength == secondStrength) {
								int newEnergy = population.get(i).getEnergy();
								newEnergy += (population.get(j).getEnergy() / 2);
								population.remove(j);
								population.get(i).energy = newEnergy;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < babies.size(); i++) {
			population.add(babies.get(i));
		}
		babies.clear();
		for (int i = 0; i < population.size(); i++) {
			int afterRest = population.get(i).getEnergy() - Params.rest_energy_cost;
			population.get(i).energy = afterRest;
			if (population.get(i).getEnergy() <= 0) {
				population.remove(i);
				i--;
			}
		}
		makeAlgae(Params.refresh_algae_count);
	}

	private static void makeAlgae(int make) {
		for (int i = 0; i < make; i++) {
			try {
				makeCritter("project4.Algae");
			} catch (InvalidCritterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void displayWorld() {
		UIText.printWorld(population);
	}
}
