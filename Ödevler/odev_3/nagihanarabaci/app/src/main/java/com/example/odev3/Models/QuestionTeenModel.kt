package com.example.odev3.Models

data class QuestionTeenModel(val fileName: String, val directoryName: String, val fileSize: Long) {
    companion object {
        fun convertByteToMb(byte: Long): Long {
            return byte / (1024 * 1024)
        }
    }

    override fun toString(): String {
        return "FileName: $fileName, DirectoryName: $directoryName, FileSize: ${fileSize} byte, ${
            convertByteToMb(
                fileSize
            )
        } mb"
    }
}

