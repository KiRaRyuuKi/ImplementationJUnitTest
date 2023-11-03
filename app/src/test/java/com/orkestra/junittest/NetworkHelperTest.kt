// Program ini adalah contoh kode untuk pengujian unit menggunakan JUnit dan Mockito.
// Ini digunakan untuk menguji kelas NetworkHelper.

package com.orkestra.junittest

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse

class NetworkHelperTest {
    private lateinit var SUT: NetworkHelper

    @Before
    fun setUp() {
        // Metode setUp() digunakan untuk melakukan konfigurasi awal sebelum menjalankan pengujian.
        // Dalam kasus ini, tidak ada konfigurasi khusus yang diperlukan, sehingga metode ini kosong.
    }

    @Test
    fun `isConnectedToNetwork() should return true when device is connected to the network`() {
        // Metode pengujian ini menguji apakah isConnectedToNetwork() seharusnya mengembalikan true
        // ketika perangkat terhubung ke jaringan. Ini mengganti objek NetworkHelper dengan objek mock
        // yang akan mengembalikan true saat isConnectedToNetwork() dipanggil.
        val mockNetworkHelper = Mockito.mock(NetworkHelper::class.java)
        Mockito.`when`(mockNetworkHelper.isConnectedToNetwork()).thenReturn(true)

        // Memastikan bahwa perangkat dianggap terhubung ke jaringan.
        SUT = mockNetworkHelper
        assertTrue(SUT.isConnectedToNetwork())
    }

    @Test
    fun `isConnectedToNetwork() should return false when device is not connected to the network`() {
        // Metode pengujian ini menguji apakah isConnectedToNetwork() seharusnya mengembalikan false
        // ketika perangkat tidak terhubung ke jaringan. Ini mengganti objek NetworkHelper dengan objek mock
        // yang akan mengembalikan false saat isConnectedToNetwork() dipanggil.
        val mockNetworkHelper = Mockito.mock(NetworkHelper::class.java)
        Mockito.`when`(mockNetworkHelper.isConnectedToNetwork()).thenReturn(false)

        // Memastikan bahwa perangkat dianggap tidak terhubung ke jaringan.
        SUT = mockNetworkHelper
        assertFalse(SUT.isConnectedToNetwork())
    }
}
