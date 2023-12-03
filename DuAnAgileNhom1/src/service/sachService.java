/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Sach;

/**
 *
 * @author Acer
 */
public class sachService {

    private List<Sach> listSv;
    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Sach> getAll() {
        listSv = new ArrayList<>();
        sql = "select tenSach,tacGia,nhaXuatBan,gia,soLuong From sach;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                listSv.add(sach);
            }
            return listSv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Sach> sortByPrice() {
        listSv = new ArrayList<>();
        sql = "select tenSach,tacGia,nhaXuatBan,gia,soLuong From sach order by gia  desc;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                listSv.add(sach);
            }
            return listSv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int inSert(Sach sach) {
        sql = "insert into sach(tenSach,tacGia,NhaXuatBan,gia,soLuong) values(?,?,?,?,?)";
        int kq = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTacGia());
            ps.setString(3, sach.getNhaXuatBan());
            ps.setInt(4, sach.getGia());
            ps.setInt(5, sach.getSoLuong());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }

        return kq;
    }

    public int deleteForm(String ma) {
        sql = "DELETE from sach where tenSach like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateSach(String tenSach, Sach sach) {
        sql = "update sach set tenSach =?,tacGia=?,nhaXuatBan=?,gia=?,soLuong=? where tenSach =?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setString(2, sach.getTacGia());
            ps.setString(3, sach.getNhaXuatBan());
            ps.setInt(4, sach.getGia());
            ps.setInt(5, sach.getSoLuong());
            ps.setString(6, tenSach);
            return ps.executeUpdate();

        } catch (Exception e) {
            return 0;
        }

    }
     public List<Sach> searchByName(String tenSach) {
        listSv = new ArrayList<>();
        sql = " select tenSach,tacGia,nhaXuatBan,gia,soLuong From sach where tenSach like ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tenSach + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                     
                );
                listSv.add(sach);
            }
            return listSv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
