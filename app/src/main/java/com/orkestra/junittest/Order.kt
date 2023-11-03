package com.orkestra.junittest

class Order(private val product: String, private val quantity: Int) {
    private lateinit var warehouse: Warehouse
    private var isFilled: Boolean = false

    // Metode fill() digunakan untuk mengisi pesanan dengan menghubungkan pesanan ke gudang (warehouse) dan mencoba menghapus produk dari gudang sesuai dengan jumlah yang diminta.
    fun fill(warehouse: Warehouse) {
        this.warehouse = warehouse
        isFilled = this.warehouse.remove(product, quantity)
    }

    // Metode isFilled() mengembalikan nilai Boolean yang menunjukkan apakah pesanan telah terisi atau belum.
    fun isFilled(): Boolean {
        return isFilled
    }
}
