import csv

# Read CSV and return an list of list of integer values
def readCSV(path):
    file = open(path, "r")
    result = []
    i = 0
    for row in csv.reader(file):
        i += 1
        if i == 1: # 1st line is not an image
            continue
        sub = []
        for el in row:
            sub.append(int(el))
        result.append(sub)
    return result
# End

# Print a list
def print_list2d_type (l):
    i = 0
    for e in l:
        print ("l[" + str(i) + "] len : " + str(len(e)))
        i += 1
        for s in e:
            print (str(type(s)) + ", ", end = "")
# End

def tab_to_xy(tab):
	x = []
	y = []
	for i_ in range(len(tab) - 1):
		i = i_ + 1
		y[i] = tab[i][len(tab[i]) - 1]
		for j in range(len(tab[i]) - 1):
			x[i][j] = tab[i][j]
	return x, y
# End

def save_labels(ytab):
    return
# End

#data = readCSV("C:\\Users\\Théophile\\Java\\Projet ML\\data\\local_train.csv")
#print ("Reading done.")
#print_list2d_type (data)
