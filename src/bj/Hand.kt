package bj

class Hand(val name: String) {

    private val _cards: MutableList<Card> = mutableListOf()

    fun add(card: Card) {
        _cards.add(card)
    }

    val points: Int get() = _cards.sumBy { it.points }

    val cards: List<Card> = _cards
    
    fun clear() {
        _cards.clear()
    }

}