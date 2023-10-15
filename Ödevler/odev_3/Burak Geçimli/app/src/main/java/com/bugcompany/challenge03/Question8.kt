package com.bugcompany.challenge03

import java.io.File

class Question8 {

    fun calculateSize(directory: File): Long {
        //Klasör var mı yok mu kontrol edilir.
        if (!directory.exists() || !directory.isDirectory) {
            throw IllegalArgumentException("Invalid directory path")
        }

        var totalSize = 0L

        //Rekürsive bir şekilde dosyanın ve alt kalsörlerin boyutu bulunur.
        for (file in directory.listFiles()!!) {
            if (file.isDirectory) {
                totalSize += calculateSize(file)
            } else {
                totalSize += file.length()
            }
        }
        return totalSize
    }


    //Çıkan sonucun daha okunaklı olması için formatlama işlemi.
    fun formatSize(size: Long): String {
        val units = arrayOf("B", "KB", "MB", "GB")
        var unitIndex = 0

        var currentSize = size.toDouble()
        while (currentSize >= 1024.0) {
            unitIndex++
            currentSize /= 1024.0
        }
        return String.format("%.2f %s", currentSize, units[unitIndex])
    }

}





