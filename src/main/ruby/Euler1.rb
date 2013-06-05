range = (1..999)
filteredRange = range.select { |x| x % 3 == 0 || x % 5 == 0}


puts filteredRange.inject(:+)
