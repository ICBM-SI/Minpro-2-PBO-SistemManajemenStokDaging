/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Daging {
    private int idDaging;
    private String namaDaging;
    private String bagianDaging;
    private double berat;
    private String tanggalMasuk;
    private String tanggalExpired;
    private int stok;
    private String status;
 
    public Daging(int idDaging, String namaDaging, String bagianDaging, double berat,
                  String tanggalMasuk, String tanggalExpired, int stok, String status) {
        this.idDaging = idDaging;
        this.namaDaging = namaDaging;
        this.bagianDaging = bagianDaging;
        this.berat = berat;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalExpired = tanggalExpired;
        this.stok = stok;
        this.status = status;
    }
 
    public int getIdDaging() {return idDaging; }
    public String getNamaDaging() {return namaDaging; }
    public String getBagianDaging() {return bagianDaging; }
    public double getBerat() {return berat; }
    public String getTanggalMasuk() {return tanggalMasuk; }
    public String getTanggalExpired() {return tanggalExpired; }
    public int getStok() {return stok; }
    public String getStatus() {return status; }
 
    public void setNamaDaging(String namaDaging) {this.namaDaging = namaDaging; }
    public void setBagianDaging(String bagianDaging) {this.bagianDaging = bagianDaging; }
    public void setBerat(double berat) {this.berat = berat; }
    public void setTanggalMasuk(String tanggalMasuk) {this.tanggalMasuk = tanggalMasuk; }
    public void setTanggalExpired(String tanggalExpired) { this.tanggalExpired = tanggalExpired; }
    public void setStok(int stok) {this.stok = stok; }
    public void setStatus(String status) {this.status = status; }
 
    public void tampilkan() {
        System.out.println(idDaging + " | " + namaDaging + " | "  + bagianDaging + " | " 
                + berat + "kg" + " | " + tanggalMasuk + " | " + tanggalExpired+ " | " 
                + stok+ " | "  + status+ " | " );
    }
}
