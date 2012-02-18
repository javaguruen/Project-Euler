import Math
import List

--Testing even more
euler1 = sum (nub ((filter (isDividableBy 3) [1..999]) ++ (filter (isDividableBy 5) [1..999])))
