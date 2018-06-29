/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

/**
 * ShowPurchasedResourceDialog a dialog that show purchased resource
 * @author ChinWeiQIng
 */
public class ShowPurchasedResourceDialog extends javax.swing.JDialog {
    DengueFighter df;
    int week;
    
    /**
     * Creates new form ShowPurchasedResourceDialog
     * @param parent DTGUI
     * @param modal boolean
     */
    public ShowPurchasedResourceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        df = ((DTGUI)parent).getDengueFighter();
        week=df.getCurrentWeek();
        weekNo.setText(Integer.toString(week));

        if (week == 0)
        {
            display.setText("This week resource is not assign yet");
            preWeekBtn.setEnabled(false);
            nextWeekBtn.setEnabled(false);
        }else{
            String usedResource = df.showAllSiteResourceUsage(week);
            display.setText(usedResource); 
            nextWeekBtn.setEnabled(false);
    }
            
        
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        weekLabel = new javax.swing.JLabel();
        weekNo = new javax.swing.JLabel();
        preWeekBtn = new javax.swing.JButton();
        nextWeekBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resource Usage");
        setResizable(false);

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        weekLabel.setFont(new java.awt.Font("Charlemagne Std", 0, 18)); // NOI18N
        weekLabel.setText("Week:");

        weekNo.setFont(new java.awt.Font("Charlemagne Std", 0, 18)); // NOI18N
        weekNo.setText("x");

        preWeekBtn.setText("< Previous");
        preWeekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preWeekBtnActionPerformed(evt);
            }
        });

        nextWeekBtn.setText("Next >");
        nextWeekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextWeekBtnActionPerformed(evt);
            }
        });

        closeBtn.setText("Close");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(preWeekBtn)
                        .addGap(201, 201, 201)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(nextWeekBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(weekLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekLabel)
                    .addComponent(weekNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(preWeekBtn)
                        .addComponent(closeBtn))
                    .addComponent(nextWeekBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * go back to previous week and display the week purchased resource
     * @param evt 
     */
    private void preWeekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preWeekBtnActionPerformed
        // TODO add your handling code here:
        if((week-1)>=0)
        {
            week-=1;
            weekNo.setText(Integer.toString(week));
            String usedResource = df.showAllSiteResourceUsage(week);
            display.setText(usedResource);
            if (week == 0)
            {
                preWeekBtn.setEnabled(false);
            }       
            if(week+1<=df.getCurrentWeek())
                nextWeekBtn.setEnabled(true);
       }            
    }//GEN-LAST:event_preWeekBtnActionPerformed

    /**
     * dispose dialog
     * @param evt 
     */
    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    /**
     * go back to following week and display the week purchased resource
     * @param evt 
     */
    private void nextWeekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextWeekBtnActionPerformed
        // TODO add your handling code here:
        if((week+1)>=0)
        {
            week+=1;
            weekNo.setText(Integer.toString(week));
            String usedResource = df.showAllSiteResourceUsage(week);
            display.setText(usedResource);
            if (week == df.getCurrentWeek())
            {
                nextWeekBtn.setEnabled(false);
            }
            if(week-1>=0)
                preWeekBtn.setEnabled(true);
        }
    }//GEN-LAST:event_nextWeekBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ShowPurchasedResourceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowPurchasedResourceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowPurchasedResourceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowPurchasedResourceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowPurchasedResourceDialog dialog = new ShowPurchasedResourceDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextArea display;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextWeekBtn;
    private javax.swing.JButton preWeekBtn;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JLabel weekNo;
    // End of variables declaration//GEN-END:variables
}