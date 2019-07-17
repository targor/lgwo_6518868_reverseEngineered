package hdmimatrixswing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TemplateView extends javax.swing.JFrame
{
     DefaultListModel<String> lbxTemplatesModel = new DefaultListModel<>();

    public TemplateView()
    {
        initComponents();
        
        lbxTemplates.setModel(lbxTemplatesModel);
        
        lbxTemplates.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String val=lbxTemplates.getSelectedValue();
                if (val!=null && !val.isEmpty())
                {
                    if (Options.get().templates.containsKey(val))
                    {
                        Template t = Options.get().templates.get(val);

                        HashMap<MatrixHelper.Output,MatrixHelper.Input> status= MatrixHelper.getIOStatus();
                        if (status!=null)
                        {
                            if (!status.get(MatrixHelper.Output.A).equals(t.inputs[0])){MatrixHelper.setMatrixPort(MatrixHelper.Output.A, t.inputs[0], true);}
                            if (!status.get(MatrixHelper.Output.B).equals(t.inputs[1])){MatrixHelper.setMatrixPort(MatrixHelper.Output.B, t.inputs[1], true);}
                            if (!status.get(MatrixHelper.Output.C).equals(t.inputs[2])){MatrixHelper.setMatrixPort(MatrixHelper.Output.C, t.inputs[2], true);}
                            if (!status.get(MatrixHelper.Output.D).equals(t.inputs[3])){MatrixHelper.setMatrixPort(MatrixHelper.Output.D, t.inputs[3], true);}
                        }

                    }
                }
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
               
            }
        });
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        lbxTemplates = new javax.swing.JList<>();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        lbxTemplates.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lbxTemplates);

        btnBack.setText("Back to normal mode");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
       MainForm.instance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        MainForm.instance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TemplateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TemplateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TemplateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TemplateView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TemplateView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lbxTemplates;
    // End of variables declaration//GEN-END:variables
}
