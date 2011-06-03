class Euler34
  attr_accessor :faculties

  def initialize
    @faculties = {0=>1}
    fac = 1
    (1..9).each do |i|
      fac *= i
      faculties[i] = fac
    end
  end

  def run(maks)
    sum = 0
    bigSum=0
    for i in  1..maks
      sum = 0
      i_s = i.to_s
      i_s.each_char do |s|
        sum += faculties[s.to_i]
      end
      if sum == i
        bigSum += sum
        puts "sum=#{sum} for i=#{i}"
      end
    end
    bigSum
  end
end

euler = Euler34.new()
puts "...."
puts euler.faculties
puts "Sum av alle tall = #{euler.run(1000000000)}"