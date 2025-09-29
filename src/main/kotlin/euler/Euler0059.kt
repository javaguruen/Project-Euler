package euler

class Euler0059(val passphrase: String) {
    val generator  = XorGenerator(passphrase)

    fun solve(): String{
        val sb = StringBuffer()
        val text = String(readFileUsingGetResource()
            .split(",")
            .map { n -> n.toInt() xor generator.next() }
            .map { it.toChar()}
            .toCharArray()
        )
        return text
    }

    fun mapNumberToChar(n: Int): Char{
        return n.toChar()
    }

    companion object{
        fun readFileUsingGetResource()
                = Euler0059::class.java.getResource("/p059_cipher.txt").readText(Charsets.UTF_8)
    }
}

class XorGenerator(val passphrase: String){
    var counter = -1

    fun next(): Int {
        return passphrase[ (++counter % 3)].code
    }
}
