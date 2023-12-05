import csv

with open('./data.csv') as file:
    data = csv.reader(file)
    data = list(data)

    total = 0

    for row in data:
        # find all spelled out numbers and actual digits
        nums = []
        digitSpellings =('one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine')
        buffer = []
        for i in row[0]:
            buffer.append(i)
            if i.isdigit():
                nums.append(int(i))
                buffer = []
            elif ''.join(buffer).endswith(digitSpellings):
                nums.append()
    print(total)