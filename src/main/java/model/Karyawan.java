/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Karyawan {
    private int idKaryawan;
    private String namaKaryawan;
    private String jabatan;
 
    public Karyawan(int idKaryawan, String namaKaryawan, String jabatan) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.jabatan = jabatan;
    }
 
    public int getIdKaryawan() {return idKaryawan; }
    public String getNamaKaryawan() {return namaKaryawan; }
    public String getJabatan() {return jabatan; }
 
    public void setNamaKaryawan(String namaKaryawan) {this.namaKaryawan = namaKaryawan; }
    public void setJabatan(String jabatan) {this.jabatan = jabatan; }
 
    public void tampilkan() {
        System.out.println(idKaryawan + namaKaryawan + jabatan);
    }
}
