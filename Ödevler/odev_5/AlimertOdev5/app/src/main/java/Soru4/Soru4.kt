package Soru4

/*
-Sözleşmeleri Tanımlamak: Arayüzler, bir sınıfın belirli metotları uygulama taahhüdünü tanımlar.
Bu, bir sınıfın belirli davranışları sağlama sözü verdiği bir sözleşme
(contract) oluşturmak için kullanılır.
-Çoklu Kalıtımı Sağlamak: Kotlin,
bir sınıfın yalnızca bir tane üst sınıfı miras almasına izin verir,
 ancak birden fazla arayüzü uygulayabilirsiniz.
 -Bağımsızlık ve Modülerlik Sağlamak: Arayüzler,
 bağımsızlık ve modülerlik sağlar. Sınıfın nasıl davranması gerektiği,
  bu sınıfın ilgili arayüzü uygulayarak tanımlanır.
-Daha Fazla Soyutlama: Arayüzler, daha fazla soyutlama ve modülerlik sağlar.
  Bu, karmaşık yazılım projelerini daha iyi düzenlemenize yardımcı olur.
  -Proje İşbirliği: Büyük yazılım projelerinde,
  arayüzler proje işbirliğini artırabilir.
  Bir ekip belirli bir arayüzü tanımlayabilir ve diğer ekip bu arayüzü uygulayabilir.
  Bu, farklı bileşenlerin uyumlu bir şekilde çalışmasına yardımcı olur.
* */
fun main(args: Array<String>) {
    val araba = sorudört()
    araba.hareketEt()


}
