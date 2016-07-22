package project4;

public class Jimmy2 extends Critter {
	private int dir;

	@Override
	public String toString(){
		return "I";
	}
	
	public boolean fight(String opponent) {
		if (getEnergy() < Params.min_reproduce_energy / 2) {
			return true;
		} else {
			int revdir = (dir + Critter.getRandomInt(4)) % 8;
			run(revdir);
			dir = revdir;
			return false;
		}
	}

	@Override
	public void doTimeStep() {
		if (super.getEnergy() > Params.min_reproduce_energy + Params.rest_energy_cost + Params.run_energy_cost) {
			Jimmy2 child = new Jimmy2();
			reproduce(child, (dir + (Critter.getRandomInt(2) % 8)));
		}
		run(dir);
	}

	public static void runStats(java.util.List<Critter> crits) {
		System.out.println("Total Jimmy2 critters: " + crits.size());
		int totalEnergy = 0;
		for (Critter m : crits) {
			totalEnergy += m.getEnergy();
		}
		System.out.println("Total energy of Jimmy2 critters: " + totalEnergy);
	}
}
