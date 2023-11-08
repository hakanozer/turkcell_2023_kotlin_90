package Soru2

// Soyut sınıf tanımlama
abstract class Arac(val marka: String, val model: String) {
    // Soyut metot tanımlama
    abstract fun hızlan()
    abstract fun frenYap()
}

// Soyut sınıfı miras alan bir sınıf
class Otomobil(marka: String, model: String) : Arac(marka, model) {
    override fun hızlan() {
        println("$marka $model hızlanıyor.")
    }

    override fun frenYap() {
        println("$marka $model fren yapıyor.")
    }
}

// Soyut sınıfı miras alan başka bir sınıf
class Motosiklet(marka: String, model: String) : Arac(marka, model) {
    override fun hızlan() {
        println("$marka $model hızlanıyor.")
    }

    override fun frenYap() {
        println("$marka $model fren yapıyor.")
    }
}