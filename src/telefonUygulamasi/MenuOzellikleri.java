package telefonUygulamasi;

import java.util.Scanner;

public class MenuOzellikleri {

    private byte menuNumarasi;
    private KisiBilgileri rehber = new KisiBilgileri();

    public MenuOzellikleri(){

        rehberiEkranaYazdir();

    }

    public int getMenuNumarasi() {

        return menuNumarasi;

    }

    public void baslat() {
        Scanner input = new Scanner(System.in);
        byte menuNumarasi;
        for (;;){
            menuNumarasi = input.nextByte();
            switch (menuNumarasi){
                case 0 : rehberiEkranaYazdir();
                    break;

                case 1 :
                    rehber.tumKisileriListele();
                    System.out.println("Kişiler Listelendi.");
                    System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz : ");
                    break;

                case 2 :
                    yeniKisiEkle();
                    System.out.println(rehber.kisiBilgileriYazdir() + " adlı kişi eklendi.");
                    System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz : ");
                    break;

                case 3 :
                    rehber.kisiGuncelle();
                    System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz : ");
                    break;

                case 4 :
                    rehber.kisiSil();
                    System.out.print("\nHangi İşlemi Yapmak İstiyorsunuz : ");
                    break;

                case 5 :
                    System.out.println("Çıkış Yapıldı.");// Çıkış
                    break;
            }
            if (menuNumarasi == 5)
                break ;
            else if(menuNumarasi>5 || menuNumarasi<0){
                System.out.print("Geçersiz Bir Sayi Girdiniz! Lütfen Tekrar Giriniz : ");

            }
        }
    }

    public void rehberiEkranaYazdir(){
        System.out.println("" +
                "**********************REHBER**********************\n" +
                "0) Menü Tuşlarini Ekrana Yazdir\n" +
                "1) Tüm Kişileri Listele\n" +
                "2) Yeni Kişi Ekle\n" +
                "3) Kişiyi Güncelle\n" +
                "4) Kişi Sil\n" +
                "5) Çıkış\n");
        System.out.print("Hangi İşlemi Yapmak İstiyorsunuz : ");
    }

    public void yeniKisiEkle(){
        Scanner input = new Scanner(System.in);
        String isim, soyIsim;
        long numara;

        System.out.print("İsim Giriniz : ");
        isim = input.nextLine();

        System.out.print("Soyismi Giriniz : ");
        soyIsim = input.nextLine();

        System.out.print("Telefon Numarasını Giriniz :");
        numara = input.nextLong();

        rehber.yeniKisiEkle( isim , soyIsim , numara);

    }


}
