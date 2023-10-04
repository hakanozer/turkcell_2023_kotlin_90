package com.example.alimertkireciodev2

import java.util.Scanner

fun main(args: Array<String>) {
   try {
       println("Üniverste Puanınınızı Giriniz!")
       var scanner=Scanner(System.`in`)
       var Puan=scanner.nextInt()
       if (Puan>=400&&Puan<=500){
           println("&&&&&&&&Tebrikler Mühendislik Fakultesini Kazandınız&&&&&&&&")
       }else{
           println("Puanınız Geçersiz Üzülmeyin Seneye Tekrar Deneyim!")
       }
   }catch (ex:Exception){
       println("-------Puanınız Geçersiz Üzülmeyin Seneye Tekrar Deneyim--------")
   }
  finally {
      println("İşlem Gerçekleştirildi!")
  }
}