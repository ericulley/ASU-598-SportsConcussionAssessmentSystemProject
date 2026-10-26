import java.util.ArrayList;

public class Athlete extends User {
    private ArrayList<SymptomSummary> summaries = new ArrayList<SymptomSummary>();
    private boolean atRisk = false;

    public Athlete() {
        super("athlete");
    }

    // Methods
    public ArrayList<SymptomSummary> getSummaries() {
        return summaries;
    }

    public void addSummary(SymptomSummary summary) {
        summaries.add(0, summary);
        // Only keep the last 5 records
        if (summaries.size() > 5) {
            summaries.remove(summaries.size() - 1);
        }
        // Compare this new record with the previous one to determine if the athlete is at risk
        if (summaries.size() > 1) {
            SymptomSummary previousRecord = summaries.get(1);
            Integer severityScoreDifference = summary.getSeverityScore() - previousRecord.getSeverityScore();
            Integer symptomCountDifference = summary.getSymptomCount() - previousRecord.getSymptomCount();
            if (symptomCountDifference < 3 && severityScoreDifference < 10) {
                summary.setOverallRating("No difference in symptom scores");
            } else if (symptomCountDifference < 3 && severityScoreDifference >= 10 && severityScoreDifference < 15) {
                summary.setOverallRating("Unsure");
            } else if (symptomCountDifference >= 3 && severityScoreDifference >= 15) {
                summary.setOverallRating("Very different symptom scores");
            } 
        }
    }

    public int getRecordCount() {
        return summaries.size();
    }

    public SymptomSummary getLatestRecord() {
        if (summaries.isEmpty()) {
            return null;
        }
        return summaries.get(0);
    }

    public void displayLatestSymptomSummary() {
        // Implementation for displaying the latest symptom scores
        SymptomSummary latestRecord = this.getLatestRecord();
        if (latestRecord != null) {
            System.out.println("Athlete's current symptom scores: " + latestRecord.toString());
        } else {
            System.out.println("No symptom records available.");
        }
    }


    public void displayAllSymptomSummaries() {
        // Implementation for displaying the latest symptom scores
        ArrayList<SymptomSummary> allRecords = this.getSummaries();
        if (allRecords != null) {
            System.out.println("---------- Athlete's Symptom Records ----------");
            System.out.println("Athlete's symptom records (latest first):");
            for (SymptomSummary record : allRecords) {
                System.out.println(record.toString());
                
            }
        } else {
            System.out.println("No symptom records available.");
        }
    }

    public void displayMostRecentOverallRating() {
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        SymptomSummary latestRecord = this.getLatestRecord();
        if (latestRecord != null) {
            String overallRating = latestRecord.getOverallRating();
            if (overallRating.equals("No difference in symptom scores")) {
                System.out.println(GREEN + "No. The athlete has " + overallRating.toLowerCase() + "." + RESET);
            } else if (overallRating.equals("Unsure")) {
                System.out.println(YELLOW + "Unsure. The athlete's overall rating is " + overallRating.toLowerCase() + "." + RESET);
            } else if (overallRating.equals("Very different symptom scores")) {
                System.out.println(RED + "Yes. The athlete has " + overallRating.toLowerCase() + "." + RESET);
            } else {
                System.out.println("Not enough symptom records available to determine.");
            }
        } else {
            System.out.println("Not enough symptom records available to determine.");
        }
        if (this.isAtRisk()) {
            System.out.println(RED + "The athlete has been flagged as at risk for concussion." + RESET);
        }
    }

    public boolean isAtRisk() {
        return atRisk;
    }

    public void setAtRisk(boolean atRisk) {
        this.atRisk = atRisk;
    }
}
