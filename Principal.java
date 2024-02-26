/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.torrehanoi;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author suyan
 */
public class Principal extends javax.swing.JFrame {
    int ContNumMov=0;
    Pila PilaTorreA;
    Pila PilaTorreB;
    Pila PilaTorreC;
    Pila PilaTorreD;
    
    DefaultTableModel ModeloTablaTorreA,ModeloTablaTorreB,ModeloTablaTorreC,ModeloTablaTorreD;
    int Objetivo=0;
    double NumMinMov=0;
    boolean Stop=false;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        ModeloTablaTorreA= (DefaultTableModel) TorreA.getModel();
        ModeloTablaTorreA.setRowCount(10);
        
        ModeloTablaTorreB= (DefaultTableModel) TorreB.getModel();
        ModeloTablaTorreB.setRowCount(10);
        
        ModeloTablaTorreC= (DefaultTableModel) TorreC.getModel();
        ModeloTablaTorreC.setRowCount(10);
        
        ModeloTablaTorreD= (DefaultTableModel) TorreD.getModel();
        ModeloTablaTorreD.setRowCount(10);
        
        DefaultTableCellRenderer renderA=new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB=new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC=new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
        
        DefaultTableCellRenderer renderD=new DefaultTableCellRenderer();
        renderD.setHorizontalAlignment(SwingConstants.CENTER);
        TorreD.getColumnModel().getColumn(0).setCellRenderer(renderD);
    }
    private void Limpiar(){
        
        ContNumMov=0;
        NumMinMov=0;
        CBNumDisc.setSelectedItem(String.valueOf(Objetivo));
    }
    
    private void PresentarCantMov(){
        ContNumMov++;
        LblMov.setText(String.valueOf(ContNumMov));
    }
    private void Reiniciar(){
        try{
            if(!LblMinMov.getText().equals("")){
                
                Limpiar();
                Iniciar();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void Iniciar(){
        try{
            PilaTorreA =new Pila();
            PilaTorreB =new Pila();
            PilaTorreC =new Pila();
            PilaTorreD=new Pila();
            Objetivo=Integer.parseInt(CBNumDisc.getSelectedItem().toString());
            //Modificar esto para 4 torres
            NumMinMov= Math.pow(2,Objetivo)-1;
         

            LblMov.setText(String.valueOf(ContNumMov));
            LblMinMov.setText(String.valueOf(String.format("%.0f", NumMinMov)));

            for(int x=Objetivo;x>=1; x--){
                Nodo Plataforma=new Nodo();
                String Disco="";
                for(int y=x; y>0;y--){
                    Disco+="#";
                }
                Plataforma.setDato(Disco);
                PilaTorreA.Push(Plataforma);
            }
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarTorreD();
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    
    private void PresentarTorreA(){
        ((DefaultTableModel)TorreA.getModel()).setRowCount(0);
        ModeloTablaTorreA.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreA.getContNodo());
        if(PilaTorreA.getContNodo()>0){
            for(K=PilaTorreA.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreA.setModel(ModeloTablaTorreA);
        ModeloTablaTorreA.setRowCount(10);
    }
    
    private void PresentarTorreB(){
        ((DefaultTableModel)TorreB.getModel()).setRowCount(0);
        ModeloTablaTorreB.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreB.getContNodo());
        if(PilaTorreB.getContNodo()>0){
            for(K=PilaTorreB.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreB.setModel(ModeloTablaTorreB);
        ModeloTablaTorreB.setRowCount(10);
    }
    private void PresentarTorreC(){
        ((DefaultTableModel)TorreC.getModel()).setRowCount(0);
        ModeloTablaTorreC.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreC.getContNodo());
        if(PilaTorreC.getContNodo()>0){
            for(K=PilaTorreC.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreC.setModel(ModeloTablaTorreC);
        ModeloTablaTorreC.setRowCount(10);
    }
    private void PresentarTorreD(){
        ((DefaultTableModel)TorreD.getModel()).setRowCount(0);
        ModeloTablaTorreD.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreD.getContNodo());
        if(PilaTorreD.getContNodo()>0){
            for(K=PilaTorreD.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreD.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreD.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreD.setModel(ModeloTablaTorreD);
        ModeloTablaTorreD.setRowCount(10);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TorreC = new javax.swing.JTable();
        BtnA_B = new javax.swing.JButton();
        BtnA_C = new javax.swing.JButton();
        BtnB_A = new javax.swing.JButton();
        BtnB_C = new javax.swing.JButton();
        BtnC_A = new javax.swing.JButton();
        BtnC_B = new javax.swing.JButton();
        CBNumDisc = new javax.swing.JComboBox<>();
        LblMinMov = new javax.swing.JLabel();
        LblMov = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Iniciar = new javax.swing.JButton();
        Reiniciar = new javax.swing.JButton();
        Resolver = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TorreD = new javax.swing.JTable();
        BtnD_A = new javax.swing.JButton();
        BtnD_B = new javax.swing.JButton();
        BtnD_C = new javax.swing.JButton();
        BtnA_D = new javax.swing.JButton();
        BtnB_D = new javax.swing.JButton();
        BtnC_D = new javax.swing.JButton();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreB.setAutoscrolls(false);
        TorreB.setFocusable(false);
        TorreB.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreA.setAutoscrolls(false);
        TorreA.setFocusable(false);
        TorreA.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreC.setAutoscrolls(false);
        TorreC.setFocusable(false);
        TorreC.setRowSelectionAllowed(false);
        jScrollPane4.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnA_B.setText("B");
        BtnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_BActionPerformed(evt);
            }
        });

        BtnA_C.setText("C");
        BtnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_CActionPerformed(evt);
            }
        });

        BtnB_A.setText("A");
        BtnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_AActionPerformed(evt);
            }
        });

        BtnB_C.setText("C");
        BtnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_CActionPerformed(evt);
            }
        });

        BtnC_A.setText("A");
        BtnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_AActionPerformed(evt);
            }
        });

        BtnC_B.setText("B");
        BtnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_BActionPerformed(evt);
            }
        });

        CBNumDisc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));
        CBNumDisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBNumDiscActionPerformed(evt);
            }
        });

        LblMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LblMov.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblMov.setForeground(new java.awt.Color(255, 51, 51));
        LblMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Numero de Discos:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Numero min de mov:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Numero de movimientos:");

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        Resolver.setText("Resolver");
        Resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolverActionPerformed(evt);
            }
        });

        TorreD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TorreD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TorreD);
        if (TorreD.getColumnModel().getColumnCount() > 0) {
            TorreD.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnD_A.setText("A");
        BtnD_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_AActionPerformed(evt);
            }
        });

        BtnD_B.setText("B");
        BtnD_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_BActionPerformed(evt);
            }
        });

        BtnD_C.setText("C");
        BtnD_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_CActionPerformed(evt);
            }
        });

        BtnA_D.setText("D");
        BtnA_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_DActionPerformed(evt);
            }
        });

        BtnB_D.setText("D");
        BtnB_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_DActionPerformed(evt);
            }
        });

        BtnC_D.setText("D");
        BtnC_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnA_D, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnB_D, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnC_D, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(BtnD_A, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnD_B, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnD_C, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Iniciar)
                                .addGap(36, 36, 36)
                                .addComponent(Reiniciar)
                                .addGap(18, 18, 18)
                                .addComponent(Resolver))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CBNumDisc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblMinMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblMov, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(546, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnB_A)
                    .addComponent(BtnC_A)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnC_B)
                        .addComponent(BtnD_A)
                        .addComponent(BtnD_B)
                        .addComponent(BtnD_C)
                        .addComponent(BtnC_D))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnB_C)
                        .addComponent(BtnA_D)
                        .addComponent(BtnB_D))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnA_B)
                        .addComponent(BtnA_C)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBNumDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(LblMinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblMov, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Iniciar)
                    .addComponent(Reiniciar)
                    .addComponent(Resolver))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBNumDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBNumDiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBNumDiscActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        ContNumMov=0;
        Iniciar();
    }//GEN-LAST:event_IniciarActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_ReiniciarActionPerformed
    private void MoverA_C(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreC.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreC.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
               
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_CActionPerformed
       MoverA_C();
    }//GEN-LAST:event_BtnA_CActionPerformed

    private void MoverA_B(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreB.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreB.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_BActionPerformed
       MoverA_B();
    }//GEN-LAST:event_BtnA_BActionPerformed
    private void MoverB_A(){
        try{
            if(PilaTorreB.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreA.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek())>0){
                        return;
                    }
                }
                PilaTorreB.Pop();
                PilaTorreA.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_AActionPerformed
        MoverB_A();
    }//GEN-LAST:event_BtnB_AActionPerformed
    private void MoverB_C(){
        try{
            if(PilaTorreB.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreC.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek())>0){
                        return;
                    }
                }
                PilaTorreB.Pop();
                PilaTorreC.Push(Plataforma);
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
                
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_CActionPerformed
        MoverB_C();
    }//GEN-LAST:event_BtnB_CActionPerformed
    private void MoverC_A(){
        try{
            if(PilaTorreC.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreA.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek())>0){
                        return;
                    }
                }
                PilaTorreC.Pop();
                PilaTorreA.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_AActionPerformed
        MoverC_A();
    }//GEN-LAST:event_BtnC_AActionPerformed
    private void MoverC_B(){
        try{
            if(PilaTorreC.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreB.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek())>0){
                        return;
                    }
                }
                PilaTorreC.Pop();
                PilaTorreB.Push(Plataforma);
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_BActionPerformed
        MoverC_B();
    }//GEN-LAST:event_BtnC_BActionPerformed
    /*private void MoverPlataforma(Pila Origen,Pila Destino){
        if(Stop==false){
            Nodo Plataforma=new Nodo();
            Plataforma.setDato(Origen.Peek());
            Origen.Pop();
            Destino.Push(Plataforma);
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarTorreD();
            
            PresentarCantMov();
            JOptionPane pane=new JOptionPane("Paso #"+LblMov.getText()+"\n\n¿Continuar?",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
            JDialog dialog=pane.createDialog("Numero de pasos");
            dialog.setLocation(600,400);
            dialog.setVisible(true);
            int op=(int) pane.getValue();
            if(op==JOptionPane.NO_OPTION){
                Stop=true;
            }
        }
    }
    private void ResolverHanoi(int n,Pila Origen,Pila Auxiliar,Pila Destino){
        if(n==1){
            MoverPlataforma(Origen,Destino);
        }else{
            ResolverHanoi(n-1,Origen,Destino,Auxiliar);
            MoverPlataforma(Origen,Destino);
            ResolverHanoi(n-1,Auxiliar,Origen,Destino);
        }
        
    } 3 torres*/
    private void MoverPlataforma(Pila Origen, Pila Destino) {
        if (!Stop) {
            Nodo Plataforma = new Nodo();
            Plataforma.setDato(Origen.Peek());
            Origen.Pop();
            Destino.Push(Plataforma);
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarTorreD(); 

            PresentarCantMov();
            JOptionPane pane = new JOptionPane("Paso #" + LblMov.getText() + "\n\n¿Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog dialog = pane.createDialog("Numero de pasos");
            dialog.setLocation(600, 400);
            dialog.setVisible(true);
            int op = (int) pane.getValue();
            if (op == JOptionPane.NO_OPTION) {
                Stop = true;
            }
        }
    }

    private void ResolverHanoi(int n, Pila Origen, Pila Auxiliar1, Pila Auxiliar2, Pila Destino) {
        if (n == 1) {
            MoverPlataforma(Origen, Destino);
        } else if (n == 2) {
            MoverPlataforma(Origen, Auxiliar1);
            MoverPlataforma(Origen, Destino);
            MoverPlataforma(Auxiliar1, Destino);
        } else {
            ResolverHanoi(n - 2, Origen, Auxiliar2, Destino, Auxiliar1);
            MoverPlataforma(Origen, Auxiliar2);
            MoverPlataforma(Origen, Destino);
            MoverPlataforma(Auxiliar2, Destino);
            ResolverHanoi(n - 2, Auxiliar1, Origen, Auxiliar2, Destino);
        }
    }

    private void ResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolverActionPerformed
        if(!LblMinMov.getText().equals("") &&PilaTorreC.getContNodo()!=Objetivo){
           Reiniciar();
           Stop=false;
           ResolverHanoi(Objetivo,PilaTorreA,PilaTorreB,PilaTorreC,PilaTorreD);
        }
    }//GEN-LAST:event_ResolverActionPerformed
    private void MoverA_D(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreD.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreD.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreD.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreD();
                PresentarCantMov();
                if(PilaTorreD.getContNodo()==Objetivo && ContNumMov==NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreD.getContNodo()==Objetivo &&ContNumMov!=NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnA_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_DActionPerformed
        MoverA_D();
    }//GEN-LAST:event_BtnA_DActionPerformed
    private void MoverB_D(){
        try{
            if(PilaTorreB.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreB.Peek());
                
                if(PilaTorreD.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreD.Peek())>0){
                        return;
                    }
                }
                PilaTorreB.Pop();
                PilaTorreD.Push(Plataforma);
                PresentarTorreB();
                PresentarTorreD();
                PresentarCantMov();
                if(PilaTorreD.getContNodo()==Objetivo && ContNumMov==NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreD.getContNodo()==Objetivo &&ContNumMov!=NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnB_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_DActionPerformed
       MoverB_D();
    }//GEN-LAST:event_BtnB_DActionPerformed
    private void MoverC_D(){
        try{
            if(PilaTorreC.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreC.Peek());
                
                if(PilaTorreD.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreD.Peek())>0){
                        return;
                    }
                }
                PilaTorreC.Pop();
                PilaTorreD.Push(Plataforma);
                PresentarTorreC();
                PresentarTorreD();
                PresentarCantMov();
                if(PilaTorreD.getContNodo()==Objetivo && ContNumMov==NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreD.getContNodo()==Objetivo &&ContNumMov!=NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnC_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_DActionPerformed
        MoverC_D();
    }//GEN-LAST:event_BtnC_DActionPerformed
    private void MoverD_A(){
        try{
            if(PilaTorreD.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreD.Peek());
                
                if(PilaTorreA.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreA.Peek())>0){
                        return;
                    }
                }
                PilaTorreD.Pop();
                PilaTorreA.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreD();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnD_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_AActionPerformed
        MoverD_A();
    }//GEN-LAST:event_BtnD_AActionPerformed
    private void MoverD_B(){
        try{
            if(PilaTorreD.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreD.Peek());
                
                if(PilaTorreB.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek())>0){
                        return;
                    }
                }
                PilaTorreD.Pop();
                PilaTorreB.Push(Plataforma);
                PresentarTorreD();
                PresentarTorreB();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnD_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_BActionPerformed
        MoverD_B();
    }//GEN-LAST:event_BtnD_BActionPerformed
    private void MoverD_C(){
        try{
            if(PilaTorreD.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreD.Peek());
                
                if(PilaTorreC.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek())>0){
                        return;
                    }
                }
                PilaTorreD.Pop();
                PilaTorreC.Push(Plataforma);
                PresentarTorreC();
                PresentarTorreD();
                PresentarCantMov();
                if(PilaTorreD.getContNodo()==Objetivo && ContNumMov==NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreD.getContNodo()==Objetivo &&ContNumMov!=NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnD_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_CActionPerformed
        MoverD_C();
    }//GEN-LAST:event_BtnD_CActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnA_B;
    private javax.swing.JButton BtnA_C;
    private javax.swing.JButton BtnA_D;
    private javax.swing.JButton BtnB_A;
    private javax.swing.JButton BtnB_C;
    private javax.swing.JButton BtnB_D;
    private javax.swing.JButton BtnC_A;
    private javax.swing.JButton BtnC_B;
    private javax.swing.JButton BtnC_D;
    private javax.swing.JButton BtnD_A;
    private javax.swing.JButton BtnD_B;
    private javax.swing.JButton BtnD_C;
    private javax.swing.JComboBox<String> CBNumDisc;
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel LblMinMov;
    private javax.swing.JLabel LblMov;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton Resolver;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    private javax.swing.JTable TorreD;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
