package supermarket.notifictation;

import java.util.Date;

public class Notification {
    public Date date;
    public Double depID;
    public Double itemID;
    public NotificationType type;

    public Notification(Date date, Double depID, Double itemID, NotificationType type) {
        this.date = date;
        this.depID = depID;
        this.itemID = itemID;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "date=" + date +
                ", depID=" + depID +
                ", itemID=" + itemID +
                ", type=" + type +
                '}';
    }
}
