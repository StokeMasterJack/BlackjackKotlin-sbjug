package bj

class Game {

    val deck = Deck()
    val ph = Hand("Player")
    val dh = Hand("Dealer")

    var isStay: Boolean = false

    init {
        deal()
    }

    fun deal() {
        ph.clear()
        dh.clear()
        ph.add(deck.take())
        ph.add(deck.take())
        dh.add(deck.take())
        dh.add(deck.take())
        isStay = false
    }

    fun hit() {
        ph.add(deck.take())
    }

    fun stay() {
        while (dh.points < 17) dh.add(deck.take())
        isStay = true
    }

    val over: Boolean get() = isStay || ph.points >= 21
}