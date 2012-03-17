import Char
import Data.List.Split
import Math

main :: IO ()
main = do 
    s <- readFile "euler22data.txt"
    print (  foldl (+) 0 (map calculateNameScore ( listToToTuples (quicksort (splitOn "," ( filter (/='"') s))))))

listToToTuples :: [String] -> [(String,Int)]
listToToTuples xs = listToToTuplesInner xs 1

listToToTuplesInner :: [String] -> Int -> [(String, Int)]
listToToTuplesInner (x:xs) iter = [(x, iter)] ++ listToToTuplesInner xs (iter+1)
listToToTuplesInner [] iter = [] 

calculateNameScore :: (String, Int) -> Int 
calculateNameScore (a,b) = (calcInner a 0) * b 

calcInner (x:xs) acc = let acc2 = acc + (Char.ord x - 64) 
                       in calcInner xs acc2
calcInner [] acc =  acc 


