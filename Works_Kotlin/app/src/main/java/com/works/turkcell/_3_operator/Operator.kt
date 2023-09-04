package com.works.turkcell._3_operator

fun main(args: Array<String>) {

    var a=11;
    var ax = 11
    var b=5;
    var age = 18
    println(a+b);
    println(a-b);
    println(a*b);
    println(a/b);
    println(a%b); // a sayısının b sayısına bölümünden kalan

    // Kıyaslama operatörleri
    // Büyükse (a, b 'den büyük ise)
    var status = a > b
    println(" 17. $status" )
    status = a < b
    println(" 19. $status" )
    if (status) {
        println("a > b")
    }

    status = age >= 18
    println(" 25. $status" )
    status = age <= 17
    println(" 27. $status" )

    var name1 = "Ali"
    var name2 = "Veli"

    // Any türü içerisine her türlü değeri alabilen türlerdir.
    var x:Any = "sali"
    var y:Any = "sali"
    if ( x === y ) {

    }

    if (  name1.equals(name2) ) {

    }

    if ( name1 === name2 ) {

    }

    if ( a == ax ) {

    }

    // Atama operatörleri
    // +=, -=, *=, /=, %=
    var num1 = 10.0
    var num2 = 20.0

    num1 += num2 // num1 = num1 + num2
    println("num1 : $num1")

    // ++, --
    var i = 0;
    // ++ değeri bir artırmak için kullanılır.
    // ++i i = i + 1
    ++i // 1
    println(i)
    i++ // 2
    println(i)

    println(i++)
    println(++i)

    // ! -> değilse
    println(status)
    println(!status)


    // Mantıksal operatörler
    var q = 10
    var w = 11
    var username = "ali@mail.com"
    var password = "1234"
    // && -> ve -> sol tarafta bulunan şart ile sağ tarafta bulunan şart sağlandı ise
    status = username.equals("ali@mail.com") && password.equals("12345")
    if ( status ) {
        println("Login Success")
    }else {
        println("Username or Password Fail")
    }

    // || -> veya -> sol taraf yada sağ tarafdaki koşullardan her hangi birinin sağlanması durumunda
    



}