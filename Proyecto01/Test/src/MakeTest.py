import os 

inputs = os.listdir('Test/input')
outputs = os.listdir('Test/output')

os.system('make bin') 

os.system('mkdir jar_out/')


for file in inputs:
    file_out = file[5:12]
    print("icdiff --no-headers  Test/output/output" + file_out  + " jar_out/output"+ file_out)
    os.system("java -jar bin/Game.jar < Test/input/" + file+ ">"+  "jar_out/output"+ file_out)
    os.system("icdiff --no-headers  Test/output/output" + file_out  + " jar_out/output"+ file_out)