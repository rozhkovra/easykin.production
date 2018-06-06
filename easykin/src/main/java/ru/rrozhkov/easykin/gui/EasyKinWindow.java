package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.db.impl.DumpManager;
import ru.rrozhkov.easykin.gui.image.ImageManager;
import ru.rrozhkov.easykin.gui.util.TabbedPaneAnalyzer;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class EasyKinWindow extends JFrame implements IGUIEditor {
    final private static EasyKinContext context = new EasyKinContext();
    final private IGUIFactory guiFactory = ru.rrozhkov.lib.gui.GUIFactory.create();
    final private GUIFactory easyKinGuiFactory = new GUIFactory();
    final private AuthManager authManager = AuthManager.instance();
    final private ImageManager imageManager = new ImageManager();
    final private TabbedPaneAnalyzer tabAnalyzer = new TabbedPaneAnalyzer();
    final private static DumpManager dumpManager = new DumpManager();

	private JTabbedPane tabbedPane;
    private static EasyKinWindow window;

    public static JFrame open() {
        if(window==null) {
            window = new EasyKinWindow();
            window.fill();
        }
        return window;
    }

	public EasyKinWindow() throws HeadlessException {
		super(context.title());
        setIconImage(imageManager.logo(this.getClass()));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(guiFactory.size(800, 600));
	}

    private void fill() {
        createMenuBar();
        getContentPane().setLayout(guiFactory.boxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(getMenuButtons());
        getContentPane().add(getTabbedPanel(), BorderLayout.SOUTH);
        setVisible(true);
    }

 	public void edit(Object obj){
        closeEditor(IGUIEditor.CODE_CANCEL);

        Component editor = easyKinGuiFactory.createEditor(context.getCurrentModule(), this, obj);
        showForm(editor);
	}

    public void filter(){
        closeEditor(IGUIEditor.CODE_OK);

        Component formPanel = easyKinGuiFactory.createFilter(context.getCurrentModule(), this);
        showForm(formPanel);
    }

    protected void showForm(Component form) {
        Container content = guiFactory.panelBordered();
        content.add(form,BorderLayout.NORTH);
        Container main = (Container)getContentPane().getComponent(1);
        main.setLayout(guiFactory.gridLayout(1, 2));
        main.add(main.getComponent(0));
        main.add(content);
        main.validate();
    }

    public void add() {
        edit(null);
    }

    public void closeEditor(int code) {
        Container main = (Container)getContentPane().getComponent(1);
        if(main.getComponentCount()>1){
            Component form = main.getComponent(1);
            main.remove(form);
        }
        main.validate();
        getContentPane().validate();
    }

    public void refresh() {
        super.repaint();
        getTabbedPane(true);
    }

     private Component getTabbedPane(boolean reload){
        if(tabbedPane==null){
            tabbedPane = guiFactory.tabbedPane();
            tabbedPane.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    context.setCurrentModule(tabAnalyzer.getCurrentModule(tabbedPane));
                }
            });
        }
        if(reload){
            int currentIndex = tabAnalyzer.getCurrentTab(context.getCurrentModule());
            tabbedPane.removeAll();
            for(String module : ModuleManager.activeModules()) {
                tabbedPane.addTab(Module.name(module), Module.icon(module), easyKinGuiFactory.createPanel(module, this));
            }

            if(currentIndex!=-1)
                tabbedPane.setSelectedIndex(currentIndex);
        }
        return tabbedPane;
    }

    private Container getTabbedPanel() {
        Container panel = guiFactory.panelBordered();
        panel.add(getTabbedPane(true));
        return panel;
    }

    private Container getMenuButtons() {
        Container menuButtons = guiFactory.panelEmpty();
        menuButtons.setLayout(guiFactory.boxLayout(menuButtons, BoxLayout.X_AXIS));

        ImageIcon plusIcon = ImageUtil.scaleImage(70, 70, imageManager.plus(this.getClass()));
        Component plusButton = guiFactory.button(plusIcon, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        menuButtons.add(plusButton);

        ImageIcon refreshIcon = ImageUtil.scaleImage(70, 70, imageManager.refresh(getClass()));
        Component refreshButton = guiFactory.button(refreshIcon, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        menuButtons.add(refreshButton);

        ImageIcon filterIcon = ImageUtil.scaleImage(70, 70, imageManager.filter(getClass()));
        Component filterButton = guiFactory.button(filterIcon, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });
        menuButtons.add(filterButton);

        return menuButtons;
    }

    private void createMenuBar(){
        ImageIcon plusIcon = ImageUtil.scaleImage(16, 16, imageManager.plus(this.getClass()));
        JMenuItem addItem = guiFactory.menuItem("Добавить",plusIcon);
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        addItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        ImageIcon refreshIcon = ImageUtil.scaleImage(16, 16, imageManager.refresh(getClass()));
        JMenuItem refreshItem = guiFactory.menuItem("Обновить",refreshIcon);
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        refreshItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        ImageIcon filterIcon = ImageUtil.scaleImage(16, 16, imageManager.filter(getClass()));
        JMenuItem filterItem = guiFactory.menuItem("Фильтр", filterIcon);
        filterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        filterItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });

        ImageIcon keyIcon = ImageUtil.scaleImage(16, 16, imageManager.key(getClass()));
        JMenuItem loginItem = guiFactory.menuItem("Сменить пользователя", keyIcon);
        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int authCode = authManager.authDialog(EasyKinWindow.this);
                if (authCode == IGUIEditor.CODE_OK) {
                    refresh();
                }
            }
        });

        ImageIcon exitIcon = ImageUtil.scaleImage(16, 16, imageManager.exit(getClass()));
        JMenuItem exitItem = guiFactory.menuItem("Выход",exitIcon);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EasyKinWindow.this.dispatchEvent(guiFactory.windowEvent(EasyKinWindow.this, WindowEvent.WINDOW_CLOSING));
            }
        });

        ImageIcon dumpIcon = ImageUtil.scaleImage(16, 16, imageManager.dump(getClass()));
        JMenuItem dumpItem = guiFactory.menuItem("Выгрузить данные",dumpIcon);
        dumpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dumpManager.dump();
            }
        });

        JMenu fileMenu = guiFactory.menu("Меню");
        fileMenu.add(loginItem);
        fileMenu.add(exitItem);

        JMenu docMenu = guiFactory.menu("Документы");
        docMenu.add(addItem);
        docMenu.add(refreshItem);
        docMenu.add(filterItem);

        JMenu serviceMenu = guiFactory.menu("Сервис");
        serviceMenu.add(dumpItem);

        JMenuBar menuBar = guiFactory.menuBar();
        menuBar.add(fileMenu);
        menuBar.add(docMenu);
        menuBar.add(serviceMenu);
        setJMenuBar(menuBar);
    }
}