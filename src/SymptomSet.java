import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SymptomSet {

    // Symptom attributes
    private HashMap<String, Integer> symptomScores;
    public static final ArrayList<String> symptomKeys = new ArrayList<String>() {{
        add("headache");
        add("pressureInHead");
        add("neckPain");
        add("nauseaOrVomiting");
        add("dizziness");
        add("blurredVision");
        add("balanceProblems");
        add("sensitivityToLight");
        add("sensitivityToNoise");
        add("feelingSlowedDown");
        add("feelingLikeInFog");
        add("dontFeelRight");
        add("difficultyConcentrating");
        add("difficultyRemembering");
        add("fatigueOrLowEnergy");
        add("confusion");
        add("drowsiness");
        add("troubleFallingAsleep");
        add("moreEmotional");
        add("irritability");
        add("sadness");
        add("nervousOrAnxious");
    }};
    public static final HashMap<String, String> symptomPromptMap = new HashMap<String, String>(Map.ofEntries(
        Map.entry("headache", "Headache"),
        Map.entry("pressureInHead", "Pressure in Head"),
        Map.entry("neckPain", "Neck Pain"),
        Map.entry("nauseaOrVomiting", "Nausea or Vomiting"),
        Map.entry("dizziness", "Dizziness"),
        Map.entry("blurredVision", "Blurred Vision"),
        Map.entry("balanceProblems", "Balance Problems"),
        Map.entry("sensitivityToLight", "Sensitivity to Light"),
        Map.entry("sensitivityToNoise", "Sensitivity to Noise"),
        Map.entry("feelingSlowedDown", "Feeling Slowed Down"),
        Map.entry("feelingLikeInFog", "Feeling Like in a Fog"),
        Map.entry("dontFeelRight", "Don't Feel Right"),
        Map.entry("difficultyConcentrating", "Difficulty Concentrating"),
        Map.entry("difficultyRemembering", "Difficulty Remembering"),
        Map.entry("fatigueOrLowEnergy", "Fatigue or Low Energy"),
        Map.entry("confusion", "Confusion"),
        Map.entry("drowsiness", "Drowsiness"),
        Map.entry("troubleFallingAsleep", "Trouble Falling Asleep"),
        Map.entry("moreEmotional", "More Emotional"),
        Map.entry("irritability", "Irritability"),
        Map.entry("sadness", "Sadness"),
        Map.entry("nervousOrAnxious", "Nervous or Anxious")
    ));

    // Constructor
    public SymptomSet() {
        // Initialize symptom scores with null values
        this.symptomScores = new HashMap<>();
        for (String symptom : SymptomSet.symptomPromptMap.keySet()) {
            symptomScores.put(symptom, null);
        }
    }

    // Methods
    public HashMap<String, Integer> getSymptomScores() {
        return this.symptomScores;
    }

    public void setSymptomScore(String symptom, Integer score) {
        if (symptomScores.containsKey(symptom)) {
            symptomScores.put(symptom, score);
        } else {
            throw new IllegalArgumentException("Invalid symptom: " + symptom);
        }
    }

    public Integer getSymptomScore(String symptom) {
        if (symptomScores.containsKey(symptom)) {
            return symptomScores.get(symptom);
        } else {
            throw new IllegalArgumentException("Invalid symptom: " + symptom);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SymptomSet{ \n");
        for (Map.Entry<String, Integer> entry : symptomScores.entrySet()) {
            sb.append("   " + entry.getKey()).append("=").append(entry.getValue()).append(", \n");
        }
        if (!symptomScores.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove trailing comma and space
        }
        sb.append('\n').append("  }");
        return sb.toString();
    }
}
