package com.orkestra.junittest

open class NetworkHelper {
    // Fungsi isConnectedToNetwork() mengembalikan Boolean yang menunjukkan apakah perangkat terhubung ke jaringan atau tidak.
    open fun isConnectedToNetwork(): Boolean {
        // Proses ping digunakan untuk memeriksa koneksi ke server Google.
        // Jika exitCode adalah 0, itu berarti koneksi berhasil, jika tidak, koneksi gagal.
        val ping = ProcessBuilder("ping", "-c", "1", "google.com").start()
        val exitCode = ping.waitFor()
        return exitCode == 0
    }
}
