package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.HSQLDBServer;
import ru.rrozhkov.easykin.gui.auth.AuthDialog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class EasyKin 
{
    static final HSQLDBServer dbServer = new HSQLDBServer("easykin", "file:data/easykin");
    static JFrame easyKinWindow;

    public static void main( String[] args ) {
        Locale.setDefault(new Locale("en"));
        dbServer.start();
        final AuthManager authManager = AuthManager.auth();
        if (!authManager.isSignedIn()) {
            close();
        }
        start();
    }

    public static void start() {
        if(easyKinWindow!=null)
            easyKinWindow.dispose();
        final EasyKinContext context = new EasyKinContext();
        context.init();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                easyKinWindow = new EasyKinWindow(context);
                easyKinWindow.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        close();
                    }
                });
            }
        });
    }

    public static void restart(){
        if(AuthManager.authDialog(easyKinWindow)==IGUIEditor.CODE_OK)
            start();
    }

    public static void close(){
        AuthManager.instance().signOut();
        dbServer.shutdown();
        System.exit(0);
    }
}