package fix.acceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quickfix.*;


public class FixAcceptor extends MessageCracker implements Application
{
    Logger logger = LogManager.getLogger();

    @Override
    public void onCreate(SessionID sessionID) {
        logger.info("In onCreate " + sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        logger.info("In onLogon " + sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        logger.info("In onLogout " + sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        logger.info("In toAdmin " + message);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        logger.info("In toAdmin " + message);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        logger.info("In toApp " + message);
    }

    public void fromApp(Message message, SessionID sessionID)
            throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        crack(message, sessionID);
        logger.info("In fromApp " + message);
    }

    @Override
    protected void onMessage(Message message, SessionID sessionID)
            throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        super.onMessage(message, sessionID);
        logger.info("message " + message);
    }
}