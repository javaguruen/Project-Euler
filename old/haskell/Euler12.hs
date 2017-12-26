import Math
import BigMath

euler12 = let elemBeforeLast = length (takeWhile (<500)( map length (map (properfactorsBig) (map toTriangleNumberBig [1..]))))
          in toTriangleNumber (elemBeforeLast + 1)
