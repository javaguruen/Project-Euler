a = (1..999)
b = a.select { |x| x % 3 == 0 || x % 5 == 0}


puts b.inject(:+)
