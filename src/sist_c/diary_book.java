/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sist_c;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hp_ProBook_11-G2
 */
public class diary_book extends javax.swing.JInternalFrame {
    DefaultTableModel dtm1 = null;
    DefaultTableModel dtm2 = null;
    raw_acounts qs = new raw_acounts();
    raw_diary_book db_ = new raw_diary_book();
    raw_diary_book_moves dbm_ = new raw_diary_book_moves();
    List<obj_acounts> ls = qs.get_all();
    List<obj_dbm> mv_ = new ArrayList<>();
    int id_actual;
    /**
     * Creates new form diary_book
     */
    public diary_book() {
        initComponents();
        
        fill_table_1(ls, "");
        fill_table_2();
    }
     void fill_table_1(List<obj_acounts> acs, String sub_){
        dtm1 = new DefaultTableModel();
        String[] cols = new String[]{"Codigo", "Descripcion"};
        dtm1.setColumnIdentifiers(cols);
        tb_acounts.setModel(dtm1);
        for(obj_acounts acs_: acs){
            if(acs_.getDescription().toLowerCase().contains(sub_.toLowerCase())){
                dtm1.addRow(new Object[]{
                    acs_.getId(),
                    acs_.getDescription()
                });
            }
        }
    }
    void fill_table_2(){
        dtm2 = new DefaultTableModel();
        String[] cols = new String[]{"Cuenta Nº", "Descripcion", "DEBE", "HABER"};
        dtm2.setColumnIdentifiers(cols);
        tb_moves.setModel(dtm2);
        double debe = 0;
        double haber = 0;
        double debet = 0;
        double habert = 0;
        for(obj_dbm item: mv_){
            if(item.isType() == 0){
                debe = item.getAmount();
                haber = 0;
                
            }else{
                debe = 0;
                haber = item.getAmount();
            }
            dtm2.addRow(new Object[]{
                item.getId_acount(),
                item.getDescription(),
                debe,
                haber                
            });
            debet = debet + debe;
            habert = habert + haber;
        }
        lbl_debe.setText(String.valueOf(debet));
        lbl_haber.setText(String.valueOf(habert));
        if(debet == habert && (debet + habert) != 0){
            btn_grabar.setEnabled(true);
        }else{
            btn_grabar.setEnabled(false);
        }
    }
    
    void limpiar(){
        id_actual = -1;
        btn_add.setEnabled(false);
        btn_grabar.setEnabled(false);
        fill_table_2();
        fill_table_1(ls, "");
        txt_code.setText("");
        txt_name.setText("");
        txt_amount.setText("");
        txt_description.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_code = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_acounts = new javax.swing.JTable();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox<>();
        txt_amount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_del = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_debe1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        lbl_haber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_debe = new javax.swing.JLabel();
        btn_grabar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_moves = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(900, 450));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txt_code.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txt_code.setForeground(new java.awt.Color(0, 51, 102));
        txt_code.setToolTipText("codigo");
        txt_code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_code.setName("code"); // NOI18N
        txt_code.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txt_codeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txt_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codeKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Codigo de la cuenta");

        tb_acounts.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tb_acounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tb_acounts);

        txt_name.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(0, 51, 102));
        txt_name.setToolTipText("Nombre de cuenta");
        txt_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar por nombre");

        jLabel7.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Codigo");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Datos de entrada");

        cb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEBE", "HABER" }));
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });

        txt_amount.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txt_amount.setForeground(new java.awt.Color(0, 51, 102));
        txt_amount.setToolTipText("Nombre de cuenta");
        txt_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Monto");

        btn_add.setForeground(new java.awt.Color(0, 51, 102));
        btn_add.setText("Agregar movimiento");
        btn_add.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_add.setEnabled(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Columna afectada");

        jLabel11.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tipo de cuenta");

        lbl_type.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbl_type.setForeground(new java.awt.Color(255, 255, 255));
        lbl_type.setText("---");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Eliminar");

        jLabel14.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Numero de lista");

        txt_del.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txt_del.setForeground(new java.awt.Color(0, 51, 102));
        txt_del.setToolTipText("codigo");
        txt_del.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        txt_del.setName("code"); // NOI18N
        txt_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_delActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(0, 51, 102));
        jButton3.setText("Remover");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Datos de entrada");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cargar comprobante");

        jLabel4.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6))
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_name))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addGap(5, 5, 5))
                    .addComponent(jLabel10)
                    .addComponent(lbl_type))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_amount)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_del, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_type, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txt_del, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 180));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Registro de transacciones");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbl_debe1.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lbl_debe1.setForeground(new java.awt.Color(0, 51, 102));
        lbl_debe1.setText("$............");
        jPanel2.add(lbl_debe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Razon de movimiento diario: ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, -1));

        txt_description.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_description.setForeground(new java.awt.Color(0, 51, 102));
        txt_description.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        jPanel2.add(txt_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 510, 30));

        lbl_haber.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lbl_haber.setForeground(new java.awt.Color(0, 51, 102));
        lbl_haber.setText("00.00");
        jPanel2.add(lbl_haber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 50, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Balance actual...");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        lbl_debe.setFont(new java.awt.Font("SansSerif", 3, 16)); // NOI18N
        lbl_debe.setForeground(new java.awt.Color(0, 51, 102));
        lbl_debe.setText("00.00");
        jPanel2.add(lbl_debe, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 50, -1));

        btn_grabar.setBackground(new java.awt.Color(0, 51, 102));
        btn_grabar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btn_grabar.setForeground(new java.awt.Color(255, 255, 255));
        btn_grabar.setText("Grabar cambios");
        btn_grabar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102)));
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_grabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, 130, 30));

        tb_moves.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tb_moves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_moves);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 860, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        // TODO add your handling code here:
        if(txt_description.getText().length() <= 10){
            JOptionPane.showMessageDialog(null, "Agregue una descripcion como minimo de 10 caracteres");
            return;
        }
        if(jdate.getDate() == null){
            JOptionPane.showMessageDialog(null, "Seleccione la fecha para grabar los datos");
            return;
        }
        obj_diary_book obj_ = new obj_diary_book();
        obj_.setDescription(txt_description.getText());
        obj_.setDate(jdate.getDate().toString());
        int code__ = db_.set(obj_);
        int id_ = db_.getByCode(code__).getId();
        //insertar movimientos individuales
        for(obj_dbm dbm: mv_){
            System.out.println("ª_");
            dbm_.set(dbm, id_);
        }
        mv_ = new ArrayList<>();
        limpiar();

    }//GEN-LAST:event_btn_grabarActionPerformed

    private void txt_codeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txt_codeAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codeAncestorAdded

    private void txt_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codeKeyReleased
        // TODO add your handling code here:
        boolean dd = false;
        try{
            for(obj_acounts ac_: ls){
                if(Integer.parseInt(txt_code.getText()) == ac_.getId()){
                    id_actual = ac_.getId();
                    txt_name.setText(ac_.getDescription());
                    lbl_type.setText(ac_.getType());
                    dd = true;
                    btn_add.setEnabled(true);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        if(dd == false){
            id_actual = -1;
            txt_name.setText("");
            lbl_type.setText("");
            btn_add.setEnabled(false);
        }

    }//GEN-LAST:event_txt_codeKeyReleased

    private void txt_codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codeKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_codeKeyTyped

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        // TODO add your handling code here:
        fill_table_1(ls, txt_name.getText());
    }//GEN-LAST:event_txt_nameKeyPressed

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_typeActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        obj_dbm book_ = new obj_dbm();
        try{
            book_.setId_acount(Integer.parseInt( txt_code.getText()));
            book_.setType((cb_type.getSelectedIndex()));
            book_.setAmount(Double.parseDouble(txt_amount.getText()));
            book_.setDescription(txt_name.getText());
            mv_.add(book_);
            limpiar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique los datos ingresados" + e);
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_delActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_delActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            mv_.remove(Integer.parseInt(txt_del.getText()) + 1);
            fill_table_2();
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Registro no encontrado");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_grabar;
    private javax.swing.JComboBox<String> cb_type;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JLabel lbl_debe;
    private javax.swing.JLabel lbl_debe1;
    private javax.swing.JLabel lbl_haber;
    private javax.swing.JLabel lbl_type;
    private javax.swing.JTable tb_acounts;
    private javax.swing.JTable tb_moves;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_del;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
