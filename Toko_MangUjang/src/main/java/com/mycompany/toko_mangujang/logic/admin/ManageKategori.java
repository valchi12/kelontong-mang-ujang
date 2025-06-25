/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.logic.admin;

import com.mycompany.toko_mangujang.model.Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class ManageKategori {
    private final Connection conn;
    
    public ManageKategori(Connection conn) {
        this.conn = conn;
    }
      
    public List<Kategori> getAllKategori() throws SQLException {
        List<Kategori> list = new ArrayList<>();
        String sql = "SELECT * FROM kategori";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Kategori(rs.getInt("kategori_id"), rs.getString("nama_kategori")));
            }
        }
        return list;
    }
     public void tambahKategori(String namaKategori) throws SQLException {
        String sql = "INSERT INTO kategori (nama_kategori) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaKategori);
            stmt.executeUpdate();
        }
    }
     
}

