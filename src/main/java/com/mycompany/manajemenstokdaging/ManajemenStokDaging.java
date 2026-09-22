/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajemenstokdaging;
import java.util.ArrayList;
import java.util.Scanner;
import model.Daging;
import model.Karyawan;
import model.StokMasuk;
import model.StokKeluar;
/**
 *
 * @author LENOVO
 */
public class ManajemenStokDaging {
 
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Daging> daftarDaging = new ArrayList<>();
    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();
    static ArrayList<StokMasuk> daftarStokMasuk = new ArrayList<>();
    static ArrayList<StokKeluar> daftarStokKeluar = new ArrayList<>();
 
    static int idDaging = 1, idKaryawan = 1, idStokMasuk = 1, idStokKeluar = 1;
 
    public static void main(String[] args) {
 
        daftarDaging.add(new Daging(idDaging++, "Daging Sapi", "Paha", 10.5,
                "01-09-2026", "10-09-2026", 20, "Tersedia"));
        daftarDaging.add(new Daging(idDaging++, "Daging Ayam", "Dada", 5.0,
                "02-09-2026", "05-09-2026", 15, "Tersedia"));
 
        daftarKaryawan.add(new Karyawan(idKaryawan++, "Budi", "Admin Gudang"));
 
        daftarStokMasuk.add(new StokMasuk(idStokMasuk++, 1, 1, 1,
                "01-09-2026", 20, "Pembelian awal"));
 
        daftarStokKeluar.add(new StokKeluar(idStokKeluar++, 1, 1,
                "05-09-2026", 3, "Penjualan", "Dijual ke pelanggan"));
 
        int pilih;
 
        do {
            System.out.println("=== SISTEM MANAJEMEN STOK DAGING ===");
            System.out.println("1. Data Daging");
            System.out.println("2. Data Karyawan");
            System.out.println("3. Stok Masuk");
            System.out.println("4. Stok Keluar");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = bacaAngka(0, 4);
 
            switch (pilih) {
                case 1: menuDaging(); break;
                case 2: menuKaryawan(); break;
                case 3: menuStokMasuk(); break;
                case 4: menuStokKeluar(); break;
                case 0: System.out.println("Program selesai."); break;
            }
        } while (pilih != 0);
 
        sc.close();
    }
 
    static void menuDaging() {
        int pilih;
        do {
            System.out.println("== Menu Daging ==");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka(0, 4);
 
            if (pilih == 1) {
                String nama = bacaTeks("Nama daging: ");
                String bagian = bacaTeks("Bagian daging: ");
                double berat = bacaDesimalPositif("Berat (kg): ");
                String tglMasuk = bacaTeks("Tanggal masuk: ");
                String tglExpired = bacaTeks("Tanggal expired: ");
                int stok = bacaAngkaPositif("Stok: ");
                String status = bacaTeks("Status: ");
 
                daftarDaging.add(new Daging(idDaging++, nama, bagian, berat, tglMasuk, tglExpired, stok, status));
                System.out.println("Data ditambahkan!");
 
            } else if (pilih == 2) {
                tampilkanDaging();
 
            } else if (pilih == 3) {
                tampilkanDaging();
                if (daftarDaging.isEmpty()) continue;
                int id = bacaAngkaPositif("ID daging yang diubah: ");
                Daging target = cariDaging(id);
                if (target == null) {
                    System.out.println("ID tidak ditemukan!");
                    continue;
                }
                target.setNamaDaging(bacaTeks("Nama baru: "));
                target.setStok(bacaAngkaPositif("Stok baru: "));
                target.setStatus(bacaTeks("Status baru: "));
                System.out.println("Data diubah!");
 
            } else if (pilih == 4) {
                tampilkanDaging();
                if (daftarDaging.isEmpty()) continue;
                int id = bacaAngkaPositif("ID daging yang dihapus: ");
                Daging target = cariDaging(id);
                if (target == null) {
                    System.out.println("ID tidak ditemukan!");
                    continue;
                }
                daftarDaging.remove(target);
                System.out.println("Data dihapus!");
            }
        } while (pilih != 0);
    }
 
    static void tampilkanDaging() {
        System.out.println("ID | Nama | Bagian | Berat | Tgl Masuk | Tgl Expired | Stok | Status");
        if (daftarDaging.isEmpty()) {
            System.out.println("(Belum ada data)");
            return;
        }
        for (Daging d : daftarDaging) {
            d.tampilkan();
        }
    }
 
    static Daging cariDaging(int id) {
        for (Daging d : daftarDaging) {
            if (d.getIdDaging() == id) return d;
        }
        return null;
    }
 
    static void menuKaryawan() {
        int pilih;
        do {
            System.out.println("== Menu Karyawan ==");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka(0, 2);
 
            if (pilih == 1) {
                String nama = bacaTeks("Nama karyawan: ");
                String jabatan = bacaTeks("Jabatan: ");
                daftarKaryawan.add(new Karyawan(idKaryawan++, nama, jabatan));
                System.out.println("Data ditambahkan!");
 
            } else if (pilih == 2) {
                System.out.println("ID | Nama | Jabatan");
                if (daftarKaryawan.isEmpty()) {
                    System.out.println("(Belum ada data)");
                } else {
                    for (Karyawan k : daftarKaryawan) {
                        k.tampilkan();
                    }
                }
            }
        } while (pilih != 0);
    }
 
    static void menuStokMasuk() {
        int pilih;
        do {
            System.out.println("== Menu Stok Masuk ==");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka(0, 2);
 
            if (pilih == 1) {
                int idD = bacaAngkaPositif("ID daging: ");
                Daging d = cariDaging(idD);
                if (d == null) {
                    System.out.println("ID Daging tidak ditemukan! Tambahkan data daging dahulu.");
                    continue;
                }
                int idS = bacaAngkaPositif("ID supplier: ");
                int idK = bacaAngkaPositif("ID karyawan: ");
                String tgl = bacaTeks("Tanggal masuk: ");
                int jumlah = bacaAngkaPositif("Jumlah: ");
                String ket = bacaTeks("Keterangan: ");
 
                daftarStokMasuk.add(new StokMasuk(idStokMasuk++, idD, idS, idK, tgl, jumlah, ket));
                d.setStok(d.getStok() + jumlah);
                System.out.println("Data ditambahkan, stok daging bertambah!");
 
            } else if (pilih == 2) {
                System.out.println("ID | Daging | Supplier | Karyawan | Tanggal | Jumlah | Keterangan");
                if (daftarStokMasuk.isEmpty()) {
                    System.out.println("(Belum ada data)");
                } else {
                    for (StokMasuk s : daftarStokMasuk) {
                        s.tampilkan();
                    }
                }
            }
        } while (pilih != 0);
    }
 
    static void menuStokKeluar() {
        int pilih;
        do {
            System.out.println("== Menu Stok Keluar ==");
            System.out.println("1. Tambah");
            System.out.println("2. Lihat");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pilih = bacaAngka(0, 2);
 
            if (pilih == 1) {
                int idD = bacaAngkaPositif("ID daging: ");
                Daging d = cariDaging(idD);
                if (d == null) {
                    System.out.println("ID Daging tidak ditemukan!");
                    continue;
                }
                int idK = bacaAngkaPositif("ID karyawan: ");
                String tgl = bacaTeks("Tanggal keluar: ");
                int jumlah = bacaAngkaPositif("Jumlah: ");
 
                if (jumlah > d.getStok()) {
                    System.out.println("Stok tidak mencukupi! Stok tersedia: " + d.getStok());
                    continue;
                }
 
                String alasan = bacaTeks("Alasan: ");
                String ket = bacaTeks("Keterangan: ");
 
                daftarStokKeluar.add(new StokKeluar(idStokKeluar++, idD, idK, tgl, jumlah, alasan, ket));
                d.setStok(d.getStok() - jumlah);
                System.out.println("Data ditambahkan, stok daging berkurang!");
 
            } else if (pilih == 2) {
                System.out.println("ID | Daging | Karyawan | Tanggal | Jumlah | Alasan | Keterangan");
                if (daftarStokKeluar.isEmpty()) {
                    System.out.println("(Belum ada data)");
                } else {
                    for (StokKeluar s : daftarStokKeluar) {
                        s.tampilkan();
                    }
                }
            }
        } while (pilih != 0);
    }
 
    static int bacaAngka(int min, int max) {
        while (true) {
            try {
                int nilai = Integer.parseInt(sc.nextLine().trim());
                if (nilai < min || nilai > max) {
                    System.out.print("Pilihan harus antara " + min + "-" + max + ". Coba lagi: ");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka. Coba lagi: ");
            }
        }
    }
 
    static int bacaAngkaPositif(String label) {
        while (true) {
            System.out.print(label);
            try {
                int nilai = Integer.parseInt(sc.nextLine().trim());
                if (nilai <= 0) {
                    System.out.println("Nilai harus lebih dari 0!");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
 
    static double bacaDesimalPositif(String label) {
        while (true) {
            System.out.print(label);
            try {
                double nilai = Double.parseDouble(sc.nextLine().trim());
                if (nilai <= 0) {
                    System.out.println("Nilai harus lebih dari 0!");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
 
    static String bacaTeks(String label) {
        while (true) {
            System.out.print(label);
            String teks = sc.nextLine().trim();
            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue;
            }
            return teks;
        }
    }
}
