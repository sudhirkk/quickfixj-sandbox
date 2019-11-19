package fix.initiator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quickfix.ApplicationAdapter;
import quickfix.DoNotSend;
import quickfix.Message;
import quickfix.SessionID;

public class FixInitiator extends ApplicationAdapter {
    final static Logger logger = LogManager.getLogger();
    @Override
    public void onCreate(SessionID sessionId) {
        logger.info("onCreate sessionId=" + sessionId.toString());
    }

    @Override
    public void onLogon(SessionID sessionId) {
        logger.info("onLogon sessionId=" + sessionId.toString());
    }

    @Override
    public void onLogout(SessionID sessionId) {
        logger.info("onLogout sessionId=" + sessionId.toString());
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
       logger.info("toAdmin ", message, sessionId);
    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {

        logger.info("toApp", message, sessionId);
    }
}
