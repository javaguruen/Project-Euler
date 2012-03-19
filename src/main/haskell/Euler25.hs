import Math
import BigMath

euler25 = snd (head (take 1 (dropWhile lessThanThousand fibos)))

fibos = [ (fibonacciBig x, x) | x <- [1..]]

lessThanThousand :: (Integer ,Integer) -> Bool
lessThanThousand (n, x) = (digits n) < 1000

