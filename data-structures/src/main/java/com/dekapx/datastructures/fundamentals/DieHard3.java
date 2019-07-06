package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class DieHard3
{
    private static int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a == c || b == c)
            {
                System.out.println("YES");
            }
            else if (c > a && c > b)
            {
                System.out.println("NO");
            }
            else if (c % gcd(a, b) == 0)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
}
