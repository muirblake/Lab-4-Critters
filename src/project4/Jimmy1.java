package project4;

public class Jimmy1 extends Critter {
	private int dir;
	
	@Override
	public String toString(){
		return "J";
	}

	public boolean fight(String opponent) {
		if (opponent.equals("J")) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void doTimeStep() {
		if(getEnergy() > Params.min_reproduce_energy + Params.rest_energy_cost + Params.run_energy_cost){
			Jimmy2 child = new Jimmy2();
			reproduce(child, (dir + (Critter.getRandomInt(2) % 8)));
		}
		dir = Critter.getRandomInt(8);
		run(dir);
	}

	public static void runStats(java.util.List<Critter> crits) {
		System.out.println("Total Jimmy1 critters: " + crits.size());
		int totalEnergy = 0;
		for (Critter m : crits) {
			totalEnergy += m.getEnergy();
		}
		System.out.println("Total energy of Jimmy1 critters: "+totalEnergy);
	}
}
