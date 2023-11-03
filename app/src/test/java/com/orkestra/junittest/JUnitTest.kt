package com.orkestra.junittest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class JUnitTest {

    // Fungsi pengujian untuk metode `add`.
    @Test
    fun add() {
        // Membuat objek kelas JUnit yang akan diuji.
        val calculator = JUnit()

        // Nilai yang diharapkan dari hasil metode add(5, 5).
        val expected = 10

        // Membandingkan hasil metode add(5, 5) dengan nilai yang diharapkan (10).
        assertEquals(expected, calculator.add(5, 5))
    }
}
