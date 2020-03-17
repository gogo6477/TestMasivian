/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author ddomiroj
 */
public class Printer {

    private final int M = 1000;
    private final int RR = 50;
    private final int CC = 4;
    private final int ORDMAX = 30;
    private int P[] = new int[M + 1];
    private int PAGENUMBER;
    private int PAGEOFFSET;
    private int ROWOFFSET;
    private int C;
    private int J;
    private int K;
    private boolean JPRIME;
    private int ORD;
    private int SQUARE;
    private int N = 0;
    private int MULT[] = new int[ORDMAX + 1];

    public Printer() {
        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;
    }


    public void identSpace() {
        while (K < M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J) {
                        MULT[N] += P[N] + P[N];
                    }
                    if (MULT[N] == J) {
                        JPRIME = false;
                    }
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K] = J;
        }        
        printLine();
    }

    private void printLine() {        
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
            Util.printInfo("The First", Integer.toString(M), "Prime Numbers === Page", Integer.toString(PAGENUMBER));
            Util.printInfoln("");
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + RR - 1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++) {
                    if (ROWOFFSET + C * RR <= M) {
                        System.out.printf("%10d", P[ROWOFFSET + C * RR]);
                    }
                }
                Util.printInfoln("");
            }
            Util.printInfoln("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR * CC;
        }
    }
}
