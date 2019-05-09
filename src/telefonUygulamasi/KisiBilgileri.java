package telefonUygulamasi;

import java.util.ArrayList;
import java.util.Scanner;

public class KisiBilgileri {

    private String isim;
    private String soyIsim;
    private long telefonNumarasi;
    private static ArrayList<String> kisiBilgisi = new ArrayList<>();

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public void setTelefonNumarasi(long telefonNumarasi) {
        if (telefonNumarasi < 0)
            this.telefonNumarasi = Math.abs(telefonNumarasi);
        else
            this.telefonNumarasi = telefonNumarasi;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public long getTelefonNumarasi() {
        return telefonNumarasi;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String kisiBilgileriYazdir() {
        return "" + getIsim() + " " + getSoyIsim().toUpperCase();
    }

    public ArrayList<String> birlestir(String pIsim, String pSoyIsım, long pTelefonNumarasi) {

        kisiBilgisi.add("Kisi : " + getIsim() + " " + getSoyIsim().toUpperCase() + "\nTelefon Numarasi : " + getTelefonNumarasi());

        return kisiBilgisi;
    }

    public void tumKisileriListele() {

        for (int i = 0; i < kisiBilgisi.size(); i++) {
            System.out.println((i + 1) + ". " + kisiBilgisi.get(i));
        }

    }

    public void yeniKisiEkle(String pIsim, String pSoyIsim, long pTelefonNumarasi) {

        setIsim(pIsim);
        setSoyIsim(pSoyIsim);
        setTelefonNumarasi(pTelefonNumarasi);

        birlestir(getIsim(), getSoyIsim(), getTelefonNumarasi());

    }

    public void kisiSil() {
        Scanner input = new Scanner(System.in);

        System.out.print("Silmek İstediğiniz Kişinin Numarasını Giriniz : ");
        int kisiNumarasi;
        for (; ; ) {
            kisiNumarasi = input.nextInt();
            if (kisiNumarasi < 0 || kisiNumarasi > kisiBilgisi.size()) {
                System.out.print("Girdiğiniz Kişi Numarasında Herhangi Bir Kişi Bulunmamaktadır" +
                        "Lütfen 1 - " + kisiBilgisi.size() + " Aralığında Bir Değer Giriniz!");
            } else {
                System.out.println(kisiBilgisi.get(kisiNumarasi - 1) + " Bilgilerine Sahip Kişiyi Silmek İstediğinize Emin Misiniz ?" +
                        "\n Evet için e , hayır için h giriniz : ");

                if (onay() == true) {
                    System.out.println(kisiBilgisi.get(kisiNumarasi - 1) + " Bilgilerine Sahip Kişi Silindi.");
                    kisiBilgisi.remove(kisiNumarasi - 1);
                    break;
                } else {
                    System.out.println("İptal Edildi!");
                    break;
                }
            }
        }
    }

    public Boolean onay() {
        Scanner input = new Scanner(System.in);

        String evetHayir = input.nextLine();

        char eH = evetHayir.charAt(0);

        boolean karsilastir;

        for (; ; ) {
            if (eH == 'e' || eH == 'E') {
                karsilastir = true;
                break;
            }
            else if (eH == 'h' || eH == 'H') {
                karsilastir = false;
                break;
            }
            else{
                System.out.print("Lütfen e veya h yaziniz : ");
            }
        }

        return karsilastir;
    }

    public void kisiGuncelle() {
        Scanner input = new Scanner(System.in);
        int kisiNumarasi;
        String yeniIsim, yeniSoyisim,yeniTelefonNumarasi;

        System.out.print("Değiştirmek istediğiniz kişinin kişi numarasını giriniz : ");

        for (; ; ) {
            kisiNumarasi = input.nextInt();

            if (kisiNumarasi < 0 || kisiNumarasi > kisiBilgisi.size()) {
                System.out.print("Girdiğiniz Kişi Numarasında Herhangi Bir Kişi Bulunmamaktadır" +
                        "Lütfen 1 - " + kisiBilgisi.size() + " Aralığında Bir Değer Giriniz!");
            }else
                {
                System.out.println("\nDeğiştirmek istediğiniz kişi :\n" + kisiBilgisi.get(kisiNumarasi - 1) + " mı?\n" +
                        "Evet için e , hayır için h yazınız.");

                if (onay() == true) {
                    System.out.print("İsmi Giriniz : ");
                    yeniIsim = input.next();

                    System.out.print("\nSoyismi Giriniz : ");
                    yeniSoyisim = input.next();

                    System.out.print("\nTelefon Numarasını Giriniz : ");
                    yeniTelefonNumarasi = input.next();

                    kisiBilgisi.set(kisiNumarasi - 1, "Kişi : " + yeniIsim + " " + yeniSoyisim.toUpperCase() + "\nTelefon Numarasi : " + yeniTelefonNumarasi);
                    System.out.println("\n" + kisiBilgisi.get(kisiNumarasi - 1) + " Olarak Bilgileri Değişti.");
                    break;
                } else {

                    System.out.println("İptal Edildi!");
                    break;
                }
            }
        }
    }
}

