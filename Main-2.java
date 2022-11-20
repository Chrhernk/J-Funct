package com.company;
import java.util.Scanner;

public class Main
{
    static int Health = 50; // starting health
    static int MP = 50; // starting magic points
    static String CallName; // makes the name callable anywhere

    public static void main(String[] args)
    {
        PT("Welcome to the world of Kronos Player!");
        PT("What should we call you?");
        Scanner SC0BJ = new Scanner(System.in); // new scanner obj
        String UsersName = SC0BJ.nextLine(); // scans the next line for data
        CallName = UsersName; // compiles the users name
        PT("Welcome! your name is : " + UsersName );
        PT("Your Health is : " + Health);
        PT("You have " + MP + " Magic Points");

        SC0BJ.nextLine(); // pretty much a System.Pause?

        First_Steps(); // Moves to the next function

    }

    static void First_Steps()
    {
        PT("You find yourself waking up, Slowly coming out of your daze on the floor in a bar.");
        PT("Around you is the remnants of tables, chairs, and shields, Looks like you were in quite the scuffle " + CallName );
        PT("As you gather yourself, You find your spell book and staff were on one of the remaining tables, would you like to open the book?");

        PT("[Yes] or [No]");
        Scanner SC0BJ = new Scanner(System.in); // new scanner
        String PlayerChoice = SC0BJ.nextLine(); // players choice
        if (PlayerChoice.equals("Yes")) // checks what the choice is equal to
        {
            PT("You open your Spell Book to the healing spells, Would you like to use one?");
            PT("[Yes] or [No]");
            String PC = SC0BJ.nextLine();
            if(PC.equals("Yes"))
            {
                PT("As you use the spell, the magic heals all small wounds on your body");
                UseMagic(10); // Use of magic deducts points
                GetHealed(50); // Heals the player
                PT("You have been healed to " + Health + " HP"); // displays health
                PT("You have " + MP + " Magic remaining"); // displays magic
                Leaving_Bar(); // next function
            }
            else if (PC.equals("No"))
            {
                PT("You decide to not use the spell, Hooking the book to your hip by its loop before you move on");
                Leaving_Bar();
            }
        }
        else if (PlayerChoice.equals("No"))
        {
            PT("You decide to not open your spell book, Deciding to hook it to your hip by its leather loop");
            Leaving_Bar();
        }
        else // catches if there are errors in the typing
        {
            PT("Sorry player! You cant seem to do that right now!");
            First_Steps();
        }
    }
    static void Leaving_Bar()  // next function
    {
        PT("As you leave the bar, you see the bright shining light from the two suns in the sky, Sol, and Stella");
        PT("Sols yellow light is warm, while Stella's is a nearly blinding white, ");
        PT("and as your eyes adjust to the light once again, you can see paths ahead of you, one to the left,");
        PT("And the other to the right.");
        PT("Would you like to go [Left] or [Right]?");
        Scanner SC0BJ = new Scanner(System.in); // new scanner
        String DirectionChoice = SC0BJ.nextLine(); // direction choice

        if (DirectionChoice.equals("Left"))
        {
            PT("You decide to go to the left, to the direction of Stella, and as you do, you fade into the light.");
        }
        else if (DirectionChoice.equals("Right"))
        {
            PT("You decide to go to the right, and towards Sol, As you do, you'll come across a small well.");
            PT("Would you like a drink? [Yes] or [No]?");
            String Drink_Choice = SC0BJ.nextLine();

            if (Drink_Choice.equals("Yes"))
            {
                PT("As you take a drink, you feel a surge of magical energy!");
                GainMagic(60);
                PT("You now have " + MP + " Magic Points remaining!");
            }
            else if (Drink_Choice.equals("No"))
            {
                PT("You decide to pass up the well, and fade into the forest, towards Sol");
                PT("As you go into the forest, you step on some brambles");
                GetHurt(40); // takes health
                PT("You have " + Health + " Remaining" );// shows health
            }
        }
    }
    static void GetHurt (int DamageTaken) {Health = Health - DamageTaken;if (Health < 0){ Health = 0; }} // takes health away
    static void GetHealed (int AmountHealed) {Health = Health + AmountHealed; if (Health > 100){Health= 100; }} // adds health
    static void UseMagic (int MagicUsed) {MP = MP - MagicUsed; if (MP < 0){ MP = 0; }} // takes MP away
    static void GainMagic (int MagicGained) {MP = MP + MagicGained; if (MP > 100){MP = 100; }} // Adds MP to total
    static void PT(String TextToDisplay) { System.out.println(TextToDisplay);} // makes talking easier
}
