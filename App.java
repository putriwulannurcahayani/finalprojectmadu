//tambahan insertsorting ->berdasarkan hargajual,hargabeli,stok

import java.util.ArrayList;
import java.util.Scanner;

//class madu
class Madu {
    // atribut variable madu
    String kodeProduk;
    String namaProduk;
    int stok;
    int harga;

    // constructor
    Madu(String kodeProduk, String namaProduk, int stok, int harga) {
        this.kodeProduk = kodeProduk;
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.harga = harga;
    }

    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        stok -= jumlah;
    }

    public void detail_produk() {
        System.out.println("Kode Produk: " + kodeProduk);
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Stok : "+stok);
        System.out.println("Harga : "+harga);
    }
}
//class pembelian
class Pembelian {
    String tanggal;
    String namaSupplier;
    int jumlahKg;
    int hargaKg;

    //constructor
    Pembelian(String tanggal, String namaSupplier, int jumlahKg, int hargaKg) {
        this.tanggal = tanggal;
        this.namaSupplier = namaSupplier;
        this.jumlahKg = jumlahKg;
        this.hargaKg = hargaKg;
    }

    public int hitungTotalHarga() {
        return jumlahKg * hargaKg;
    }

    public void detailPembelian() {
        System.out.println("Tanggal : "+tanggal);
        System.out.println("Nama Supplaier : "+namaSupplier);
        System.out.println("Jumlah(kg) : "+jumlahKg);
        System.out.println("Harga (per kg): "+hargaKg);
    }
}

//class penjualan
class Penjualan {
    String tanggal;
    String namaPembeli;
    int jumlahKg;
    int hargaKg;

    //constructor
    Penjualan(String tanggal, String namaPembeli, int jumlahKg, int hargaKg) {
        this.tanggal = tanggal;
        this.namaPembeli = namaPembeli;
        this.jumlahKg = jumlahKg;
        this.hargaKg = hargaKg;
    }

    public int hitungTotalHarga() {
        return jumlahKg * hargaKg;
    }

    //detail penjualan
    public void detail_penjualan() {
        System.out.println("Tanggal : "+tanggal);
        System.out.println("Nama Pembeli :"+namaPembeli);
        System.out.println("Jumlah (kg) : "+jumlahKg);
        System.out.println("Harga (kg) : "+hargaKg);
    }
}
//class laporan
class LaporanPembukuanMadu {
    ArrayList<Madu> daftarMadu = new ArrayList<Madu>(50);
    ArrayList<Penjualan> daftarPenjualan = new ArrayList<Penjualan>(50);

    public  void sortinginsertionHarga(ArrayList<Madu> arr) {
        int panjangarr = arr.size();
        for (int i = 1; i < panjangarr; i++) {
            Madu key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j).harga > key.harga) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        System.out.println("Hasil sorting ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Kode Madu : "+arr.get(i).kodeProduk);
            System.out.println("Nama Madu : "+arr.get(i).namaProduk);
            System.out.println("Harga Jual : "+arr.get(i).harga);
            System.out.println("Stok : "+arr.get(i).stok);
        }
    }

    public static void sortinginsertionStok(ArrayList<Madu> arr) {
        int panjangarr = arr.size();
        for (int i = 1; i < panjangarr; i++) {
            Madu key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j).stok > key.stok) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
        System.out.println("Hasil sorting ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Kode Madu : "+arr.get(i).kodeProduk);
            System.out.println("Nama Madu : "+arr.get(i).namaProduk);
            System.out.println("Harga Jual : "+arr.get(i).harga);
            System.out.println("Stok : "+arr.get(i).stok);
        }
    }

    public Madu binarySearch(ArrayList<Madu> arr, String kode) {
        int l = 0;
        int r = arr.size() - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            int result = arr.get(mid).kodeProduk.compareTo(kode);
            if (result == 0) {
                System.out.println("Madu ditemukan");
                return arr.get(mid);
            } else if (result < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println("Madu tidak ditemukan");
        return null;
    }

    public void tambahMadu() {
        System.out.println("== Tambah Data Madu ==");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kode Produk: ");
        String kodeProduk = scanner.nextLine();
        System.out.print("Nama Produk: ");
        String namaProduk = scanner.nextLine();
        System.out.print("Stok: ");
        int stok = Integer.parseInt(scanner.nextLine());
        System.out.print("Harga : ");
        int harga = Integer.parseInt(scanner.nextLine());

        Madu madu = new Madu(kodeProduk, namaProduk, stok, harga);
        daftarMadu.add(madu);
        System.out.println("Data madu berhasil ditambahkan.\n");
    }

    public void hapusMadu() {
        if (daftarMadu.isEmpty()) {
            System.out.println("Belum ada data madu yang tersedia.\n");
            return;
        }

        System.out.println("== Hapus Data Madu ==");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kode Produk Madu yang akan dihapus: ");
        String kodeProduk = scanner.nextLine();

        Madu madu = binarySearch(daftarMadu, kodeProduk);
        if (madu != null) {
            daftarMadu.remove(madu);
            System.out.println("Data madu berhasil dihapus.\n");
        } else {
            System.out.println("Data madu tidak ditemukan.\n");
        }
    }
    public void tambahPenjualan() {
        if (daftarMadu.isEmpty()) {
            System.out.println("Belum ada data madu yang tersedia. Tambahkan data madu terlebih dahulu.\n");
            return;
        }

        System.out.println("== Tambah Data Penjualan ==");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tanggal: ");
        String tanggal = scanner.nextLine();
        System.out.print("Nama Pembeli: ");
        String namaPembeli = scanner.nextLine();
        System.out.print("Kode Produk Madu yang Dijual: ");
        String kodeProduk = scanner.nextLine();

        Madu madu = binarySearch(daftarMadu, kodeProduk);
        if (madu == null) {
            System.out.println("Data madu tidak ditemukan.\n");
            return;
        }
        System.out.print("Jumlah (Kg): ");
        int jumlahKg = Integer.parseInt(scanner.nextLine());
        int hargaKg = madu.harga;
        if (madu.stok < jumlahKg) {
            System.out.println("Stok madu tidak mencukupi.\n");
            return;
        }

        Penjualan penjualan = new Penjualan(tanggal, namaPembeli, jumlahKg, hargaKg);
        daftarPenjualan.add(penjualan);
        madu.kurangiStok(jumlahKg);
        System.out.println("Data penjualan berhasil ditambahkan.\n");
    }

    public void tampilkanLaporan() {
        if (daftarPenjualan.isEmpty()) {
            System.out.println("Belum ada data penjualan yang tersedia.\n");
            return;
        }

        System.out.println("== Laporan Penjualan ==");
        for (Penjualan penjualan : daftarPenjualan) {
            System.out.println("Pembeli : "+penjualan.namaPembeli);
            System.out.println("Tanggal Pembelian :"+penjualan.tanggal);
            System.out.println("Jumlah : "+penjualan.jumlahKg);
            System.out.println("Harga : "+penjualan.hargaKg);
            System.out.println("Total : "+penjualan.hargaKg*penjualan.jumlahKg);
        }
    }

    public void DaftarMadu() {
        if(daftarMadu.isEmpty()){
            System.out.println("Belum ada data madu yang tersedia.\n");
        }else{
            for (Madu madu : daftarMadu) {
                System.out.println("Kode Madu : "+madu.kodeProduk);
                System.out.println("Nama Madu : "+madu.namaProduk);
                System.out.println("Stok Madu : "+madu.stok);
                System.out.println("Harga  : "+madu.harga);
            }
        }
    }
    public void menuDaftarMadu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Daftar Madu");
        System.out.println("2. Urutkan berdasarkan Harga");
        System.out.println("3. Urutkan berdasarkan Stok");
        System.out.print("Masukan Pilihan: ");
        int pilihan = Integer.parseInt(scanner.nextLine());
        if (pilihan == 1) {
            DaftarMadu();
        }else if(pilihan==2){
            sortinginsertionHarga(daftarMadu);
        }else if(pilihan == 3){
            sortinginsertionStok(daftarMadu);
        }else{
            System.out.println("Pilihan Salah");
        }


    }
}

public class App {
    public static void main(String[] args) {
        LaporanPembukuanMadu pembukuanMadu = new LaporanPembukuanMadu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Aplikasi Pembukuan Madu ===");
            System.out.println("1. Tambah Data Madu");
            System.out.println("2. Hapus Data Madu");
            System.out.println("3. Tambah Data Penjualan");
            System.out.println("4. Tampilkan Laporan Penjualan");
            System.out.println("5. Daftar Madu");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            int menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1:
                    pembukuanMadu.tambahMadu();
                    break;
                case 2:
                    pembukuanMadu.hapusMadu();
                    break;
                case 3:
                    pembukuanMadu.tambahPenjualan();
                    break;
                case 4:
                    pembukuanMadu.tampilkanLaporan();
                    break;
                case 5:
                    pembukuanMadu.menuDaftarMadu();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang sesuai.\n");
            }
        }
    }

}