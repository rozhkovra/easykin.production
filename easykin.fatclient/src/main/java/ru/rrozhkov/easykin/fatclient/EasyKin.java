package ru.rrozhkov.easykin.fatclient;

import ru.rrozhkov.easykin.fatclient.gui.EasyKinWindow;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.core.db.impl.HSQLDBServer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.TimeZone;

public class EasyKin {
    static final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");
    final static private AuthManager authManager = AuthManager.instance();

    public static void main( String[] args ) {
        Locale.setDefault(new Locale("en"));
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+6:00"));
        dbServer.start();
        auth();
        start();
    }

    public static void auth() {
        authManager.auth();
        if (!authManager.isSignedIn()) {
            close();
        }
    }

    public static void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame window = EasyKinWindow.open();
                window.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        close();
                    }
                });

            }
        });
    }

    public static void close(){
        authManager.signOut();
        dbServer.shutdown();
        System.exit(0);
    }
}