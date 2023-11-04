package com.example.sefasatilogluodev5

fun main() {
    //Hayvan listesi olusturduk. Daha sonra Hayvan sinifidan kedi ve kopek hayvanlarini turettik.
    //Override ile hayvanlarin kendine ozgu seslerini hayvanSesi methodunu cagirarak. Kendisine ozgu sesleri cikardi :)

    val hayvanlarListesi = arrayOf(Kopek("Pasa"),Kedi("Boncuk"))
    //Polymorphism kullanarak bu islemi yaptik.
    //Polymorphism kisaca Üst siniftan aldigi özelligi birden cok kez tanımlanıp kullanilmasidir. Kopek sinifi hayvan sinifinda override ettigi ses methodunu islevini gecersiz kılıyor.
    //Bu sayede kedi de kopekde ya da farklı hayvanlar sinifi olsuturarak onlara ait ust siniftan aldıgı ozellgi islevini yani kendi hayvana ozgü sesini cikarmasidir.
    for (hayvan in hayvanlarListesi) {
        hayvan.hayvanSesi()
    }



}