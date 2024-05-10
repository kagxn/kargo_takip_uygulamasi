package layout;

import Fonksiyonlar.kullaniciDao;
import dto.kullanici;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static layout.Login.online;

public class Login extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    public static kullanici online;

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        Txt_userName = new javax.swing.JTextField();
        Btn_yeniKayit = new javax.swing.JButton();
        Btn_giris = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        user_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setText("Şifre:");

        Txt_userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_userNameActionPerformed(evt);
            }
        });

        Btn_yeniKayit.setText("Kaydol");
        Btn_yeniKayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_yeniKayitActionPerformed(evt);
            }
        });

        Btn_giris.setText("Giriş");
        Btn_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_girisActionPerformed(evt);
            }
        });

        jLabel4.setText("Kullanıcı Adı:");

        btn_Back.setText("<");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel2.setText("Giris Yap");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(Btn_giris)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_yeniKayit)
                                .addGap(7, 7, 7))
                            .addComponent(Txt_userName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(user_password, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(171, 171, 171))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_giris, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_yeniKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 370));

        jLabel3.setText("Kullanıcı Adı");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_girisActionPerformed

        String sql = "select * from kullanici where userName=? and password=?";

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KargoTakip?user=postgres&password=TWM6xqGq");
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, Txt_userName.getText());
            psmt.setString(2, user_password.getText());

            rs = psmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Oturum açma başarılı!");

                online = kullaniciDao.kullaniciBilgileri(Txt_userName.getText()).get(0);
              //  System.out.println(online.getKullaniciId());
                // online.setUserName(Txt_userName.getText());
                new Kullanici_Paneli(Txt_userName.getText()).setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Oturum açma başarısız!");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_Btn_girisActionPerformed

    private void Btn_yeniKayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_yeniKayitActionPerformed
        Kayıt_Ol r = new Kayıt_Ol();
        r.setVisible(true);
        this.setVisible(false);
        
      
    }//GEN-LAST:event_Btn_yeniKayitActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        this.setVisible(false);  // register ekranını kapatıyoruz
        new Main().setVisible(true);// login ekranını tekrar açıyoruz.
    }//GEN-LAST:event_btn_BackActionPerformed

    private void Txt_userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_userNameActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_giris;
    private javax.swing.JButton Btn_yeniKayit;
    private javax.swing.JTextField Txt_userName;
    private javax.swing.JButton btn_Back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.Panel panel1;
    private javax.swing.JPasswordField user_password;
    // End of variables declaration//GEN-END:variables
}