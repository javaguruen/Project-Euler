import qualified Data.Vector as V
import Data.List.Split
import Math

main :: IO ()
main = do 
    s <- readFile "euler13data.txt"
    print (foldl (+) 0 (strToIntList(splitOn "\n" s)))



