import csv

# Read CSV and return an list of list of integer values
def readCSV(path):
    file = open(path, "r")
    return csv.reader(file)
# End

# Print a list
def print_list2d (l):
    i = 0
    for e in l:
        print ("l[" + str(i) + "] len : " + str(len(e)))
        i += 1
        for s in e:
            print (str(s) + ", ", end = "")
# End

def tab_to_xy(tab):
    return
# End

def save_labels(ytab):
    return
# End
