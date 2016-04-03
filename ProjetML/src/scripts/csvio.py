import csv

#   Read CSV
def readCSV(path):
	file = open(path, "rb")
	reader = csv.reader(file)
	for row in reader:
		print(row)
#   End

def tab_to_xy(tab):
    return
#   End

def save_labels(ytab):
    return
#   End

readCSV("C:\\Users\\Jules\\git\\ProjetMLEyeRobot\\ProjetML\\data\\local_train.csv")
