module CRealErf(erf) where
import Data.Ratio
import CRealI

-- XXX wrong for x > 1
erf_dr :: CReal -> CReal
erf_dr x = x * power_series sequ' id (x*x)
  where sequ = acc_seq (\a n -> -a*(1%n))
	sequ' = zipWith (/) sequ [1,3..]

erf :: CReal -> CReal
erf x = 2 / sqrt pi * erf_dr x

{-
x^(2*n+1) / n!

n**(2*n+1) / 
n! = sqrt(2*pi*n) * exp(-n) * n**n

term n = |x|

n**(2*n) / (e**(-n) * n**n)
-}
