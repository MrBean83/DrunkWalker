/**
 * Created by Henroid83 on 3/9/15.
 */

import java.lang.Math;
import java.util.Scanner;

public class DrunkWalker
{
    // data items
    private static char ch[][] = new char[10][10];
    private static int randNSEW;
    private static int stopCode = 0;
    private static int row = 0;
    private static int col = 0;
    private static char alpha = 'A';

    public static void main(String args[])
    {
        loadArray();
        initializeRow();
        initializeColumn();

        ch[row][col] = alpha;
        alpha++;

        while(stopCode != 1)
        {
            getRand();
            walk(randNSEW, 0);

            if(alpha > 'Z')
            {
                stopCode = 1;
                System.out.println("\nmade it home");
                printArray();
            }

        } // end while loop
    } // end main

    private static void walk(int direction, int attempts) {
        if(attempts > 3) {
            stopCode = 1;
            System.out.println("\narrested -- in jail");
            printArray();
        } else {
            switch (direction) {
                case 0:
                    if (row > 0 && ch[row - 1][col] == '.') {
                        row--;
                        ch[row][col] = alpha;
                        alpha++;
                    } else
                        walk(direction + 1, attempts + 1);
                    break;
                case 1:
                    if(col < 9 && ch[row][col + 1] == '.') {
                        col++;
                        ch[row][col] = alpha;
                        alpha++;
                    } else
                        walk(direction + 1, attempts + 1);
                    break;
                case 2:
                    if(row < 9 && ch[row + 1][col] == '.') {
                        row++;
                        ch[row][col] = alpha;
                        alpha++;
                    } else
                        walk(direction + 1, attempts + 1);
                    break;
                case 3:
                    if(col > 0 && ch[row][col - 1] == '.') {
                        col--;
                        ch[row][col] = alpha;
                        alpha++;
                    } else
                        walk(0, attempts + 1);
                    break;
                default:
                    break;
            } // end switch
        }
    }

    public static void loadArray()
    {
        int row;
        int col;

        for(row = 0; row < 10; row++)
        {
            for(col = 0; col < 10; col++)
            {
                ch[row][col] = '.';
            }
        }
    } // end loadArray

    public static void printArray()
    {
        int row;
        int col;

        for(row = 0; row < 10; row++)
        {
            System.out.println();
            for(col = 0; col < 10; col++)
            {
                System.out.print(ch[row][col]);
            }
        }
        System.out.println();
    } // end printArray

    public static void getRand()
    {
        int x100 = 0;
        double randomNum = 0.0;
        randomNum = Math.random();
        x100 = (int) (randomNum * 100);
        randNSEW = x100 % 4;
    }

    public static int initializeRow()
    {
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Please enter the row where you'd like to start: ");
        row = scanIn.nextInt();

        while(row < 0 || row > 9)
        {
            System.out.println("Sorry, that is not a valid row number.");
            System.out.println("Please enter a row between 0-9: ");
            row = scanIn.nextInt();
        }

        return row;
    }

    public static int initializeColumn()
    {
        Scanner scanIn = new Scanner(System.in);

        System.out.println("Please enter the column where you'd like to start: ");
        col = scanIn.nextInt();

        while(col < 0 || col > 9)
        {
            System.out.println("Sorry, that is not a valid column number.");
            System.out.println("Please enter a column between 0-9: ");
            col = scanIn.nextInt();
        }

        return col;
    }
}
