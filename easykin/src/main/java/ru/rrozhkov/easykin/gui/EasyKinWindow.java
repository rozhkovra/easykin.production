package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.db.impl.DumpManager;
import ru.rrozhkov.easykin.gui.image.ImageManager;
import ru.rrozhkov.easykin.gui.util.ContextUtil;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.gui.util.ImageUtil;
import ru.rrozhkov.easykin.model.category.ICategory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static ru.rrozhkov.easykin.gui.PanelFactory.createPanel;

public class EasyKinWindow extends JFrame implements IGUIEditor{
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private EasyKinContext context;

	public EasyKinWindow(EasyKinContext context) throws HeadlessException {
		super(ContextUtil.title());
        setIconImage(ImageManager.logo(this.getClass()));
		this.context = context;
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

 	public void edit(int index){
        closeEditor(IGUIEditor.CODE_CANCEL);

        Object obj = context.masterData().getObjByIndex(index);
        JPanel content = new JPanel(new BorderLayout());
        JPanel formPanel = FormFactory.getFormPanel(context.masterData(), this, obj);
        content.add(formPanel,BorderLayout.NORTH);
        Container main = (Container)getContentPane().getComponent(1);
        main.setLayout(new GridLayout(1, 2));
        main.add(main.getComponent(0));
        main.add(content);
        main.validate();
	}

    public void filter(){
        closeEditor(IGUIEditor.CODE_OK);

        JPanel content = new JPanel(new BorderLayout());
        JPanel formPanel = FilterFormFactory.getFilterFormPanel(context, this);
        content.add(formPanel,BorderLayout.NORTH);
        Container main = (Container)getContentPane().getComponent(1);
        main.setLayout(new GridLayout(1, 2));
        main.add(main.getComponent(0));
        main.add(content);
        main.validate();
    }

    public void add() {
        edit(-1);
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
        context.init();
        getTabbedPane(true);
    }

     private JTabbedPane getTabbedPane(boolean reload){
        if(tabbedPane==null){
            tabbedPane = new JTabbedPane();
            tabbedPane.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    context.masterData().chooseCategory(ContextUtil.getCurrentCategory(context.masterData(), getTabbedPane(false)));
                }
            });
        }
        if(reload){
            int currentIndex = ContextUtil.getCurrentTab(context.masterData(), getTabbedPane(false));
            tabbedPane.removeAll();
            for(ICategory category : context.masterData().categories()) {
                tabbedPane.addTab(category.getName(), createPanel(this, context.masterData(), category));
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
        Component filterButton = GuiUtil.button(filterIcon,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });
        menuButtons.add(filterButton);

        ImageIcon dumpIcon = ImageUtil.scaleImage(70, 70, ImageManager.dump(getClass()));
        Component dumpButton = GuiUtil.button(dumpIcon,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DumpManager.dump(context.masterData());
            }
        });
//        menuButtons.add(dumpButton);

        return menuButtons;
    }

    private void createMenuBar(){
        JMenuItem addItem = new JMenuItem("Добавить");
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.SHIFT_MASK));
        addItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        JMenuItem refreshItem = new JMenuItem("Обновить");
        refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));
        refreshItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        JMenuItem filterItem = new JMenuItem("Фильтр");
        filterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        filterItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        });

        JMenuItem loginItem = new JMenuItem("Сменить пользователя");
        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EasyKin.restart();
            }
        });

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EasyKin.close();
            }
        });

        JMenuItem dumpItem = new JMenuItem("Выгрузить данные");
        dumpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DumpManager.dump(context.masterData());
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