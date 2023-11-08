package com.bugcompany.challenge05.Question1

/**
 * Bu konu hakkında yazmış olduğum Medium yazısının Linki
 * https://medium.com/@burakgecimli444/kotlin-kal%C4%B1t%C4%B1m-inheritance-ve-miras-alma-19d32a3b129a
 */

/**
 * Ortak özellikler ve davranışları tanımlamak: Miras, bir sınıfın ortak özelliklerini ve davranışlarını tanımlamak için kullanılabilir
 * Bu, kod yeniden kullanımını artırarak ve kodun daha kısa ve daha öz olmasını sağlayarak yazılım geliştirme sürecini daha verimli hale getirir.
 *
 * Sınıf hiyerarşisi oluşturmak: Miras, sınıflar arasında bir hiyerarşi oluşturmak için kullanılabilir.
 * Bu, sınıfların ilişkilerini ve bağımlılıkları tanımlamak için kullanılabilir.
 *
 * Özelleştirilmiş davranışlar oluşturmak: Miras, temel bir sınıfın davranışlarını özelleştirmek için kullanılabilir.
 * Bu, temel sınıfın özelliklerini ve davranışlarını değiştirmeden yeni özellikler ve davranışlar eklemek için kullanılabilir.
 */


fun main() {
    val invidualCustomer = InvidualCustomer(1, "123", "Burak", "Geçimli")
    val corporateCustomer = CorporateCustomer(2, "789", "Trendyol")

    val customerManager = CustomerManager()
    customerManager.add(invidualCustomer)
    customerManager.add(corporateCustomer)

}