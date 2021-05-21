//-------------------------------------------------------------------------
	//Assignment 4
	//Written by: Youngjae Kim 40169282
	//For COMP 248 section P -Fall 2020
	//This program will let the user play a battle ship game with computer.
	//User and computer will place 6ships and 4grenade each on the 8by 8 grid
	//When one of them choose the point where oppenent's ship is located,
	//they delete the opponent's ship, when they choose the point where opponent's
	//grenade is located, they lose a turn. When someone deletes all of the opponent's
	//ship, he wins. 
	//-------------------------------------------------------------------------
/**
 * This is the program of battleship game
 * @author austi
 *
 */
public class driverclass1 {
	      public static void main(String[] args) {
			System.out.println("---------------------------------------------");
			System.out.println("Welcome to the Battleship game");
			System.out.println("---------------------------------------------");
			System.out.println("Hi, let's play Battleship!");        // greeting message
			System.out.println();
			
		gridclass1 obj1 = new gridclass1();	//call the object
		obj1.userinputShip();     // bring method to make user input ships.
		obj1.userinputGrenade();  // bring method to make user input grenades. 
		obj1.computerinputShipnGrenade();  // bring method to make computer input ships and grenades. 
		
	
		do {obj1.userattack(); //bring method to make user attack.  
			obj1.comattack();  //bring method to make user attack. 
		}while(!obj1.until());  // make a loop to let the game continue until one of them deletes all ships of an opponent. 
		
		
		}

	}


