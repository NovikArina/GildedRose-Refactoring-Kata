package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class GildedRoseTest {

//    @Test
//    fun foo() {
//        val items = listOf(Item("foo", 0, 0))
//        val app = GildedRose(items)
//        app.updateQuality()
//        assertEquals("fixme", app.items[0].name)
//
//    }

    @ParameterizedTest
    @CsvSource(
            "3, 10, 1, 13",
            "7, 10, 1, 12",
            "12, 10, 1, 11",
            "1, 10, 2, 0",
            "7, 10, 3, 18",
    )
    fun testBackstagePasses(
            sellIn: Int,
            quality: Int,
            days: Int,
            expectedQuality: Int
    ) {
        val items = listOf(Item(GildedRose.BACKSTAGE_PASSES, sellIn, quality))
        val gildedRose = GildedRose(items)
        for (i in 1..days) {
            gildedRose.updateQuality()
        }
        assertEquals(expectedQuality, items[0].quality)
    }

    @ParameterizedTest
    @CsvSource(
            "2, 0, 5, 0",
            "3, 50, 1, 48",
            "2, 50, 3, 42",
    )
    fun testConjured(
            sellIn: Int,
            quality: Int,
            days: Int,
            expectedQuality: Int
    ) {
        val items = listOf(Item(GildedRose.CONJURED, sellIn, quality))
        val gildedRose = GildedRose(items)
        for (i in 1..days) {
            gildedRose.updateQuality()
        }
        assertEquals(expectedQuality, items[0].quality)
    }

    @ParameterizedTest
    @CsvSource(
            "10, 20, 5, 25",
            "0, 0, 3, 3",
            "2, 50, 2, 50",
    )
    fun testAgedBrie(
            sellIn: Int,
            quality: Int,
            days: Int,
            expectedQuality: Int
    ) {
        val items = listOf(Item(GildedRose.AGED_BRIE, sellIn, quality))
        val gildedRose = GildedRose(items)
        for (i in 1..days) {
            gildedRose.updateQuality()
        }
        assertEquals(expectedQuality, items[0].quality)
    }

    @ParameterizedTest
    @CsvSource(
            "3, 80, 1, 80",
            "5, 80, 6, 80"
    )
    fun testSulfuras(
            sellIn: Int,
            quality: Int,
            days: Int,
            expectedQuality: Int
    ) {
        val items = listOf(Item(GildedRose.SULFURAS, sellIn, quality))
        val gildedRose = GildedRose(items)
        for (i in 1..days) {
            gildedRose.updateQuality()
        }
        assertEquals(expectedQuality, items[0].quality)
    }

    @ParameterizedTest
    @CsvSource(
            "3, 40, 4, 35",
            "5, 20, 3, 17",
            "3, 3, 5, 0",
    )
    fun testNormalItems(
            sellIn: Int,
            quality: Int,
            days: Int,
            expectedQuality: Int
    ) {
        val items = listOf(Item("Normal", sellIn, quality))
        val gildedRose = GildedRose(items)
        for (i in 1..days) {
            gildedRose.updateQuality()
        }
        assertEquals(expectedQuality, items[0].quality)
    }

}


