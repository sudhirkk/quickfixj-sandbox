package fix.initiator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quickfix.*;
import quickfix.fix44.Logon;

import java.util.Scanner;

public class FixInitiatorApp {
    static SocketInitiator socketInitiator = null;
    final static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws ConfigError {
        SessionSettings sessionSettings = new SessionSettings("./fix-initiator.cfg");

        Application fixInitiator = new FixInitiator();

        FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
        FileLogFactory fileLogFactory = new FileLogFactory(sessionSettings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        socketInitiator = new SocketInitiator(fixInitiator, fileStoreFactory,
                sessionSettings, fileLogFactory, messageFactory);
        socketInitiator.start();

        SessionID sessionId = (SessionID) socketInitiator.getSessions().get(0);
        Session.lookupSession(sessionId).logon();

        Logon logon = new Logon();
        logon.set(new quickfix.field.HeartBtInt(30));
        logon.setBoolean(141, false);

        logger.info("Logon: ", logon.toString());
        try {
            Session.sendToTarget(logon, sessionId);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }
}
