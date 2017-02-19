package com.anilkaynar.mybasketballstats;

/**
 * Created by anilkaynar on 19.02.2017.
 */

public class Stat {
    double Fg;
    double yFg;
    int p3;
    double yp3;

    public double getFg() {
        return Fg;
    }

    public double getyFg() {
        return yFg;
    }

    public int getP3() {
        return p3;
    }

    public double getYp3() {
        return yp3;
    }

    public double getEfg() {
        return Efg;
    }

    double Efg;

    public Stat(double fg, double yFg, int p3, double yp3, double Efg) {
        Fg = fg;
        this.yFg = yFg;
        this.p3 = p3;
        this.yp3 = yp3;
        this.Efg = Efg;
    }
    public double calculateEFg(int Fg,int p3,double Fga) {
        return (Fg+0.5*p3)/Fga;
    }
}
