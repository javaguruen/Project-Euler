package euler

import euler.euler054Utils.*
import euler.euler054Utils.Suit.*
import org.junit.Ignore
import org.junit.Test

class Euler0054Test {
    val e54 = Euler0054()

    @Test
    fun `Parse card from string`() {
        assert(Card.create("8C") == Card(8, Suit.CLUBS))
    }

    @Test
    @Ignore
    fun `read hands from file`() {
        assert(-1 == Euler0054().run())
    }

    @Test
    fun `Parse line of string to two hands`() {
        val line = "5H 5C 6S 7S KD 2C 3S 8S 8D TD"
        val (handA, handB) = Euler0054().mapLineToHands(line)
        assert(handA.cards[0] == Card(5, HEARTS))
        assert(handA.cards[4] == Card(13, DIAMONDS))
        assert(handB.cards[0] == Card(2, CLUBS))
        assert(handB.cards[4] == Card(10, DIAMONDS))
    }

    @Test
    fun `Single hand detector`() {
        val line = "2C 5C 7D 8S QH"
        val score = HighestHandDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("HighestHand" == score?.name)
        assert(12 == score?.value)
        assert(1 == score?.rank)
    }

    @Test
    fun `One pair detector`() {
        val line = "2C 3S 8S 8D TD"
        val score = OnePairDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("OnePair" == score?.name)
        assert(8 == score?.value)
        assert(2 == score?.rank)
        assert(10 == score?.nextHighest?.max())
    }

    @Test
    fun `Two pairs detector`() {
        val line = "2C TS 8S 8D TD"
        val score = TwoPairsDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("TwoPairs" == score?.name)
        assert(10 == score?.value)
        assert(3 == score?.rank)
        assert(2 == score?.nextHighest?.max())
    }

    @Test
    fun `Three of a kind detector`() {
        val line = "2D 9C AS AH AC"
        val score = ThreeOfAKineDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("ThreeOfAKind" == score?.name)
        assert(14 == score?.value)
        assert(4 == score?.rank)
        assert(9 == score?.nextHighest?.max())
    }

    @Test
    fun `Straight detector`() {
        val line = "2D 4C 3S 6H 5C"
        val score = StraightsDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("Straight" == score?.name)
        assert(6 == score?.value)
        assert(5 == score?.rank)
        assert(0 == score?.nextHighest?.size)
    }

    @Test
    fun `Flush detector`() {
        val line = "2D 7D 3D 6D 5D"
        val score = FlushDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("Flush" == score?.name)
        assert(7 == score?.value)
        assert(6 == score?.rank)
        assert(0 == score?.nextHighest?.size)
    }

    @Test
    fun `Full Hous detector`() {
        val line = "2D 5D 2C 5S 5H"
        val score = FullHouseDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("FullHouse" == score?.name)
        assert(5 == score?.value)
        assert(7 == score?.rank)
        assert(0 == score?.nextHighest?.size)
    }

    @Test
    fun `Four of a kind detector`() {
        val line = "2D 5D 5C 5S 5H"
        val score = FourOfAKindDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("FourOfAKind" == score?.name)
        assert(5 == score?.value)
        assert(8 == score?.rank)
        assert(2 == score?.nextHighest?.first())
    }

    @Test
    fun `Straight Flush detector`() {
        val line = "2D 4D 3D 6D 5D"
        val score = StraightsDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("StraightFlush" == score?.name)
        assert(6 == score?.value)
        assert(9 == score?.rank)
        assert(0 == score?.nextHighest?.size)
    }

    @Test
    fun `Royal Straight Flush detector`() {
        val line = "AD TD KD QD JD"
        val score = StraightsDetector().detect(e54.mapStringToHand(line))
        assert(score != null)
        assert("RoyalStraightFlush" == score?.name)
        assert(14 == score?.value)
        assert(10 == score?.rank)
        assert(0 == score?.nextHighest?.size)
    }

    @Test
    fun `Score best hand`() {
        var handA = e54.mapStringToHand("5H 5C 6S 7S KD")
        var handB = e54.mapStringToHand("2C 3S 8S 8D TD")
        var bestHand = e54.bestHand(handA, handB)
        assert(handB == bestHand)


        /*

        Pair of Eights
        Player 2
        2	 	5D 8C 9S JS AC
        Highest card Ace
        2C 5C 7D 8S QH
        Highest card Queen
        Player 1
        3	 	2D 9C AS AH AC
        Three Aces
                3D 6D 7D TD QD
                Flush with Diamonds
        Player 2
        4	 	4D 6S 9H QH QC
        Pair of Queens
        Highest card Nine
        3D 6D 7H QD QS
                Pair of Queens
        Highest card Seven
        Player 1
        5	 	2H 2D 4C 4D 4S
        Full House
                With Three Fours
        3C 3D 3S 9S 9D
                Full House
                with Three Threes
        Player 1
*/
    }

    @Test
    fun `IndexOutOfBoundsException i ThreeOfAKind`(){
        //Card(valor=5, suit=CLUBS), Card(valor=14, suit=DIAMONDS), Card(valor=5, suit=DIAMONDS), Card(valor=14, suit=CLUBS), Card(valor=9, suit=CLUBS)]) vs Hand(cards=[Card(valor=7, suit=CLUBS), Card(valor=5, suit=HEARTS), Card(valor=8, suit=DIAMONDS), Card(valor=10, suit=DIAMONDS), Card(valor=13, suit=SPADES)])
        val lineA = "5C AD 5D AC 9C"
        val scoreA = ThreeOfAKineDetector().detect(e54.mapStringToHand(lineA))
        assert(scoreA == null)
    }

    @Test
    fun `Detect hand problem`(){
        val handA = e54.mapStringToHand("TD 8C 4H 7C TC")
        val handB = e54.mapStringToHand("KC 4C 3H 7S KS")

        println( e54.detectorsForHand(handA).map { it.detect(handA) } )
        println( e54.detectorsForHand(handB).map { it.detect(handB) } )

    }

    @Test
    fun `straight detector`(){
        val hand = e54.mapStringToHand("6H 4H 5C 3H 2H")
        val score = e54.scoreHand(hand)
        println( score )

    }

    @Test
    @kotlin.test.Ignore("Sollution")
    fun `Sollution`(){
        val sollution = e54.run()
        assert(sollution == 376)
    }
}