
package hdmimatrixswing;

import hdmimatrixswing.MatrixHelper.Input;
import hdmimatrixswing.MatrixHelper.Output;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class IOSelection extends javax.swing.JPanel
{
    ArrayList<StringClass> inDevices=new ArrayList<StringClass>();
    private IOSelection instance=null;
    DefaultListModel<String> lbxTemplatesModel = new DefaultListModel<>();
    
    boolean initializing=true;
    public IOSelection()
    {
        initComponents();
        
        
        lbxTemplates.setModel(lbxTemplatesModel);
        
        lbxTemplates.registerKeyboardAction(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                deleteSelectedTemplate();
            }
        },KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), JComponent.WHEN_FOCUSED);
        
        
        lbxTemplates.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
               
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
               
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
               
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
               
            }
        });
        
        lbxTemplates.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                String val=lbxTemplates.getSelectedValue();
                if (val!=null && !val.isEmpty())
                {
                    if (Options.get().templates.containsKey(val))
                    {
                        Template t = Options.get().templates.get(val);
                        setTemplateData(t);
                        instance.repaint();
                        savetemplate.setEnabled(false);
                        
                    }
                }
                setTemplateName();
            }
        });
        
        instance=this;
        ditxt1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (ditxt1.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (ditxt1.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (ditxt1.hasFocus()) {templateChaged();}
            }
        });
        ditxt2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (ditxt2.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (ditxt2.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (ditxt2.hasFocus()) {templateChaged();}
            }
        });
        ditxt3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (ditxt3.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (ditxt3.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (ditxt3.hasFocus()) {templateChaged();}
            }
        });
        ditxt4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (ditxt4.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (ditxt4.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (ditxt4.hasFocus()) {templateChaged();}
            }
        });

        
        
        dotxt1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (dotxt1.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (dotxt1.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (dotxt1.hasFocus()) {templateChaged();}
            }
        });
        dotxt2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (dotxt2.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (dotxt2.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (dotxt2.hasFocus()) {templateChaged();}
            }
        });
        dotxt3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (dotxt3.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (dotxt3.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (dotxt3.hasFocus()) {templateChaged();}
            }
        });
        dotxt4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                if (dotxt4.hasFocus()) {templateChaged();}
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                if (dotxt4.hasFocus()) {templateChaged();}
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                 if (dotxt4.hasFocus()) {templateChaged();}
            }
        });
        
        docbx1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                instance.repaint();
                if (cbxapplychanges.isSelected() && !templateload){applystates();}
                if (!initializing){templateChaged();}
            }
        });
        docbx2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                instance.repaint();
                if (cbxapplychanges.isSelected() && !templateload){applystates();}
                if (!initializing){templateChaged();}
            }
        });
        docbx3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                instance.repaint();
                if (cbxapplychanges.isSelected() && !templateload){applystates();}
                if (!initializing){templateChaged();}
            }
        });
        docbx4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                instance.repaint();
                if (cbxapplychanges.isSelected() && !templateload){applystates();}
                if (!initializing){templateChaged();}
            }
        });
        
        
        cbxApplyOnTemplateClick.setSelected(Options.get().applyontemplateselect);                        
        cbxapplychanges.setSelected(Options.get().applyinstantly);
        
        
        fillDeviceDescriptions();
        reloadTemplateList();
        
        if (lbxTemplates.getModel().getSize()>0)
        {
            lbxTemplates.setSelectedIndex(0);
        }
        
        setTemplateName();
        initializing=false;
    }

    
    public void setTemplateName()
    {
        String val=lbxTemplates.getSelectedValue();
        if (val==null)
        {
            lbltemplate.setText("Template: New Template");
        }
        else
        {
            lbltemplate.setText("Template: "+lbxTemplates.getSelectedValue());
        }

    }
    public void templateChaged()
    {
        savetemplate.setEnabled(true);
        
        inDevices.get(0).name=ditxt1.getText();
        inDevices.get(1).name=ditxt2.getText();
        inDevices.get(2).name=ditxt3.getText();
        inDevices.get(3).name=ditxt4.getText();
    }
   
     public void paint(Graphics g) 
     {
        super.paint(g);  // fixes the immediate problem.
        paint(DeviceOut1,docbx1,g);
        paint(DeviceOut2,docbx2,g);
        paint(DeviceOut3,docbx3,g);
        paint(DeviceOut4,docbx4,g);
    }
     
    private void paint(javax.swing.JPanel device, javax.swing.JComboBox<String> box, Graphics g)
    {
        float x1=((float)(device.getLocation().x+device.getSize().width));
        float y1=((float)device.getLocation().y+((float)device.getSize().height/2));
        
        StringClass sc= (StringClass)box.getSelectedItem();
        
        javax.swing.JPanel device2 =null; 
        if (sc.input==MatrixHelper.Input.I1){device2=DeviceIn1;}
        if (sc.input==MatrixHelper.Input.I2){device2=DeviceIn2;}
        if (sc.input==MatrixHelper.Input.I3){device2=DeviceIn3;}
        if (sc.input==MatrixHelper.Input.I4){device2=DeviceIn4;}
        
        float x2=((float)device2.getLocation().x);
        float y2=((float)device2.getLocation().y+((float)device2.getSize().height/2));
        
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(x1,y1,x2,y2);
        g2.draw(lin);
        
    }
    
    boolean templateload=false;
    Template currentTemplate=null;
    private void setTemplateData(Template t)
    {
        currentTemplate=t;
        templateload=true;
        ditxt1.setText(t.inputnames[0]);
        ditxt2.setText(t.inputnames[1]);
        ditxt3.setText(t.inputnames[2]);
        ditxt4.setText(t.inputnames[3]);
        
        dotxt1.setText(t.outputnames[0]);
        dotxt2.setText(t.outputnames[1]);
        dotxt3.setText(t.outputnames[2]);
        dotxt4.setText(t.outputnames[3]);
        
        inDevices.get(0).name=ditxt1.getText();
        inDevices.get(1).name=ditxt2.getText();
        inDevices.get(2).name=ditxt3.getText();
        inDevices.get(3).name=ditxt4.getText();
        
        JComboBox<String> combo=null;
        for (int i=0;i<4;i++)
        {
            
            if (i==0){combo=docbx1;}
            if (i==1){combo=docbx2;}
            if (i==2){combo=docbx3;}
            if (i==3){combo=docbx4;}
            
            if (t.inputs[i]==Input.I1)
            {
                combo.setSelectedIndex(0);
            }
            if (t.inputs[i]==Input.I2)
            {
                combo.setSelectedIndex(1);
            }
            if (t.inputs[i]==Input.I3)
            {
                combo.setSelectedIndex(2);
            }
            if (t.inputs[i]==Input.I4)
            {
                combo.setSelectedIndex(3);
            }
        }
        
        if (cbxApplyOnTemplateClick.isSelected())
        {
            applystates();
        }
        templateload=false;
        
    }
     
     
    private void refreshDeviceDescriptions()
    {
        templateChaged();
        currentTemplate.inputnames[0]=ditxt1.getText();
        currentTemplate.inputnames[1]=ditxt2.getText();
        currentTemplate.inputnames[2]=ditxt3.getText();
        currentTemplate.inputnames[3]=ditxt4.getText();
        
        currentTemplate.outputnames[0]=dotxt1.getText();
        currentTemplate.outputnames[1]=dotxt2.getText();
        currentTemplate.outputnames[2]=dotxt3.getText();
        currentTemplate.outputnames[3]=dotxt4.getText();
      
        inDevices.get(0).name=ditxt1.getText();
        inDevices.get(1).name=ditxt2.getText();
        inDevices.get(2).name=ditxt3.getText();
        inDevices.get(3).name=ditxt4.getText();
         
        docbx1.repaint();
        docbx2.repaint();
        docbx3.repaint();
        docbx4.repaint();
    }
    
    private void fillDeviceDescriptions()
    {
        inDevices.clear();
        inDevices.add(new StringClass(ditxt1.getText(),Input.I1));
        inDevices.add(new StringClass(ditxt2.getText(),Input.I2));
        inDevices.add(new StringClass(ditxt3.getText(),Input.I3));
        inDevices.add(new StringClass(ditxt4.getText(),Input.I4));
        
        Helper.clerAndFillCombo(docbx1, inDevices);
        Helper.clerAndFillCombo(docbx2, inDevices);
        Helper.clerAndFillCombo(docbx3, inDevices);
        Helper.clerAndFillCombo(docbx4, inDevices);
        
        docbx2.setSelectedIndex(1);
        docbx3.setSelectedIndex(2);
        docbx4.setSelectedIndex(3);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeviceOut1 = new javax.swing.JPanel();
        docbx1 = new javax.swing.JComboBox<>();
        dotxt1 = new javax.swing.JTextField();
        DeviceIn1 = new javax.swing.JPanel();
        ditxt1 = new javax.swing.JTextField();
        DeviceIn2 = new javax.swing.JPanel();
        ditxt2 = new javax.swing.JTextField();
        DeviceIn3 = new javax.swing.JPanel();
        ditxt3 = new javax.swing.JTextField();
        DeviceIn4 = new javax.swing.JPanel();
        ditxt4 = new javax.swing.JTextField();
        DeviceOut2 = new javax.swing.JPanel();
        docbx2 = new javax.swing.JComboBox<>();
        dotxt2 = new javax.swing.JTextField();
        DeviceOut3 = new javax.swing.JPanel();
        docbx3 = new javax.swing.JComboBox<>();
        dotxt3 = new javax.swing.JTextField();
        DeviceOut4 = new javax.swing.JPanel();
        docbx4 = new javax.swing.JComboBox<>();
        dotxt4 = new javax.swing.JTextField();
        cbxapplychanges = new javax.swing.JCheckBox();
        btnapply = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTemplateName = new javax.swing.JTextField();
        btnCreateTemplate = new javax.swing.JButton();
        cbxApplyOnTemplateClick = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbxTemplates = new javax.swing.JList<>();
        savetemplate = new javax.swing.JButton();
        lbltemplate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setName("JPanel1"); // NOI18N
        setPreferredSize(new java.awt.Dimension(821, 700));

        DeviceOut1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        docbx1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dotxt1.setText("Device OUT 1");

        javax.swing.GroupLayout DeviceOut1Layout = new javax.swing.GroupLayout(DeviceOut1);
        DeviceOut1.setLayout(DeviceOut1Layout);
        DeviceOut1Layout.setHorizontalGroup(
            DeviceOut1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docbx1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeviceOut1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dotxt1)
                .addContainerGap())
        );
        DeviceOut1Layout.setVerticalGroup(
            DeviceOut1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceOut1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dotxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docbx1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DeviceIn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeviceIn1.setPreferredSize(new java.awt.Dimension(242, 60));

        ditxt1.setText("Device IN 1");

        javax.swing.GroupLayout DeviceIn1Layout = new javax.swing.GroupLayout(DeviceIn1);
        DeviceIn1.setLayout(DeviceIn1Layout);
        DeviceIn1Layout.setHorizontalGroup(
            DeviceIn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceIn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeviceIn1Layout.setVerticalGroup(
            DeviceIn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceIn1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        DeviceIn2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeviceIn2.setPreferredSize(new java.awt.Dimension(242, 60));

        ditxt2.setText("Device IN 2");

        javax.swing.GroupLayout DeviceIn2Layout = new javax.swing.GroupLayout(DeviceIn2);
        DeviceIn2.setLayout(DeviceIn2Layout);
        DeviceIn2Layout.setHorizontalGroup(
            DeviceIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceIn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeviceIn2Layout.setVerticalGroup(
            DeviceIn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceIn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        DeviceIn3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeviceIn3.setPreferredSize(new java.awt.Dimension(242, 60));

        ditxt3.setText("Device IN 3");

        javax.swing.GroupLayout DeviceIn3Layout = new javax.swing.GroupLayout(DeviceIn3);
        DeviceIn3.setLayout(DeviceIn3Layout);
        DeviceIn3Layout.setHorizontalGroup(
            DeviceIn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceIn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeviceIn3Layout.setVerticalGroup(
            DeviceIn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceIn3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        DeviceIn4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeviceIn4.setPreferredSize(new java.awt.Dimension(242, 60));

        ditxt4.setText("Device IN 4");

        javax.swing.GroupLayout DeviceIn4Layout = new javax.swing.GroupLayout(DeviceIn4);
        DeviceIn4.setLayout(DeviceIn4Layout);
        DeviceIn4Layout.setHorizontalGroup(
            DeviceIn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeviceIn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt4, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeviceIn4Layout.setVerticalGroup(
            DeviceIn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceIn4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ditxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        DeviceOut2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        docbx2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dotxt2.setText("Device OUT 2");

        javax.swing.GroupLayout DeviceOut2Layout = new javax.swing.GroupLayout(DeviceOut2);
        DeviceOut2.setLayout(DeviceOut2Layout);
        DeviceOut2Layout.setHorizontalGroup(
            DeviceOut2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docbx2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeviceOut2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dotxt2)
                .addContainerGap())
        );
        DeviceOut2Layout.setVerticalGroup(
            DeviceOut2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceOut2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dotxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docbx2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DeviceOut3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        docbx3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dotxt3.setText("Device OUT 3");

        javax.swing.GroupLayout DeviceOut3Layout = new javax.swing.GroupLayout(DeviceOut3);
        DeviceOut3.setLayout(DeviceOut3Layout);
        DeviceOut3Layout.setHorizontalGroup(
            DeviceOut3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docbx3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeviceOut3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dotxt3)
                .addContainerGap())
        );
        DeviceOut3Layout.setVerticalGroup(
            DeviceOut3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceOut3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dotxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docbx3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DeviceOut4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        docbx4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dotxt4.setText("Device OUT 4");

        javax.swing.GroupLayout DeviceOut4Layout = new javax.swing.GroupLayout(DeviceOut4);
        DeviceOut4.setLayout(DeviceOut4Layout);
        DeviceOut4Layout.setHorizontalGroup(
            DeviceOut4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(docbx4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeviceOut4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dotxt4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        DeviceOut4Layout.setVerticalGroup(
            DeviceOut4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeviceOut4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dotxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(docbx4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbxapplychanges.setLabel("Send Changes on Template to Matrix instantly");
        cbxapplychanges.setName("applyinstant"); // NOI18N
        cbxapplychanges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxapplychangesMouseClicked(evt);
            }
        });

        btnapply.setText("Send changes to Matrix!");
        btnapply.setActionCommand("Send changes to Matrix!");
        btnapply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapplyActionPerformed(evt);
            }
        });

        jLabel1.setText("Templates");

        txtTemplateName.setText("Template name");

        btnCreateTemplate.setText("Create current state as Template");
        btnCreateTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTemplateActionPerformed(evt);
            }
        });

        cbxApplyOnTemplateClick.setLabel("Send changes to Matrix when a template is selected");
        cbxApplyOnTemplateClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxApplyOnTemplateClickMouseClicked(evt);
            }
        });

        lbxTemplates.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lbxTemplates);

        savetemplate.setText("Save changes on template");
        savetemplate.setEnabled(false);
        savetemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetemplateActionPerformed(evt);
            }
        });

        lbltemplate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltemplate.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxApplyOnTemplateClick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTemplateName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateTemplate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(savetemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DeviceOut1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeviceOut2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeviceOut3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeviceOut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DeviceIn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeviceIn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeviceIn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DeviceIn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxapplychanges)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnapply)))
                        .addContainerGap())
                    .addComponent(lbltemplate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbltemplate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(DeviceIn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(DeviceIn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(DeviceIn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(DeviceIn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeviceOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeviceOut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeviceOut3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeviceOut4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemplateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateTemplate)
                    .addComponent(savetemplate))
                .addGap(18, 18, 18)
                .addComponent(cbxApplyOnTemplateClick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxapplychanges)
                    .addComponent(btnapply))
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnapplyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnapplyActionPerformed
    {//GEN-HEADEREND:event_btnapplyActionPerformed
        applystates();
    }//GEN-LAST:event_btnapplyActionPerformed

    private void btnCreateTemplateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCreateTemplateActionPerformed
    {//GEN-HEADEREND:event_btnCreateTemplateActionPerformed
        StringClass out1=(StringClass)docbx1.getSelectedItem();
        StringClass out2=(StringClass)docbx2.getSelectedItem();
        StringClass out3=(StringClass)docbx3.getSelectedItem();
        StringClass out4=(StringClass)docbx4.getSelectedItem();
        
        String templateName=txtTemplateName.getText();
        if (templateName!=null && !templateName.isEmpty())
        {
           Template t = new Template(templateName);
           t.inputnames[0]=ditxt1.getText();
           t.inputnames[1]=ditxt2.getText();
           t.inputnames[2]=ditxt3.getText();
           t.inputnames[3]=ditxt4.getText();
           
           t.outputnames[0]=dotxt1.getText();
           t.outputnames[1]=dotxt2.getText();
           t.outputnames[2]=dotxt3.getText();
           t.outputnames[3]=dotxt4.getText();
           
           t.inputs[0]=out1.input;
           t.inputs[1]=out2.input;
           t.inputs[2]=out3.input;
           t.inputs[3]=out4.input;
        
           
           Options.get().templates.put(templateName, t);
           
           reloadTemplateList();
        }
    }//GEN-LAST:event_btnCreateTemplateActionPerformed

    private void cbxApplyOnTemplateClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxApplyOnTemplateClickMouseClicked
        Options.get().applyontemplateselect=cbxApplyOnTemplateClick.isSelected();
    }//GEN-LAST:event_cbxApplyOnTemplateClickMouseClicked

    private void cbxapplychangesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxapplychangesMouseClicked
        Options.get().applyinstantly=cbxapplychanges.isSelected();
    }//GEN-LAST:event_cbxapplychangesMouseClicked

    private void savetemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetemplateActionPerformed
        
        StringClass out1=(StringClass)docbx1.getSelectedItem();
        StringClass out2=(StringClass)docbx2.getSelectedItem();
        StringClass out3=(StringClass)docbx3.getSelectedItem();
        StringClass out4=(StringClass)docbx4.getSelectedItem();

        String templateName=lbxTemplates.getSelectedValue();
        if (currentTemplate!=null && templateName!=null && !templateName.isEmpty())
        {
           Template t = new Template(templateName);
           t.inputnames[0]=ditxt1.getText();
           t.inputnames[1]=ditxt2.getText();
           t.inputnames[2]=ditxt3.getText();
           t.inputnames[3]=ditxt4.getText();
           
           t.outputnames[0]=dotxt1.getText();
           t.outputnames[1]=dotxt2.getText();
           t.outputnames[2]=dotxt3.getText();
           t.outputnames[3]=dotxt4.getText();
           
           t.inputs[0]=out1.input;
           t.inputs[1]=out2.input;
           t.inputs[2]=out3.input;
           t.inputs[3]=out4.input;
           
           Options.get().templates.put(templateName, t);

           savetemplate.setEnabled(false);
        }
    }//GEN-LAST:event_savetemplateActionPerformed

    private void deleteSelectedTemplate()
    {
        int lasIndex=lbxTemplates.getSelectedIndex();
        String val=lbxTemplates.getSelectedValue();
        if (val!=null && !val.isEmpty())
        {
            HashMap<String,Template> l =Options.get().templates;
            if (l.containsKey(val))
            {
                l.remove(val);
            }
            lbxTemplatesModel.removeElement(val);
            if (lasIndex<lbxTemplates.getModel().getSize())
            {
                lbxTemplates.setSelectedIndex(lasIndex);
            }
            else if(lasIndex>lbxTemplates.getModel().getSize()-1 && lbxTemplates.getModel().getSize()>0)
            {
                lbxTemplates.setSelectedIndex(lbxTemplates.getModel().getSize()-1);
            } 
            else if (lbxTemplates.getModel().getSize()>0)
            {
                lbxTemplates.setSelectedIndex(0);
            }
            
            if (lbxTemplates.getModel().getSize()==0)
            {
                setTemplateData(new Template(null));
            }
        }
    }
    
    private void reloadTemplateList()
    {
        lbxTemplatesModel.removeAllElements();
        HashMap<String,Template> l =Options.get().templates;
        
        for(Template t: l.values())
        {
            lbxTemplatesModel.addElement(t.templateName);
        }      
    }
    
    
    private void applystates()
    {
        StringClass out1=(StringClass)docbx1.getSelectedItem();
        StringClass out2=(StringClass)docbx2.getSelectedItem();
        StringClass out3=(StringClass)docbx3.getSelectedItem();
        StringClass out4=(StringClass)docbx4.getSelectedItem();
        
        HashMap<Output,Input> status= MatrixHelper.getIOStatus();
        if (status!=null)
        {
            if (!status.get(Output.A).equals(out1.input)){MatrixHelper.setMatrixPort(Output.A, out1.input, true);}
            if (!status.get(Output.B).equals(out2.input)){MatrixHelper.setMatrixPort(Output.B, out2.input, true);}
            if (!status.get(Output.C).equals(out3.input)){MatrixHelper.setMatrixPort(Output.C, out3.input, true);}
            if (!status.get(Output.D).equals(out4.input)){MatrixHelper.setMatrixPort(Output.D, out4.input, true);}
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DeviceIn1;
    private javax.swing.JPanel DeviceIn2;
    private javax.swing.JPanel DeviceIn3;
    private javax.swing.JPanel DeviceIn4;
    private javax.swing.JPanel DeviceOut1;
    private javax.swing.JPanel DeviceOut2;
    private javax.swing.JPanel DeviceOut3;
    private javax.swing.JPanel DeviceOut4;
    private javax.swing.JButton btnCreateTemplate;
    private javax.swing.JButton btnapply;
    private javax.swing.JCheckBox cbxApplyOnTemplateClick;
    private javax.swing.JCheckBox cbxapplychanges;
    private javax.swing.JTextField ditxt1;
    private javax.swing.JTextField ditxt2;
    private javax.swing.JTextField ditxt3;
    private javax.swing.JTextField ditxt4;
    private javax.swing.JComboBox<String> docbx1;
    private javax.swing.JComboBox<String> docbx2;
    private javax.swing.JComboBox<String> docbx3;
    private javax.swing.JComboBox<String> docbx4;
    private javax.swing.JTextField dotxt1;
    private javax.swing.JTextField dotxt2;
    private javax.swing.JTextField dotxt3;
    private javax.swing.JTextField dotxt4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltemplate;
    private javax.swing.JList<String> lbxTemplates;
    private javax.swing.JButton savetemplate;
    private javax.swing.JTextField txtTemplateName;
    // End of variables declaration//GEN-END:variables
}
