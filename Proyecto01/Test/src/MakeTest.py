import os 

inputs = os.listdir('../../Test/input')
outputs = os.listdir('../../Test/output')
os.system('cd ../../; make bin') 
os.system('cd ../../; mkdir jar_out/') 
counter = 0 
for file in inputs:
    file_out = file[5:12]
    order = "cd ../../; make run_test input=Test/input/"+ file + " output=Test/output/output" + file_out + " jar_out=jar_out/output"+ file_out  
    os.system(order)