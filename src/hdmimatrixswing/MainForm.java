//created by Targor https://github.com/targor/lwgo_6518868_reverseEngineered

package hdmimatrixswing;

import java.awt.Color;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainForm extends javax.swing.JFrame
{

    IOSelection jp1= new IOSelection();
    EEIDEditor jp2= new EEIDEditor();
    public static MainForm instance=null;

    public MainForm()
    {
        initComponents();
        instance=this;
        
        Options.get();
        
        reloadCOMDevices();
  
        TabPane1.setVisible(true);
        TabPane1.addTab("IOSelection", jp1);
        TabPane1.addTab("EEID editor", jp2);
        
        btnTemplateMode.setEnabled(false);
        
        
        TabPane1.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (TabPane1.getTitleAt(TabPane1.getSelectedIndex()).equals(("IOSelection")))
                {
                    MatrixHelper.setChannelSeletion();
                }
                else if (TabPane1.getTitleAt(TabPane1.getSelectedIndex()).equals(("EEID editor")))
                {
                    MatrixHelper.setEDIDSelection();
                }
            }
        });
    }
    
    private boolean refreshing=false;
    private void reloadCOMDevices()
    {
        refreshing=true;
        
        // put list of serial adapters into the combo box
        String[] list=jssc.SerialPortList.getPortNames();
                
        combo1.removeAllItems();
        if (list!=null && list.length>0)
        {
            for (String str: list)
            {
                StringClass sc =new StringClass(str,str);
                combo1.addItem(sc);
            }
            btnConnect.setEnabled(true);
            
            for (int i=0;i<combo1.getModel().getSize();i++)
            {
                if (combo1.getItemAt(i).type.equals(Options.get().currentPort))
                {
                    combo1.setSelectedIndex(i);
                    break;
                }
            }
           
            
        }
        else
        {
            StringClass sc =new StringClass("No entries available, maybe you have no SERIAL port, or none is connected.");
            combo1.addItem(sc);
            btnConnect.setEnabled(false);
        }
        refreshing=false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPane1 = new javax.swing.JTabbedPane();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        btnConnect = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnTemplateMode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HDMI Matrix Control for Liwago 6518868 by Sentcool");
        setPreferredSize(new java.awt.Dimension(1024, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TabPane1.setName("TabPanel1"); // NOI18N

        jLabel1.setText("Select Connection Interface");

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>());
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        btnConnect.setText("Test connection");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        btnTemplateMode.setText("TemplateMode");
        btnTemplateMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemplateModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo1, 0, 609, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTemplateMode)
                .addContainerGap())
            .addComponent(TabPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo1)
                        .addComponent(btnConnect)
                        .addComponent(btnReload)
                        .addComponent(btnTemplateMode))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnConnectActionPerformed
    {//GEN-HEADEREND:event_btnConnectActionPerformed
        
       btnConnect.setEnabled(false);
       btnReload.setEnabled(false);
       combo1.setEnabled(false);
       if (RS232.ConnectionTest(Options.get().currentPort))
       {
           btnConnect.setBackground(Color.green);
           TabPane1.setVisible(true);
           btnTemplateMode.setEnabled(true);
       }
       else
       {
           btnConnect.setBackground(Color.red);
           TabPane1.setVisible(false);
           btnTemplateMode.setEnabled(false);

       }
       
       btnConnect.setEnabled(true);
       btnReload.setEnabled(true);
       combo1.setEnabled(true);
    }//GEN-LAST:event_btnConnectActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_combo1ActionPerformed
    {//GEN-HEADEREND:event_combo1ActionPerformed
        if (!refreshing && combo1.getSelectedItem()!=null)
        {
            String type=((StringClass)combo1.getSelectedItem()).type;
            if (type!=null)
            {
                Options.get().currentPort=type;
                btnConnect.setBackground(new Color(128,128,128));
            }
        }
    }//GEN-LAST:event_combo1ActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnReloadActionPerformed
    {//GEN-HEADEREND:event_btnReloadActionPerformed
        reloadCOMDevices();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        Options.save();
    }//GEN-LAST:event_formWindowClosing

    private void btnTemplateModeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTemplateModeActionPerformed
    {//GEN-HEADEREND:event_btnTemplateModeActionPerformed
        TemplateView tv = new TemplateView();
        tv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTemplateModeActionPerformed

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainForm().setVisible(true);
            }
        });
      
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabPane1;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnTemplateMode;
    private javax.swing.JComboBox<StringClass> combo1;
    // End of variables declaration//GEN-END:variables
}
