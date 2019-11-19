package fix.acceptor;


import quickfix.*;

public class FixAcceptorApp {

    public static void main(String[] args) throws ConfigError {
        Application acceptor = new FixAcceptor();
        SessionSettings sessionSettings = new SessionSettings("./fix-acceptor.cfg");
        FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
        FileLogFactory fileLogFactory = new FileLogFactory(sessionSettings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        SocketAcceptor socketAcceptor = new SocketAcceptor(acceptor, fileStoreFactory,
                sessionSettings, fileLogFactory, messageFactory);
        socketAcceptor.start();
    }
}
