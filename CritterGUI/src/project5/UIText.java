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

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UIText {
	private Scanner myinput;

	UIText(Scanner s) {
		myinput = s;
	}

	public void nextcmd() throws Exception {
		System.out.print("critters>");
		String cmd = myinput.nextLine();
		try {
			int cmdCode = cmdparse(cmd);
		} catch (Exception e) {
			System.out.println("error processing: " + cmd);
			System.out.println(e);
		}

	}

	private int cmdparse(String cmd) throws Exception {
		String[] usercommand = null;
		if (cmd.equals("")) {
			return 0;
		}
		usercommand = cmd.split("\\s+");
		switch (usercommand[0]) {
		case ("quit"): {
			System.exit(1);
		}
		case ("show"): {
			if(usercommand.length != 1){
				throw new IllegalArgumentException();
			}
			Critter.displayWorld();
			return 0;
		}
		case ("step"): {
			if (usercommand.length == 2) {
				int stepnum = Integer.parseInt(usercommand[1]);
				while (stepnum >= 0) {
					Critter.worldTimeStep();
					stepnum--;
				}
			} else if (usercommand.length == 1) {
				Critter.worldTimeStep();
			}
			else{
				throw new IllegalArgumentException();
			}
			return 0;
		}
		case ("seed"): {
			while (true) {
				if (usercommand.length == 2) {
					Critter.setSeed(Long.parseLong(usercommand[1]));
					return 0;
				} else {
					System.out.println("Enter a Long with your seed.");
					throw new IllegalArgumentException();
				}
			}

		}
		case ("make"): {
			int numCritters;
			if (usercommand.length == 2) {
				numCritters = 1;
			} else if (usercommand.length == 3) {
				numCritters = Integer.parseInt(usercommand[2]);
			} else {
				System.out.println("State a critter name!");
				throw new IllegalArgumentException();
			}
			try {
				Class<?> critverify = Class.forName(usercommand[1]);
			} catch (ClassNotFoundException e) {
				throw new InvalidCritterException(usercommand[1]);
			}
			for (int i = 0; i < numCritters; i++) {
				Critter.makeCritter(usercommand[1]);
			}
			return 0;
		}
		case ("stats"): {
			java.util.List<Critter> critterlist;
			if (usercommand.length == 2) {
				critterlist = Critter.getInstances(usercommand[1]);
				Class<?>critclass = Class.forName(usercommand[1]);
				java.lang.reflect.Method rsMethod = critclass.getMethod("runStats", java.util.List.class);
				rsMethod.invoke(null, critterlist);
				return 0;
			} else {
				throw new IllegalArgumentException();
			}
		}
		default: {
			System.out.println("invalid command: " + cmd);
		}
		}

		return -1;

	}
}