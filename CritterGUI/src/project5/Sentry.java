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

public class Sentry extends Critter {

	@Override
	public String toString() {
		return "S";
	}

	public boolean fight(String not_used) {
		return true;
	}

	@Override
	public void doTimeStep() {
		Sentry s = new Sentry();
		if (getEnergy() > Params.min_reproduce_energy + Params.rest_energy_cost + Params.run_energy_cost) {
			reproduce(s, Critter.getRandomInt(8));
		}
	}

	public static void runStats(java.util.List<Critter> crits) {
		System.out.println("Total Sentry critters: " + crits.size());
		int totalEnergy = 0;
		for (Critter m : crits) {
			totalEnergy += m.getEnergy();
		}
		System.out.println("Total energy of Sentry critters: " + totalEnergy);
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.TRIANGLE;
	}

	@Override
	public javafx.scene.paint.Color viewOutlineColor() {
		return javafx.scene.paint.Color.BLUEVIOLET;
	}
}
