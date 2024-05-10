package Fonksiyonlar;

import static Fonksiyonlar.CreateDb.password;
import static Fonksiyonlar.CreateDb.url;
import static Fonksiyonlar.CreateDb.username;
import dto.alici;
import dto.tablolar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class aliciDao {

    public static List<alici> aliciBilgileri(String mobileNo, String firstName, String lastName) {
        List<alici> result = new ArrayList<>();
        String query = "select * from alici where alici.mobileNo=? and alici.firstName=? and alici.lastName=?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, mobileNo);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    alici alici1 = new alici();
                    alici1.setAlici_Id(rs.getInt("alici_id"));
                    alici1.setFirstName(rs.getString("firstName"));
                    alici1.setLastName(rs.getString("lastName"));
                    alici1.setMobileNo(rs.getString("mobileNo"));
                    alici1.setAdress(rs.getString("address"));
                    alici1.setIl(rs.getString("il"));
                    alici1.setIlce(rs.getString("ilce"));

                    result.add(alici1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {}
        return result;
    }

    public static List<tablolar> alici_koordinatlari(String il) {
        List<tablolar> result = new ArrayList<>();
        String query = "select lat,lon from iller where iller.isim=?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, il);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    tablolar a = new tablolar();
                    a.setLat(rs.getInt("lat"));
                    a.setLon(rs.getInt("lon"));
                    result.add(a);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {}
        return result;
    }

    public static void addAlici(String ad, String soyad, String telefon, String ilce, String il, String aliciAdres) {
        String insert_alici = "INSERT INTO alici (firstName,lastName,mobileNo,ilce,il,address) VALUES('" + ad + "','" + soyad + "','" + telefon + "','"
                + ilce + "','" + il + "','" + aliciAdres + "')";
        CreateDb.execute(CreateDb.url, insert_alici);
    }
}
