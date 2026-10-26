import java.util.ArrayList;

public class PostGameRecord {
    private SymptomSet symptomSet;
    private boolean atRisk;

    // Constructor
    public PostGameRecord() {
        this.symptomSet = new SymptomSet();
    }

    // Methods
    public SymptomSet getSymptomSet() {
        return this.symptomSet;
    }

    public ArrayList<String> getSymptomKeys() {
        return this.symptomSet.getSymptomKeys();
    }

    public boolean isAtRisk() {
        return atRisk;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostGameRecord{");
        sb.append("symptomSet=").append(symptomSet.toString());
        sb.append(", atRisk=").append(atRisk);
        sb.append('}');
        return sb.toString();
    }
}
