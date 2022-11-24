import random
def generateValidCell():
  TYPES = 'RRRRR'
  COLORS = '123456'
  type =  TYPES[random.randint(1,4)]
  color =  COLORS[random.randint(1,4)]
  return type + color + ' '



def main():
  rowCount = random.randint(0,50)
  colCount = random.randint(0,50)
  print(str(rowCount) + " " + str(colCount)) 
  for rowIndex in range(rowCount):
    for colIndex in range(colCount):
      print(generateValidCell(), end="")
    print("")


main()