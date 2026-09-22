/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
abstract class TransaksiStok {
    private int idTransaksi;
    private int idDaging;
    private int idKaryawan;
    private String tanggal;
    private int jumlah;
    private String keterangan;
 
    protected TransaksiStok(int idTransaksi, int idDaging, int idKaryawan,
                             String tanggal, int jumlah, String keterangan) {
        this.idTransaksi = idTransaksi;
        this.idDaging = idDaging;
        this.idKaryawan = idKaryawan;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }
 
    //ini geter
    public int getIdTransaksi() { return idTransaksi; }
    public int getIdDaging() { return idDaging; }
    public int getIdKaryawan() { return idKaryawan; }
    public String getTanggal() { return tanggal; }
    public int getJumlah() { return jumlah; }
    public String getKeterangan() { return keterangan; }
 
    //seter
    public void setIdKaryawan(int idKaryawan) { this.idKaryawan = idKaryawan; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }
 
    public abstract void tampilkan();
}
 
public class StokMasuk extends TransaksiStok {
    private int idSupplier;
 
    public StokMasuk(int idStokMasuk, int idDaging, int idSupplier, int idKaryawan,
                      String tanggalMasuk, int jumlah, String keterangan) {
        super(idStokMasuk, idDaging, idKaryawan, tanggalMasuk, jumlah, keterangan);
        this.idSupplier = idSupplier;
    }
 
    public int getIdSupplier() { return idSupplier; }
    public void setIdSupplier(int idSupplier) { this.idSupplier = idSupplier; }
 
    @Override
    public void tampilkan() {
        System.out.println(getIdTransaksi() + " | Daging:" + getIdDaging() + " | Supplier:" + idSupplier
                + " | Karyawan:" + getIdKaryawan() + " | " + getTanggal() + " | " + getJumlah()
                + " | " + getKeterangan());
    }
}
