/* CRITTERS <MyClass.java>
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Blake Muir
 * Bmm2897
 * <Student1 5-digit Unique No.>
 * James Tsao
 * jt28593
 * <Student2 5-digit Unique No.>
 * Slip days used: 1
 * Fall 2015
 */

package project5;

import project5.Critter.CritterShape;

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
			Jimmy1 child = new Jimmy1();
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
	
	@Override
	public CritterShape viewShape() { return CritterShape.STAR; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.AQUA; }
}
