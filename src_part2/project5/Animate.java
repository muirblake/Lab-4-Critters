package project5;

public class Animate implements Runnable{
	private double timestep;
	
	Animate(double d){
		timestep = d;
	}
	
	public void run(){
		double sleeptime = 1000;
		if(timestep>=50){
			sleeptime = 1000/((timestep-49)/5);
		}
		else{
			sleeptime=1000*((50-timestep)/5);
		}
		while(true){
			if(Thread.currentThread().isInterrupted()){
				break;
			}
			Critter.worldTimeStep();
			Critter.displayWorld();
			try {
				Thread.sleep(java.lang.Math.round(sleeptime));
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}