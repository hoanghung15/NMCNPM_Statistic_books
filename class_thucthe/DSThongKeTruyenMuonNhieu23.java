/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package class_thucthe;

/**
 *
 * @author Admin
 */
public class DSThongKeTruyenMuonNhieu23 extends DauTruyen23{
    private int tongSoLuongMuon;
    private float tongTien;

    public DSThongKeTruyenMuonNhieu23() {
    }
    
    
    public DSThongKeTruyenMuonNhieu23(int tongSoLuongMuon, float tongTien, int maDauTruyen, String tenTruyen, String tenTacGia, String nhaXuatBan, int namXuatBan, String theLoai, int soLuong, float giaThue) {
        super(maDauTruyen, tenTruyen, tenTacGia, nhaXuatBan, namXuatBan, theLoai, soLuong, giaThue);
        this.tongSoLuongMuon = tongSoLuongMuon;
        this.tongTien = tongTien;
    }

    public int getTongSoLuongMuon() {
        return tongSoLuongMuon;
    }

    public void setTongSoLuongMuon(int tongSoLuongMuon) {
        this.tongSoLuongMuon = tongSoLuongMuon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
}
