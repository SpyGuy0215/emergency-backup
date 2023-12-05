import csv

with open('./data.csv') as file:
    data = csv.reader(file)
    data = list(data)

    total = 0

    for row in data:
        firstNum = 0
        lastNum = 0
        for i in row[0]:
            if i.isdigit():
                if firstNum == 0:
                    firstNum = int(i)
                lastNum = int(i)
        total += (firstNum * 10) + lastNum
    print(total)