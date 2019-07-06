package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class MatrixTracing
{
    public static final int MOD_VALUE = 1000000007;
    public static void main(String[] args)
    {
        int max = 2000001;
        long[] fact = new long[max];
        long[] inv = new long[max];

        fact[1] = 1;
        inv[1] = 1;
        for (int i = 2; i < max; i++)
        {
            fact[i] = fact[i - 1] * i % MOD_VALUE;
            long val = 1, x = i;
            for (int j = MOD_VALUE - 2; j > 0; j /= 2)
            {
                if (j % 2 == 1)
                {
                    val = val * x % MOD_VALUE;
                }
                x = x * x % MOD_VALUE;
            }
            inv[i] = inv[i - 1] * val % MOD_VALUE;
        }
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++)
        {
            int m = in.nextInt();  // # of rows
            int n = in.nextInt();  // # of cols
            if (m == 1 || n == 1)
            {
                System.out.println("1");
            }
            else
            {
                long ans = fact[n + m - 2];
                ans = ans * inv[n - 1] % MOD_VALUE * inv[m - 1] % MOD_VALUE;
                System.out.println(ans);
            }
        }
    }
}
