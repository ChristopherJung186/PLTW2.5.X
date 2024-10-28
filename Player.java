/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name = "";
  private double points;

  /* your code here - constructor(s) */ 
  public Player(String username) {
    name = username;
    points = 0;
    System.out.println("Welcome to the game, " + this.name);
  }

  public Player() {
    System.out.println("Enter player name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    sc.close();
    System.out.println("Welcome to the game, " + this.name);
  }
 
  /* your code here - accessor(s) */ 
  public String getName()
  {
    return name;
  }

  public double getPoints()
  {
    return points;
  }
   
  /* your code here - mutator(s) */ 
  public void setName(String x)
  {
    name = x;
  }
}