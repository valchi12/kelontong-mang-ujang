/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.model;

/**
 *
 * @author IVAN
 */
public class Kategori {
    private int id;
    private String nama;
    
    public Kategori(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
}
