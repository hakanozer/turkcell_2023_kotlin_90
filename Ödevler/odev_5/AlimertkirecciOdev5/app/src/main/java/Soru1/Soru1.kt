import Soru1.Araba
import Soru1.Motosiklet
import Soru1.Tasit

import android.text.style.TabStopSpan

/*1.Soru:
Inheritance::A:
Kalıtım Nesne yönelimli programlama dilinin en önemli özelliğidir.Kalıtım mevcut sınıfın
(veya temel veya üst sınıfın) özelliğinin yeni sınıfa ( veya türetilmiş sınıfa veya alt sınıfa)miras alınmasına olanak tanır.
Ana Sınıfa (süper sınıf veya ana sınıf) adı verilir ve üst sınıfı miras alan sınıfı alt sınıf adı verilir.
alt sınıf kendi özelliklerinin yanı sıra üst sınıfın özelliklerini de içerir.
İki veya daha fazla sınıfın aynı özelliklere sahip olması durumunda kalıtım kavramına izin verilir.Kodun yeniden
kullanabilirliğine izin verir.Türetilmiş bir sınıfın yanlızca bir temel sınıfı vardır ancak birden fazla arayüze sahip olabilirken,
bir temel sınıfın bir veya daha fazla türetilmiş sınıfı olabilir.
Kotlinde türetilmiş sınıf,sınıf başlığındaki :operatörünü kullanarak bir temel sınıfı miras alır,Türetme sınıfı adından veya
yapıcıdan sonra.
*
1.Sorunun A Seçeneğinin Örneği için B Örneğine Fazladan alan Ekledim.
*/



fun main(args: Array<String>) {
    val araba = Araba("Bmw", "3 Serisi", 2022)
    araba.bilgileriGöster()
    araba.sür()

    val motosiklet = Motosiklet("Kavasaki", "1000R", 2021)
    motosiklet.bilgileriGöster()
    motosiklet.sür()
    val tasit = Tasit("Otobüs", "Mercedes", 2012)
    motosiklet.bilgileriGöster()
    motosiklet.sür()
}