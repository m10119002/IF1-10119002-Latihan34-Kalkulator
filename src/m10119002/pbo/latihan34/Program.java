/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10119002.pbo.latihan34;

import java.util.Scanner;

/**
 *
 * @author
 * NAMA     : Firman Sahita
 * KELAS    : IF-1
 * NIM      : 10119002
 * Deskripsi Program : Program ini berisi program Kalkulator
 * (OBJECT ORIENTED)
 * 
 */
public class Program {
    public static Integer val1, val2;
    
    public static Integer masukkanAngka(int fase) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.print("Masukkan Angka ke-".
                concat(Integer.toString(fase)).concat(" : "));
        input = scanner.nextLine();
        
        Integer hasil;
        try {
            hasil = Integer.parseInt(input);
            return hasil;
        } catch (NumberFormatException ex) {
            System.err.println("ERROR: Pastikan nilai berupa Angka!");
            return null;
        } catch (Exception ex) {
            System.err.println("ERROR: Terjadi kesalahan Sistem!");
            return 0;
        }
    }
    
    public static String strPembagian(double hasil) {
        String str;
        if (hasil % 1 == 0) {
            str = Integer.toString((int)hasil);
        } else {
            str = Double.toString(hasil);
            String[] explode = str.split("\\.");
            int akhir = explode.length-1;
            int batas = (explode[akhir].length() > 2? 2 : explode[akhir].length());
            if(explode.length==2) {
                str = explode[0].
                        concat(".").concat(explode[1].substring(0, batas));
            } else {
                for (int i=0; i<explode.length; i++) {
                    if(i==0) str = explode[0];
                    else if(i<akhir) str = str.concat(explode[i]);
                }
                str = str.concat(".").concat(explode[akhir].substring(0, batas));
            }
            str = str.replace('.', ',');
        }
        return str;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Kalkulator kalk = new Kalkulator();
        
        System.out.println("====Aplikasi Kalkulator Bilangan====");
        val1 = masukkanAngka(1);
        while (val1==null) {
            val1 = masukkanAngka(1);
        }
        kalk.value1 = (double) val1;
        val2 = masukkanAngka(2);
        while (val2==null) {
            val2 = masukkanAngka(2);
        }
        kalk.value2 = (double) val2;
        
        System.out.println("");
        
        System.out.println("Hasil Pertambahan : ".
                concat(Double.toString(kalk.tambahBilangan())));
        System.out.println("Hasil Pengurangan : ".
                concat(Double.toString(kalk.kurangBilangan())));
        System.out.println("Hasil Perkalian : ".
                concat(Double.toString(kalk.kaliBilangan())));
        System.out.println("Hasil Pembagian : ".
                concat(strPembagian(kalk.bagiBilangan())));
        System.out.println("Hasil Sisa : ".
                concat(Double.toString(kalk.sisaBilangan())));
    }
    
}
