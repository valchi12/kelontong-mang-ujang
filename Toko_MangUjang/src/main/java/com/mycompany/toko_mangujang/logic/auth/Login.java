/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.logic.auth;

import com.mycompany.toko_mangujang.model.Akun;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IVAN
 */
public class Login {
     private final Connection conn;

    public Login(Connection conn) {
        this.conn = conn;
    }

    public Akun autentikasi(String username, String password) throws SQLException {
        String sql = "SELECT * FROM akun WHERE (username = ?) AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Akun(
                        rs.getInt("akun_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        }
        return null; 
    }
}

