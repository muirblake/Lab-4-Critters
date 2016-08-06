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

public class Mule extends Critter {
	private int dir;
	
	@Override
	public String toString(){
		return "M";
	}
	
	public boolean fight (String not_used){
		dir = Critter.getRandomInt(8);
		if (getEnergy() > Params.rest_energy_cost + Params.look_energy_cost) {
			if(!look2(dir).equals("M")){
				dir = (dir + 4) % 8;
			}
		}
		walk(dir);
		return false;
	}
	@Override
	public void doTimeStep(){
		dir = Critter.getRandomInt(8);

		run(dir);
	}
	
	public static void runStats(java.util.List<Critter> crits){
		System.out.println("Total Mule critters: " + crits.size());
		int totalEnergy = 0;
		for (Critter m : crits) {
			totalEnergy += m.getEnergy();
		}
		System.out.println("Total energy of Mule critters: "+totalEnergy);
	}
	
	@Override
	public CritterShape viewShape() { return CritterShape.TRIANGLE; }

	@Override
	public javafx.scene.paint.Color viewOutlineColor() { return javafx.scene.paint.Color.MEDIUMSEAGREEN; }
}
