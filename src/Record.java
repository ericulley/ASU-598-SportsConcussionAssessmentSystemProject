public class Record {
    private int[] symptoms;
    private boolean atRisk;

    public Record(int[] symptoms) {
        this.symptoms = symptoms;
    }

    public int[] getSymptoms() {
        return symptoms;
    }

    public boolean isAtRisk() {
        return atRisk;
    }
}
