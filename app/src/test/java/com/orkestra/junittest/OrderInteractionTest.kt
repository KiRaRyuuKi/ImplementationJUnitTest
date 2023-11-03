package com.orkestra.junittest

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OrderInteractionTest {
    private val LAPTOP = "Macbook"

    @Test
    fun `test warehouse capacity is reduced when fulfilling order`() {
        // Membuat objek Order untuk produk "Macbook" dengan pesanan 50 unit.
        val order = Order(LAPTOP, 50)

        // Membuat objek mock Warehouse untuk menggantikan gudang dalam pengujian.
        val warehouseMock = mock(Warehouse::class.java)

        // Mengatur perilaku mock Warehouse untuk mengembalikan nilai 0 saat getInventory("Macbook") dipanggil.
        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(0)

        // Mengatur perilaku mock Warehouse untuk mengembalikan true saat remove("Macbook", 50) dipanggil.
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(true)

        // Mengisi pesanan menggunakan mock Warehouse dan memastikan bahwa pesanan dianggap terisi.
        order.fill(warehouseMock)
        assertTrue(order.isFilled())

        // Memeriksa bahwa kapasitas gudang telah berkurang menjadi 0 untuk produk "Macbook".
        assertEquals(0, warehouseMock.getInventory(LAPTOP))
    }

    @Test
    fun `test warehouse capacity is not reduced when order cannot be fulfilled`() {
        // Membuat objek Order untuk produk "Macbook" dengan pesanan 51 unit.
        val order = Order(LAPTOP, 51)

        // Membuat objek mock Warehouse untuk menggantikan gudang dalam pengujian.
        val warehouseMock = mock(Warehouse::class.java)

        // Mengatur perilaku mock Warehouse untuk mengembalikan nilai 50 saat getInventory("Macbook") dipanggil.
        `when`(warehouseMock.getInventory(LAPTOP)).thenReturn(50)

        // Mengatur perilaku mock Warehouse untuk mengembalikan false saat remove("Macbook", 50) dipanggil.
        `when`(warehouseMock.remove(LAPTOP, 50)).thenReturn(false)

        // Mengisi pesanan menggunakan mock Warehouse dan memastikan bahwa pesanan tidak terisi.
        order.fill(warehouseMock)
        assertFalse(order.isFilled())

        // Memeriksa bahwa kapasitas gudang tidak berkurang (tetap 50) untuk produk "Macbook".
        assertEquals(50, warehouseMock.getInventory(LAPTOP))
    }
}
