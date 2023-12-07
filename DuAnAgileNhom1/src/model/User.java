/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class User {
    
    private String id;
    
    private String username;
    
    private String password;
    
    private boolean gioiTinh;
    
    
    private String hoVaTen;
        
    private String quyen;

    public User(String id, String username, String password, String hoVaTen, String quyen) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hoVaTen = hoVaTen;
        this.quyen = quyen;
    }

    public User(String id, String username, String password, boolean gioiTinh, String hoVaTen, String quyen) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.quyen = quyen;
    }

    public User(String username, String password, boolean gioiTinh, String hoVaTen, String quyen) {
        this.username = username;
        this.password = password;
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.quyen = quyen;
    }
    
    
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    
    
    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", hoVaTen=" + hoVaTen + ", quyen=" + quyen + '}';
    }


   

   
    
}
