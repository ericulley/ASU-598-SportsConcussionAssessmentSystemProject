public class SymptomSummary {
    private SymptomSet symptomSet;
    private int symptomCount = 0;
    private int severityScore = 0;
    private String overallRating = "Not yet determined";

    // Constructor
    public SymptomSummary(SymptomSet symptomSet) {
        this.symptomSet = symptomSet;
        for (int score : symptomSet.getSymptomScores().values()) {
            if (score > 0) this.symptomCount++;
            this.severityScore += score;
        }
    }

    // Methods
    public SymptomSet getSymptomSet() {
        return this.symptomSet;
    }

    public int getSymptomCount() {
        return this.symptomCount;
    }

    public int getSeverityScore() {
        return this.severityScore;
    }

    public void incrementSymptomCount() {
        this.symptomCount++;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SymptomRecord{ \n");
        sb.append("  symptomSet = ").append(symptomSet.toString());
        sb.append(",\n");
        sb.append("  Total number of symptoms = ").append(symptomCount).append(",\n");
        sb.append("  Symptom severity score = ").append(severityScore).append(",\n");
        if (overallRating.equals("No difference in symptom scores")) {
            sb.append("  Overall rating = ").append(GREEN).append(overallRating).append(RESET).append(",\n");
        } else if (overallRating.equals("Unsure")) {
            sb.append("  Overall rating = ").append(YELLOW).append(overallRating).append(RESET).append(",\n");
        } else if (overallRating.equals("Very different symptom scores")) {
            sb.append("  Overall rating = ").append(RED).append(overallRating).append(RESET).append(",\n");
        } else {
            sb.append("  Overall rating = ").append(overallRating).append(",\n");
        }
        sb.append("\n");
        sb.append('}');
        return sb.toString();
    }
}
