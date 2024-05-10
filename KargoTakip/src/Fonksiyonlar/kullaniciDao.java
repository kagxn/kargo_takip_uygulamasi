package Fonksiyonlar;

import static Fonksiyonlar.CreateDb.password;
import static Fonksiyonlar.CreateDb.url;
import static Fonksiyonlar.CreateDb.username;
import dto.tablolar;
import dto.kullanici;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import layout.Login;

public class kullaniciDao {
    /*
     Aşırı yükleme Burada Kullanıldı ...
     */

    public static List<kullanici> kullaniciBilgileri(String userName, int parametre2) {
        List<kullanici> result = new ArrayList<>();
        String query = "select * from kullanici where kullanici.userName=?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);

            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    kullanici kullanici1 = new kullanici();
                    kullanici1.setKullanici_id(rs.getInt("kullanici_id"));
                    kullanici1.setFirstName(rs.getString("firstName"));
                    kullanici1.setLastName(rs.getString("lastName"));
                    kullanici1.setUserName(rs.getString("userName"));
                    kullanici1.setPassword(rs.getString("password"));
                    kullanici1.setEmail(rs.getString("email"));
                    kullanici1.setMobileNo(rs.getString("mobileNo"));
                    kullanici1.setAdress(rs.getString("address"));
                    result.add(kullanici1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
        }
        return result;
    }

    public static List<kullanici> kullaniciBilgileri(String userName) {
        List<kullanici> result = new ArrayList<>();
        String query = "select * from kullanici where kullanici.userName=?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userName);

            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    kullanici kullanici1 = new kullanici();
                    kullanici1.setKullanici_id(rs.getInt("kullanici_id"));
                    kullanici1.setFirstName(rs.getString("firstName"));
                    kullanici1.setLastName(rs.getString("lastName"));
                    kullanici1.setUserName(rs.getString("userName"));
                    kullanici1.setPassword(rs.getString("password"));
                    kullanici1.setEmail(rs.getString("email"));
                    kullanici1.setMobileNo(rs.getString("mobileNo"));
                    kullanici1.setAdress(rs.getString("address"));
                    result.add(kullanici1);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        } catch (Exception e) {
        }
        return result;
    }

    public static List<tablolar> Kullanici_koordinatlari() {
        List<tablolar> result = new ArrayList<>();
        String query = "select lat,lon from iller where iller.isim=(select (kullanici.il) from kullanici where kullanici_id=?);";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, Login.online.getKullaniciId());
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
        } catch (Exception e) {
        }
        return result;
    }

    public static void addKullanici(String firstName, String lastName, String userName, String password, String email, String mobileNo, String il, String ilce, String address) {
        String query = "CALL kullanici_ekle_proc('" + firstName + "','" + lastName + "','" + userName + "','"
                + password + "','" + email + "','" + mobileNo + "','" + il + "','" +ilce + "','" + address + "')";
        
        CreateDb.execute(url, query);
    }
    
    public static boolean isAvailable(String userName){
          String isExists = "SELECT kullanici.userName FROM kullanici WHERE userName=?;";
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(isExists)) {
            stmt.setString(1, userName);
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
}
