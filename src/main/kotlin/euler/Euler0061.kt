package euler

class Euler0061 {
    val numberGroups = listOf<NumberGroup>(
        TriangleNumber(),
        PentagonalNumber(),
        SquareNumber()
    )

    fun solver() {
        numberGroups.forEach { ng ->
            val previous = mutableListOf<E61Number>()
            ng.numbers.forEach { n ->
                previous.add(n)
                numberGroups.forEach { innerG ->
                    if (ng.javaClass.name != innerG.javaClass.name) {
                        val candidates = innerG.startsWith(n.value.lastTwo()).forEach { c ->
                            println("$n -> $c")
                        }
                    }
                }
            }
        }
    }

    inline fun <reified T> generatePermutations(arr: List<T>): List<List<T>> {
        val list: MutableList<List<T>> = mutableListOf()
        permuteHelper(list, mutableListOf<T>(), arr);
        return list;
    }

    fun <T> permuteHelper(list: MutableList<List<T>>, resultList: MutableList<T>, arr: List<T>) {
        // Base case
        if (resultList.size == arr.size) {
            list.add(resultList.map { i -> i })
        } else {
            for (i in 0 until arr.size) {
                if (resultList.contains(arr[i])) {
                    continue
                }

                if (!resultList.contains(arr[i])) {
                    // Choose element
                    resultList.add(arr[i])
                    // Explore
                    permuteHelper(list, resultList, arr);
                    // Unchoose element
                    resultList.removeAt(resultList.size - 1);
                }
            }
        }
    }


    fun start() {
        try {
            val permutations = generatePermutations(
                listOf(
                    SquareNumber(),
                    TriangleNumber(),
                    PentagonalNumber(),
                    HexagonalNumber(),
                    HeptagonalNumber(),
                    OctagonalNumber()
                )
            )
            permutations.forEach { permutation ->
                solver2(mutableListOf(), permutation.first().numbers, permutation.tail())
            }
        } catch (e: SolutionException){
            val sum = e.chain.map { c -> c.value.toInt() }
                .sum()
            println("Sum of chain ${e.chain} is $sum")
        }
    }

    fun solver2(chain: List<E61Number>, candidates: List<E61Number>, rest: List<NumberGroup>) {
        if (rest.isEmpty()) {
            candidates.filter { c -> c.value.lastTwo() == chain.first().value.firstTwo() }
                .forEach { c -> throw SolutionException(chain + c) }
        } else {
            candidates.filter { chain.isEmpty() || chain.last().value.lastTwo() == it.value.firstTwo() }
                .forEach { n ->
                    if (chain.none { ch -> ch.position == n.position }) {
                        solver2(
                            chain + n,
                            rest.first().startsWith(n.value.lastTwo()),
                            rest.tail()
                        )
                    }
                }
        }
    }
}
data class SolutionException(val chain: List<E61Number>): Exception()
fun String.firstTwo(): String = this.substring(0, 2)
fun String.lastTwo(): String = this.substring(2)
fun <T> List<T>.tail(): List<T> {
    return if (this.size <= 1) emptyList() else this.subList(1, this.size)
}

sealed class NumberGroup {
    open val numbers: List<E61Number> = listOf()
    val byFirstTwo: Map<String, List<E61Number>> by lazy { numbers.groupBy { it.value.substring(0, 2) } }

    protected fun generateNumbers(gen: (Int) -> Int): List<E61Number> {
        var n = 1
        var triN = gen(n)
        val numbers = mutableListOf<E61Number>()
        while (triN <= 10_000) {
            if (triN >= 1000) {
                numbers.add(E61Number(triN.toString(), n))
            }
            triN = gen(++n)
        }
        //val l = numbers.mapIndexed { index, i -> E61Number(String.format("%04d", i), index) }
        return numbers
    }

    fun startsWith(digits: String): List<E61Number> {
        return numbers.filter { it.value.startsWith(digits) }
    }

    fun endsWith(digits: String): List<E61Number> {
        return numbers.filter { it.value.endsWith(digits) }
    }
}

data class E61Number(val value: String, val position: Int)

class TriangleNumber : NumberGroup() {
    override lateinit var numbers: List<E61Number>

    init {
        numbers = generateNumbers(KMathLib::triangleNumber)
    }

}

class SquareNumber : NumberGroup() {
    override val numbers = generateNumbers(KMathLib::squareNumber)

}

class PentagonalNumber : NumberGroup() {
    override val numbers = generateNumbers(KMathLib::pentagonalNumber)

}

class HexagonalNumber : NumberGroup() {
    override val numbers = generateNumbers(KMathLib::hexagonalNumber)

}

class HeptagonalNumber : NumberGroup() {
    override val numbers = generateNumbers(KMathLib::heptagonalNumber)

}

class OctagonalNumber : NumberGroup() {
    override val numbers = generateNumbers(KMathLib::octagonalNumber)

}
