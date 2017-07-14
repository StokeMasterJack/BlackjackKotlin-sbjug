package bj

class Point(val x: Int, val y: Int)


//fun allCap(s: String): String {
//    return s.toUpperCase()
//}


fun String.allCap(): String {
    return this.toUpperCase()
}

fun useAllCap() {
    println("bll".allCap())
}

