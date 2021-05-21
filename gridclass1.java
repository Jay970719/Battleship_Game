
import java.util.Scanner;

public class gridclass1 {
	
     private static final int nbrow=8; 
	 private static final int nbcolumn=8;
	 private boolean f;
	 private int numberofurship;
	 private int numberofmyship;
	 private static String [][] grid= new String[8][8];
	 private static String [][] gridcopy = new String[8][8];
	 //set instance variables and array to make the code.
	 
	 
	 //set a constructor 
	 public gridclass1() {
		 for(int i=0; i<8; i++)
			 for (int j=0; j<8; j++)
				 gridcopy[i][j]= " _ "; 
	 }
	 
	 //code to make user input ships
	 public void userinputShip() {
		  for (int i=1;i<=6;i++)	 
		 do{System.out.print("Enter the coordinates of your ship #"+i + ": ");
	        Scanner jay = new Scanner(System.in);
	        String location = jay.next();                //let the user input ships
	        char column = location.toUpperCase().charAt(0);  
	        int row = Integer.parseInt(location.substring(1));
	        //condition for set ships' location. 65 is a ASCII number of A
	        if((row-1 >= 0 && row-1 < nbrow)&& ((int)column-65 >= 0 && (int)column-65 < nbcolumn) && (grid[row-1][(int)column-65] == null))
	         {grid[row-1][(int)column-65] = " s ";
	             f = true;}
	        else if((row-1 >= 0 && row-1 < nbrow) && ((int)column-65 >= 0 && (int)column-65 < nbcolumn) && grid[row-1][(int)column-65] == " s ")
	            {System.out.println("sorry, cordinates already used. try again.");
	             f= false;}
	        else if((row-1 < 0 || row-1 >= nbrow) || ((int)column-65 < 0 || (int)column-65 >= nbcolumn))
	            {System.out.println("sorry, cordinates outside the grid. try again.");
	             f= false;}
	           }while(!f); }   // make a while loop to make it continued until user inputs the right location.
	 
      //code to make user input grenades
      public void userinputGrenade() {
		  System.out.println();
		  for (int i=1;i<=4;i++)	 
			 do{System.out.print("Enter the coordinates of your grenade #"+i + ": ");
		        Scanner jay = new Scanner(System.in);
		        String location = jay.next();             //let the user input grenades.
		        char column = location.toUpperCase().charAt(0);
		        int row = Integer.parseInt(location.substring(1));
		        if((row-1 >= 0 && row-1 < nbrow)&& ((int)column-65 >= 0 && (int)column-65 < nbcolumn) && (grid[row-1][(int)column-65] == null))
		         {grid[row-1][(int)column-65] = " g ";
		             f = true;}
		        else if((row-1 >= 0 && row-1 < nbrow) && ((int)column-65 >= 0 && (int)column-65 < nbcolumn)  
		        		  &&(grid[row-1][(int)column-65] == " s "||grid[row-1][(int)column-65] == " g "))
		            {System.out.println("sorry, cordinates already used. try again.");
		             f= false;}
		        else if((row-1 < 0 || row-1 >= nbrow) || ((int)column-65 < 0 || (int)column-65 >= nbcolumn))
		            {System.out.println("sorry, cordinates outside the grid. try again.");
		             f= false;}
		           }while(!f); }  // make a while loop to make it continued until user inputs the right location.   
		  
	                                 
	  //code to make computer input ships and grenades randomly
	  public void computerinputShipnGrenade() {
		   System.out.println();
		   System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
		   for (int i=1; i<=6; i++)        //computer deploy ships
		   do{int a = (int)(Math.random()*8);
		    int b = (int)(Math.random()*8);     //pick random numbers.
		    if (grid[a][b] == null) 
		        {grid[a][b] =" S ";
		         f= true;}
		    else f= false;  }while(!f);  // repeats until it finds the right location.
		  
		   for (int i=1; i<=4; i++)   //computer set grenades
			   do{int a = (int)(Math.random()*8);
			    int b = (int)(Math.random()*8);  
			    if (grid[a][b] == null) 
			        {grid[a][b] =" G ";
			         f= true;}
			    else f= false;  }while(!f); // repeats until it finds the right location.
		   System.out.println();
		   System.out.println();
	   }
	  
	  //code for user attacks.
	  public void userattack() {
		   do {System.out.print("position of your rocket: ");
		   Scanner jay2 = new Scanner(System.in);
		   String attack = jay2.next();         //input the location of the rocket. 
		   char column = attack.toUpperCase().charAt(0);
	       int row = Integer.parseInt(attack.substring(1));
	      
	    if((row-1 >= 0 && row-1 < nbrow)&& ((int)column-65 >= 0 && (int)column-65 < nbcolumn) && (grid[row-1][(int)column-65] == null)&&gridcopy[row-1][(int)column-65]==" _ ")
	       {System.out.println("nothing.");
	        gridcopy[row-1][(int)column-65]=" * ";   //if there is nothing in the grid, copy of the grid has the value of ' * '
	        for (int i=0; i<8; i++)
	        	{System.out.print("              ");
		         {for (int j=0; j<8; j++)
	                   System.out.print(gridcopy[i][j]);
	                    System.out.println(); }}  // print the copy of the grid.
	                       f= true;   }    //loop finish here.             
	        
	      
	   else if((row-1 >= 0 && row-1 < nbrow)&& ((int)column-65 >= 0 && (int)column-65 < nbcolumn) 
	    		           && (grid[row-1][(int)column-65] == " G "||grid[row-1][(int)column-65] == " g ")&&gridcopy[row-1][(int)column-65] ==" _ ")
	        {System.out.println("boom! grenade."); 
	        gridcopy[row-1][(int)column-65]= grid[row-1][(int)column-65] ; // if there is G or g, copy of the grid has the same value of the grid. 
	        for (int i=0; i<8; i++)
	        	{System.out.print("              ");
		         {for (int j=0; j<8; j++)
	                   System.out.print(gridcopy[i][j]);
	                    System.out.println(); }}     //print the copy of the grid. 
	                    comattack();                // if you choose the grenade, you lose a turn and an opponent can play twice in a row. 
	                       f= true;   }            //loop finish here.              
	          
	    else if((row-1 >= 0 && row-1 < nbrow)&& ((int)column-65 >= 0 && (int)column-65 < nbcolumn) 
	    		                 && (grid[row-1][(int)column-65] == " S "||grid[row-1][(int)column-65] == " s ")&&gridcopy[row-1][(int)column-65] ==" _ ")
	       {gridcopy[row-1][(int)column-65]=grid[row-1][(int)column-65]; //if there is S or s, copy of the grid has the same value of the grid.
	           count();     //count to know if the game is finished or not.                           
	    	   if (numberofurship==6)     //If there are 6 user's ships in the copy of the grid, then user loses. 
    	       {System.out.println("ship hit.  You lose!");
    	         for (int i=0; i<8; i++)
	               for (int j=0; j<8; j++)
	            	   if(grid[i][j]!=null)
	            		   gridcopy[i][j]=grid[i][j]; //copy of the grid has the same value as the grid except the null ones. 
    	         for (int i=0; i<8; i++)
  	               for (int j=0; j<8; j++)
  	            	   if(gridcopy[i][j]== " * ")
  	            		   gridcopy[i][j]= " _ ";  // we have to change ' * ' into ' _ '  in the final grid. 
    	         for (int i=0; i<8; i++)
    	        	{System.out.print("              ");
		           {for (int j=0; j<8; j++)
	                 System.out.print(gridcopy[i][j]); // now we print the final copy of the grid.
	                  System.out.println(); } }  
    	          System.out.println("\n"+"Game finished. bye!");  //end message
    	               System.exit(0);}                            //end this program.
               
	    	   else if(numberofmyship==6)    //If there are 6 computer's ships in the copy of the grid, then user wins. 
                {System.out.println("ship hit. You win!");
                 for (int i=0; i<8; i++)
                   for (int j=0; j<8; j++)
        	         if(grid[i][j]!=null)
        		       gridcopy[i][j]=grid[i][j];
                 for (int i=0; i<8; i++)
    	               for (int j=0; j<8; j++)
    	            	   if(gridcopy[i][j]== " * ")
    	            		   gridcopy[i][j]= " _ ";
                 for (int i=0; i<8; i++)
                 { System.out.print("              ");
                   {for (int j=0; j<8; j++)
                     System.out.print(gridcopy[i][j]);
                     System.out.println(); }}
                 System.out.println("\n"+"Game finished. bye!");
                     System.exit(0);}
	          
	    	   else {System.out.println("ship hit."); //if there are not 6 ships in the copy of the grid yet, then continue
	             for (int i=0; i<8; i++)
	             { System.out.print("              ");
		           {for (int j=0; j<8; j++)
	                    System.out.print(gridcopy[i][j]);  // print the copy of the grid.
	                     System.out.println(); }}
	                        f= true;   } }  //loop finish
	         
	          
	     else if((row-1 >= 0 && row-1 < nbrow) && ((int)column-65 >= 0 && (int)column-65 < nbcolumn)  
	     		   &&gridcopy[row-1][(int)column-65] !=" _ ")  // if user choose the place which is already chosen.
	          {System.out.println("position already called.");
	           for (int i=0; i<8; i++)
	           { System.out.print("              ");
	 	           {for (int j=0; j<8; j++)
	                     System.out.print(gridcopy[i][j]);   //print the copy of the grid. 
	                      System.out.println(); }}
	                      f=true;}    //loop finish
	       
	    else if((row-1 < 0 || row-1 >= nbrow) || ((int)column-65 < 0 || (int)column-65 >= nbcolumn))
	         {System.out.println("position outside the grid. try again."); //if user choose the location outside of the grid.
	          f= false;} }while(!f);   }  // loop not finish. play until user find the right location. 
	      
	 //code for computer attacks
	 public void comattack() {   
	   do{int c = (int)(Math.random()*8);
		  int d = (int)(Math.random()*8);      //attack randomly, every explanation under is same as user attack.// only user--> computer.
		 
	   if((c >= 0 && c < nbrow)&& (d >= 0 && d < nbcolumn) && (grid[c][d] == null)&& gridcopy[c][d] ==" _ ")
	      {System.out.println("position of my rocket: "+ (char)(d+65)+ (c+1));
		   System.out.println("nothing.");
	      gridcopy[c][d]= " * ";
	      for (int i=0; i<8; i++)
	    	  {System.out.print("              ");
		           {for (int j=0; j<8; j++)
	                 System.out.print(gridcopy[i][j]);
	                  System.out.println(); }}
	                     f= true;   }            
	      
	    else if((c >= 0 && c < nbrow)&& (d >= 0 && d < nbcolumn) 
	    		                      && (grid[c][d] == " G "||grid[c][d] == " g ")&& gridcopy[c][d] ==" _ ")
	      {System.out.println("position of my rocket: "+ (char)(d+65)+ (c+1));
	       System.out.println("boom! grenade.");
	       gridcopy[c][d]=grid[c][d];
	        for (int i=0; i<8; i++)
	        	{System.out.print("              ");
		           {for (int j=0; j<8; j++)
	                 System.out.print(gridcopy[i][j]);
	                  System.out.println(); }}
	                   userattack();
	                    f= true;   }                           
	          
	     else if((c >= 0 && c < nbrow)&& (d >= 0 && d < nbcolumn) 
	    		                     && (grid[c][d] == " S "||grid[c][d] == " s ")&& gridcopy[c][d] ==" _ ")
	      { System.out.println("position of my rocket: "+ (char)(d+65)+ (c+1));
	        gridcopy[c][d]=grid[c][d];
	           count();                      
	    	   if (numberofurship==6)
	    	       {System.out.println("ship hit.  You lose!");
	    	         for (int i=0; i<8; i++)
		               for (int j=0; j<8; j++)
		            	   if(grid[i][j]!=null)
		            		   gridcopy[i][j]=grid[i][j];
	    	         for (int i=0; i<8; i++)
	    	               for (int j=0; j<8; j++)
	    	            	   if(gridcopy[i][j]== " * ")
	    	            		   gridcopy[i][j]= " _ ";
	    	         for (int i=0; i<8; i++)
	    	         { System.out.print("              ");
			           {for (int j=0; j<8; j++)
		                 System.out.print(gridcopy[i][j]);
		                  System.out.println(); }}
	    	         System.out.println("\n"+"Game finished. bye!");
	    	              System.exit(0);} 
	            
	    	     else if(numberofmyship==6)
	                {System.out.println("ship hit. You win!");
	                 for (int i=0; i<8; i++)
                       for (int j=0; j<8; j++)
            	         if(grid[i][j]!=null)
            		       gridcopy[i][j]=grid[i][j];
	                 for (int i=0; i<8; i++)
	    	               for (int j=0; j<8; j++)
	    	            	   if(gridcopy[i][j]== " * ")
	    	            		   gridcopy[i][j]= " _ ";
	                 for (int i=0; i<8; i++)
	                 { System.out.print("              ");
	                   {for (int j=0; j<8; j++)
                         System.out.print(gridcopy[i][j]);
                         System.out.println(); }}
	                 System.out.println("\n"+"Game finished. bye!");
	                     System.exit(0);}
	           
	    	     else {System.out.println("ship hit.");
	              for (int i=0; i<8; i++)
	            	  {System.out.print("              ");
		              {for (int j=0; j<8; j++)
	                     System.out.print(gridcopy[i][j]);
	                     System.out.println(); }}
	                     f= true; }  }  
	          
	      else if((c >= 0 && c < nbrow) && (d >= 0 && d < nbcolumn)  
	     		 && gridcopy[c][d] !=" _ ")
	      { System.out.println("position of my rocket: "+ (char)(d+65)+ (c+1));
	  	    System.out.println("position already called."); 
	        for (int i=0; i<8; i++)
	        	{System.out.print("              ");
		            {for (int j=0; j<8; j++)
	                 System.out.print(gridcopy[i][j]);
	                 System.out.println(); }}
	                 f=true;}
		  
	      else if((c < 0 || c >= nbrow) || (d < 0 || d >= nbcolumn))
	         f= false; }while(!f);  }                            
	     
     
	 //boolean method to make the program continue until user or computer finds 6 ships of an opponent.
 	 public boolean until() {
	       if (numberofurship ==6 || numberofmyship ==6)
			 return true;
           else return false;	  }   
 	 
 	 
 	 //method to count the discovered ships in the copy if the grid. 
     public void count() {
    	 numberofmyship= 0;
    	 numberofurship= 0;        //every turn, it has to count from 0.( not cumulative)
 		 for (int i=0; i<8; i++)
           for (int j=0; j<8; j++)
        	      if(gridcopy[i][j]==" S ")
        	    	  numberofmyship++;             //Every time there is "S", add 1 in the number of the computer ship.
    	 
        	       else if(gridcopy[i][j]== " s ")
          	    	    numberofurship++;           //Every time there is "s", add 1 in the number of the user ship.                  
 	   }  
    
		
	  }

