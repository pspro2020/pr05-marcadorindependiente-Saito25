import utils.Marcador;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int numberOfThread = 10;
        final Thread[] threads = new Thread[10];
        Marcador marcador = new Marcador();

        for (int i = 0; i < numberOfThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int value;
                    for (int i = 0; i < 10000; i++) {
                        value = random.nextInt(6) + 1;

                        switch (value) {
                            case 1:
                                marcador.incrementOne_Face();
                                break;
                            case 2:
                                marcador.incrementTwo_Face();
                                break;
                            case 3:
                                marcador.incrementThree_Face();
                                break;
                            case 4:
                                marcador.incrementFour_Face();
                                break;
                            case 5:
                                marcador.incrementFive_Face();
                                break;
                            case 6:
                                marcador.incrementSix_Face();
                                break;
                        }
                        marcador.incrementTotalRolls();
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(marcador);
        System.out.println(marcador.getTotalRolls());
    }
}
