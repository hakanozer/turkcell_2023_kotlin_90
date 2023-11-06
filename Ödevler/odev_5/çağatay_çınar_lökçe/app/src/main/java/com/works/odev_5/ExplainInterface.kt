package com.works.odev_5

class ExplainInterface: Aciklama {
    override fun explaination() {
        println("Interfaceler mantık olarak bir şablondur aslında.Amacına uygun şekilde hangi metodların olması gerektiğini hangi parametreleri alacağını belirttiğimiz bir şablon diyebiliriz.Fakat bu şablonda metodun içini tanımlayamayız.Nesne türetilirken bu metodların içi doldurulur.Ayrıca bunun yapılması zorunludur yoksa nesne türetilemez.Yani bir nesne üretmek istiyorsak override yapmak zorundayız.Bu da bize hata yapma,bir adımı atlama veya bir şeyi unutma olasılığını elimine etme imkanı tanır.Mesela bu ödevde ben Aciklama adı altında bir interface tanımladım ve explaination diye bir metod içeriyor.Println ile açıklama yaptığım bütün nesnelerde bu interface i kullandım.Bütün nesnelerde farklı davranış sergiliyor çünkü hepsinde override ettim mecburen.Böylece her ürettiğim nesnede explaination metodunu tekrar tanımlamak durumunda kalmadım ve zamandan kazandım.")
    }

    open fun explainationb(){
        println("Interfacelere özel bir özellik olarak, bir nesne birden fazla interfaceden miras alabilir.Bu olay aslında tam bir tak-çıkar veya puzzle mantığında olup, nesnenin amacına uygun olacak şekilde metodları implement etmeye yarar ve sonradan kodu değiştirmeyi,kodun bakımını kolaylaştırır.")
    }
}