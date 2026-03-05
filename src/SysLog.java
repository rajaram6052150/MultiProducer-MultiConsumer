import java.sql.Timestamp;

public class SysLog {
    Timestamp timestamp;
    String facility;
    Severity severity;
    String description;

    public SysLog(Timestamp timestamp, String facility, Severity severity, String description) {
        this.timestamp = timestamp;
        this.facility = facility;
        this.severity = severity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "SysLog [timestamp=" + timestamp + ", facility=" + facility + ", severity=" + severity + ", description=" + description + "]";
    }
}
