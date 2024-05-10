package layout;

import static Fonksiyonlar.CreateDb.password;
import static Fonksiyonlar.CreateDb.url;
import static Fonksiyonlar.CreateDb.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Kazanc_Sorgula extends javax.swing.JFrame {
    
    public Kazanc_Sorgula() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Back1 = new javax.swing.JButton();
        cmb_il = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Takip No.", "Ürün Tanımı", "Ad", "Soyad", "Adres", "Durum", "Ücret"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_Back1.setText("<");
        btn_Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Back1ActionPerformed(evt);
            }
        });

        cmb_il.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bir il seçiniz", "Tüm İller", "ADANA", "ADIYAMAN", "AFYON", "AĞRI", "AKSARAY", "AMASYA", "ANKARA", "ANTALYA", "ARDAHAN", "ARTVİN", "AYDIN", "BALIKESİR", "BARTIN", "BATMAN", "BAYBURT", "BİLECİK", "BİNGÖL", "BİTLİS", "BOLU", "BURDUR", "BURSA", "ÇANAKKALE", "ÇANKIRI", "ÇORUM", "DENİZLİ", "DİYARBAKIR", "DÜZCE", "EDİRNE", "ELAZIĞ", "ERZİNCAN", "ERZURUM", "ESKİŞEHİR", "GAZİANTEP", "GİRESUN", "GÜMÜŞHANE", "HAKKARİ", "HATAY", "IĞDIR", "ISPARTA", "İSTANBUL", "İZMİR", "KAHRAMANMARAŞ", "KARABÜK", "KARAMAN", "KARS", "KASTAMONU", "KAYSERİ", "KİLİS", "KIRIKKALE", "KIRKLARELİ", "KIRŞEHİR", "KOCAELİ", "KONYA", "KÜTAHYA", "MALATYA", "MANİSA", "MARDIN", "MERSİN", "MUĞLA", "MUŞ", "NEVŞEHİR", "NİĞDE", "ORDU", "OSMANİYE", "RİZE", "SAKARYA", "SAMSUN", "ŞANLIURFA", "SİİRT", "SİNOP", "SİVAS", "ŞIRNAK", "TEKİRDAĞ", "TOKAT", "TRABZON", "TUNCELİ", "UŞAK", "VAN", "YALOVA", "YOZGAT", "ZONGULDAK" }));
        cmb_il.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ilActionPerformed(evt);
            }
        });

        jLabel1.setText("Toplam Kazanç :");

        lbl_total.setText("0");

        jLabel3.setText("TL");

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel4.setText("Kazançlar");

        jButton1.setText("Tümünü Göster");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ödendi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Kapıda Ödeme");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Back1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(cmb_il, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Back1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(cmb_il, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_total)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Back1ActionPerformed
        this.setVisible(false);
        new Admin_Paneli().setVisible(true);
    }//GEN-LAST:event_btn_Back1ActionPerformed

    
    private void cmb_ilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ilActionPerformed
        
    }//GEN-LAST:event_cmb_ilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String il = cmb_il.getSelectedItem() + "";
        
        if(il.equals("Tüm İller"))
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id;";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }                  
        }

        else
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE alici.il='" + il + "';";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }           
        }

        int rowIndex = jTable1.getRowCount();
        System.out.println(rowIndex);
        int ucret=0;
        String tmp;
      //  durum = (String) jTable1.getValueAt(rowIndex, 7);
        for(int i=0;i<rowIndex;i++){
            tmp= jTable1.getValueAt(i, 6)+"";
        ucret += Integer.parseInt(tmp);
        }
         
        lbl_total.setText(ucret+"");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String il = cmb_il.getSelectedItem() + "";
        
        if(il.equals("Tüm İller"))
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE kargo.odeme_bicimi_no='1'";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }                  
        }

        else
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE alici.il='" + il + "' and kargo.odeme_bicimi_no='1';";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }           
        }

        int rowIndex = jTable1.getRowCount();
        System.out.println(rowIndex);
        int ucret=0;
        String tmp;
      //  durum = (String) jTable1.getValueAt(rowIndex, 7);
        for(int i=0;i<rowIndex;i++){
            tmp= jTable1.getValueAt(i, 6)+"";
        ucret += Integer.parseInt(tmp);
        }
         
        lbl_total.setText(ucret+"");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String il = cmb_il.getSelectedItem() + "";
        
        if(il.equals("Tüm İller"))
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE kargo.odeme_bicimi_no='2'";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }                  
        }

        else
        {
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi,kargo.ucret"
                    + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                    + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                    + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE alici.il='" + il + "' and kargo.odeme_bicimi_no='2';";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery();) {
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = {rs.getString("takip_no"), rs.getString("urun_tanimi"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("teslim_adresi"), rs.getString("durum_adi"), rs.getInt("ucret")};
                        tm.addRow(o);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }           
        }

        int rowIndex = jTable1.getRowCount();
        System.out.println(rowIndex);
        int ucret=0;
        String tmp;
      //  durum = (String) jTable1.getValueAt(rowIndex, 7);
        for(int i=0;i<rowIndex;i++){
            tmp= jTable1.getValueAt(i, 6)+"";
        ucret += Integer.parseInt(tmp);
        }
         
        lbl_total.setText(ucret+"");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Kazanc_Sorgula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmb_il;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_total;
    // End of variables declaration//GEN-END:variables
}
