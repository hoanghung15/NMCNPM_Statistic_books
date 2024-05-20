/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package dao;
import class_thucthe.DSThongKeTruyenMuonNhieu23;
import class_thucthe.DauTruyen23;
import class_thucthe.HoaDonTra23;
import class_thucthe.KhachHang23;
import class_thucthe.testclass;
import java.lang.reflect.Array;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKeTruyenMuonNhieuDAO23 {

    public static Connection con;
    
    public ThongKeTruyenMuonNhieuDAO23(){
        if(con==null){
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=NMCNPM;user=sa;password=15122003;encrypt=false;trustServerCertificate=true;";
            String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<DSThongKeTruyenMuonNhieu23> getDSThongKeTruyenMuonNhieu(Date startDate, Date endDate){
        ArrayList<DSThongKeTruyenMuonNhieu23> result = new ArrayList<DSThongKeTruyenMuonNhieu23>();
        String sql = "WITH TongMuon AS (" +
                 "    SELECT maDauTruyen, COUNT(*) AS soLuongMuon " +
                 "    FROM tblTruyenMuon23 " +
                 "    WHERE ngayMuon BETWEEN ? AND ? " +
                 "    GROUP BY maDauTruyen " +
                 "), " +
                 "TongTien AS (" +
                 "    SELECT tm.maDauTruyen, SUM(hd.tongTien) AS tongTienThuDuoc " +
                 "    FROM tblTruyenMuon23 tm " +
                 "    JOIN tblHoaDonTra23 hd ON tm.maTruyenMuon = hd.maTruyenMuon " +
                 "    WHERE hd.ngayTra BETWEEN ? AND ? " +
                 "    GROUP BY tm.maDauTruyen " +
                 ") " +
                 "SELECT dt.maDauTruyen, dt.tenTruyen, dt.tenTacGia, dt.nhaXuatBan, dt.namXuatBan, " +
                 "       COALESCE(tm.soLuongMuon, 0) AS 'tongSoLuongMuon', COALESCE(tt.tongTienThuDuoc, 0) AS 'tongTien' " +
                 "FROM tblDauTruyen23 dt " +
                 "LEFT JOIN TongMuon tm ON dt.maDauTruyen = tm.maDauTruyen " +
                 "LEFT JOIN TongTien tt ON dt.maDauTruyen = tt.maDauTruyen " +
                 "WHERE COALESCE(tm.soLuongMuon, 0) > 0";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sdf.format(startDate));
            ps.setString(2, sdf.format(endDate));
            ps.setString(3, sdf.format(startDate));
            ps.setString(4, sdf.format(endDate));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                DSThongKeTruyenMuonNhieu23 r = new DSThongKeTruyenMuonNhieu23();
                r.setMaDauTruyen(rs.getInt("maDauTruyen"));
                r.setTenTruyen(rs.getString("tenTruyen"));
                r.setTenTacGia(rs.getString("tenTacGia"));
                r.setNhaXuatBan(rs.getString("nhaXuatBan"));
                r.setNamXuatBan(rs.getInt("namXuatBan"));
                r.setTongSoLuongMuon(rs.getInt("tongSoLuongMuon"));
                r.setTongTien(rs.getFloat("tongTien"));
                result.add(r);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.sort(result, new Comparator<DSThongKeTruyenMuonNhieu23>() {
            @Override
            public int compare(DSThongKeTruyenMuonNhieu23 o1, DSThongKeTruyenMuonNhieu23 o2) {
                int compareBySoLuongMuon = Integer.compare(o2.getTongSoLuongMuon(), o1.getTongSoLuongMuon());
                if (compareBySoLuongMuon != 0) {
                    return compareBySoLuongMuon;
                }
                return Float.compare(o2.getTongTien(), o1.getTongTien());
            }
        });
        return result;
    } 
    
    public ArrayList<HoaDonTra23> getDSHoaDon(int maDauTruyen, Date startDate, Date endDate){
    ArrayList<HoaDonTra23> result = new ArrayList<HoaDonTra23>();
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        
        
        String sql ="SELECT HD.maHoaDon AS ID, KH.hoTen AS 'Tên Khách hàng', CONCAT(PM.ngayTao, ' ', PM.gioTao) AS 'Ngày, giờ mượn', CONCAT(HD.ngayTra, ' ', HD.gioTra) AS 'Ngày, giờ trả', HD.tongTien AS 'Tổng số tiền'\n" +
                    "FROM tblHoaDonTra23 HD\n" +
                    "JOIN tblTruyenMuon23 TM ON HD.maTruyenMuon = TM.maTruyenMuon\n" +
                    "JOIN tblPhieuMuon23 PM ON TM.maPhieuMuon = PM.maPhieuMuon\n" +
                    "JOIN tblKhachHang23 KH ON HD.maKhachHang = KH.maKhachHang\n" +
                    "WHERE TM.maDauTruyen = ?\n" +
                    "AND HD.ngayTra BETWEEN ? AND ?";
        
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, maDauTruyen);
        pstmt.setDate(2, new java.sql.Date(startDate.getTime()));
        pstmt.setDate(3, new java.sql.Date(endDate.getTime()));
        
        rs = pstmt.executeQuery();
        
        while (rs.next()) {
            HoaDonTra23 hoaDon = new HoaDonTra23();
            hoaDon.setMaHoaDonTra(rs.getInt("ID"));
            KhachHang23 kh = new KhachHang23();
            kh.setHoTen(rs.getString("Tên Khách hàng"));
            hoaDon.setKhachHang(kh);
            hoaDon.setNgayGioMuon(rs.getString("Ngày, giờ mượn"));
            hoaDon.setNgayGioTra(rs.getString("Ngày, giờ trả"));
            hoaDon.setTongTien(rs.getFloat("Tổng số tiền"));
            result.add(hoaDon);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    } 

    return result;
}
    
    
}
