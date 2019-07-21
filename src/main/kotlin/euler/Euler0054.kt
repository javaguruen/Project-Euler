package euler

import euler.euler054Utils.*
import java.lang.RuntimeException

class Euler0054 {
    fun run(): Int {
        var wonByA = 0
        val hands = readHandsFromFile()
        for (hand in hands){
            val (hA, hB) = hand
            //println("checking $hA vs $hB")
            if ( bestHand(hA, hB) == hA){
                wonByA += 1
                println("\t$hA won over $hB")
            } else {
                println("\t$hA lost to $hB")
            }
        }
        println("Player A won $wonByA times")
        return wonByA
    }

    private fun readHandsFromFile(): List<Pair<Hand, Hand>> {
        return this::class.java.classLoader
                .getResourceAsStream("Euler054.txt")
                .bufferedReader()
                .readLines()
                .map { mapLineToHands(it) }
    }

    internal fun mapLineToHands(line: String): Pair<Hand, Hand> {
        val l1 = line.substring(0, 14)
        val l2 = line.subSequence(15, line.length)
        val handA = Hand(
                l1.split(" ")
                        .map { Card.create(it) }
        )
        val handB = Hand(
                l2.split(" ")
                        .map { Card.create(it) }
        )
        return Pair(handA, handB)
    }

    internal fun mapStringToHand(line: String) = Hand(
            line.split(" ")
                    .map { Card.create(it) }
    )

    fun bestHand(handA: Hand, handB: Hand): Hand {
        val scoreA = scoreHand(handA)
        val scoreB = scoreHand(handB)

        if (scoreA.rank > scoreB.rank) {
            return handA
        } else if (scoreA.rank < scoreB.rank) {
            return handB
        }
        if (scoreA.value > scoreB.value) {
            return handA
        } else if (scoreA.value < scoreB.value) {
            return handB
        } else {
            val aSorted = scoreA.nextHighest.sortedDescending()
            val bSorted = scoreB.nextHighest.sortedDescending()

            val listPairs: List<Pair<Int, Int>> = aSorted.zip(bSorted)
            for (c in listPairs) {
                if (c.first > c.second) {
                    return handA
                } else if (c.second > c.first) {
                    return handB
                }
            }
            throw RuntimeException("Should have a winner.")
        }
    }

    fun scoreHand(hand: Hand): Score {
        return detectorsForHand(hand)
                .map { it.detect(hand) }
                .filterNotNull()
                .first()
    }

    //checking Hand(cards=[Card(valor=10, suit=DIAMONDS), Card(valor=8, suit=CLUBS), Card(valor=4, suit=HEARTS), Card(valor=7, suit=CLUBS), Card(valor=10, suit=CLUBS)]) vs Hand(cards=[Card(valor=13, suit=CLUBS), Card(valor=4, suit=CLUBS), Card(valor=3, suit=HEARTS), Card(valor=7, suit=SPADES), Card(valor=13, suit=SPADES)])
    //TD 8C 4H 7C TC
    //KC 4C 3H 7S KS

    fun detectorsForHand(hand: Hand): List<ScoreDetector> {
        val grouped = hand.cards.groupBy { it.valor }
        return when (grouped.size) {
            5 -> listOf(
                    HighestHandDetector(),
                    StraightsDetector(),
                    FlushDetector()
            )
            4 -> listOf(
                    OnePairDetector()
            )
            3 -> listOf(
                    TwoPairsDetector(),
                    ThreeOfAKineDetector()
            )
            2 -> listOf(
                    FullHouseDetector(),
                    FourOfAKindDetector()
            )
            else -> throw RuntimeException("Impossible hand $hand")
        }
    }
}
