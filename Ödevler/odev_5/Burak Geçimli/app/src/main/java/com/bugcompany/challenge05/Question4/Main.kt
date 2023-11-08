package com.bugcompany.challenge05.Question4

/**
 * Bir sınıfın davranışını tanımlamak ve zorlamak için bir sözleşme olarak işlev görürler.
 * Bir interface, bir sınıfın hangi metodları uygulaması gerektiğini belirtir, ancak metodların nasıl uygulanacağını belirtmez.
 * Bu şekilde, farklı sınıflar aynı interface’i uygulayarak ortak bir davranışa sahip olabilirler.
 * Bir sınıfın birden fazla interface’i uygulamasına izin verirler.
 * Bu, çoklu kalıtımın sağladığı esnekliği verir, ancak çoklu kalıtımın karmaşıklığını ve sorunlarını önler.
 * Bir sınıf, birden fazla interface’in metodlarını uygulayarak farklı rolleri yerine getirebilir.(Yetenek kazanırlar)
 * Bir sınıfın iç yapısını gizlemek için soyutlama sağlarlar. Bir interface, bir sınıfın ne yaptığını belirtir, ancak nasıl yaptığını gizler.
 * Bu, sınıfın uygulamasının değiştirilmesini kolaylaştırır, çünkü interface’in kullanıcıları sınıfın nasıl çalıştığını bilmezler.
 * Interface'ler is-a hiyerarşisinde üst tip olmanın yanında implement edilen sınıfa yetkinlikte kazandırır.(able)Örneğin Comparable bir arayüzdür
 */

fun main() {
    val calculator = Calculator()

    calculator.add(10, 20)
    calculator.subtract(20, 5)
    calculator.log(50.0, 2.0)

}