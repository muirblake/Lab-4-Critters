/* CRITTERS <MyClass.java>
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Blake Muir
 * Bmm2897
 * <Student1 5-digit Unique No.>
 * James Tsao
 * jt28593
 * <Student2 5-digit Unique No.>
 * Slip days used: 0
 * Fall 2015
 */

package project5;

import project5.Critter.CritterShape;

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
		if (getEnergy() > Params.rest_energy_cost + Params.look_energy_cost) {
			if(look2(dir).equals("J")){
				walk(dir);
			}
		}
		walk(dir);
	}

	public static void runStats(java.util.List<Critter> crits) {
		System.out.println("Total Jimmy2 critters: " + crits.size());
		int totalEnergy = 0;
		for (Critter m : crits) {
			totalEnergy += m.getEnergy();
		}
		System.out.println("Total energy of Jimmy2 critters: " + totalEnergy);
	}
	
	@Override
	public CritterShape viewShape() { return CritterShape.STAR; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.CRIMSON; }
}
