package com.orkestra.junittest

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OrderStateTest {
    private val Laptop = "Macbook"
    private val Mouse = "Logitech Mouse"
    private val warehouse = Warehouse()

    @BeforeEach
    fun setUp() {
        // Membuat objek gudang (Warehouse) dan menambahkan produk ke dalamnya.
        warehouse.add(Laptop, 50)
        warehouse.add(Mouse, 20)
    }

    @Test
    fun `test order is fulfilled if capacity in warehouse is sufficient`() {
        // Membuat pesanan (Order) untuk produk "Macbook" sebanyak 20 unit.
        val order = Order(Laptop, 20)

        // Mengisi pesanan dengan gudang (Warehouse).
        order.fill(warehouse)

        // Memastikan bahwa pesanan dianggap terisi (isFilled() mengembalikan true).
        assertTrue(order.isFilled())

        // Memeriksa bahwa kapasitas gudang produk "Macbook" berkurang menjadi 30 unit.
        assertEquals(30, warehouse.getInventory(Laptop))
    }

    @Test
    fun `test order is not fulfilled if capacity in warehouse is insufficient`() {
        // Membuat pesanan (Order) untuk produk "Logitech Mouse" sebanyak 21 unit.
        val order = Order(Mouse, 21)

        // Mengisi pesanan dengan gudang (Warehouse).
        order.fill(warehouse)

        // Memastikan bahwa pesanan tidak terisi (isFilled() mengembalikan false).
        assertFalse(order.isFilled())

        // Memeriksa bahwa kapasitas gudang produk "Logitech Mouse" tetap 20 unit.
        assertEquals(20, warehouse.getInventory(Mouse))
    }
}
