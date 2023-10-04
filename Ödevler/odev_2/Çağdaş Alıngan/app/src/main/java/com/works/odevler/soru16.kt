package com.works.odevler

// girilen 2 Strin ifadenin  karakter sayılarını karşıllaştıran ve eşit değilse "Karakter sayıları uyuşmuyor"
// uyarısı veren kotlin kodu yazınız.

fun main(args: Array<String>) {
   try {
        val str1 = "çağdaş"
        val str2 = "murat"

        if (str1.length.equals(str2.length)){
            println("Karakter sayıları eşit")
        }else{
            println("Karakter sayıları eşit değil")
        }

   }catch (ex:Exception){
       println("Hata yakalandı : ${ex.message}")
   }finally {
       println("Hocam verdiğiniz 11. soru zormuş bu arada :D")
   }
}