module Math where


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


