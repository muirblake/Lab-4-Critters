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

package project4;

public class Sentry extends Critter {
	
	@Override
	public String toString(){
		return "S";
	}

	public boolean fight(String not_used){
		return true;
	}
	@Override
	public void doTimeStep(){
		Sentry s = new Sentry();
		reproduce(s, Critter.getRandomInt(8));
	}
	
	public static void runStats(java.util.List<Critter> sentries){
		System.out.println("Sentry statistics are off limits. Please go away.");
	}
}
