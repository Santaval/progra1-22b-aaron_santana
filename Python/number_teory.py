def main():
 while True:
  selection = str.upper(input("\nChoose an option: \n P: Prime number\n C: Compose number\n R: Relative primes\n D: Divisor\n"))
  
  if selection == "P":
    number = setNumber("Digit a number")
    print(str(isPrime(number)))
  elif selection == "C":
    print(str(not isPrime()))
  elif selection == "R":
    number1 = setNumber("Digit first number")
    number2 = setNumber("Digit second number")
    print(str(areRelativesPrimes(number1, number2)))
  elif selection == "D":
    dividing = setNumber("Dividing number")
    divisor = setNumber("Divisor number")
    print(str(isDivisor(dividing, divisor)))   


def isPrime(number):
  for counter  in range(number):
      if counter > 1 and isDivisor(number, counter): 
       return False
  return True 

def areRelativesPrimes(number1, number2):
  number1Divisors = setDivisors(number1)
  number2Divisors = setDivisors(number2)

  for num in number1Divisors:
    if num in number2Divisors:
      return False
  return True          

def isDivisor(dividing, divisor):
  if (dividing % divisor == 0):
    return True
  return False 

def setDivisors(number):
  divisors = []
  for counter in range(number):
    if counter > 1 and  isDivisor(number, counter):
      divisors.append(counter)
  return divisors

def setNumber(text): 
  return  int(input(text+":\n")) 

main()    