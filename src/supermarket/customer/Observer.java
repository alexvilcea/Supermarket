package supermarket.customer;

import supermarket.notifictation.Notification;

public interface Observer {
    public void update(Notification notification);
}
