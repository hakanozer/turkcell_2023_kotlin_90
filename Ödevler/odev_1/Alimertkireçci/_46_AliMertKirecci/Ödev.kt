//package _46_AliMertKirecci
////1.soru: - Kullanıcıdan 3 Kenar Değeri Alıyorsun
////Bu 3 Değerden Üçgen Yapılıp Yapılamayacağını
////Test Edip Sonucu Bastıracaksınız
////Her 2 Kenarın Toplamı Diğer 3. Kenara Eşit/Fazlaysa
////Üçgen Olur
//fun main(args: Array<String>) {
//    println("kütfen 1.kenarı giriniz")
//    val kenar1= readLine()!!.toDouble()
//    println("Lütfen 2. kenarı giriniz")
//    val kenar2= readLine()!!.toDouble()
//    println("lütfen 3. kenarı giriniz")
//    val kenar3= readLine()!!.toDouble()
//    if (kenar1!=null&&kenar2!=null&&kenar3!=null&&kenar2>0&&kenar1>0&&kenar3>0){
//        if (kenar1+kenar2>=kenar3&&kenar2+kenar3>=kenar1&&kenar1+kenar3>=kenar2){
//            println("Değerler Üçgen Oluşturmaya Uygundur!$kenar1,$kenar2,$kenar3")
//        }else{
//            println("Değerler Üçgen oluşturmaz$kenar1,$kenar2,$kenar3")
//        }
//    }else{
//        println("Üçgen Oluşturmak için Uygun değil sayıları kontrol edin!$kenar1,$kenar2,$kenar3")
//    }
//    // 2:soru Kullanıcıdan 2 Sayı Alıyorsunuz
////	Bu 2 Büyük ve Küçük Olanını Ekrana Bastırıyorsunuz
////	Eğer Sayılar Eşitse Sayılar Eşittir Mesajını
////	Ekrana Bastırıyorsunuz
//    println("Lutfen birinci Sayıyı girin")
//    val say1= readLine()!!.toDouble()
//    println("Lütfen ikinci değeri giriniz")
//    val say2= readLine()!!.toDouble()
//    if (say2>say1){
//        println("İkinci Sayı Değeri Büyük ==$say2")
//    }else if (say2==say1){
//        println("Sayı değerleri Eşittir Kontrol edin==$say1=$say2")
//    }
//    else{
//        println("Sayı Bir Değeri Büyüktür==$say1")
//    }
//    //3Soru - Kullanıcıya Aşağıdaki Menuyu Gösteriyorsunuz
//    //
//    //	Menu :
//    //	1 - F -> C
//    //	2 - C -> F
//    //	    Secim :
//    //
//    //	Kullanıcı 1'i Seçerse Fahrenheit Değerini Alıyorsunuz
//    //	Girilen Değeri Dereceye Çevirip
//    //	x F = y C Şeklinde Ekranda Gösteriyorsunuz
//    //
//    //	Eğer 2. Seçenek Seçildiyse, C Değerini Alıyorsunuz
//    //	Girilen Değeri Fahrenheit'a Çevirip
//    //	x C = y F Şeklinde Ekranda Gösteriyorsunuz
//    //
//    //	Eğer Kullanıcı Menu Seceneginde 1,2 Dışında Bir Sayı
//    //	Girerse Ekrana Hatalı Seçim Mesajını Bastırmalısınız
//    println("Menü")
//    println("Lütfen Sayı Seçiniz (1,2)?")
//    var number= readLine()!!.toInt()
//    when(number){
//        1->{
//            println("Lütfen Fahrenheit'ten Celsiusa çevirmek istediğiniz değeri giriniz?")
//            var fahrdeger= readLine()!!.toInt()
//            var F=fahrdeger*0.5551-17.7777
//            println("$F =Fahrenheit")
//
//
//        }
//        2->{
//            println("Lütfen Celsiusdan Fahrenheite çevirmek istediğniz değeri giriniz?")
//            var Derece= readLine()!!.toInt()
//            var C=Derece/1.8000-32
//            println("$C =Derece")
//        }
//        else->println("Geçersiz Değer Girdiniz!!")
//    }
//// 4.Soru- Kullanıcıdan Bir N Sayısı Alıyorsunuz
////	1'den N'e Kadar Olan Sayıların Toplamını
////	Ekrana Bastırıyorsunuz (Formulü Araştırın)
//    println("Lütfen Bir N sayısı Giriniz?")
//    var n = readLine()!!.toDouble()
//    println(n*(n+1)/2)
//
//    //5 - Kullanıcıdan 3 Haneli Bir Sayı
//    //	Alıyorsunuz. Bu Sayının
//    //	Basamaklarının Toplamını
//    //	Yazdırıyorsunuz
//    //
//    //	Örnek :
//    //	Sayı Girin : 245
//    //	2 + 4 + 5 = 11
//    println("lütfen 3 Haneli Bir Sayı giriniz")
// var degerler= readLine()!!.toInt()
//    if (degerler >= 100  && degerler <= 999 &&degerler != null ){
//        var bir=degerler % 10
//        var on=(degerler / 10) %10
//        var yüz=degerler / 100
//        val toplam= bir+on+yüz
//        println("Girilen Sayi=$degerler //  Genel Toplam =$bir+$on+$yüz=$toplam")
//    }else{
//        println("Yanlış Değer!!$degerler")
//    }
////6 - Kullanıcıdan 3 Haneli Bir Sayı
////	Alıyorsunuz. Bu Sayının
////	Rakamlarını Tersten Yazdırıyorsunuz
////	Örnek :
////	Sayı Girin : 743
////	347
//    println("lütfen tersten yazdırmak istediğiniz 3 Haneli Bir Sayı giriniz")
//    var degerler2= readLine()!!.toInt()
//    if (degerler2 >= 100  && degerler2 <= 999 &&degerler2 != null ){
//        var yüz=degerler2 / 100
//	var on=(degerler2 / 10) %10
// 	 var bir=degerler2 % 10
//       
//      
//
//        println("Girilen Sayi=$degerler2 //Tersten Yazdırılan sayı  $bir$on$yüz")
//
//    }else{
//        println("Yanlış Değer!!$degerler2")
//    }
//
//    //7 -	Kullanıcıdan Kac Sayi Girecegini Ogren (N)
//    //    Kullanıcıdan N Tane Sayı Al
//    //
//    //    Sayı Girişi Bittikten Sonra Aşağıdakine Benzer Bir Rapor Olustur
//    //    Girilen 17 Sayıdan :
//    //    8 Tanesi Pozitif
//    //    6 Tanesi Negatif
//    //    En Büyüğü : 67
//    //    En Küçüğü : -9
//    //    10 Tanesi Çift
//    //    7 Tanesi Tek
//    //    Toplamları : 567
//    //    Ortalamaları : 33,345
//
//}
//
//
//
//
//yukarda aynı değerler kullanıldığı içiin
fun main(args: Array<String>) {
    println("Kullanılacak n sayısılarını  giriniz:")
    var n = readLine()!!.toInt()
    var toplam1=0
    var tek=0
    var cift=0
    var negatif=0
    var pozit=0
    var buyuk=0
    var kucuk=0
    for(i in 0..n){
                 println("$i lütfen Sayiyi Giriniz:")
        var sayi= readLine()!!.toInt()
        toplam1+=sayi
        if (sayi>0){
            pozit++
        }else{
            negatif++
        }
if (sayi%2==0){
    cift++
}else
{
    tek++
}
        if (sayi>kucuk){
            sayi-=kucuk
        }
        if (sayi<buyuk){
            sayi+=buyuk
        }

        val ortalama=toplam1/n
        println(" $n Kadar Sayı girildi")
        println("$pozit pozitif sayısı")
        println("$negatif negatif sayısı")
        println("$buyuk En Buyk sayi ")
        println("$toplam1 Toplam")
        println("$ortalama Genel Ortalama")
        println("$cift Girilen sayılardan çift olanlar")
        println("$tek girilen sayılardaan tek olanlar")

    }

}