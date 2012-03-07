module Math where

--getOnes : Untested!
getOnes :: Int -> Int
getOnes n = let onepart = n `div` 10
                upfilter = onepart * 10
            in n - upfilter 


getTens :: Int -> Int
getTens n =  let tenpart = n `div` 100
                 upfilter = tenpart * 100
            in ((n - upfilter) `div` 10)

getHundreds :: Int -> Int
getHundreds n = let hundredpart = n `div` 1000
                    upfilter = hundredpart * 1000
            in ((n - upfilter) `div` 100)

getThousands :: Int -> Int
getThousands n  = let thousandpart = n `div` 10000
                      upfilter = thousandpart * 10000
                in ((n - upfilter) `div` 1000)

collatzChainLength :: Int -> Int 
collatzChainLength n = collatzChainLengthInner 0 n

collatzChainLengthInner :: Int -> Int  -> Int
collatzChainLengthInner acc 1 = acc
collatzChainLengthInner acc n = if even n then
                              collatzChainLengthInner (acc+1) (n `div` 2)
                           else
                              collatzChainLengthInner (acc+1) (3 * n +1 )

collatzChain :: Int -> [Int]
collatzChain 1 = []
collatzChain n = if even n  then
          [n `div` 2] ++ collatzChain  (n `div` 2)
        else
          [3 * n + 1] ++ collatzChain (3 * n +1) 


strToIntList :: [String] -> [Integer]
strToIntList (x:xs) = [read x] ++ strToIntList xs
strToIntList [] = [] 

toTriangleNumber :: Int -> Int
toTriangleNumber 1 = 1 
toTriangleNumber n = n + toTriangleNumber (n-1)

isPytagoreanTriplet :: Int -> Int -> Int -> Bool
isPytagoreanTriplet a b c = let firstCondition = (a < b) && (b < c)
                                secoundCondition = a^2 + b^2 == c^2
                                in firstCondition && secoundCondition


allPermutations :: Int -> [Int] -> [Int] -> [(Int , Int, Int)]
allPermutations c (x:xs) (ys) = (tuplify c x ys) ++ allPermutations c xs ys
allPermutations c [] (ys) = []


tuplify :: Int -> Int -> [Int] -> [(Int,Int,Int)]
tuplify c n (x:xs) = [(c,n,x)] ++ tuplify c n xs
tuplify c n [] = [] 

nthPrime :: Int -> Int
nthPrime n = innerloopNthPrime n 2 3


innerloopNthPrime n acc iter = if isprime iter
              then
                let iter2 = iter +1
                    acc2 = acc +1
                in if acc2 > n then
                    iter
                    else
                    innerloopNthPrime n acc2 iter2
              else
                let iter2 = iter +1
                in innerloopNthPrime n acc iter2                


crossedMulti :: [Int] -> [Int] -> [Int]
crossedMulti (x:xs) (ys) = crossed x ys ++ crossedMulti xs ys
crossedMulti [] (ys) = []

crossed :: Int -> [Int] -> [Int]
crossed n (xs) = map (n *) xs

isPalindrome :: Eq a => [a] -> Bool
isPalindrome str = let rev = reverse str
                   in listsEqual str rev


listsEqual :: Eq a => [a] -> [a] -> Bool
listsEqual (x:xs) (y:ys) = if not (x==y) then False else listsEqual xs ys
listsEqual [] [] = True
listsEqual (x:xs) [] = False
listsEqual [] (y:ys) = False

fibonacciList :: Int -> [Int]
fibonacciList 1  = [1]
fibonacciList n = [1,1] ++ innerfibonacciList n 1 1 3

innerfibonacciList :: Int -> Int -> Int -> Int -> [Int]
innerfibonacciList n beforeLastElem lastElem  iter = if (iter <= n)
    then
        [(lastElem + beforeLastElem)] ++ (innerfibonacciList n lastElem (beforeLastElem + lastElem) (iter+1))
    else
        []

isDividableBy :: Int -> Int -> Bool
isDividableBy divisor n = n `mod` divisor == 0

isAmicable :: Int -> Bool
isAmicable n = let sumproper = tverrsum (properfactors n)
                   possiblepair = tverrsum ( properfactors sumproper)
                   in (n == possiblepair) && (n /= sumproper)

tverrsum :: [Int] -> Int
tverrsum (x:xs) = tverrsum xs + x
tverrsum [] = 0

tverrprodukt :: String -> Int
tverrprodukt (x:xs) = (read [x]) * tverrprodukt xs
tverrprodukt [] = 1

isprime :: Int -> Bool 
isprime n = let maxCand = prepare n
                in isprimeloop n maxCand 2

isprimeloop :: Int -> Int -> Int -> Bool
isprimeloop n maxCandidate iter = if iter <= maxCandidate 
		then
		if n `mod` (fromIntegral iter) < 1
			then --factor found!
				False
			else
			let tmp = iter + 1
			in
			isprimeloop n maxCandidate tmp 
		else True

prepare :: Int  ->  Int
prepare n = floor (sqrt (fromIntegral n))

primefactors :: Int -> [Int]
primefactors n = filter isprime (properfactors n) 

preparefactors :: Int  ->  Int
preparefactors n = floor (sqrt (fromIntegral n))

--All numbers that evenly divide n, if any. Prime or composite.
properfactors :: Int -> [Int]
properfactors n = let maxCand = preparefactors n
            in factorsLoop n maxCand 2 [1]

factorsLoop :: Int ->Int ->Int -> [Int] -> [Int]
factorsLoop n maxCandidate iter acc = if iter <= maxCandidate
    then
        if n `mod` (fromIntegral) iter < 1
            then --factor found
            let tmp = iter + 1
                accC = if iter /= n `div` iter
                    then
                        [iter] ++ [ n `div` iter] ++ acc 
                    else
                        [iter] ++ acc    
                in factorsLoop n maxCandidate tmp accC
            else
            let tmp = iter + 1
                in factorsLoop n maxCandidate tmp acc 
    else
        acc


