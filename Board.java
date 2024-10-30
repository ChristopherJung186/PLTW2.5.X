/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board()
  {
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    System.out.println("Phrase: " + phrase);
  }
  /* your code here - accessor(s) */
  public String getSolvedPhrase() {

  }

  public int getLetterValue() {

  }
  /* your code here - mutator(s)  */
  


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess) // could be known as solvePhrase
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  public String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
  /* Checks if a letter exists in the phrase, if so, gets added to the displayed phrase.
   * 
   * Precondition:
   *  phrase has been set via constructor.
   *  guess is a single character.
   * 
   * Postcondition:
   *  The phrase displayed is updated to include the letter if it is there.
   */
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false; // initialize whether a letter is found to false
    String newSolvedPhrase = ""; // establish empty string
    
    for (int i = 0; i < phrase.length(); i++) // loop by index through phrase
    {
      if (phrase.substring(i, i + 1).equals(guess)) // check letter at index i
      {
        newSolvedPhrase += guess + " "; // if it's equal add it to newSolvedPhrase
        foundLetter = true; // letter found so change it
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " "; // if not guessed don't reveal letter
      }
    }
    solvedPhrase = newSolvedPhrase; // with new guess added
    return foundLetter; // tell user if guess exists
  } 
} 
