package bj

import kotlinx.html.HtmlBlockTag
import kotlinx.html.b
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.h1
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import kotlin.browser.document
import kotlin.dom.clear

val _g = Game()

fun main(args: Array<String>) {
    render(_g)
}

fun render(g: Game) {
    val root = document.getElementById("root")
    root!!.clear()
    val div = document.create.div {
        h1 {
            +"Blackjack"
        }
        buttonBar(this, g)
        div {
            style = "display:flex"
            handView(this, g.ph)
            handView(this, g.dh)
        }
    }
    root.appendChild(div)
}

fun handView(parent: HtmlBlockTag, h: Hand) {
    parent.div {
        style = "padding:1rem;margin:1rem;background:#DDDDDD;width:10rem;width:10rem;"
        div {
            b { +"${h.name} Hand" }
        }
        div {
            h.cards.forEach {
                div { +it.name }
            }
        }
        div {
            b { +"${h.points} Points" }
        }

    }
}

fun buttonBar(parent: HtmlBlockTag, g: Game) {
    parent.div {
        button {
            +"Deal"
            onClickFunction = {
                g.deal()
                render(g)
            }
        }
        button {
            +"Hit"
            onClickFunction = {
                g.hit()
                render(g)
            }
        }
        button {
            +"Stay"
            onClickFunction = {
                g.stay()
                render(g)
            }
        }
    }

}

