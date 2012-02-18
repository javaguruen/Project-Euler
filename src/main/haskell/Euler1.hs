import Math
import List

--Test 
euler1 = sum (nub ((filter (isDividableBy 3) [1..999]) ++ (filter (isDividableBy 5) [1..999])))
