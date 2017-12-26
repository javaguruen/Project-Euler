import Data.List

euler24 = take 1 (drop 999999 (sort (permutations [0,1,2,3,4,5,6,7,8,9])))

