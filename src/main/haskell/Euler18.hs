import Data.List.Split
import Math

main :: IO ()
main = do 
    s <- readFile "euler18data.txt"
    print ( foldl (max) 0 (euler18 (strToIntListWithSpaces (splitOn "\n" s))))
    --print (foldl (+) 0 (strToIntList(splitOn "\n" s)))

euler18 :: [[Integer]] -> [Integer]
euler18 xs = euler18Inner xs [0]

euler18Inner :: [[Integer]] -> [Integer] -> [Integer]
euler18Inner (x:xs) computedLine = euler18Inner xs (zipWith3 (zip3CombineMax) (computedLine++[0]) ([0] ++ computedLine) x)
euler18Inner [] computedLine = computedLine 

