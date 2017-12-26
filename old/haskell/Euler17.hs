import qualified Data.Vector as V
import Math

ones = V.fromList["","one","two","three","four","five","six","seven","eight","nine", "ten",
                 "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]

tens = V.fromList["","","twenty", "thirty","forty","fifty","sixty","seventy","eighty","ninety"]

toString :: Int -> String 
toString n = thousandsToString (getThousands n) n ++ hundredsToString (getHundreds n) n ++ 
    tensToString (getTens n) ++ onesToString (getOnesSpecial n)  

euler17 = sum (map length (map toString [1..1000])) 

onesToString n = ones V.! n 

tensToString n = if n > 0 then tens V.! n else []

hundredsToString n originalNumber = let possibleAnd = if originalNumber `mod` 100 == 0 then "" else "and"
                                    in if n > 0 then (ones V.! n ++ "Hundred"++possibleAnd) else []

thousandsToString n originalNumber = let possibleAnd = if originalNumber `mod` 1000 == 0 then "" else "and" 
                                     in if n > 0 then (ones V.! n ++ "Thousand"++possibleAnd) else []

--Should return numbers up to tventy
getOnesSpecial :: Int -> Int
getOnesSpecial n = let onepart = n `div` 10
                       upfilter = onepart * 10
                       tens = getTens n 
            	in if (tens /= 1 ) then n - upfilter else ((n-upfilter) + (tens * 10))
