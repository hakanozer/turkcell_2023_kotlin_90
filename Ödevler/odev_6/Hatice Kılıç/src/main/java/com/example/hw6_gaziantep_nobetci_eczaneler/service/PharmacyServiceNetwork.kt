package com.example.hw6_gaziantep_nobetci_eczaneler.service
import com.example.hw6_gaziantep_nobetci_eczaneler.model.PharmacyInfo

interface PharmacyServiceNetwork {
    fun getPharmacies() :List<PharmacyInfo>
    fun getPharmaciesOnDuty()
}