package project4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UIText {
	private Scanner myinput;

	UIText(Scanner s) {
		myinput = s;
	}

	public static void printWorld(java.util.List<Critter> population) {
		String[][] gfxworld = new String[Params.world_width][Params.world_height];
		for (Critter c : population) {
			gfxworld[c.getX_coord()][c.getY_coord()] = c.toString();		
		}
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++) {
			System.out.print("-");
		}
		System.out.print("+\n");
		for (int i = 0; i < Params.world_height; i++) {
			System.out.print("|");
			for (int j = 0; j < Params.world_width; j++) {
				if(gfxworld[i][j] == null){
					System.out.print(" ");
				}
				else{
					System.out.print(gfxworld[i][j]);
				}
			}
			System.out.print("|\n");
		}
		System.out.print("+");
		for (

		int i = 0; i < Params.world_width; i++) {
			System.out.print("-");
		}
		System.out.print("+\n");
	}

	public void nextcmd() {
		System.out.print("critters>");
		String cmd = myinput.nextLine();
		try {
			int cmdCode = cmdparse(cmd);
		} catch (Exception e) {
			System.out.println("error processing: " + cmd);
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
				numCritters = Integer.parseInt(usercommand[1]);
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
				switch (usercommand[1]) {
				case "project4.Craig": {
					Craig.runStats(critterlist);
				}
				default: {
					Critter.runStats(critterlist);
				}
				}
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