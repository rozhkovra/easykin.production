package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.db.impl.DumpManager;
import ru.rrozhkov.easykin.gui.image.ImageManager;
import ru.rrozhkov.easykin.gui.util.ContextUtil;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class EasyKinWindow extends JFrame implements IGUIEditor {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private EasyKinContext context;

	public EasyKinWindow() throws HeadlessException {
		super(ContextUtil.title());
        setIconImage(ImageManager.logo(this.getClass()));
		this.context = new EasyKinContext();
        fill();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
        setMinimumSize(new Dimension(800,600));
	}

    private void fill() {
        createMenuBar();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(getMenuButtons());
        getContentPane().add(getTabbedPanel(), BorderLayout.SOUTH);
    }

 	public void edit(Object obj){
        closeEditor(IGUIEditor.CODE_CANCEL);

        JPanel editor = GUIFactory.createEditor(context.getCurrentModule(), this, obj);
        showForm(editor);
	}

    public void filter(){
        closeEditor(IGUIEditor.CODE_OK);

        JPanel formPanel = GUIFactory.createFilter(context.getCurrentModule(), this);
        showForm(formPanel);
    }

    protected void showForm(JPanel form) {
        JPanel content = new JPanel(new BorderLayout());
        content.add(form,BorderLayout.NORTH);
        Container main = (Container)getContentPane().getComponent(1);
        main.setLayout(new GridLayout(1, 2));
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

     private JTabbedPane getTabbedPane(boolean reload){
        if(tabbedPane==null){
            tabbedPane = new JTabbedPane();
            tabbedPane.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    context.setCurrentModule(ContextUtil.getCurrentModule(tabbedPane));
                }
            });
        }
        if(reload){
            int currentIndex = ContextUtil.getCurrentTab(context.getCurrentModule());
            tabbedPane.removeAll();
            for(String module : ModuleManager.activeModules()) {
                tabbedPane.addTab(Module.name(module), Module.icon(module), GUIFactory.createPanel(module, this));
            }

            if(currentIndex!=-1)
                tabbedPane.setSelectedIndex(currentIndex);
        }
        return tabbedPane;
    }

    private JPanel getTabbedPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(getTabbedPane(true));
        return panel;
    }

    private JPanel getMenuButtons() {
        JPanel menuButtons = new JPanel();
        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.X_AXIS));

        ImageIcon plusIcon = ImageUtil.scaleImage(70, 70, ImageManager.plus(this.getClass()));
        Component plusButton = GuiUtil.button(plusIcon, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        menuButtons.add(plusButton);

        ImageIcon refreshIcon = ImageUtil.scaleImage(70, 70, ImageManager.refresh(getClass()));
        Component refreshButton = GuiUtil.button(refreshIcon,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        menuButtons.add(refreshButton);

        ImageIcon filterIcon = ImageUtil.scaleImage(70, 70, ImageManager.filter(getClass()));
        Component filterButton = GuiUtil.button(filterIcon, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });
        menuButtons.add(filterButton);

        return menuButtons;
    }

    private void createMenuBar(){
        ImageIcon plusIcon = ImageUtil.scaleImage(16, 16, ImageManager.plus(this.getClass()));
        JMenuItem addItem = new JMenuItem("Добавить",plusIcon);
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        addItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        ImageIcon refreshIcon = ImageUtil.scaleImage(16, 16, ImageManager.refresh(getClass()));
        JMenuItem refreshItem = new JMenuItem("Обновить",refreshIcon);
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        refreshItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        ImageIcon filterIcon = ImageUtil.scaleImage(16, 16, ImageManager.filter(getClass()));
        JMenuItem filterItem = new JMenuItem("Фильтр", filterIcon);
        filterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        filterItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });

        ImageIcon keyIcon = ImageUtil.scaleImage(16, 16, ImageManager.key(getClass()));
        JMenuItem loginItem = new JMenuItem("Сменить пользователя", keyIcon);
        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EasyKin.restart();
            }
        });

        ImageIcon exitIcon = ImageUtil.scaleImage(16, 16, ImageManager.exit(getClass()));
        JMenuItem exitItem = new JMenuItem("Выход",exitIcon);
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EasyKin.close();
            }
        });

        ImageIcon dumpIcon = ImageUtil.scaleImage(16, 16, ImageManager.dump(getClass()));
        JMenuItem dumpItem = new JMenuItem("Выгрузить данные",dumpIcon);
        dumpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DumpManager.dump();
            }
        });

        JMenu fileMenu = new JMenu("Меню");
        fileMenu.add(loginItem);
        fileMenu.add(exitItem);

        JMenu docMenu = new JMenu("Документы");
        docMenu.add(addItem);
        docMenu.add(refreshItem);
        docMenu.add(filterItem);

        JMenu serviceMenu = new JMenu("Сервис");
        serviceMenu.add(dumpItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(docMenu);
        menuBar.add(serviceMenu);
        setJMenuBar(menuBar);
    }
}