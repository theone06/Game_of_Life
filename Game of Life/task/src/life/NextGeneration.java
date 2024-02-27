package life;

public class NextGeneration {
    public String[][] nextGeneration(Universe state) {
        String[][] current = state.currentStateOfUniverse();
        String[][] nextGen = new String[current.length][current[0].length];
        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[0].length; j++) {
                if (state.willILive(i,j)) {
                    nextGen[i][j] = "O";
                } else {
                    nextGen[i][j] = " ";
                }
            }
        }
        return nextGen;
    }
    public void updateUniverse(Universe state, String[][] nextGen) {
        int rows = state.universe.length;
        int columns = state.universe[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                state.universe[i][j] = nextGen[i][j];
            }
        }
    }
}
