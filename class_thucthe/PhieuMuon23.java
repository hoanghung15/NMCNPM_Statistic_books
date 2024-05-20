/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package class_thucthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.Timer;


public class PhieuMuon23 {
    private int maPhieuMuon;
    private KhachHang23 khachHang;
    private NguoiDung23 nguoiDung;
    private Date ngayMuon;
    private Timer gioMuon;
    public static List<TruyenMuon23> danhSachTruyenMuon = new ArrayList<>();

    public PhieuMuon23() {
    }

    public PhieuMuon23(int maPhieuMuon, KhachHang23 khachHang, NguoiDung23 nguoiDung, Date ngayMuon, Timer gioMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.khachHang = khachHang;
        this.nguoiDung = nguoiDung;
        this.ngayMuon = ngayMuon;
        this.gioMuon = gioMuon;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public KhachHang23 getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang23 khachHang) {
        this.khachHang = khachHang;
    }

    public NguoiDung23 getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung23 nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Timer getGioMuon() {
        return gioMuon;
    }

    public void setGioMuon(Timer gioMuon) {
        this.gioMuon = gioMuon;
    }

    public static List<TruyenMuon23> getDanhSachTruyenMuon() {
        return danhSachTruyenMuon;
    }

    public static void setDanhSachTruyenMuon(List<TruyenMuon23> danhSachTruyenMuon) {
        PhieuMuon23.danhSachTruyenMuon = danhSachTruyenMuon;
    }
        
}

    