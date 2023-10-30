fun main(args: Array<String>){
    var liste = listOf(1,2,3,4,5,6)
    for(element in liste){
        println(element)
    }
    println()
    for(index in 0..liste.size-1 ){
        println(liste[index])
    }
}