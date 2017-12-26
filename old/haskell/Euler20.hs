tverrmain = let a = factorial 100
                astr = show a
                in tverrsum astr

tverrsum (x:xs) = tverrsum xs + read [x] :: Int
tverrsum [] = 0
