import Math

euler142 = findMaxCollanzLenght 1 1 1 1000000

findMaxCollanzLenght :: Int -> Int -> Int -> Int -> Int
findMaxCollanzLenght currentMax maxFoundAtN n maxN  = if n < maxN 
                                      then
                                        let currentlength = collatzChainLength n 
                                        in if currentlength > currentMax
                                            then
                                              findMaxCollanzLenght currentlength n (n+1) maxN 
                                            else
                                              findMaxCollanzLenght currentMax maxFoundAtN (n+1) maxN 
                                      else
                                        maxFoundAtN
