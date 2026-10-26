import java.util.ArrayList;

public class Athlete extends User {
    private ArrayList<PostGameRecord> records = new ArrayList<PostGameRecord>();

    public Athlete() {
        super("athlete");
    }

    // Methods
    public void addRecord(PostGameRecord record) {
        records.add(0, record);
        if (records.size() > 5) {
            records.remove(records.size() - 1);
        }
    }

    public PostGameRecord getLatestRecord() {
        if (records.isEmpty()) {
            return null;
        }
        return records.get(0);
    }
}
