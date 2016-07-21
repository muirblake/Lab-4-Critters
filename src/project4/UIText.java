package project4;

import java.awt.List;
import java.util.ArrayList;
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
		for (int i = 0; i < Params.world_width; i++) {
			System.out.print("|");
			for (int j = 0; j < Params.world_height; i++) {
				if (gfxworld[i][j] == null) {
					System.out.println(" ");
				} else {
					System.out.println(gfxworld[i][j]);
				}
			}
			System.out.print("|\n");
		}
		System.out.print("+");
		for (int i = 0; i < Params.world_width; i++) {
			System.out.print("-");
		}
		System.out.print("+\n");
	}

	public void nextcmd() {
		System.out.print("critters>");
		String cmd = myinput.nextLine();
		int cmdCode = cmdparse(cmd);
	}

	private int cmdparse(String cmd) {
		String[] usercommand = null;

		usercommand = cmd.split(" ");
		if (usercommand[0].equals("quit")) {
			System.exit(1);
		}
		if (usercommand[0].equals("show")) {
			Critter.displayWorld();
			return 0;
		}
		if (usercommand[0].equals("step")) {
			if (usercommand.length == 2) {
				int stepnum = Integer.parseInt(usercommand[1]);
				while (stepnum >= 0) {
					Critter.worldTimeStep();
				}
			} else if (usercommand.length == 1) {
				Critter.worldTimeStep();
			}
			return 0;
		}
		if (usercommand[0].equals("seed")) {
			if (usercommand.length == 2) {
				Critter.setSeed(Long.parseLong(usercommand[1]));
			}
			return 0;
		}
		if (usercommand[0].equals("make")) {
			return 0;
		}
		if (usercommand[0].equals("stats")) {
			return 0;
		}
		return -1;

	}
}