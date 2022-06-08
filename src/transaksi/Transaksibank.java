package transaksi;
import java.util.ArrayList;

public class Transaksibank {
    public String nama;
    public int nomorRekening;
    public int saldo;

    ArrayList<String> mutasi = new ArrayList<String>();

    public Transaksibank (String nama, int nomorRekening, int saldo){
        this.nama = nama;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public boolean cekSaldo(int jumlah){
        if(jumlah < this.saldo){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cekNasabah(int nomorRekening){
        if(nomorRekening == this.nomorRekening){
            return true;
        }
        return false;
    }

    public void tarikUang(int jumlah){
        if(cekSaldo(jumlah)){
            this.saldo -= jumlah;
        }
    }

    public void simpanUang(int jumlah, int nomorRekening, Transaksibank t1){
        t1.saldo += jumlah;
    
    }

    public void transferUang(int jumlah, int nomorRekening, Transaksibank t1){
        if(cekSaldo(jumlah)){
            tarikUang(jumlah);
            simpanUang(jumlah, nomorRekening, t1);
            System.out.println("Transaksi anda berhasil!!");
            System.out.println("Anda melakukan transfer uang sebesar Rp " + jumlah + "ke nomor rekening " + nomorRekening);
            mutasi.add("Transfer uang dengan jumlah uang sebesar " + jumlah + " telah berhasil");
        }
    }

    public void mutasiRekening(){
        for(String mts : mutasi){
            System.out.println(mts);
        }
    }


}
