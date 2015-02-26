package designpatterns.programmingtoaninterface;

public class SystemStatus implements Logable {

    private long createdTimestamp;

    public SystemStatus() {
        createdTimestamp = System.currentTimeMillis();
    }

    private int getStatus() {
        if (System.currentTimeMillis() - createdTimestamp > 1000) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getInitInfo() {
        return "SystemStatus object created " + createdTimestamp;
    }

    public String getLogableEvent() {
        return String.valueOf("Status: " + getStatus());
    }
}
