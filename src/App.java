
import java.util.Scanner;
import transaksi.Transaksibank;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int pilihan = 0;
        String ulang = "y";
        Transaksibank susi = new Transaksibank("Susi", 1234567, 500000);
        Transaksibank budi = new Transaksibank("Budi", 8910111, 500000);
        while(ulang.equalsIgnoreCase("y")){
            pilihan = pilihMenu(keyboard);
            bersihkanLayar();
            if(pilihan == 1){
                bersihkanLayar();
                cekSaldoAkun(susi, budi);
            }
            else if(pilihan == 2){
                bersihkanLayar();
                transferUangAkun(keyboard, susi, budi);
            }
            else if(pilihan ==3){
                bersihkanLayar();
                printMutasiRekning(susi);
            }
            else{
                bersihkanLayar();
                System.out.println("Terima kasih");
                break;
            }
            System.out.println("Anda ingin mengulang transaksi kembali [y/n] ? ");
            ulang = keyboard.next();
            if(ulang.equalsIgnoreCase("n")){
                bersihkanLayar();
                System.out.println("Terima kasih");
            }
        }

    }

    public static int pilihMenu(Scanner keyboard){
        int pilihan;
        System.out.println("=====================================================================================================");
        System.out.println("Bank JAVA");
        System.out.println("=====================================================================================================");
        System.out.println("1.Cek saldo akun");
        System.out.println("2.Transfer uang");
        System.out.println("3.Cek mutasi");
        System.out.println("4.Keluar");
        System.out.print("Pilihlah transaksi yang anda inginkan = ");
        pilihan = keyboard.nextInt();
        return pilihan;
    }

    public static void bersihkanLayar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void cekSaldoAkun(Transaksibank t1, Transaksibank t2){
        System.out.println("Nasabah " + t1.nama + " dengan nomor rekening " + t1.nomorRekening + " dan saldo " + t1.saldo);
        System.out.println("Nasabah " + t2.nama + " dengan nomor rekening " + t2.nomorRekening + " dan saldo " + t2.saldo);
    }

    public static void transferUangAkun(Scanner keyboard, Transaksibank t1, Transaksibank t2){
        int jumlahUang;
        System.out.print("Masukkan jumlah uang yang ingin anda transfer = ");
        jumlahUang = keyboard.nextInt();
        t1.transferUang(jumlahUang, 8910111, t2);

        System.out.println("Sisa Saldo anda = Rp " + t1.saldo);
        System.out.println("Saldo budi = Rp " + t2.saldo);
    }

    public static void printMutasiRekning(Transaksibank t1){
        t1.mutasiRekening();
    }

}
