package designpatterns.programmingtoaninterface;

public class Tester {

    public static void main(String[] args) throws Exception {
        new Tester();
    }

    public Tester() throws Exception {
        Logger logger = new Logger();
        SystemStatus systemStatus = new SystemStatus();
        NetworkConnection networkConnection = new NetworkConnection();
        logger.appendToLog(systemStatus);
        logger.appendToLog(networkConnection);
        networkConnection.connect();
        Thread.sleep(2000);
        logger.appendToLog(systemStatus);
        logger.appendToLog(networkConnection);
        logger.close();
    }
}
