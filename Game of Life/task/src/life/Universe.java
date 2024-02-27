package life;

import java.util.ArrayList;
import java.util.Random;

public class Universe {
    String[][] universe;
    public void generateUniverse(int size, int seed) {
        Random random = new Random();
        this.universe = new String[size][size];
        random.setSeed(seed);
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe[0].length; j++) {
                if (random.nextBoolean()) {
                    universe[i][j] = "O";
                }else {
                    universe[i][j] = " ";
                }
            }
        }
    }
    public void displayUniverse() {
        for (int i = 0; i < this.universe.length; i++) {
            for (int j = 0; j < this.universe[0].length; j++) {
                System.out.print(this.universe[i][j]);
            }
            System.out.println();
        }
    }
    public String[][] currentStateOfUniverse() { return this.universe; }
    public String northNeighbor(int row, int column) {
        if (row == 0) {
            return this.universe[this.universe.length-1][column];
        }
        return this.universe[row-1][column];
    }
    public String southNeighbor(int row, int column) {
        if (row == this.universe.length-1) {
            return this.universe[0][column];
        }
        return this.universe[row+1][column];
    }
    public ArrayList<String> allEastNeighbors(int row, int column) {
        ArrayList<String> eastList = new ArrayList<>();
        if (column == this.universe[0].length-1) {
            eastList.add(this.universe[row][0]);
            eastList.add(northNeighbor(row, 0));
            eastList.add(southNeighbor(row, 0));
        }else {
            eastList.add(this.universe[row][column+1]);
            eastList.add(northNeighbor(row, column+1));
            eastList.add(southNeighbor(row, column+1));
        }
        return eastList;
    }
    public ArrayList<String> allWestNeighbors(int row, int column) {
        ArrayList<String> westList = new ArrayList<>();
        if (column == 0) {
            westList.add(this.universe[row][this.universe[0].length-1]);
            westList.add(northNeighbor(row, this.universe[0].length-1));
            westList.add(southNeighbor(row, this.universe[0].length-1));
        }else {
            westList.add(this.universe[row][column-1]);
            westList.add(northNeighbor(row,column-1));
            westList.add(southNeighbor(row,column-1));
        }
        return westList;
    }
    public ArrayList<String> allNeighbors(int row, int column) {
        ArrayList<String> listNeighbors = new ArrayList<>();
        listNeighbors.add(northNeighbor(row, column));
        listNeighbors.add(southNeighbor(row, column));
        listNeighbors.addAll(allEastNeighbors(row, column));
        listNeighbors.addAll(allWestNeighbors(row, column));
        return listNeighbors;
    }
    public boolean willILive(int row, int column) {
        int aliveNeighbors = 0;
        boolean iWillSurvive = false;
        ArrayList<String> neighbors = new ArrayList<>(allNeighbors(row, column));
        //count the living neighbors
        for (String s : neighbors) {
            if (s.equals("O")) {
                aliveNeighbors++;
            }
        }
        if (isAlive(row, column) && aliveNeighbors >= 2 && aliveNeighbors <= 3)
            iWillSurvive = true;
        if (!isAlive(row, column) && aliveNeighbors == 3)
            iWillSurvive =  true;

        return iWillSurvive;
    }
    public boolean isAlive(int row, int column) {
        return this.universe[row][column].equals("O");
    }
    public int numberAlive() {
        int total = 0;
        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe[0].length; j++) {
                if (isAlive(i, j))
                    total++;
            }
        }
        return total;
    }
}
