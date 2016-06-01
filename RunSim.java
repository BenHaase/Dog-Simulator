//Ben Haase project 3 cs 2261
//low comments because everything is really straightforward....

import java.util.Scanner;
//class to run the classes and simulation
public class RunSim {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int playnum = 0; //holds number of players
		int dognum = 0; //holds number of dogs
		int control = 0; //used to control user input choice in main simulation
		System.out.println("Enter Number of Player: "); 
		playnum = input.nextInt();
		Human[] players = new Human[playnum]; //create human array
		for(int i=0; i<playnum; i++){ //create players and their dogs
			System.out.println("Enter player name: ");
			String pname = input.next();
			if(Math.random()>.5)dognum=2; //random number of dogs
			else dognum=1;
			String[] dog = new String[dognum]; //store dog names
			for(int k=0; k<dognum; k++){
				System.out.println("Enter dog name: ");
				dog[k] = input.next();
			}
			players[i] = new Human(dognum, pname, dog); //create this player and their dogs
		}
		System.out.println();
		while(control!=5){ //main game loop
			for(int i=0; i<playnum; i++){ //iterate through players
				System.out.println(players[i].toString()); //output player
				System.out.println("Choose action: 1:walk, 2:feed, 3:bath, 4:buyfood, or 5:exit.");
				control = input.nextInt(); //user decision
				if(control==1) players[i].walks();
				if(control==2) players[i].feeds();
				if(control==3) players[i].bathes();
				if(control==4) players[i].buysFood();
				if(control==5) i=playnum;
				players[i].passTheTime(); //pass the time
				control=0;
			}
		}
	}
}
