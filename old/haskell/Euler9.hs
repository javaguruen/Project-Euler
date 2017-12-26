import Math

euler9 = filter sumsTo1k (euler9inner 1 1000)

euler9inner :: Int -> Int -> [(Int, Int, Int)]
euler9inner iter max = let reslist = filter isPytagoreanTripletTuple ( filter sumsTo1k(forSomeCGetAllABs iter))
                   in if length reslist > 0 
                    then
                      if iter < max
                        then 
                        reslist ++ euler9inner (iter +1) max
                        else
                          reslist
                    else
                      if iter < max
                        then 
                      euler9inner (iter + 1) max
                      else 
                        []

sumsTo1k :: (Int, Int, Int ) -> Bool
sumsTo1k (a,b,c) = (a + b + c) == 1000

forSomeCGetAllABs :: Int -> [(Int, Int, Int)]
forSomeCGetAllABs c = let maxA = min (1000-c) (c-1) 
                          maxB = min (1000-c) (c-1)
                          in allPermutations c [1..maxA] [1..maxB]

--Note the re-arrangments of the parameters
isPytagoreanTripletTuple :: (Int, Int, Int) -> Bool
isPytagoreanTripletTuple (a,b,c) = isPytagoreanTriplet c b a


