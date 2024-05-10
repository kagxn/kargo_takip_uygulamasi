package Fonksiyonlar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateDb {

    public static String url = "jdbc:postgresql://localhost:5432/KargoTakip?user=postgres&password=TWM6xqGq";
    // Defines username and password to connect to database server.
    public static String username = "postgres";  // write your mysql username in here
    public static String password = "TWM6xqGq";  // write your mysql password in here

    public static void execute(String url, String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();
            conn.close();
        } catch (Exception e) {}

    }

    public CreateDb() throws SQLException {

        String sql = "CREATE DATABASE IF NOT EXISTS KargoTakip;";
        execute(url, sql);
        //Müşteri tablosu 
        System.out.println("abc");
        String table_kullanici = "CREATE TABLE IF NOT EXISTS kullanici "
                + "(kullanici_id SERIAL PRIMARY KEY, "
                + "firstName VARCHAR(50) NOT NULL, "
                + "lastName VARCHAR(50) NOT NULL, "
                + "userName VARCHAR(50) NOT NULL UNIQUE, "
                + "password VARCHAR(20) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "mobileNo VARCHAR(100) NOT NULL, "
                + "il VARCHAR(30) NOT NULL, "
                + "ilce VARCHAR(30) NOT NULL, "
                + "address VARCHAR(250) NOT NULL);";

        String table_admin = "CREATE TABLE IF NOT EXISTS admin "
                + "(admin_id SERIAL PRIMARY KEY, "
                + "firstName VARCHAR(50) NOT NULL, "
                + "lastName VARCHAR(50) NOT NULL, "
                + "userName VARCHAR(50) NOT NULL UNIQUE, "
                + "password VARCHAR(20) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "mobileNo VARCHAR(100) NOT NULL, "
                + "il VARCHAR(30) NOT NULL, "
                + "ilce VARCHAR(30) NOT NULL, "
                + "address VARCHAR(250) NOT NULL);";
         
        
        //iller tablosu oluşturuluyor
        String table_iller = "CREATE TABLE IF NOT EXISTS iller "
                + "(il_no SERIAL PRIMARY KEY, "
                + "isim VARCHAR(50), "
                + "lat INTEGER, "
                + "lon INTEGER);";

        String table_ilceler = "CREATE TABLE IF NOT EXISTS ilceler "
                + "(ilce_no SERIAL PRIMARY KEY, "
                + "isim VARCHAR(50), "
                + "il_no INTEGER REFERENCES iller(il_no));";

        String table_durum = "CREATE TABLE IF NOT EXISTS durum("
                + "durum_no SERIAL PRIMARY KEY, "
                + "durum_adi VARCHAR(50));";

        String table_odeme_bicimi = "CREATE TABLE IF NOT EXISTS odeme_bicimi("
                + "odeme_bicimi_no SERIAL PRIMARY KEY, "
                + "odeme_bicimi_adi VARCHAR(25));";

        String table_alici = "CREATE TABLE IF NOT EXISTS alici "
                + "(alici_id SERIAL PRIMARY KEY, "
                + "firstName VARCHAR(50) NOT NULL, "
                + "lastName VARCHAR(50) NOT NULL, "
                + "mobileNo VARCHAR(100) NOT NULL, "
                + "ilce VARCHAR(100) NOT NULL, "
                + "il VARCHAR(100) NOT NULL, "
                + "address VARCHAR(250) NOT NULL);";

        String table_kargo = "CREATE TABLE IF NOT EXISTS kargo ("
                + "kar_id SERIAL PRIMARY KEY, "
                + "takip_no VARCHAR(15) NOT NULL, "
                + "kar_agirlik DOUBLE PRECISION NOT NULL, "
                + "kirilabilir INTEGER NOT NULL, "
                + "teslim_adresi VARCHAR(250) NOT NULL, "
                + "kullanici_id INTEGER NOT NULL, "
                + "alici_id INTEGER NOT NULL, "
                + "urun_tanimi VARCHAR(250) NOT NULL, "
                + "gonderme_tarihi DATE NOT NULL, "
                + "teslim_tarihi DATE, "
                + "durum_no INTEGER NOT NULL, "
                + "ucret INTEGER NOT NULL, "
                + "odeme_bicimi_no INTEGER NOT NULL, "
                + "CONSTRAINT fk_durum_no FOREIGN KEY (durum_no) REFERENCES durum(durum_no), "
                + "CONSTRAINT fk_odeme_bicimi_no FOREIGN KEY (odeme_bicimi_no) REFERENCES odeme_bicimi(odeme_bicimi_no), "
                + "CONSTRAINT fk_alici_id FOREIGN KEY (alici_id) REFERENCES alici(alici_id)"
                + ");";
        
        
                String il_ekle = "INSERT INTO iller (il_no, isim,lat,lon) VALUES (1, 'ADANA',37.00000000, 35.32133330),"
                + "(2, 'ADIYAMAN',37.76416670, 38.27616670),"
                + "(3, 'AFYON', 38.76376000, 30.54034000),"
                + "(4, 'AĞRI', 39.72166670, 43.05666670),"
                + "(5, 'AMASYA',40.65000000, 35.83333330),"
                + "(6, 'ANKARA', 39.92077000, 32.85411000),"
                + "(7, 'ANTALYA', 36.88414000, 30.70563000),"
                + "(8, 'ARTVİN',41.18333330, 41.81666670),"
                + "(9, 'AYDIN',37.84440000, 27.84580000),"
                + "(10, 'BALIKESİR', 39.64836900, 27.88261000),"
                + "(11, 'BİLECİK', 40.15013100, 29.98306100),"
                + "(12, 'BİNGÖL', 38.88534900, 40.49829100),"
                + "(13, 'BİTLİS', 38.40000000, 42.11666670),"
                + "(14, 'BOLU', 40.73947900, 31.61156100),"
                + "(15, 'BURDUR', 37.72690900, 30.28887600),"
                + "(16, 'BURSA', 40.18257000, 29.06687000),"
                + "(17, 'ÇANAKKALE', 40.15531200, 26.41416000),"
                + "(18, 'ÇANKIRI', 40.60000000, 33.61666670),"
                + "(19, 'ÇORUM', 40.55055560, 34.95555560),"
                + "(20, 'DENİZLİ', 37.77652000, 29.08639000),"
                + "(21, 'DİYARBAKIR', 37.91441000, 40.23062900),"
                + "(22, 'EDİRNE', 41.66666670, 26.56666670),"
                + "(23, 'ELAZIĞ', 38.68096900, 39.22639800),"
                + "(24, 'ERZİNCAN', 39.75000000, 39.50000000),"
                + "(25, 'ERZURUM', 39.90431890, 41.26788530),"
                + "(26, 'ESKİŞEHİR', 39.78430200, 30.51922000),"
                + "(27, 'GAZİANTEP', 37.06622000, 37.38332000),"
                + "(28, 'GİRESUN', 40.91281100, 38.38953000),"
                + "(29, 'GÜMÜŞHANE', 40.46027780, 39.48138890),"
                + "(30, 'HAKKARİ', 37.58333330, 43.73333330),"
                + "(31, 'HATAY', 36.40184880, 36.34980970),"
                + "(32, 'ISPARTA', 37.76666670, 30.55000000),"
                + "(33, 'MERSİN', 36.80000000, 34.63333330),"
                + "(34, 'İSTANBUL', 41.00527000, 28.97696000),"
                + "(35, 'İZMİR', 38.41885000, 27.12872000),"
                + "(36, 'KARS', 40.59267000, 43.07783100),"
                + "(37, 'KASTAMONU', 41.38871000, 33.78273000),"
                + "(38, 'KAYSERİ', 38.73333330, 35.48333330),"
                + "(39, 'KIRKLARELİ', 41.73333330, 27.21666670),"
                + "(40, 'KIRŞEHİR', 39.15000000, 34.16666670),"
                + "(41, 'KOCAELİ', 40.85327040, 29.88152030),"
                + "(42, 'KONYA', 37.86666670, 32.48333330),"
                + "(43, 'KÜTAHYA', 39.41666670, 29.98333330),"
                + "(44, 'MALATYA', 38.35519000, 38.30946000),"
                + "(45, 'MANİSA', 38.61909900, 27.42892100),"
                + "(46, 'KAHRAMANMARAŞ', 37.58333330, 36.93333330),"
                + "(47, 'MARDİN', 37.31223610, 40.73511200),"
                + "(48, 'MUĞLA', 37.21527780, 28.36361110),"
                + "(49, 'MUŞ', 38.74329260, 41.50648230),"
                + "(50, 'NEVŞEHİR', 38.62442000, 34.72396900),"
                + "(51, 'NİĞDE', 37.96666670, 34.68333330),"
                + "(52, 'ORDU', 40.98333330, 37.88333330),"
                + "(53, 'RİZE', 41.02005000, 40.52344900),"
                + "(54, 'SAKARYA', 40.75687930, 30.37813800),"
                + "(55, 'SAMSUN', 41.29278200, 36.33128000),"
                + "(56, 'SİİRT', 37.94429000, 41.93288000),"
                + "(57, 'SİNOP', 42.02642220, 35.15507450),"
                + "(58, 'SİVAS', 39.74766200, 37.01787900),"
                + "(59, 'TEKİRDAĞ', 40.98333330, 27.51666670),"
                + "(60, 'TOKAT', 40.31666670, 36.55000000),"
                + "(61, 'TRABZON', 41.00000000, 39.73333330),"
                + "(62, 'TUNCELİ', 39.10798680, 39.54016720),"
                + "(63, 'ŞANLIURFA', 37.15000000, 38.80000000),"
                + "(64, 'UŞAK', 38.68230100, 29.40819000),"
                + "(65, 'VAN', 38.49416670, 43.38000000),"
                + "(66, 'YOZGAT', 39.82000000, 34.80444440),"
                + "(67, 'ZONGULDAK', 41.45640900, 31.79873100),"
                + "(68, 'AKSARAY', 38.36869000, 34.03698000),"
                + "(69, 'BAYBURT', 40.25516900, 40.22488000),"
                + "(70, 'KARAMAN', 37.17593000, 33.22874800),"
                + "(71, 'KIRIKKALE', 39.84682100, 33.51525100),"
                + "(72, 'BATMAN', 37.88116800, 41.13509000),"
                + "(73, 'ŞIRNAK', 37.51638890, 42.46111110),"
                + "(74, 'BARTIN', 41.63444440, 32.33750000),"
                + "(75, 'ARDAHAN', 41.11048100, 42.70217100),"
                + "(76, 'IĞDIR', 39.91666670, 44.03333330),"
                + "(77, 'YALOVA', 40.65000000, 29.26666670),"
                + "(78, 'KARABÜK', 41.20000000, 32.63333330),"
                + "(79, 'KİLİS', 36.71839900, 37.12122000),"
                + "(80, 'OSMANİYE', 37.06805000, 36.26158900),"
                + "(81, 'DÜZCE', 40.84384900, 31.15654000);";


        String ilce_ekle = "INSERT INTO ilceler (ilce_no, isim, il_no) VALUES (1, 'Abana', 37)," 
                + "(2,'Altunhisar',51),"
                + "(3,'Alucra',28),"
                + "(4,'Amasra',74),"
                + "(5,'Amasya Merkez',5),"
                + "(6, 'Araç', 78)," 
                + "(7, 'Artvin Merkez', 8), " 
                + "(8, 'Ayancık', 57)," 
                + "(9, 'Aydın', 9), " 
                + "(10, 'Bağlar', 21)," 
                + "(11, 'Balıkesir Merkez', 10)," 
                + "(12, 'Bartın Merkez', 74), " 
                + "(13, 'Batman Merkez', 72)," 
                + "(14, 'Bayburt Merkez', 69)," 
                + "(15, 'Beşikdüzü', 61), " 
                + "(16, 'Beykoz', 34)," 
                + "(17, 'Beylikdüzü', 34)," 
                + "(18, 'Biga', 17), " 
                + "(19, 'Bilecik Merkez', 11)," 
                + "(20, 'Bingöl Merkez', 12)," 
                + "(21, 'Bismil', 21), " 
                + "(22, 'Bitlis Merkez', 13)," 
                + "(23, 'Bolu Merkez', 14)," 
                + "(24, 'Bor', 51), " 
                + "(25, 'Borçka', 8)," 
                + "(26, 'Bozcaada', 17)," 
                + "(27, 'Bozyazı', 33), " 
                + "(28, 'Bozüyük', 11)," 
                + "(29, 'Burdur Merkez', 15)," 
                + "(30, 'Bursa Merkez', 16), " 
                + "(31, 'Çanakkale Merkez', 17)," 
                + "(32, 'Çankaya', 6)," 
                + "(33, 'Çarşamba', 55), " 
                + "(34, 'Çaycuma', 67)," 
                + "(35, 'Çerkezköy', 59)," 
                + "(36, 'Çorum Merkez', 19), " 
                + "(37, 'Çubuk', 6)," 
                + "(38, 'Çukurca', 29)," 
                + "(39, 'Çumra', 42), " 
                + "(40, 'Dalaman', 48)," 
                + "(41, 'Dargeçit', 47)," 
                + "(42, 'Denizli Merkez', 20), " 
                + "(43, 'Devrek', 67)," 
                + "(44, 'Didim', 9),"
                + "(45, 'Dikili', 35), " 
                + "(46, 'Dilovası', 41)," 
                + "(47, 'Diyarbakır Merkez', 21)," 
                + "(48, 'Doğubayazıt', 4), " 
                + "(49, 'Düzce Merkez', 81)," 
                + "(50, 'Edirne Merkez', 22)," 
                + "(51, 'Edremit', 10), " 
                + "(52, 'Elazığ Merkez', 23)," 
                + "(53, 'Eminönü', 34)," 
                + "(54, 'Enez', 22), " 
                + "(55, 'Erciş', 65)," 
                + "(56, 'Erdek', 10)," 
                + "(57, 'Ereğli', 67), " 
                + "(58, 'Ermenek', 42)," 
                + "(59, 'Erzincan Merkez', 24)," 
                + "(60, 'Erzurum Merkez', 25), " 
                + "(61, 'Eskişehir Merkez', 26)," 
                + "(62, 'Fatsa', 52)," 
                + "(63, 'Finike', 7), " 
                + "(64, 'Foça', 35)," 
                + "(65, 'Gaziantep Merkez', 27)," 
                + "(66, 'Gebze', 41), " 
                + "(67, 'Gelibolu', 17)," 
                + "(68, 'Gemlik', 16)," 
                + "(69, 'Giresun Merkez', 28), " 
                + "(70, 'Gölbaşı', 6)," 
                + "(71, 'Gölcük', 41)," 
                + "(72, 'Gönen', 10), " 
                + "(73, 'Görele', 28)," 
                + "(74, 'Güroymak', 13)," 
                + "(75, 'Gürpınar', 65), "
                + "(76, 'Hakkari Merkez', 30)," 
                + "(77, 'Halfeti', 63)," 
                + "(78, 'Havsa', 22), " 
                + "(79, 'Hayrabolu', 59)," 
                + "(80, 'Hendek', 54)," 
                + "(81, 'Hilvan', 63), " 
                + "(82, 'Hopa', 8)," 
                + "(83, 'Iğdır Merkez', 76)," 
                + "(84, 'Isparta Merkez', 32), " 
                + "(85, 'İdil', 47)," 
                + "(86, 'İnegöl', 16)," 
                + "(87, 'İskenderun', 31), "
                + "(88, 'Altınyayla',15),"
                + "(89, 'Altınyayla',58),"
                + "(90, 'Kahramanmaraş Merkez', 46), " 
                + "(91, 'Karabük Merkez', 78)," 
                + "(92, 'Karacabey', 16)," 
                + "(93, 'Karaman Merkez', 70), " 
                + "(94, 'Kars Merkez', 36)," 
                + "(95, 'Kastamonu Merkez', 37)," 
                + "(96, 'Kaş', 7), " 
                + "(97, 'Kemalpaşa', 35)," 
                + "(98, 'Kesan', 22)," 
                + "(99, 'Kestel', 16), " 
                + "(100, 'Kilis Merkez', 79)," 
                + "(101, 'Kırıkkale Merkez', 71),"
                + "(102,'Adıyaman',2),"
                + "(103,'Adilcevaz',13),"
                + "(104,'Afşin',46),"
                + "(105,'Afyonkarahisar Merkez',3),"
                + "(106,'Ağaçören',68),"
                + "(107,'Ağın',23),"
                + "(108,'Ağlasun',15),"
                + "(109,'Ağlı',37),"
                + "(110,'Ağrı Merkez',4),"
                + "(111,'Ahırlı',42),"
                + "(112,'Ahlat',13),"
                + "(113,'Ahmetli',45),"
                + "(114,'Akçaabat',61),"
                + "(115,'Akçadağ',44),"
                + "(116,'Akçakale',63),"
                + "(117,'Akçakent',40),"
                + "(118,'Akçakoca',81),"
                + "(119,'Akdağmadeni',66),"
                + "(120,'Akdeniz',33),"
                + "(121,'Akhisar',45),"
                + "(122,'Akıncılar',58),"
                + "(123,'Akkışla',38),"
                + "(124,'Akkuş',52),"
                + "(125,'Akören',42),"
                + "(126,'Akpınar',40),"
                + "(127,'Aksaray',68),"
                + "(128,'Akseki',7),"
                + "(129,'Aksu',7),"
                + "(130,'Aksu',32),"
                + "(131,'Akşehir',42),"
                + "(132,'Akyaka',36),"
                + "(133,'Akyazı',54),"
                + "(134,'Akyurt',6),"
                + "(135,'Alaca',19),"
                + "(136,'Alacakaya',23),"
                + "(137,'Alaçam',55),"
                + "(138,'Aladağ',1),"
                + "(139,'Alanya',7),"
                + "(140,'Alaplı',67),"
                + "(141,'Alaşehir',45),"
                + "(142,'Aliağa',35),"
                + "(143,'Almus',60),"
                + "(144,'Alpu',26),"
                + "(145,'Altıeylül',10),"
                + "(146,'Altındağ',6),"
                + "(147,'Altınekin',42),"
                + "(148,'Altınordu',52),"
                + "(149,'Altınova',77),"
                + "(150,'Altınözü',31),"
                + "(151,'Altıntaş',43);";

        String durum_ekle = "INSERT INTO durum (durum_no,durum_adi) VALUES (1, 'Hazırlanıyor'),"
                + "(2, 'Yola çıktı'),"
                + "(3, 'Dağıtımda'),"
                + "(4,'Teslim edildi');";
        
        String odeme_bicimi_ekle="INSERT INTO odeme_bicimi(odeme_bicimi_no,odeme_bicimi_adi) VALUES (1, 'Ödendi'),"
                + "(2, 'Kapıda Ödeme')";
       
        String admin_ekle="INSERT INTO admin (firstName,lastName,userName,password,email,mobileNo,il,ilce,address) VALUES" 
                + "('Özgür','Şahan','ozguradmin','123456','ozgur@gmail.com','0543235','ANKARA','Mamak','Ege Mah.'),"
                + "('Necati','Özben','necatiadmin','123456','necati@gmail.com','05317651','ANKARA','Çankaya','Balgat');";
        
        String kullanici_ekle = "INSERT INTO kullanici (firstName, lastName, userName, password, email, mobileNo, il, ilce, address) VALUES "
        + "('Emir', 'Güngör', 'emir', '123456', 'emir@gmail.com', '5551234567', 'ANTALYA', 'Alanya', 'Örnek Sokak 1'), "
        + "('Ahmet', 'Yılmaz', 'ahmet.yilmaz', 'sifre123', 'ahmet.yilmaz@email.com', '5551234567', 'İSTANBUL', 'Beykoz', 'Örnek Sokak 1'), "
        + "('Ayşe', 'Demir', 'ayse.demir', 'parola456', 'ayse.demir@email.com', '5559876543', 'ANKARA', 'Çankaya', 'Bağdat Caddesi 22'), "
        + "('Mehmet', 'Kara', 'mehmet.kara', 'sifre789', 'mehmet.kara@email.com', '5552345678', 'İZMİR', 'Dikili', 'Göztepe Mahallesi 45'), "
        + "('Fatma', 'Aksoy', 'fatma.aksoy', 'parola101', 'fatma.aksoy@email.com', '5558765432', 'ADANA', 'Aladağ', 'Çınar Sokak 7'), "
        + "('İsmail', 'Güneş', 'ismail.gunes', 'sifre2022', 'ismail.gunes@email.com', '5557654321', 'BURSA', 'İnegöl', 'Atatürk Caddesi 33');";
        
        String table_kazanc = "CREATE TABLE IF NOT EXISTS kazanc("
                + "odeme_tipi VARCHAR(50) PRIMARY KEY,"
                + "kargo_sayisi INTEGER,"
                + "toplam_kazanc INTEGER);"; 
        
        String table_adminlog = "CREATE TABLE IF NOT EXISTS adminlog("
                + "log_id SERIAL PRIMARY KEY,"
                + "updated_kargo VARCHAR(20),"
                + "durum_no INTEGER,"
                + "teslim_tarihi VARCHAR(10),"
                + "update_time TIMESTAMP);";
        
        String kazanc_ekle = "INSERT INTO kazanc (odeme_tipi, kargo_sayisi, toplam_kazanc) VALUES " 
                + "('ödendi', 0, 0),"
                + "('kapıda ödeme', 0, 0);";
        
        String table_duyurular = "CREATE TABLE IF NOT EXISTS duyurular("
                + "takip_no VARCHAR(10),"
                + "urun_tanimi VARCHAR(50),"
                + "durum VARCHAR(20)," // BU integer de olabilir test et
                + "update_time TIMESTAMP,"
                + "teslim_tarihi VARCHAR(30));";
        
        String createTrigger1 = "CREATE OR REPLACE FUNCTION log_kargo_update() " 
                +"RETURNS TRIGGER AS $$ " 
                +"BEGIN " 
                +"    INSERT INTO adminlog (updated_kargo, durum_no, teslim_tarihi, update_time) " 
                +"    VALUES (NEW.takip_no, NEW.durum_no, NEW.teslim_tarihi, NOW()); " 
                +"    RETURN NEW; " 
                +"END; " 
                +"$$ LANGUAGE plpgsql; "
                +"CREATE TRIGGER trigger_kargo_update " 
                +"AFTER UPDATE ON kargo " 
                +"FOR EACH ROW " 
                +"EXECUTE FUNCTION log_kargo_update();";
        
        String createTrigger2 = "CREATE OR REPLACE FUNCTION kargo_kazanc() " 
                +"RETURNS TRIGGER AS $$ " 
                +"BEGIN " 
                +"    IF NEW.odeme_bicimi_no = 1 THEN " 
                +"        UPDATE kazanc " 
                +"        SET " 
                +"            kargo_sayisi = kargo_sayisi + 1, " 
                +"            toplam_kazanc = toplam_kazanc + NEW.ucret " 
                +"        WHERE " 
                +"            odeme_tipi = 'ödendi'; " 
                +"    ELSIF NEW.odeme_bicimi_no = 2 THEN " 
                +"        UPDATE kazanc " 
                +"        SET " 
                +"            kargo_sayisi = kargo_sayisi + 1, " 
                +"            toplam_kazanc = toplam_kazanc + NEW.ucret " 
                +"        WHERE " 
                +"            odeme_tipi = 'kapıda ödeme'; " 
                +"    END IF; " 
                +"    RETURN NEW; " 
                +"END; " 
                +"$$ LANGUAGE plpgsql; "
                +"CREATE TRIGGER trigger_kargokazanc " 
                +"AFTER INSERT ON kargo " 
                +"FOR EACH ROW " 
                +"EXECUTE FUNCTION kargo_kazanc();";
        
        String createProcAdminEkle = "CREATE OR REPLACE PROCEDURE admin_ekle_proc( " 
                +        "      p_firstname VARCHAR, " 
                +        "	p_lastname VARCHAR, " 
                +        "	p_username VARCHAR, " 
                +        "	p_password VARCHAR, " 
                +        "	p_email VARCHAR, " 
                +        "	p_mobileno VARCHAR, " 
                +        "	p_il VARCHAR, " 
                +        "	p_ilce VARCHAR, " 
                +        "	p_address VARCHAR " 
                +        ") LANGUAGE SQL " 
                +        "AS $$ "
                +        "    INSERT INTO admin(firstName, lastName, userName, password, email, mobileNo, il, ilce, address) " 
                +        "	VALUES (p_firstname, p_lastname, p_username, p_password, p_email, p_mobileno, p_il, p_ilce, p_address); "
                +        "$$;";
        
        String createProcKullaniciEkle = "CREATE OR REPLACE PROCEDURE kullanici_ekle_proc( " 
                +        "      p_firstname VARCHAR, " 
                +        "	p_lastname VARCHAR, " 
                +        "	p_username VARCHAR, " 
                +        "	p_password VARCHAR, " 
                +        "	p_email VARCHAR, " 
                +        "	p_mobileno VARCHAR, " 
                +        "	p_il VARCHAR, " 
                +        "	p_ilce VARCHAR, " 
                +        "	p_address VARCHAR " 
                +        ") LANGUAGE SQL " 
                +        "AS $$ "
                +        "    INSERT INTO kullanici(firstName, lastName, userName, password, email, mobileNo, il, ilce, address) " 
                +        "	VALUES (p_firstname, p_lastname, p_username, p_password, p_email, p_mobileno, p_il, p_ilce, p_address); "
                +        "$$;";

        execute(url, table_kullanici); // Sorgular çalıştırılıyor
        execute(url, table_admin);
        execute(url, table_iller);
        execute(url, table_ilceler);
        execute(url, table_durum);
        execute(url, table_odeme_bicimi);
        execute(url, table_alici);
        execute(url, il_ekle);
        execute(url, ilce_ekle);
        execute(url, durum_ekle);
        execute(url, odeme_bicimi_ekle);
        execute(url, table_kargo);
        execute(url, admin_ekle );
        execute(url, kullanici_ekle);
        execute(url, kazanc_ekle);
        execute(url, table_kazanc);
        execute(url, table_adminlog);
        execute(url, table_duyurular);
        execute(url, createTrigger1);
        execute(url, createTrigger2);
        execute(url, createProcAdminEkle);
        execute(url, createProcKullaniciEkle);
    }

 
}
