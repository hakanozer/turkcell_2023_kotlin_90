package com.gorkemarslanbogan.kotlinvize.Vize


 abstract class HomeWorkAbstract {
    protected fun EkranaYazdir(text:String) {
        println(text)
    }
     //getUserInput kullanıcıdan dinamik şekilde istinilen türde veri almak için abstract içinde yazıdlı
     //global şekilde alt sınıfın tekrara düşmeden istenilen yerde çağırılması için.
    protected fun getUserInput(message: String, inputType: String): Any {
        EkranaYazdir(message)
        val userInput = readLine() ?: ""

        return when (inputType) {
            "double" -> {
                val doubleValue = try {
                    userInput.toDouble()
                } catch (e: NumberFormatException) {
                    EkranaYazdir("Geçersiz giriş. Lütfen bir sayı girin.")
                    null
                }

                doubleValue ?: userInput
            }
            "int" -> {
                val intValue = try {
                    userInput.toInt()
                } catch (e: NumberFormatException) {
                    EkranaYazdir("Geçersiz giriş. Lütfen bir tam sayı girin.")
                    null
                }

                intValue ?: userInput
            }
            "boolean" -> {
                val lowerCaseInput = userInput.toLowerCase()
                if (lowerCaseInput == "true" || lowerCaseInput == "false") {
                    lowerCaseInput.toBoolean()
                } else {
                    EkranaYazdir("Geçersiz giriş. Lütfen 'true' veya 'false' girin.")
                    userInput
                }
            }
            else -> userInput
        }
    }
}

private interface IHomeWork {
    fun Soru1()
    fun Soru2()
    fun Soru3()
    fun getSumOfAllPrimes(n: Int) : Int
    fun Soru5(number: Int) : Boolean
    fun Soru6(Calisan: Personel, calisilanSaat: Int)
    fun Soru7()
    fun Soru8()
}

 class HomeWork : HomeWorkAbstract(), IHomeWork {
    override fun Soru1() {
        try {
            val stringNumber = "1234"
            var toplam = 0
            if(stringNumber.length == 4) {
                for (char in stringNumber){
                    if(char.isDigit())
                    toplam += char.toString().toInt()
                }
                EkranaYazdir("Sayının rakamları toplamı: $toplam")
            }else {
                 EkranaYazdir("Lütfen 4 Basamaklı Bir Sayi Girin")
            }
        }catch (exception: IllegalArgumentException){
            exception.printStackTrace()
        }
    }

    override fun Soru2() {
        try {
            val stringNumber = "14532"
            if(stringNumber.length == 5) {
                EkranaYazdir(stringNumber.reversed())
            }
        }catch (exception: IllegalArgumentException){
            exception.printStackTrace()
        }
    }

    override fun Soru3() {
        val number = 20
        val toplam = seriToplamHesapla(number)
        EkranaYazdir("Serinin Toplam: $toplam")
    }

    override fun getSumOfAllPrimes(n: Int): Int {
        var toplam = 0
        for(i in 1..n){
            if(isPrime(i)) {
                toplam += i
            }
        }
        EkranaYazdir("Sayının rakamları toplamı: $toplam")
        return toplam
    }

    override fun Soru5(number: Int): Boolean {
        EkranaYazdir("Sayı ${if (isPrime(number)) "Asal" else "Asal Değil" }")
        return isPrime(number)
    }

     override fun Soru6(calisan: Personel, ekCalisilanSaat: Int) {
         val className = calisan.javaClass.simpleName
         EkranaYazdir("$className bu ay alınacak maas: ${calisan.maasHesapla(ekCalisilanSaat)}")
     }

     override fun Soru7() {
    //         Class (Sınıf) : bir veya birden fazla veri yapısını ve metodları tek bir çatı altında toplayan ve istenilen şekilde
    //         aksiyon aldırabileceğimiz özel bir veri yapısıdır sınıf.
    //         İçinde değişkenler, metodlar, constructorlar bulunur.
    //         Uygulamamızın içinde her bir sınıf bir nesneyi temsil eder bu nesneler aracığıyla uygulamamızı daha modüler
    //         düzenli ve gelişime açık hale getirmemize yarar.
    //         Sınıflar üst sınıf dediğimiz ata sınıflardan özellik metodlar alabilir ve kendi özelliklerini geliştirebilir.
    //         Her sınıf sadece 1 kez kalıtım alabilir.
    //
    //         Object (Nesne) : Nesneler bir sınıfın örneğini temsil eder her nesne sınıfa ait belirle metodları değişkenleri vb
    //         veri yapılarına sahiptir Örneğin Hayvan sınıfından ürettiğimiz kedi nesnesi bir hayvan sınıfını temsil eder ve
    //         o özelliklere sahiptir. ve hayvanların ortak özelliklerini temsil eder çıkardığı ses, fiziksel yapısı vb şeyleri.
    //
    //         Abstract Class: Soyut sınıflar tam bir sınıf değildir içinde metodlar ve değişkenler bulunur amacı soyut sınıftan türetilen
    //                 sınıflara iskelet görevi görür hangi metodu hangi değişkene ihtiyacı olduğunu belirtir.
    //         Ortak özellikleri olan sınıflar için kullanılır ve kod tekrarını azaltır bakımını ve geliştirilebilirliği arttırır.
    //
    //         İnterface (Ara yüz) : Sınıflar arasında belirli metodları paylaşmayı sağlar ve ilgili sınıfın o metodu kullanacağına
    //         teminat garanti verir.
    //         Metodlar soyut haldedir alt sınıfta fonksiyonun gövdesi doldurulmak zorundadır.
    //         Bir sınıf birden fazla arayüze sahip olabilir.
    //         İnterfaceler isimlendirme gereği başında I kullanılır IKotlinInterface gibi zorunlu değildir ama yazılım kültürüne
    //         yerleşmiş bir kuraldır.
    //         İnterfaceler ekip çalışmasında kolaylık sağlar bir sınıfın birden fazla metoda sahip olmasını kod tekrarını ve modülerliği arttırır.
     }

     override fun Soru8() {
         //public
         // default erişim belirtecidir ilgili değişkene metoda yapıya her yerden erişilebilir kılar
         // yerine göre güvenlidir yerine göre güvenlik açığı oluşturabilecek kadar tehlikelidir.
         //Çünkü bu metodlar her yerde kullanılabilir değişkenlerin ise her yerden değeri manipüle edilebilir.

         //private
        //ilgili değişkene metoda yapıya sadece bulunduğu (ilgili) sınıf içinden erişilebilir
        //ilgili yapıyı güvenilir kılar
        //private yapılarda değişkenlere sınıf içerisinden
        // getter setter yapılarıyla erişilip içeriği değiştirilebilir

       //protected
       //ilgili sınıf ve bu sınftan türetilen alt sınıflar tarafından erişilebilir
       //değerler ilgili sınıf ve kalıtılan sınıflar tarafından değiştirilebilir.
       //metodlar kullanılabilir
       //amacı belirli bir kominüte içinde metodları ve değişken yapılarını kullanmaktır.
       //publiğe göre daha güvenlidir.

        //internal modül (proje içinden) her yerden erişilebilir public'ten tek farkı
         //başka projelerden bu class metod değişkenlere erişilemez sadece bulunduğu
         //projelerden erişilebilir.


     }


     companion object {
        fun seriToplamHesapla(number: Int) : Double {
            var faktoriyel = 1
            var toplam  = 0.0
            for(i in 1..number){
                faktoriyel *= i
                toplam += i.toDouble() / faktoriyel
            }
            return toplam
        }
         fun isPrime(number: Int): Boolean {
            var response = true
            if (number >= 2) {
                for (i in 2 until number) {
                    if (number % i == 0) {
                        response = false
                        break
                    }
                }
            }else if(number < 0) {
                throw NumberFormatException("Lütfen 0'dan büyük bir sayı giriniz..")
            }
            else {
                response = false
            }
            return response
        }
    }

}