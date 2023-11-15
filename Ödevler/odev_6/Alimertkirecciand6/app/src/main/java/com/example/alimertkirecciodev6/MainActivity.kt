
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alimertkirecciodev6.EczaneAdapter
import com.example.alimertkirecciodev6.InternetServisi
import com.example.alimertkirecciodev6.NobetciEczane
import com.example.alimertkirecciodev6.R
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


//jsoup da çalışıyorsan sdk lar olmalı
class MainActivity : AppCompatActivity() {
    //Manıfest Üzerinden Internet izni almamız gerekmektedir.
    //async çözümleri eskidir. Thread da olabilir aslında.
    private lateinit var servis : InternetServisi
    private lateinit var Ilce: ListView
    private lateinit var tarihler: TextView
    private lateinit var eczanelerList: List<NobetciEczane>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Yukleme()
        verigetir()
    }
    val url="https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
    val doc:Document=Jsoup.connect(url).timeout(15000).get()

     fun verigetir(  ){
        Log.d("Tag",doc.toString())
        servis = InternetServisi()
        val run = Runnable {
            eczanelerList = servis.Nobetcieczane1()
            runOnUiThread {
                val adapter = EczaneAdapter(this, eczanelerList)
                Ilce.adapter = adapter

                if(InternetServisi.tarih != null){
                    tarihler.text = InternetServisi.tarih
                }

            }
        }//benzer nitelikte bir iş parçacığı kurmak gerekir.
        //==>> aşağıda yazavaığım iş parçacığı.
        Thread(run).start()
        ///Thread iş parçacığı kullanarak ilerleme yapmamızı sağlar.
    }

    fun Yukleme(){
        Ilce = findViewById(R.id.ilce)
        tarihler = findViewById(R.id.tarih)
    }}



//15000 milsc süre verdik eğer gecikme olursa uygulamada hiçbirşey yapamayız bunu yapamadığımız içinde programı yapamayız.bundan dolayı kod serbest hale gelmeli.

