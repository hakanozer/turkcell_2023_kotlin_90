package Soru2
/*Abstract (Soyut)
Soyut anahtar kelimeyle bildiren sınıfa soyut sınıf denir.Soyut bir sınıf başlatılmaz.Yani soyut sınıfın nesnesini yaratamayız.
Soyut sınıfın yöntemi ve özellikleri ,açıkça soyut olarak bildirilmedikçe Soyut değildir.
Soyut sınıflar,uygulama olmayan ancak türetilmiş sınıfa uygulanması gereken kısmen tanımlanmış sınıflar,yöntemler ve
özelliklerdir.Türetilmiş sınıf ,temel sınıfın özelliklerini uygulamıyorsa o zaman aynı zamanda soyut bir sınıf olması gerekir.
Soyut sınıf veya soyut işlevin , varsayılanı olarak açık oldukları için open anahtar sözcüğü ile açıklama eklenmesine gerek yoktur.
Soyut üye işlevi gövdesi içermez.Üye işlevi ,soyut sınıfın gövdesinde yer alıyorsa soyut olarak bildirilmez.
*/
fun main(args: Array<String>) {
    val otomobil = Otomobil("Ford", "Focus")
    val motosiklet = Motosiklet("Yamaha", "YZF-R6")

    otomobil.hızlan()
    otomobil.frenYap()

    motosiklet.hızlan()
    motosiklet.frenYap()
}