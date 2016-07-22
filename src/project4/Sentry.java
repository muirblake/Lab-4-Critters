package project4;

public class Sentry extends Critter {

	public boolean fight(String not_used){
		return true;
	}
	
	public void doTimeStep(){
		Sentry s = new Sentry();
		reproduce(s, Critter.getRandomInt(8));
	}
	
	public static void runStats(java.util.List<Critter> sentries){
		System.out.println("Sentry statistics are off limits. Please go away.");
	}
}
