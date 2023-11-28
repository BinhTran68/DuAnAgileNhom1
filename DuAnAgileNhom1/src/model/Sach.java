/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Sach {

    private long id;
    private String tenSach, tacGia, nhaXuatBan;
    private Integer gia, soLuong;

    public Sach() {
    }

    public Sach(long id, String tenSach, String tacGia, String nhaXuatBan, Integer gia, Integer soLuong) {
        this.id = id;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public Sach(String tenSach, String tacGia, String nhaXuatBan, Integer gia, Integer soLuong) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getTenSach(),this.getTacGia(),this.getNhaXuatBan(),this.getGia(),this.getSoLuong()
        };
    }

}
