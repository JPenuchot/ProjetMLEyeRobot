from keras.models import Sequential
from keras.layers import Dense, Dropout, Activation
from keras.layers import Convolution2D, MaxPooling2D
from keras.optimizers import SGD

import csvio

def generate_model(xdat, ydat):
	do stuff...

def save_model(model):
	do stuff...

tabx, taby = tab_to_xy(readCSV("../data/"))

model = Sequencial()

#	Building model...
