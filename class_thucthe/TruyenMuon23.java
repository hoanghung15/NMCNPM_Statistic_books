/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package class_thucthe;

import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class TruyenMuon23 {
    private int maTruyenMuon;
    private Date ngayMuon;
    private Timer gioMuon;
    private DauTruyen23 truyen;
    private PhieuMuon23 phieuMuon;
    
    public TruyenMuon23() {
    }

    public TruyenMuon23(int maTruyenMuon, Date ngayMuon, Timer gioMuon, DauTruyen23 truyen, PhieuMuon23 phieuMuon) {
        this.maTruyenMuon = maTruyenMuon;
        this.ngayMuon = ngayMuon;
        this.gioMuon = gioMuon;
        this.truyen = truyen;
        this.phieuMuon = phieuMuon;
    }

    public int getMaTruyenMuon() {
        return maTruyenMuon;
    }

    public void setMaTruyenMuon(int maTruyenMuon) {
        this.maTruyenMuon = maTruyenMuon;
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

    public DauTruyen23 getTruyen() {
        return truyen;
    }

    public void setTruyen(DauTruyen23 truyen) {
        this.truyen = truyen;
    }

    public PhieuMuon23 getPhieuMuon() {
        return phieuMuon;
    }

    public void setPhieuMuon(PhieuMuon23 phieuMuon) {
        this.phieuMuon = phieuMuon;
    }
    
}
