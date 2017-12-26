module BigMath where

import CReal

bigDivide :: CReal -> CReal
bigDivide n = 1 / n

fibonacciBig :: Integer -> Integer
fibonacciBig n = fibonacciBigInner 1 1 3 n

fibonacciBigInner nmin2 nmin1 iter max = if iter < max 
            then fibonacciBigInner nmin1 (nmin1 + nmin2) (iter+1) max
            else (nmin1 + nmin2)
    
tverrsumBig :: String -> Integer
tverrsumBig (x:xs) = read [x] + tverrsumBig xs
tverrsumBig [] = 0

toTriangleNumberBig :: Integer -> Integer
toTriangleNumberBig 1 = 1
toTriangleNumberBig n = n + toTriangleNumberBig (n-1)

isprimeBig :: Integer -> Bool 
isprimeBig n = let maxCand = preparefactorsBig n
                in isprimeloopBig n maxCand 2

isprimeloopBig :: Integer -> Integer -> Integer -> Bool
isprimeloopBig n maxCandidate iter = if iter <= maxCandidate 
    then
    if n `mod` (fromInteger iter) < 1
      then --factor found!
        False
      else
      let tmp = iter + 1
      in
      isprimeloopBig n maxCandidate tmp 
    else True


primefactorsBig :: Integer -> [Integer]
primefactorsBig n = filter isprimeBig (properfactorsBig n) 

preparefactorsBig :: Integer -> Integer
preparefactorsBig n = floor (sqrt (fromInteger n))

properfactorsBig :: Integer -> [Integer]
properfactorsBig n = let maxCand = preparefactorsBig n
    in factorsLoopBig n maxCand 2 [1]

factorsLoopBig :: Integer -> Integer -> Integer -> [Integer] -> [Integer]
factorsLoopBig n maxCandidate iter acc = if iter <= maxCandidate
then
        if n `mod` (fromIntegral) iter < 1
            then --factor found
            let tmp = iter + 1
                accC = if iter /= n `div` iter
                    then
                        [iter] ++ [ n `div` iter] ++ acc 
                    else
                        [iter] ++ acc    
                in factorsLoopBig n maxCandidate tmp accC
            else
            let tmp = iter + 1
                in factorsLoopBig n maxCandidate tmp acc 
    else
        acc
