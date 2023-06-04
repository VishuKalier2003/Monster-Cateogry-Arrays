/* You are playing a video game where you are defending your city from a group of n monsters. You are given a 
0-indexed integer array dist of size n, where dist[i] is the initial distance in kilometers of the ith monster from 
the city. The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an 
integer array speed of size n, where speed[i] is the speed of the ith monster in kilometers per minute. You have a 
weapon that, once fully charged, can eliminate a single monster. However, the weapon takes one minute to charge. The 
weapon is fully charged at the very start. You lose when any monster reaches your city. If a monster reaches the 
city at the exact moment the weapon is fully charged, it counts as a loss, and the game ends before you can use 
your weapon. Return the maximum number of monsters that you can eliminate before you lose, or n if you can 
eliminate all the monsters before they reach the city.
* Eg 1 : dist = [1,3,4]                  speed = [1,1,1]                Output = 3
* Eg 2 : dist = [1,1,2,3]                speed = [1,1,1,1]              Output = 1
* Eg 3 : dist = [3,4,2]                  speed = [5,3,2]                Output = 1
*/
import java.util.*;
public class Monster
{
      public int MaximumElimination(int distance[], int speed[])
      {
            float time[] = new float[distance.length];    // Time Array... //* Time Array -> O(N)
            for(int i = 0; i < time.length; i++)       // Finding the time required for reach Monster to arrive...
                  time[i] = distance[i] / speed[i];
            Arrays.sort(time);      //! Sorting -> O(N log N)
            int count = 1, j = 0;
            while(j < distance.length - 1)     //! Comparison -> O(N)
            {
                  if(time[j + 1] - time[j] < 1)     // If two monsters arrive within a minute...
                        break;     // End the loop...
                  count++;     // Increment kill count...
                  j++;
            }
            return count;     // Return the number of monsters killed...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of Monsters arriving : ");
            x = sc.nextInt();
            int mon[] = new int[x];
            for(int i = 0; i < mon.length; i++)
            {
                  System.out.print("Enter distance of "+(i+1)+" th Monster : ");
                  mon[i] = sc.nextInt();
            }
            int spd[] = new int[x];
            for(int i = 0; i < spd.length; i++)
            {
                  System.out.print("Enter speed of "+(i+1)+" th Monster : ");
                  spd[i] = sc.nextInt();
            }
            Monster monster = new Monster();    // Object creation...
            System.out.print("The Maximum Monsters killed : "+monster.MaximumElimination(mon, spd));
            sc.close();
      }
}



//! Time Complexity -> O(N log N)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? We find the speed of each Monster and then sort the array...
 * ? If two monsters arrive within a minute, then the city is dsetroyed...
 */