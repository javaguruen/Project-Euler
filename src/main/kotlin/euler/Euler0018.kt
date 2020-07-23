package euler

class Euler0018 {

    fun buildGraph() {
        val arrays = pyramid.split("\n")
                .map { it -> it.split(" ") }
        println(arrays)
        val depth = arrays.size
        var prevNodes = arrayOf<Node>()
        var currNodes = arrayOf<Node>()
        for (level in depth - 1 downTo 0) {
            for (n in 0 until arrays[level].size) {
                currNodes += Node(
                        value = arrays[level][n].toInt(),
                        left = if (prevNodes.size == 0) null else prevNodes[n],
                        right = if (prevNodes.size == 0) null else prevNodes[n + 1]
                )
            }
            prevNodes = currNodes
            currNodes = arrayOf()
        }
        val root = prevNodes
        println("Size of root: ${root.size}")
        println("Max subtree = ${root[0].maxSubtree}")
    }


    val pyramid = """
        75
        95 64
        17 47 82
        18 35 87 10
        20 04 82 47 65
        19 01 23 75 03 34
        88 02 77 73 07 63 67
        99 65 04 28 06 16 70 92
        41 41 26 56 83 40 80 70 33
        41 48 72 33 47 32 37 16 94 29
        53 71 44 65 25 43 91 52 97 51 14
        70 11 33 28 77 73 17 78 39 68 17 57
        91 71 52 38 17 14 91 43 58 50 27 29 48
        63 66 04 68 89 53 67 30 73 16 69 87 40 31
        04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    """.trimIndent()
}

data class Node(val value: Int, val left: Node?, val right: Node?) {
    var maxSubtree: Int? = null

    init {
        maxSubtree = if (left != null) {
            value + Math.max(left.maxSubtree ?: 0, right?.maxSubtree ?: 0)
        } else value
    }
}