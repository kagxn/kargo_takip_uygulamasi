package Fonksiyonlar;

import static Fonksiyonlar.CreateDb.password;
import static Fonksiyonlar.CreateDb.url;
import static Fonksiyonlar.CreateDb.username;
import dto.tablolar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static layout.Kargolari_Listele.durum;
import static layout.Kargolari_Listele.takipNo;

public class kargoDao {

    public static List<tablolar> getInfo(String takipNo) {
        String query = "SELECT kargo.urun_tanimi,kargo.takip_no,alici.firstName,alici.lastName,kargo.teslim_adresi,durum.durum_adi"
                + " FROM kullanici INNER JOIN kargo ON kullanici.kullanici_id=kargo.kullanici_id"
                + " INNER JOIN durum ON kargo.durum_no=durum.durum_no"
                + " INNER JOIN alici ON alici.alici_id=kargo.alici_id WHERE kargo.takip_no=?;";
        List<tablolar> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, takipNo);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    tablolar info = new tablolar();
                    info.setUrun_tanimi(rs.getString("urun_tanimi"));
                    info.setTakip_no(rs.getString("takip_no"));
                    info.setFirstName(rs.getString("firstName"));
                    info.setLastName(rs.getString("lastName"));
                    info.setAdress(rs.getString("teslim_adresi"));
                    info.setDurum_adi(rs.getString("durum_adi"));

                    result.add(info);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;

    }


    public static double getdistance(int kullanici_x, int kullanici_y, int alici_x, int alici_y) {
        System.out.println("getDistance Çalıiştı");
        double distance_x = Math.pow((kullanici_x-alici_x),2);
        double distance_y = Math.pow((kullanici_y-alici_y),2);
        double distance= Math.sqrt(distance_x+distance_y);       
        return distance;
    }

    public static double getCargoPrice(double distance, double agirlik) {
        double price = 0;
        if (distance == 0) {
            price = 20 + ((agirlik*agirlik)/10) ;
        } else {
            price = distance * 20 + ((agirlik*agirlik)/10) ;
        }
        System.out.println("price:" + price);
        return price;
    }

    public static boolean takip_no_isexist(String takipNo) {
        String isExists = "SELECT takip_no FROM kargo WHERE takip_no=?;";
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(isExists)) {
            stmt.setString(1, takipNo);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {

                    result = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    //parametre değişkeni bu projede aşırı yüklenme kullanılması zorunlu olduğu için kullanıldı.
    public static void delKargo(String takip_no, int parametre) {
        String delete_kargo = "Delete from kargo where takip_no='" + takipNo + "';";
        if (parametre == 1) {
            if (!((durum.equals("Yola çıktı")) || (durum.equals("Dağıtımda")))) {
                CreateDb.execute(url, delete_kargo);
                JOptionPane.showMessageDialog(null, "Kargo iadesi başlatıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Üzgünüz, kargo yola çıktı. Kargo teslim edilmeden iade edilemez!");
            }
        } else {
            CreateDb.execute(url, delete_kargo);
            JOptionPane.showMessageDialog(null, "Kayıt silindi");
        }
    }

    public static void delKargo(String takip_no, double parametre) {
        String delete_kargo = "Delete from kargo where takip_no='" + takip_no + "';";
        if (parametre == 1) {
            if (!((durum.equals("Yola çıktı")) || (durum.equals("Dağıtımda")))) {
                CreateDb.execute(url, delete_kargo);
                JOptionPane.showMessageDialog(null, "Kargo iadesi başlatıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Üzgünüz, kargo yola çıktı. Kargo teslim edilmeden iade edilemez!");
            }
        } else {
            CreateDb.execute(url, delete_kargo);
            JOptionPane.showMessageDialog(null, "Kayıt silindi");
        }
    }

    public static void sendKargo(String takip_no, double kar_agirlik, int kirilabilir, String teslim_adresi, int kullanici_id, int alici_id, String urun_tanimi, Date gonderme_tarihi, int durum_no, int ucret, int odeme_bicimi_no) {
        System.out.println("aaaaaaaaaaaaaaaaaaa"+takip_no);
        String insert_kargo = "INSERT INTO kargo (takip_no,kar_agirlik,kirilabilir,teslim_adresi,kullanici_id,alici_id,urun_tanimi,gonderme_tarihi,durum_no,ucret,odeme_bicimi_no) VALUES('" + takip_no + "','"
                + kar_agirlik + "','" + kirilabilir + "','" + teslim_adresi + "','" + kullanici_id
                + "','" + alici_id + "','" + urun_tanimi + "','" + gonderme_tarihi + "','" + 1 + "','" + ucret + "','" + odeme_bicimi_no + "')";
       
        CreateDb.execute(CreateDb.url, insert_kargo);
    }
}
