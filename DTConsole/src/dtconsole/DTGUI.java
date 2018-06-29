/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

//import java.awt.*;
//import java.util.*;
//import java.awt.Event.*;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;

import java.lang.*;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;


/**
 * DTGUI is the main frame that run the Dengue Fighter game
 * @author ChinWeiQing
 * @version 2.0
 */
public class DTGUI extends javax.swing.JFrame {   
    public DengueFighter df;

    private Site choosenSite;
    private Resource choosenRes;
    private int choosenQuantity;
    private int maxQuantity;
    
    private int count = 0;
     
    /**
     * for jlist
     */
    private DefaultListModel model; 
 
    /**
     * run initComponent where it generate all swing
     * run startup, create dengue fighter and setup all of its site/resource
     * run setupDisplay, update all display stuff
     */
    public DTGUI() {
        initComponents();
        startup();
        setDisplay();                 
    }
    
    /**
     * get the created dengueFighter from this class
     * @return created dengueFighter 
     */
    public DengueFighter getDengueFighter(){
        return df;    
    }
    /**
     * set the dengueFighter with input name,and update the display,
     * @param df user input name for the dengue fighter
     */
    public void setDengueFighter(DengueFighter df){
        this.df= df;    
        setDisplay();
    }
    
    /**
     * set up the jlist for select resource panel
     * show on text area if no resource available
     */
    private void setResourceJList(){
        model = new DefaultListModel(); //type of jlist {DefaultListModel : everything do for u, AbstractListModel: the one u fire. ,Listmodel: DIY}
        resourceJList.setModel(model); //same for all below
        

        //check the non purchased resource and add it into the jlist, display ther after,and auto select 1st one
        //if there is no resource available, show it on text area
        for (Resource r: df.findAvailableResourceForWeek(choosenSite))
        {
           model.addElement(r);
        }
        if (model.getSize()==0)
        {
            resourceOkBtn.setEnabled(false);
            displayTextArea.setText("Selected Site: "+choosenSite+"\n Note:No Resource Available for this site! =<");          
        }
        else
        {
            resourceJList.setSelectionInterval(0, 0);
        }
            
        
    }
    
    /**
     * set up the jlist for select quantity panel
     * show max quantity a user can but for the resource
     */
    private void setQuantityJList(){
        model = new DefaultListModel(); //type of jlist {DefaultListModel : everything do for u, AbstractListModel: the one u fire. ,Listmodel: DIY}
        quantityJList.setModel(model);
        quantityJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        // add quantity "0"
        model.addElement(0);
        
        //go thought a loop and print the max quantity they can buy for the site, auto select 1st one
        int counts=1;
        for(int i=1;i<maxQuantity+1;i++) 
        {          
            model.addElement(counts);
            counts++;
        }
        quantityJList.setSelectionInterval(0, 0);
    }
   
    /**
     * create new dengue fighter, add 3 new site to it,create and add 8 resource to it,
     * initialize starting budget base on site income.
     */
    private void startup(){
        //create new dengue fighter
        df = new DengueFighter();
        
        //add 3 new site
        df.addSite(new Site());
        df.addSite(new Site());
        df.addSite(new Site());
        
        //initialize starting budget
        df.setCurrentBudget(df.budgetCalculator(0));
        
       //create 7new resource
        Pesticide larvicide = new Pesticide("Larvicide\t", 100, Grade.LOW, 
            Grade.MEDIUM);   
        Pesticide fogging = new Pesticide("Fogging\t", 200, Grade.MEDIUM, 
            Grade.LOW);
        Pesticide residualSpray = new Pesticide( "Residual Spray\t", 300, Grade.HIGH, 
            Grade.HIGH);
        MedicalServices generalWard = new MedicalServices( "General Ward\t", 100, 
            15);
        MedicalServices isolationWard = new MedicalServices( "Isolation Ward\t", 300, 
           30);
        CleanupTeam generalCleaning = new CleanupTeam( "General Cleaning", 100, 
            Grade.LOW);
        CleanupTeam targetedCleaning = new CleanupTeam( "Targeted Cleaning", 500, 
            Grade.HIGH);
         
        //add 7 new res to the dengue fighter
        df.addResource(larvicide);
        df.addResource(fogging);
        df.addResource(residualSpray);
        df.addResource(generalWard);
        df.addResource(isolationWard);
        df.addResource(generalCleaning);
        df.addResource(targetedCleaning); 
       
    }
   
    /**
     * set up what panel should be visible and what should and not be editable
     * print the current week and budget
     */
    public void setDisplay(){
        //set display area ediable false
        //set select resource/quatitny panel visible false
        displayTextArea.setEditable(false); 
        selectResourcePanel.setVisible(false);
        selectQuantityPanel.setVisible(false);
        
        //limit user to select only 1 for resource/quantity jlist
        resourceJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        quantityJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);       
        
        //print week no. & current budget to DTGUI
        weekOutputLabel.setText(Integer.toString(df.getCurrentWeek()));
        budgetOutputLabel.setText(Double.toString(df.getCurrentBudget()));
         
    }
    
    /**
     * print current week and budget
     */
    public void setBudgetNWeek(){
        //print week no. & current budget to DTGUI
        weekOutputLabel.setText(Integer.toString(df.getCurrentWeek()));
        budgetOutputLabel.setText(Double.toString(df.getCurrentBudget()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLayeredPane1 = new javax.swing.JLayeredPane();
        budgetLabel = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        weekOutputLabel = new javax.swing.JLabel();
        budgetOutputLabel = new javax.swing.JLabel();
        smapBtn = new javax.swing.JButton();
        optionPanel = new javax.swing.JPanel();
        optionLabel = new javax.swing.JLabel();
        endWeekBtn = new javax.swing.JButton();
        addResourceBtn = new javax.swing.JButton();
        viewSiteBtn = new javax.swing.JButton();
        viewResourceBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        quitBtn = new javax.swing.JButton();
        viewResourceUsage = new javax.swing.JButton();
        manuPanel = new javax.swing.JPanel();
        selectSitePanel = new javax.swing.JPanel();
        manageSiteLabel = new javax.swing.JLabel();
        s100Btn = new javax.swing.JButton();
        s101Btn = new javax.swing.JButton();
        s102Btn = new javax.swing.JButton();
        selectQuantityPanel = new javax.swing.JPanel();
        quantityPanel = new javax.swing.JScrollPane();
        quantityJList = new javax.swing.JList();
        selectQuantity = new javax.swing.JLabel();
        quantityBackBtn = new javax.swing.JButton();
        quantityOkBtn = new javax.swing.JButton();
        selectResourcePanel = new javax.swing.JPanel();
        resourceScrollPane = new javax.swing.JScrollPane();
        resourceJList = new javax.swing.JList();
        selectResource = new javax.swing.JLabel();
        resourceBackBtn = new javax.swing.JButton();
        resourceOkBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DengueFighter2.0");
        setResizable(false);

        budgetLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        budgetLabel.setText("Budget:");

        weekLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N
        weekLabel.setText("week:");

        weekOutputLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N

        budgetOutputLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 12)); // NOI18N

        smapBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dtconsole/Tayninhmapsmall.jpg"))); // NOI18N
        smapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smapBtnActionPerformed(evt);
            }
        });

        optionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optionPanel.setToolTipText("");

        optionLabel.setFont(new java.awt.Font("Charlemagne Std", 1, 14)); // NOI18N
        optionLabel.setText("Option");

        endWeekBtn.setText("End Week");
        endWeekBtn.setToolTipText("apply all purchased resources");
        endWeekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endWeekBtnActionPerformed(evt);
            }
        });

        addResourceBtn.setText("Create New Resource");
        addResourceBtn.setToolTipText("nid more resource!");
        addResourceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResourceBtnActionPerformed(evt);
            }
        });

        viewSiteBtn.setText("View Site Detail");
        viewSiteBtn.setToolTipText("");
        viewSiteBtn.setOpaque(false);
        viewSiteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSiteBtnActionPerformed(evt);
            }
        });

        viewResourceBtn.setText("View Resource Detail");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, viewResourceBtn, org.jdesktop.beansbinding.ELProperty.create("Cick to Sort by Type/Cost"), viewResourceBtn, org.jdesktop.beansbinding.BeanProperty.create("toolTipText"));
        bindingGroup.addBinding(binding);

        viewResourceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResourceBtnActionPerformed(evt);
            }
        });

        menuBtn.setText("Back To Menu");
        menuBtn.setToolTipText("go for new one");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save Game");
        saveBtn.setToolTipText("take a break,save it!");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        quitBtn.setText("Quit Game");
        quitBtn.setToolTipText("Goodbye?");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        viewResourceUsage.setText("View Resource Usage");
        viewResourceUsage.setToolTipText("check purchased resource");
        viewResourceUsage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResourceUsageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addResourceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewResourceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewSiteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endWeekBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewResourceUsage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(optionPanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(optionLabel)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );

        optionPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addResourceBtn, endWeekBtn, menuBtn, quitBtn, saveBtn, viewResourceBtn, viewSiteBtn});

        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(viewSiteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewResourceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addResourceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewResourceUsage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endWeekBtn)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitBtn)
                .addContainerGap())
            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(optionPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(optionLabel)
                    .addContainerGap(251, Short.MAX_VALUE)))
        );

        optionPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addResourceBtn, endWeekBtn, menuBtn, quitBtn, saveBtn, viewResourceBtn, viewSiteBtn});

        manuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        manuPanel.setToolTipText("purchase resource for site");
        manuPanel.setLayout(new javax.swing.OverlayLayout(manuPanel));

        manageSiteLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        manageSiteLabel.setText("Manage Site:");

        s100Btn.setText("S100");
        s100Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s100BtnActionPerformed(evt);
            }
        });

        s101Btn.setText("S101");
        s101Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s101BtnActionPerformed(evt);
            }
        });

        s102Btn.setText("S102");
        s102Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s102BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectSitePanelLayout = new javax.swing.GroupLayout(selectSitePanel);
        selectSitePanel.setLayout(selectSitePanelLayout);
        selectSitePanelLayout.setHorizontalGroup(
            selectSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSitePanelLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(selectSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(s102Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(selectSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(s100Btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(s101Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(246, 246, 246))
            .addGroup(selectSitePanelLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(manageSiteLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        selectSitePanelLayout.setVerticalGroup(
            selectSitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectSitePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(manageSiteLabel)
                .addGap(36, 36, 36)
                .addComponent(s100Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(s101Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(s102Btn)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        manuPanel.add(selectSitePanel);

        selectQuantityPanel.setPreferredSize(new java.awt.Dimension(646, 233));

        quantityJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3", "4", "5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        quantityPanel.setViewportView(quantityJList);

        selectQuantity.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        selectQuantity.setText("Select Quantity");
        selectQuantity.setToolTipText("");

        quantityBackBtn.setText("Back");
        quantityBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityBackBtnActionPerformed(evt);
            }
        });

        quantityOkBtn.setText("OK");
        quantityOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityOkBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectQuantityPanelLayout = new javax.swing.GroupLayout(selectQuantityPanel);
        selectQuantityPanel.setLayout(selectQuantityPanelLayout);
        selectQuantityPanelLayout.setHorizontalGroup(
            selectQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuantityPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectQuantityPanelLayout.createSequentialGroup()
                        .addGap(0, 245, Short.MAX_VALUE)
                        .addGroup(selectQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuantityPanelLayout.createSequentialGroup()
                                .addComponent(selectQuantity)
                                .addGap(245, 245, 245))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuantityPanelLayout.createSequentialGroup()
                                .addComponent(quantityBackBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectQuantityPanelLayout.createSequentialGroup()
                        .addComponent(quantityPanel)
                        .addContainerGap())))
        );
        selectQuantityPanelLayout.setVerticalGroup(
            selectQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectQuantityPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(selectQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(selectQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityBackBtn)
                    .addComponent(quantityOkBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manuPanel.add(selectQuantityPanel);

        selectResourcePanel.setAutoscrolls(true);
        selectResourcePanel.setFocusTraversalPolicyProvider(true);

        resourceJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "1", "2", "3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        resourceJList.setDragEnabled(true);
        resourceJList.setMaximumSize(new java.awt.Dimension(1000, 1000));
        resourceScrollPane.setViewportView(resourceJList);

        selectResource.setFont(new java.awt.Font("Charlemagne Std", 0, 14)); // NOI18N
        selectResource.setText("Select Available Resource");
        selectResource.setToolTipText("");

        resourceBackBtn.setText("Back");
        resourceBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resourceBackBtnActionPerformed(evt);
            }
        });

        resourceOkBtn.setText("OK");
        resourceOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resourceOkBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectResourcePanelLayout = new javax.swing.GroupLayout(selectResourcePanel);
        selectResourcePanel.setLayout(selectResourcePanelLayout);
        selectResourcePanelLayout.setHorizontalGroup(
            selectResourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectResourcePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectResourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resourceScrollPane)
                    .addGroup(selectResourcePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resourceBackBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resourceOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, selectResourcePanelLayout.createSequentialGroup()
                .addGap(0, 215, Short.MAX_VALUE)
                .addComponent(selectResource)
                .addGap(199, 199, 199))
        );
        selectResourcePanelLayout.setVerticalGroup(
            selectResourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectResourcePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(selectResource)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resourceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(selectResourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resourceBackBtn)
                    .addComponent(resourceOkBtn))
                .addContainerGap())
        );

        manuPanel.add(selectResourcePanel);

        displayTextArea.setColumns(20);
        displayTextArea.setRows(5);
        displayTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayTextArea.setMaximumSize(new java.awt.Dimension(144, 104));
        jScrollPane1.setViewportView(displayTextArea);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(smapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(budgetLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(budgetOutputLabel))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(weekLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(weekOutputLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(weekLabel)
                            .addComponent(weekOutputLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(budgetLabel)
                            .addComponent(budgetOutputLabel))
                        .addGap(13, 13, 13)
                        .addComponent(smapBtn))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(manuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1.setLayer(budgetLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(weekLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(weekOutputLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(budgetOutputLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(smapBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        smapBtn.getAccessibleContext().setAccessibleDescription("small map");
        jLayeredPane1.setLayer(optionPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(manuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 884, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
     * display site detail in text when button pressed
     * @param evt 
     */
    private void viewSiteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSiteBtnActionPerformed
        // TODO add your handling code here:
        displayTextArea.setText(df.showSite());
    }//GEN-LAST:event_viewSiteBtnActionPerformed

    /**
     * create and display new resource dialog when button press
     * @param evt 
     */
    private void addResourceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResourceBtnActionPerformed
        // TODO add your handling code here:
        new AddNewResourceDialog(this,true).setVisible(true);
    }//GEN-LAST:event_addResourceBtnActionPerformed

    /**
     * activate resource purchase, set current week+1, update all site effect,budget, all display when button pressed
     * check if any site healthy ppl >11, if yes, game over and quit game.
     * @param evt 
     */
    private void endWeekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endWeekBtnActionPerformed
        // TODO add your handling code here:
        df.activateResourcePurchase();
        df.setCurrentWeek(df.getCurrentWeek()+1);
        df.updateAllsite();
        displayTextArea.setText(df.showSite());
        df.setCurrentBudget((df.budgetCalculator(df.getCurrentBudget()))); 
        weekOutputLabel.setText(Integer.toString(df.getCurrentWeek()));
        budgetOutputLabel.setText(Double.toString(df.getCurrentBudget()));
        
        for(Site s:df.getDengueFighterSites()){
            if (s.getPopulation()-10 <=s.getNumInfected()){
                 JOptionPane.showMessageDialog(this, "you fail to save your people..","GAMEOVER", WIDTH);                
                    System.exit(0);   
            }
        }
         
    }//GEN-LAST:event_endWeekBtnActionPerformed

    /**
     * loop display resource by cost or type, changed when button pressed
     * @param evt 
     */
    private void viewResourceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResourceBtnActionPerformed
        // TODO add your handling code here:
        
        if (count % 2 != 0){
            count++;
            displayTextArea.setText(df.showResourceByCost());
        }else{
            count++;
            displayTextArea.setText(df.showResourceByType());
        }
        
    }//GEN-LAST:event_viewResourceBtnActionPerformed

    /**
     * create and show map dialog when button pressed
     * @param evt 
     */
    private void smapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smapBtnActionPerformed
        // TODO add your handling code here:
        MapDialog s= new MapDialog(this,true);
         s.setVisible(true);
    }//GEN-LAST:event_smapBtnActionPerformed

    /**
     * ask user if he wan to save before disposing current game and go back to menu when button pressed
     * recreate new dengue fighter when user click yes or no
     * close DTGUI and open new Menu Dialog
     * @param evt 
     */
    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        // TODO add your handling code here:
                  
         if (df != null)
        {
            int n = JOptionPane.showConfirmDialog(this, "Going back to Menu, Would you like to save* your current people* first", "Warning!", JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION)
            {
                FileHandling.saveToFile(this, df);
                startup();
                this.setVisible(false);
                new MenuDialog(this,true).setVisible(true);
            }
            else if (n ==JOptionPane.NO_OPTION)
            {
                startup();
                selectSitePanel.setVisible(true);
                this.setVisible(false);
                new MenuDialog(this,true).setVisible(true);
            }          
	}
        
        
            

    }//GEN-LAST:event_menuBtnActionPerformed

    /**
     * pop up same game dialog ,where user enter name for the save file and press save.
     * @param evt 
     */
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        FileHandling.saveToFile(this, df);
    }//GEN-LAST:event_saveBtnActionPerformed

    /**
     * under manage site panel, site S100 selected and displayed when button pressed
     * @param evt 
     */
    private void s100BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s100BtnActionPerformed
        // TODO add your handling code here:
        choosenSite = df.findSite("S100");
        
        setResourceJList();
        selectSitePanel.setVisible(false);
        selectResourcePanel.setVisible(true);
        displayTextArea.setText("Selected Site: "+choosenSite);
      
    }//GEN-LAST:event_s100BtnActionPerformed

    /**
     * under manage site panel, site S101 selected, and displayed when button pressed
     * @param evt 
     */
    private void s101BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s101BtnActionPerformed
        // TODO add your handling code here:
        choosenSite = df.findSite("S101");
        
        setResourceJList();
        selectSitePanel.setVisible(false);
        selectResourcePanel.setVisible(true);
        displayTextArea.setText("Selected Site: "+choosenSite);
        
    }//GEN-LAST:event_s101BtnActionPerformed

    /**
     * under manage site panel, site S102 selected and displayed when button pressed
     * @param evt 
     */
    private void s102BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s102BtnActionPerformed
        // TODO add your handling code here:
        choosenSite =  df.findSite("S102");
        
        setResourceJList();
        selectSitePanel.setVisible(false);
        selectResourcePanel.setVisible(true);
        displayTextArea.setText("Selected Site: "+choosenSite);
        
    }//GEN-LAST:event_s102BtnActionPerformed

    /**
     * ask if user want to save game before closing the game when button pressed
     * @param evt 
     */
    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(this, "Would you like to save* your current people* first", "Warning", JOptionPane.YES_NO_CANCEL_OPTION);
            if (n == JOptionPane.YES_OPTION){
		FileHandling.saveToFile(this, df);
                System.exit(0);
            }else if(n == JOptionPane.NO_OPTION){
                System.exit(0);
            }
            
    }//GEN-LAST:event_quitBtnActionPerformed

    /**
     * under manage resource panel, retrieve chosen resource ID when button pressed
     * @param evt 
     */
    private void resourceOkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resourceOkBtnActionPerformed
        // TODO add your handling code here:
      
        if (resourceJList.isSelectionEmpty()==false){
            
            //List <Resource> choice = (ArrayList)resourceJList.getSelectedValuesList();
            String choice = resourceJList.getSelectedValuesList().toString();
            //retrieve the selected resource ID
            String resName = choice.substring(11,15);
            displayTextArea.setText("Selected Site: "+choosenSite+"\nSelected Resource: "+resName);

            //get resource detail
            choosenRes=df.findResource(resName);

            //calculate the maximum quantity player can buy for the resource
            maxQuantity = ( (int)df.getCurrentBudget()/choosenRes.getCost());
            setQuantityJList();
            selectResourcePanel.setVisible(false);
            selectQuantityPanel.setVisible(true);
        }else{
         JOptionPane.showMessageDialog(this,"Select a resource pls");

        }
        
        
    }//GEN-LAST:event_resourceOkBtnActionPerformed

    /**
     * under manage resource panel, go back to manage site panel when button pressed
     * @param evt 
     */
    private void resourceBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resourceBackBtnActionPerformed
        // TODO add your handling code here:
        displayTextArea.setText("");
        selectSitePanel.setVisible(true);
        selectResourcePanel.setVisible(false);
    }//GEN-LAST:event_resourceBackBtnActionPerformed

    /**
     * under manage quantity resource panel, go back to manage resource panel when button pressed
     * @param evt 
     */
    private void quantityBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityBackBtnActionPerformed
        // TODO add your handling code here:
        displayTextArea.setText("Selected Site: "+choosenSite);
        setResourceJList();
        selectResourcePanel.setVisible(true);
        selectQuantityPanel.setVisible(false);
    }//GEN-LAST:event_quantityBackBtnActionPerformed

    /**
     * under mange quantity panel, retrieve chosen quantity and set the resource and quantity 
     * for the site when button pressed
     * @param evt 
     */
    private void quantityOkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityOkBtnActionPerformed
        // TODO add your handling code here:
        
        //if selection is not empty
        if (resourceJList.isSelectionEmpty()==false){
            //retrieve the quantity from selected list as string 
            String quantity = quantityJList.getSelectedValuesList().toString();
            
            //convert to int
            int choosenQuantity =Integer.parseInt(quantity.replaceAll("[\\D]", ""));
            
            //check if its 0
            if (choosenQuantity == 0)

                 displayTextArea.setText("Selected Site: "+choosenSite+"\nSelected Resource: "+choosenSite.getSiteID()+ 
                         "\n\nSelected Quantity: "+choosenQuantity + 
                         "\n\nResource "+choosenRes.getResourceID()+" not purchase for site "+choosenSite.getSiteID() +
                         "!  =| \nNote: Quantity enter 0! ");
            
            //if not 0
            else
            {
                //check if enough budget
                boolean check= df.budgetCheck(choosenQuantity,choosenRes);
                
                //if its enough
                if (check ==true)
                {
                    choosenSite.setResourceUsage(df.getCurrentWeek(),choosenQuantity,choosenRes,choosenSite);
                    displayTextArea.setText("Selected Site: "+choosenSite+"\nSelected Resource: "+choosenSite.getSiteID()+ 
                            "\n\nSelected Quantity: "+ choosenQuantity+
                            "\n\nResource "+choosenRes.getResourceID()+" sucessfully purchased for site "+choosenSite.getSiteID() +"!  :D"+
                            "\nNote: Resource require 1 week to implement.");

                    budgetOutputLabel.setText(Double.toString(df.getCurrentBudget()));
                }
                //if not
                else
                {

                    displayTextArea.setText("Selected Site: "+choosenSite+"\nSelected Resource: "+choosenSite.getSiteID()+
                            "\n\nSelected Quantity: "+ choosenQuantity+
                            "\n\nResource "+choosenRes.getResourceID()+" fail to purchase for site "+choosenSite.getSiteID() +
                            "!  :( \nNote: Insufficient Budget!");    
                }       
            }
            
            //go back to the select site panel
            selectSitePanel.setVisible(true);
            selectQuantityPanel.setVisible(false);
            
           //tell user to select something before press enter 
           }else{
               JOptionPane.showMessageDialog(this,"Select a quantity please");
           }
    }//GEN-LAST:event_quantityOkBtnActionPerformed

    /**
     * create and show shoewPurchastedResourceDialog when button pressed
     * @param evt 
     */
    private void viewResourceUsageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResourceUsageActionPerformed
        // TODO add your handling code here:
        ShowPurchasedResourceDialog s= new ShowPurchasedResourceDialog(this,true);
                s.setVisible(true);

    }//GEN-LAST:event_viewResourceUsageActionPerformed

    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DTGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DTGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DTGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DTGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //create new DTGUI,set visible false
               DTGUI i =new DTGUI();
               i.setVisible(false);
               
               //create new menu dialog, set visible true
               MenuDialog m = new MenuDialog(i,true);         
               m.setVisible(true);    
               
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addResourceBtn;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JLabel budgetOutputLabel;
    private javax.swing.JTextArea displayTextArea;
    private javax.swing.JButton endWeekBtn;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageSiteLabel;
    private javax.swing.JPanel manuPanel;
    private javax.swing.JButton menuBtn;
    private javax.swing.JLabel optionLabel;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton quantityBackBtn;
    private javax.swing.JList quantityJList;
    private javax.swing.JButton quantityOkBtn;
    private javax.swing.JScrollPane quantityPanel;
    private javax.swing.JButton quitBtn;
    private javax.swing.JButton resourceBackBtn;
    private javax.swing.JList resourceJList;
    private javax.swing.JButton resourceOkBtn;
    private javax.swing.JScrollPane resourceScrollPane;
    private javax.swing.JButton s100Btn;
    private javax.swing.JButton s101Btn;
    private javax.swing.JButton s102Btn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel selectQuantity;
    private javax.swing.JPanel selectQuantityPanel;
    private javax.swing.JLabel selectResource;
    private javax.swing.JPanel selectResourcePanel;
    private javax.swing.JPanel selectSitePanel;
    private javax.swing.JButton smapBtn;
    private javax.swing.JButton viewResourceBtn;
    private javax.swing.JButton viewResourceUsage;
    private javax.swing.JButton viewSiteBtn;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JLabel weekOutputLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}