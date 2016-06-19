package eu.bausov.projects.darts;

class Player {
    private String name;
    private Coordinate[] coordinates = new Coordinate[5];
    private int[] scores = new int[5];

    public Player(String name) {
        this.name = name;
    }

    int total(){
        int result = 0;
        for (int i = 0; i < scores.length; i++) {
            result += scores[i];
        }
        return result;
    }

    public String getName() {
        return name;
    }

    Coordinate[] getCoordinates() {
        return coordinates;
    }

    int[] getScores() {
        return scores;
    }
}
