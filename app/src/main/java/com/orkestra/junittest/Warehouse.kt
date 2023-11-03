package com.orkestra.junittest

class Warehouse {
    // Properti `warehouse` adalah koleksi HashMap yang digunakan untuk menyimpan inventaris produk.
    private val warehouse: HashMap<String, Int> = hashMapOf()

    // Metode add(product: String, quantity: Int) digunakan untuk menambahkan produk ke inventaris dengan jumlah tertentu.
    fun add(product: String, quantity: Int) {
        warehouse[product] = quantity
    }

    // Metode remove(product: String, quantity: Int) digunakan untuk menghapus produk dari inventaris sesuai dengan jumlah yang diminta.
    fun remove(product: String, quantity: Int): Boolean {
        if (warehouse.contains(product).not()) {
            println("Product not found in warehouse")
            return false
        }

        if (warehouse[product] == 0) {
            println("No items for this product in the warehouse")
            return false
        }

        if (warehouse[product]!! < quantity) {
            println("Not enough items in the warehouse")
            return false
        }

        val currentQty = warehouse[product]
        val newQty = currentQty!!.minus(quantity)
        warehouse[product] = newQty
        return true
    }

    // Metode getInventory(product: String) digunakan untuk mendapatkan jumlah produk yang tersisa dalam inventaris.
    fun getInventory(product: String): Int? {
        return warehouse.get(product)
    }
}
