package com.gildedrose

class GildedRose(var items: List<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val CONJURED = "Conjured Mana Cake"
    }

    // Aged Brie increases in Quality the older it gets
    private fun updateAgedBrieItem(item: Item) {
        item.sellIn--
        item.quality++
        validateQuality(item)
    }

    // Backstage passes increases in Quality as its SellIn value approaches
    // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
    // Quality drops to 0 after the concert
    private fun updateBackstagePassesItem(item: Item) {
        item.sellIn--
        if (item.sellIn < 0) {
            item.quality = 0
            return
        }
        item.quality++
        if (item.sellIn <= 10) {
            item.quality++
        }
        if (item.sellIn <= 5) {
            item.quality++
        }
        validateQuality(item)
    }

    //Conjured items degrade in Quality twice as fast as normal
    private fun updateConjuredItem(item: Item) {

        item.sellIn--
        item.quality -= 2
        if (item.sellIn < 0) {
            item.quality -= 2
        }
        validateQuality(item)
    }

    // Quality degrades twice as fast after sellIn date
    private fun updateNormalItem(item: Item) {

        item.sellIn--
        item.quality--
        if (item.sellIn < 0) {
            item.quality--
        }
        validateQuality(item)
    }

    //The Quality of an item is never negative ane more than 50
    private fun validateQuality(item: Item) {
        if (item.quality < 0) {
            item.quality = 0
        }
        if (item.quality > 50) {
            item.quality = 50
        }
    }

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                AGED_BRIE -> updateAgedBrieItem(item)
                BACKSTAGE_PASSES -> updateBackstagePassesItem(item)
                SULFURAS -> {} // We don't need to change legendary Sulfuras items
                CONJURED -> updateConjuredItem(item)
                else -> updateNormalItem(item)
            }
        }
    }
}

