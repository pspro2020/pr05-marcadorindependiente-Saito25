package utils;

import java.util.Random;

public class Marcador {
    private int one_Face = 0;
    private int two_Face = 0;
    private int three_Face = 0;
    private int four_Face = 0;
    private int five_Face = 0;
    private int six_Face = 0;
    private int totalRolls = 0;

    private Object[] objectLockers  = new Object[6];

    public Marcador() {
        for (int i = 0; i < objectLockers.length; i++) {
            objectLockers[i] = new Object();
        }
    }

    private final Random random = new Random();

    public void incrementOne_Face() {
        synchronized (objectLockers[0]) {
            one_Face++;
        }
    }

    public void incrementTwo_Face() {
        synchronized (objectLockers[1]) {
            two_Face++;
        }
    }
    public void incrementThree_Face() {
        synchronized (objectLockers[2]) {
            three_Face++;
        }
    }
    public void incrementFour_Face() {
        synchronized (objectLockers[3]) {
            four_Face++;
        }
    }
    public void incrementFive_Face() {
        synchronized (objectLockers[4]) {
            five_Face++;
        }
    }
    public void incrementSix_Face() {
        synchronized (objectLockers[5]) {
            six_Face++;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Cara 1: %d\n" +
                        "Cara 2: %d\n" +
                        "Cara 3: %d\n" +
                        "Cara 4: %d\n" +
                        "Cara 5: %d\n" +
                        "Cara 6: %d\n",
                one_Face,
                two_Face,
                three_Face,
                four_Face,
                five_Face,
                six_Face);
    }

    public synchronized void incrementTotalRolls() {
        totalRolls++;
    }

    public int getTotalRolls() {
        return totalRolls;
    }
}
