package euler.euler054Utils

import java.lang.RuntimeException
import kotlin.math.max

enum class Suit { SPADES, HEARTS, CLUBS, DIAMONDS }

data class Card(val valor: Int, val suit: Suit) {
    override fun toString(): String {
        return "$valor-${suit.name[0]}"
    }

    companion object {
        fun create(code: String): Card {
            val valueAsString = code[0]
            val suitAsString = code[1]

            val v = when {
                valueAsString.isDigit() -> Character.getNumericValue(valueAsString)
                valueAsString == 'T' -> 10
                valueAsString == 'J' -> 11
                valueAsString == 'Q' -> 12
                valueAsString == 'K' -> 13
                valueAsString == 'A' -> 14
                else -> throw RuntimeException("Invalid valor for card $code")
            }
            val s = when (suitAsString) {
                'C' -> Suit.CLUBS
                'H' -> Suit.HEARTS
                'D' -> Suit.DIAMONDS
                'S' -> Suit.SPADES
                else -> throw RuntimeException("Invalid suit for card $code")
            }
            return Card(v, s)
        }
    }
}

data class Hand(val cards: List<Card>)

data class Score(
        val name: String,
        val value: Int,
        val nextHighest: List<Int>,
        val rank: Int
)

interface ScoreDetector {
    fun detect(hand: Hand): Score?
}

class HighestHandDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueValues: Set<Int> = hand.cards.map { it.valor }.toSet()
        val uniqueSuits = hand.cards.map { it.suit }.toSet()
        val highestValue: Int = uniqueValues.sortedDescending().first()
        if( uniqueValues.maxOrNull()!! - uniqueValues.minOrNull()!! + 1 == 5){
            //straight
            return null
        }
        if (uniqueValues.size == 5 && uniqueSuits.size < 5 && uniqueSuits.size > 1) {
            return Score("HighestHand", highestValue, uniqueValues.toList(), 1)
        } else {
            return null
        }
    }
}

class OnePairDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueValues = hand.cards.map { it.valor }.toSet()
        val grouped = hand.cards.groupBy { it.valor }
        if (uniqueValues.size != 4) {
            return null
        }
        val value: Int = grouped.values
                .filter { it.size == 2 }
                .map { it.get(0).valor }
                .first()
        val rest: List<Int> = hand.cards.filterNot { it.valor == value }.map { it.valor }
/*
        if (rest.maxOrNull()!! - rest.minOrNull()!! + 1 == 5) {
            return null
        }
*/
        return Score("OnePair", value, rest, 2)
    }
}

class TwoPairsDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueValues = hand.cards.map { it.valor }.toSet()
        if (uniqueValues.size != 3) {
            return null
        }
        val grouped = hand.cards.groupBy { it.valor }
        val groupsOfSize2 = grouped.filter { it.value.size == 2 }
        val groupsOfSize1 = grouped.filter { it.value.size == 1 }
        if (groupsOfSize1.size != 1 || groupsOfSize2.size != 2) {
            return null
        }
        val value = max(
                groupsOfSize2.entries.elementAt(0).value.first().valor,
                groupsOfSize2.entries.elementAt(1).value.first().valor
        )

        val rest = grouped.entries.filter { it.value.size == 1 }.map { it.value }.first().map { it.valor }
        return Score("TwoPairs", value, rest, 3)
    }
}

class ThreeOfAKineDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueValues = hand.cards.map { it.valor }.toSet()
        if (uniqueValues.size != 3) {
            return null
        }
        val grouped = hand.cards.groupBy { it.valor }
        val groupsOfSize3 = grouped.filter { it.value.size == 3 }
        val groupsOfSize1 = grouped.filter { it.value.size == 1 }.flatMap { it.value }.map { it.valor }
        if( groupsOfSize3.size != 1){
            return null
        }

        val value = groupsOfSize3.entries.elementAt(0).value.first().valor
        return Score("ThreeOfAKind", value, groupsOfSize1, 4)
    }
}

class StraightsDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueValues = hand.cards.map { it.valor }.toSet()
        val grouped = hand.cards.groupBy { it.suit }
        if (uniqueValues.size != 5) {
            return null
        }
        val rest = hand.cards.map { it.valor }
        if (rest.maxOrNull()!! - rest.minOrNull()!! + 1 != 5) {
            return null
        }
        if (grouped.keys.size == 1) {
            if (rest.maxOrNull() == 14) return Score("RoyalStraightFlush", 14, emptyList(), 10)
            else return Score("StraightFlush", rest.maxOrNull()!!, emptyList(), 9)
        } else {
            return Score("Straight", rest.maxOrNull()!!, emptyList(), 5)
        }
    }
}

class FlushDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val uniqueSuits = hand.cards.map { it.suit }.toSet()
        if (uniqueSuits.size != 1) {
            return null
        }
        val lowest: Int = hand.cards.map { it.valor }.minOrNull()!!
        val highest: Int = hand.cards.map { it.valor }.maxOrNull()!!
        if( highest - lowest + 1 == 5 ){
            return null //straight flush
        } else {
            return Score("Flush", highest, emptyList(), 6)
        }
    }
}

class FullHouseDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val grouped = hand.cards.groupBy { it.valor }
        if (grouped.keys.size == 2
                && grouped.entries.any { it.value.size == 2 }
                && grouped.entries.any { it.value.size == 3 }) {
            val max = hand.cards.map { it.valor }.maxOrNull()!!
            return Score("FullHouse", max, emptyList(), 7)

        } else {
            return null
        }
    }
}

class FourOfAKindDetector : ScoreDetector {
    override fun detect(hand: Hand): Score? {
        val grouped = hand.cards.groupBy { it.valor }
        if (grouped.keys.size == 2
                && grouped.entries.any { it.value.size == 1 }
                && grouped.entries.any { it.value.size == 4 }) {
            val single = grouped.values.filter { it.size == 1 }.first().map { it.valor }
            val four = grouped.values.filter { it.size == 4 }.first()
            return Score("FourOfAKind", four.first().valor, single, 8)

        } else {
            return null
        }
    }
}


