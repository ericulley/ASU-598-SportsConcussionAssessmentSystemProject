import java.util.HashMap;

public class SymptomSet {

    // Symptom attributes
    private HashMap<String, Integer> symptomScores;
    private int headache;
    private int preasureInHead;
    private int neckPain;
    private int nauseaOrVomiting;
    private int dizziness;
    private int blurredVision;
    private int balanceProblems;
    private int sensitivityToLight;
    private int sensitivityToNoise;
    private int feelingSlowedDown;
    private int feelingLikeInFog;
    private int dontFeelRight;
    private int difficultyConcentrating; 
    private int difficultyRemembering;
    private int fatigueOrLowEnergy;
    private int confusion;
    private int drowsiness;
    private int troubleFallingAsleep;
    private int moreEmotional;
    private int irritability;
    private int sadness;
    private int nervousOrAnxious;


    public SymptomSet(String[] symptoms) {
        this.symptomScores = new HashMap<>();
    }

    public String[] getSymptoms() {
        return symptomScores.keySet().toArray(new String[0]);
    }
}
