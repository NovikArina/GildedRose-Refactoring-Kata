package com.gildedrose

class GildedRose(var items: List<Item>) {

    companion object {
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val CONJURED = "Conjured Mana Cake"

        const val MIN_QUALITY = 0
        const val MAX_QUALITY = 50
    }

    // Aged Brie increases in Quality the older it gets
    private fun updateAgedBrieItem(item: Item) {
        item.sellIn--
        item.increaseQuality()
    }

    // Backstage passes increases in Quality as its SellIn value approaches
    // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
    // Quality drops to 0 after the concert
    private fun updateBackstagePassesItem(item: Item) {
        item.sellIn--
        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY
            return
        }
        item.quality++
        if (item.sellIn <= 10) {
            item.increaseQuality()
        }
        if (item.sellIn <= 5) {
            item.increaseQuality()
        }
    }

    //Conjured items degrade in Quality twice as fast as normal
    private fun updateConjuredItem(item: Item) {

        item.sellIn--
        item.decreaseQuality(2)
        if (item.sellIn < 0) {
            item.decreaseQuality(2)
        }
    }

    // Quality degrades twice as fast after sellIn date
    private fun updateNormalItem(item: Item) {

        item.sellIn--
        item.decreaseQuality()
        if (item.sellIn < 0) {
            item.decreaseQuality()
        }
    }

    fun updateQuality() {
        for (item in items) {
            when {
                item.name.startsWith(AGED_BRIE) -> updateAgedBrieItem(item)
                item.name.startsWith(BACKSTAGE_PASSES) -> updateBackstagePassesItem(item)
                item.name.startsWith(SULFURAS) -> {} // We don't need to change legendary Sulfuras items
                item.name.startsWith(CONJURED) -> updateConjuredItem(item)
                else -> updateNormalItem(item)
            }
        }
    }

    private fun Item.increaseQuality(amount: Int = 1) {
        val newQuality = quality + amount
        this.quality = newQuality.takeIf { it <= MAX_QUALITY } ?: MAX_QUALITY
    }

    private fun Item.decreaseQuality(amount: Int = 1) {
        val newQuality = quality - amount
        this.quality = newQuality.takeIf { it >= MIN_QUALITY } ?: MIN_QUALITY
    }
}

