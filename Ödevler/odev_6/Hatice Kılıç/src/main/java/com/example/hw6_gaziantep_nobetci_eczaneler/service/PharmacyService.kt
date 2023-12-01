package com.example.hw6_gaziantep_nobetci_eczaneler.service

import com.example.hw6_gaziantep_nobetci_eczaneler.common.Constants
import com.example.hw6_gaziantep_nobetci_eczaneler.model.PharmacyInfo
import org.jsoup.Jsoup

class PharmacyService : PharmacyServiceNetwork {

    override fun getPharmacies(): List<PharmacyInfo> {
        val pharmacyList = mutableListOf<PharmacyInfo>()
        try {
            val document = connectAndTimeout()
            Constants.date = document.getElementsByClass("nopaddingl").select("h4").text()
            val element = document.getElementsByTag("tbody")[0].getElementsByTag("tr")
            for (i in element) {
                pharmacyList.add(PharmacyInfo(i.text().replace("YAZDIR", "")))
            }
        } catch (e: Exception) {
            handleException(e)
        }
        return pharmacyList
    }

    override fun getPharmaciesOnDuty() {
        try {
            val tdList = connectAndTimeout().select("tbody td")
            tdList.forEachIndexed { index, td ->
                if (td.select("ilce-baslik").isNotEmpty()) {
                    Constants.pharmacyRegion = td.text()
                } else {
                    Constants.pharmacyName = td.select("td:eq(0)").text()
                    Constants.pharmacyAddress = td.select("td:eq(1)").text()
                }
                if (index < tdList.size - 1) {
                    if (tdList[index + 1].select("ilce-baslik")
                            .isEmpty() && Constants.pharmacyRegion != null
                    ) {
                        Constants.pharmacyName = td.select("td:eq(0)").text()
                        Constants.pharmacyAddress = td.select("td:eq(1)").text()
                    }
                }
            }
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun connectAndTimeout() = Jsoup.connect(Constants.URL).timeout(Constants.TIME_OUT).get()

    private fun handleException(e: Exception) = e.printStackTrace()
}