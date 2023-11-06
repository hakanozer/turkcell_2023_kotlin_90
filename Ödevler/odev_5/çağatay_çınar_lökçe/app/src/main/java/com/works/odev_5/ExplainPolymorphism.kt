package com.works.odev_5

open class ExplainPolymorphism: Aciklama {
    override fun explaination() {
        println("Polimorfizm, bir nesnenin aynı arayüze dayanmasına ya da aynı metodu çalıştırmasına rağmen farklı davranışlar göstermesine denir.Nesne yönelimli yazılım dünyası için,esneklik sağlaması,bakımı kolay olması ve kod tekrarından kaçınmayı sağlaması açısından çok önemlidir.Mesela bir hayvan sınıfımız olsun ve bu sınıfın sesCikar metodu olsun.Bu sınıftan kedi ve köpek türetelim ve sesCikar metodunu her iki sinif icin override edelim.Daha sonra hayvan sınıfını parametre olarak alan bir fonksiyon tanımlayalım ve bu fonksiyon içine giren parametrenin sesCikar metodunu tetiklesin.Bu yolla tek bir çağrı ile kedi ve köpek nesnesinden iki farklı davranış görmüş oluruz.Buna polimorfizm denir.\n")
    }
}