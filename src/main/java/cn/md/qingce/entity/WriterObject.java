package cn.md.qingce.entity;

public class WriterObject extends ReadObject {
    String id;

    String U;
    String V;
    String W;
    String X;
    String Y;
    String Z;
    String AA;
    String AB;
    String AC;
    String AD;

    String AI;

    public String getAJ() {
        return AJ;
    }

    public void setAJ(String AJ) {
        this.AJ = AJ;
    }

    String AJ;

    public void set(int j, String str) {
        if (j == 0) {
            setId(str);
        }
        if (j == 1) {
            setB(str);
        }
        if (j == 2) {
            setC(str);
        }
        if (j == 3) {
            setD(str);
        }
        if (j == 4) {
            setE(str);
        }
        if (j == 5) {
            setF(str);

        }
        if (j == 6) {
            setG(str);

        }
        if (j == 7) {
            setH(str);
        }
        if (j == 8) {
            setI(str);
        }
        if (j == 9) {
            setJ(str);
        }
        if (j == 10) {
            setK(str);
        }
        if (j == 11) {
            setL(str);
        }
        if (j == 12) {
            setM(str);
        }
        if (j == 13) {
            setN(str);
        }
        if (j == 14) {
            setO(str);
        }
        if (j == 15) {
            setP(str);
        }
        if (j == 16) {
            setQ(str);
        }
        if (j == 17) {
            setR(str);
        }
        if (j == 18) {
            setS(str);
        }
        if (j == 19) {
            setT(str);
        }
        if (j == 20) {
            setU(str);
        }
        if (j == 21) {
            setV(str);
        }
        if (j == 22) {
            setW(str);
        }
        if (j == 23) {
            setX(str);
        }
        if (j == 24) {
            setY(str);
        }
        if (j == 25) {
            setZ(str);
        }
        if (j == 26) {
            setAA(str);

        }
        if (j == 27) {
            setAB(str);
        }
        if (j == 28) {
            setAC(str);
        }
        if (j == 29) {
            setAD(str);
        }
        if (j == 30) {
            setAE(str);
        }
        if (j == 31) {
            setAF(str);
        }
        if (j == 32) {
            setAG(str);
        }
        if (j == 33) {
            setAH(str);
        }
        if (j == 34) {
            setAI(str);
        }
        if (j == 35) {
            setAJ(str);
        }

    }

    @Override
    public String get(int j) {
        String str = "";
        if (j == 0) {
            str = getId() + "";
        }
        if (j == 1) {
            str = getB();
        }
        if (j == 2) {
            str = getC();
        }
        if (j == 3) {
            str = getD();
        }
        if (j == 4) {
            str = getE();
        }
        if (j == 5) {
            str = getF();

        }
        if (j == 6) {
            str = getG();

        }
        if (j == 7) {
            str = getH();
        }
        if (j == 8) {
            str = getI();
        }
        if (j == 9) {
            str = getJ();
        }
        if (j == 10) {
            str = getK();
        }
        if (j == 11) {
            str = getL();
        }
        if (j == 12) {
            str = getM();
        }
        if (j == 13) {
            str = getN();
        }
        if (j == 14) {
            str = getO();
        }
        if (j == 15) {
            str = getP();
        }
        if (j == 16) {
            str = getQ();
        }
        if (j == 17) {
            str = getR();
        }
        if (j == 18) {
            str = getS();
        }
        if (j == 19) {
            str = getT();
        }
        if (j == 20) {
            str = getU();
        }
        if (j == 21) {
            str = getV();
        }
        if (j == 22) {
            str = getW();
        }
        if (j == 23) {
            str = getX();
        }
        if (j == 24) {
            str = getY();
        }
        if (j == 25) {
            str = getZ();
        }
        if (j == 26) {
            str = getAA();

        }
        if (j == 27) {
            str = getAB();
        }
        if (j == 28) {
            str = getAC();
        }
        if (j == 29) {
            str = getAD();
        }
        if (j == 30) {
            str = getAE();
        }
        if (j == 31) {
            str = getAF();
        }
        if (j == 32) {
            str = getAG();
        }
        if (j == 33) {
            str = getAH();
        }
        if (j == 34) {
            str = getAI();
        }
        if (j == 35) {
            str = getAJ();
        }

        return str;
    }

    @Override
    public String toString() {
        return "WriterObject{" +
                "id=" + id +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", E='" + E + '\'' +
                ", F='" + F + '\'' +
                ", G='" + G + '\'' +
                ", H='" + H + '\'' +
                ", I='" + I + '\'' +
                ", J='" + J + '\'' +
                ", K='" + K + '\'' +
                ", L='" + L + '\'' +
                ", M='" + M + '\'' +
                ", N='" + N + '\'' +
                ", O='" + O + '\'' +
                ", P='" + P + '\'' +
                ", Q='" + Q + '\'' +
                ", R='" + R + '\'' +
                ", S='" + S + '\'' +
                ", T='" + T + '\'' +
                ", U='" + U + '\'' +
                ", V='" + V + '\'' +
                ", W='" + W + '\'' +
                ", X='" + X + '\'' +
                ", Y='" + Y + '\'' +
                ", Z='" + Z + '\'' +
                ", AA='" + AA + '\'' +
                ", AB='" + AB + '\'' +
                ", AC='" + AC + '\'' +
                ", AD='" + AD + '\'' +
                ", AE='" + AE + '\'' +
                ", AF='" + AF + '\'' +
                ", AG='" + AG + '\'' +
                ", AH='" + AH + '\'' +
                ", AI='" + AI + '\'' +
                ", Aj='" + AJ + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getU() {
        return U;
    }

    public void setU(String u) {
        U = u;
    }

    public String getV() {
        return V;
    }

    public void setV(String v) {
        V = v;
    }

    public String getW() {
        return W;
    }

    public void setW(String w) {
        W = w;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getZ() {
        return Z;
    }

    public void setZ(String z) {
        Z = z;
    }

    public String getAA() {
        return AA;
    }

    public void setAA(String AA) {
        this.AA = AA;
    }

    public String getAB() {
        return AB;
    }

    public void setAB(String AB) {
        this.AB = AB;
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public String getAD() {
        return AD;
    }

    public void setAD(String AD) {
        this.AD = AD;
    }

    public String getAI() {
        return AI;
    }

    public void setAI(String AI) {
        this.AI = AI;
    }


}
