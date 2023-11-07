/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sist_c;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp_ProBook_11-G2
 */
public class statistics extends javax.swing.JInternalFrame {
    DefaultTableModel dtml = null;
    raw_acounts raw_ac = new raw_acounts();
    raw_diary_book raw_db = new raw_diary_book();
    raw_diary_book_moves raw_dbm = new raw_diary_book_moves();
    List<obj_diary_book> db_l = new ArrayList<>();
    List<obj_acounts> ls = new ArrayList<>();
    List<obj_dbm> mv_ = new ArrayList<>();
    List<obj_acounts> actual_acounts = new ArrayList<>();
    List<String> type_acounts = new ArrayList<>();
    /**
     * Creates new form statistics
     */
    public statistics() {
        initComponents();
    }
    void fill_table_1(){
        dtml = new DefaultTableModel();
        String[] cols = new String[]{"Cuenta Nº", "Descripcion", "DEBE", "HABER"};
        dtml.setColumnIdentifiers(cols);
        tb_moves.setModel(dtml);
        double debe = 0;
        double haber = 0;
        double debet = 0;
        double habert = 0;
        for(obj_diary_book item_: db_l){
            for(obj_dbm item: item_.getMoves()){
                if(item.isType() == 0){
                    debe = item.getAmount();
                    haber = 0;

                }else{
                    debe = 0;
                    haber = item.getAmount();
                }
                dtml.addRow(new Object[]{
                    item.getId_acount(),
                    "   " + item.getDescription(),
                    debe,
                    haber                
                });
                debet = debet + debe;
                habert = habert + haber;
            }
            dtml.addRow(new Object[]{
                    "",
                    item_.getDescription(),
                    "",
                    ""                
                });
            
        }
        txt_debe.setText(String.valueOf(debet));
        txt_haber.setText(String.valueOf(habert));
    }
    void fill_table_2(){
        dtml = new DefaultTableModel();
        String[] cols = new String[]{"Cuenta Nº", "Descripcion", "ACTIVO", "PASIVO o PATRIMONIO"};
        String[] debe_ = new String[]{"Activo", "Cuentas de resultados deudoras (gastos)", "Cuentas complementarias de activo"};
        String order_ac = "Cuentas de orden";
        List<obj_acounts> orderer_ac = new ArrayList<>();
        dtml.setColumnIdentifiers(cols);
        tb_balance.setModel(dtml);
        double debe = 0;
        double haber = 0;
        double debet = 0;
        double habert = 0;
        List<obj_dbm> obj_f = new ArrayList<>();
        
        for(obj_acounts obac: actual_acounts){
            obj_dbm da_ = new obj_dbm();
            da_.setDescription(obac.getDescription());
            da_.setId_acount(obac.getId());
            da_.setAcount_type(obac.getType());
            for(obj_diary_book db_or: db_l){
                for(obj_dbm bdbm: db_or.getMoves() ){
                    if(bdbm.getId_acount() == obac.getId()){
                        da_.setType(bdbm.isType());
                         if(bdbm.isType() == 0){
                             da_.sum(bdbm.getAmount());
                         }else{
                             da_.sum(-(bdbm.getAmount()));
                         }
                    }
                }
            }
            obj_f.add(da_);
        }
        for(obj_dbm item: obj_f){
        System.out.print(item.getAmount());
            if(item.getAcount_type().contains(debe_[0]) || item.getAcount_type().contains(debe_[1]) || item.getAcount_type().contains(debe_[2])){
                debe = item.getAmount();
                haber = 0;
            }else{
                debe = 0;
                haber = item.getAmount();
            }
            if(item.getAcount_type().contains(order_ac)){
                if(item.isType() == 0){
                    debe = item.getAmount();
                    haber = 0;
                }else{
                    debe = 0;
                    haber = item.getAmount() * -1;
                }
            }
            
                dtml.addRow(new Object[]{
                    item.getId_acount(),
                    "   " + item.getDescription(),
                    debe,
                    haber                
                });
                debet = debet + debe;
                habert = habert + haber;
            }
        txt_debe2.setText(String.valueOf(debet));
        txt_haber2.setText(String.valueOf(habert));
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_moves = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        txt_haber = new javax.swing.JTextField();
        txt_debe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Scroll1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_balance = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        txt_haber2 = new javax.swing.JTextField();
        txt_debe2 = new javax.swing.JTextField();
        jdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(880, 450));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Revision de cuentas");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Fecha");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro general de libro diario");

        tb_moves.setForeground(new java.awt.Color(0, 51, 102));
        tb_moves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Description", "Debe", "Haber"
            }
        ));
        tb_moves.setFocusable(false);
        tb_moves.setUpdateSelectionOnSort(false);
        tb_moves.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(tb_moves);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 51, 102));
        jTextField1.setText("BALANCE TOTAL");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jTextField1.setFocusable(false);

        txt_haber.setEditable(false);
        txt_haber.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txt_haber.setForeground(new java.awt.Color(0, 51, 102));
        txt_haber.setText("---");
        txt_haber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_haber.setFocusable(false);
        txt_haber.setRequestFocusEnabled(false);

        txt_debe.setEditable(false);
        txt_debe.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txt_debe.setForeground(new java.awt.Color(0, 51, 102));
        txt_debe.setText("---");
        txt_debe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_debe.setFocusable(false);
        txt_debe.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_debe, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_haber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_haber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_debe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Libro diario", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registro general de cuentas en uso");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Scroll1.setForeground(new java.awt.Color(0, 51, 102));
        Scroll1.setFocusable(false);
        Scroll1.setRequestFocusEnabled(false);
        Scroll1.setVerifyInputWhenFocusTarget(false);
        Scroll1.setLayout(new java.awt.GridLayout(0, 2));
        jScrollPane2.setViewportView(Scroll1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 610, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cuentas", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));

        jLabel4.setFont(new java.awt.Font("SansSerif", 2, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Balance general");

        tb_balance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Description", "Debe", "Haber"
            }
        ));
        tb_balance.setFocusable(false);
        jScrollPane3.setViewportView(tb_balance);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 51, 102));
        jTextField2.setText("BALANCE TOTAL");
        jTextField2.setToolTipText("");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jTextField2.setFocusable(false);
        jTextField2.setOpaque(true);
        jTextField2.setRequestFocusEnabled(false);

        txt_haber2.setEditable(false);
        txt_haber2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txt_haber2.setForeground(new java.awt.Color(0, 51, 102));
        txt_haber2.setText("---");
        txt_haber2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_haber2.setFocusable(false);
        txt_haber2.setOpaque(true);
        txt_haber2.setRequestFocusEnabled(false);
        txt_haber2.setSelectionColor(new java.awt.Color(0, 51, 102));

        txt_debe2.setEditable(false);
        txt_debe2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        txt_debe2.setForeground(new java.awt.Color(0, 51, 102));
        txt_debe2.setText("---");
        txt_debe2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_debe2.setFocusable(false);
        txt_debe2.setOpaque(true);
        txt_debe2.setRequestFocusEnabled(false);
        txt_debe2.setSelectionColor(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_debe2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_haber2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_haber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_debe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );

        jTabbedPane1.addTab("Balance", jPanel3);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 880, 340));

        jdate.setBackground(new java.awt.Color(255, 255, 255));
        jdate.setForeground(new java.awt.Color(0, 51, 102));
        jPanel4.add(jdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 150, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recargar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void fill_major(){
        Scroll1.removeAll();
        int ct_t1= 0;
        int ct_t2 = 0;
        int count_ = 0;
        
        for(String str_tt: type_acounts){// recorrido de los tipos de cuentas para libro mayor
            JLabel title = new JLabel("# " + str_tt);
            Scroll1.add(title);
            count_++;
            JLabel title2 = new JLabel("############################");
            Scroll1.add(title2);
            count_++;
            
            for(obj_acounts ac_ac: actual_acounts){
//recorrido de cuentas general
                if(ac_ac.getType().contains(str_tt) || str_tt.contains(ac_ac.getType())){
                    //si la cuenta corresponde al tipo de cuenta actual
                    JPanel panel = new JPanel();
                    JLabel titlex = new JLabel(ac_ac.getDescription());
                    panel.add(titlex);
                    panel.setLayout(new java.awt.GridLayout(0, 1, 0, 0));
                    String [] names = {"Debe", "Haber"};
                    int size_ = 0;

                        int acx = 0;
                        List<obj_dbm> mv__ = raw_dbm.getByAc(ac_ac.getId());
                        for(obj_dbm dbm_: mv__){
                                acx++;
                        }
                        String [][] names2 = new String [acx+1][2];
                        names2[0][1] = "DEBE";
                        names2[0][0] = "HABER";
                    
                        for(obj_dbm dbm_: mv__){
                            if(ac_ac.getId() == dbm_.getId_acount()){
                                if(dbm_.isType() == 1){
                                    
                                    names2[acx][1] = Double.toString(dbm_.getAmount());
                                    names2[acx][0] = " ";
                                }else{
                                    
                                    names2[acx][1] = " ";
                                    names2[acx][0] = Double.toString(dbm_.getAmount());
                                }
                            }
                        }
                        //Creacion de la tabla a partir de array
                        DefaultTableModel mod  = new DefaultTableModel(names2,names);
                        JTable table = new JTable(mod);
                        panel.add(table);
                        Scroll1.add(panel);
                        count_++;
                    
                }
            }
            System.out.println(count_);
            if (count_%2 != 0){
                JLabel title3 = new JLabel("------");
                Scroll1.add(title3);
                count_++;
            }
        }
        Scroll1.updateUI();
    }
    
    private void get_names(){
        List<String> acounts_ = new ArrayList<>();
        String list = "";
        int cc = 0;
        int cc2 = 0;
        int cc3 = 1;
        boolean rs_cc = false;
        for(obj_diary_book obdb: db_l){
            cc2++;
            cc = obdb.getMoves().size();
            for(obj_dbm odbc_: obdb.getMoves()){
                rs_cc = true;
                if(!acounts_.contains(Integer.toString(odbc_.getId_acount()))){
                    if(cc3 != cc2 && rs_cc){
                        list = list + " or ";
                        cc3++;
                        rs_cc = false;
                    }
                    acounts_.add(Integer.toString(odbc_.getId_acount()));
                    list = list + "id='" +Integer.toString(odbc_.getId_acount()) + "'";
                    cc--;
                    if(0 < cc && rs_cc){
                        list = list + " or ";
                        rs_cc = false;
                    }
                }
            }    
        }
        actual_acounts = raw_ac.get_idList(list); 
        for(obj_acounts obj_ac: actual_acounts){
                if(!type_acounts.contains(obj_ac.getType())){
                    type_acounts.add(obj_ac.getType());
                }
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            db_l = raw_db.getByDate(jdate.getDate().toString());
            if(db_l == null){
                JOptionPane.showMessageDialog(null, "No hay datos registrados en esa fecha");
            }
            int counter = 0;
            for(obj_diary_book drb: db_l){
                db_l.get(counter).setMoves(raw_dbm.getByDB(drb));
                counter++;
            }
            fill_table_1();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar... " + e);
            return;
        }

        /**
        A partir de aqui se cargan las cuentas T del libro mayor
        */
        get_names();
        fill_major();

        /*
        A partir de aqui se carga el balance de comprobacion
        */
        fill_table_2();
        //JOptionPane.showMessageDialog(null, "Cargado correctamente");

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Scroll1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JTable tb_balance;
    private javax.swing.JTable tb_moves;
    private javax.swing.JTextField txt_debe;
    private javax.swing.JTextField txt_debe2;
    private javax.swing.JTextField txt_haber;
    private javax.swing.JTextField txt_haber2;
    // End of variables declaration//GEN-END:variables
}
