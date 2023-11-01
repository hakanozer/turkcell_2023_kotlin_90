package com.works.odev4

fun main(args: Array<String>) {

    val kisiler = mutableListOf<Kisiler>()

    while(true) {
        println("1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        val choice = try {
            readLine()?.toInt() ?: 0
        }catch(ex: Exception) {
            println("Hata!! Lütfen sadece 1 ve 8 arasında sayı değeri giriniz!")
            continue
        }

        when(choice) {
            1 -> {
                if(kisiler.isEmpty()) {
                    println("Kayıtlı kişi yok!")
                }else {
                    println("Kayitli kisileriniz: ")
                    kisiler.forEachIndexed { sira, kisi ->
                        println("""
                            ${sira +1} . Kisi
                            Adı : ${kisi.ad}
                            Soyadı : ${kisi.soyad}
                            Telefon Numarası : ${kisi.tel}
                        """.trimIndent())
                        println("--------------------------------------------------------")
                    }
                }
            }

            2 -> {

                println("Yeni Kayıt ekle")
                println("Kisi adı:")
                val adi = readLine() ?: ""
                println("Kisi soyadi :")
                val soyadi = readLine() ?: ""
                println("Kisi Telefonu")
                val telefonu = readLine() ?: ""
                val kayit = Kisiler(adi, soyadi, telefonu)
                val yeniKayit = kisiler.add(kayit)
                println("Kisi Bilgileri başarıyla eklendi")

            }


            3 -> {
                println("Kayit Silme")
                println("Silinecek kişinin sira numarasını giriniz: ")
                val siraNo = readLine()?.toIntOrNull() ?: 0

                if(siraNo in 0..kisiler.size-1) {
                    val kisiSilme = kisiler.removeAt(siraNo-1)
                    println("Kişi başarıyla silindi")
                }else {
                    println("Hata! Geçersiz sıra numarası")
                }

            }

            4 -> {
                println("Kayit Güncelle")
                println("Kayit güncellemek için sira no giriniz: ")
                val yeniSiraNo = readLine()?.toIntOrNull() ?: 0

                if(yeniSiraNo in 0..kisiler.size-1) {
                    val guncelKisi = kisiler[yeniSiraNo]
                    println("Güncellenecek kişinin adini giriniz: ")
                    //opsiyonel
                    val guncelAd = readLine() ?: guncelKisi.ad
                    println("Güncellenecek kişinin soyadını giriniz: ")
                    //opsiyonel
                    val guncelSoyad = readLine() ?: guncelKisi.soyad
                    println("Güncellenecek kişinin telefonunu giriniz: ")
                    //opsiyonel
                    val guncelTel = readLine() ?: guncelKisi.tel

                    val guncellenenKisi = Kisiler(guncelAd, guncelSoyad, guncelTel)
                    kisiler[yeniSiraNo] = guncellenenKisi
                    println("Güncelleme başarıyla tamamlandı")

                }else {
                    println("Hata! Geçersiz no girildi")
                }

            }

            5 -> {
                kisiler.clear()
                println("Tüm kayıtlar silindi")

            }

            6 -> {
                println("6 - Kayıt Ara (Ad veya Soyada Göre)")
                val filterInput = readLine() ?: ""
                val adFilter = kisiler.filter { it.ad.contains(filterInput)}
                if(adFilter.isNotEmpty()) {
                    adFilter.forEachIndexed { sira, kisi ->
                        println("""
                            Kisi Sırası: ${sira+1}
                            Kisi adı: ${kisi.ad}
                            Kisi soyadi: ${kisi.soyad}
                            Kisi telefonu: ${kisi.tel}
                            
                        """.trimIndent())
                    }
                }else{
                    println("Kişi bulunamadı")
                }


            }

            7 -> {
                println("7 - Kayıt Ara (Telefon Numarasına Göre)")
                val telInput = readLine() ?: ""
                val telFilter = kisiler.filter { it.tel.contains(telInput)}

                if(telFilter.isNotEmpty()) {
                    telFilter.forEachIndexed { sira, kisi ->
                        println("""
                            Kisi Sırası: ${sira+1}
                            Kisi adı: ${kisi.ad}
                            Kisi soyadi: ${kisi.soyad}
                            Kisi telefonu: ${kisi.tel}
                            
                        """.trimIndent())

                    }
                }else {
                    println("Uygun telefon numarası kayıdı bulunamadı")
                }


            }

            8 -> {
                println("Uygulamadan çıkış istemi")
                break

            }
        }
    }
}