package ru.rrozhkov.easykin;

import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.lib.db.impl.HSQLDBServer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class EasyKin {
    static final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");

    public static void main( String[] args ) {
        Locale.setDefault(new Locale("en"));
        dbServer.start();
        auth();
        start();
    }

    public static void auth() {
        final AuthManager authManager = AuthManager.auth();
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
        AuthManager.instance().signOut();
        dbServer.shutdown();
        System.exit(0);
    }
}