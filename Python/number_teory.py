def main():
 while True:
  selection = str.upper(input("\nChoose an option: \n P: Prime number\n C: Compose number\n R: Relative primes\n D: Divisor\n"))
  
  if selection == "P":
    print(str(isPrime()))
  elif selection == "C":
    print(str(not isPrime()))
  elif selection == "R":
    print(str(areRelativesPrimes()))
  elif selection == "D":
    print(str(isDivisor()))   


def isPrime():
  number = setNumber("Digit a number")
  for counter  in range(number):
      if counter > 1 and number % counter == 0: 
       return False
  return True 

def areRelativesPrimes():
  number1 = setNumber("Digit first number")
  number2 = setNumber("Digit second number")
  number1Divisors = []
  number2Divisors = []
  for counter in range(number1):
    if counter > 1 and number1 % counter == 0:
      number1Divisors.append(counter)
  for counter in range(number2):
    if counter > 1 and number2 % counter == 0:
      number2Divisors.append(counter)  

  for num in number1Divisors:
    if num in number2Divisors:
      return False
  return True          

def isDivisor():
  dividing = setNumber("Dividing number")
  divisor = setNumber("Divisor number")
  if (dividing % divisor == 0):
    return True
  return False 

def setNumber(text): 
  return  int(input(text+":\n")) 

main()    