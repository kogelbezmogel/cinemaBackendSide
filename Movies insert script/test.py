import pickle

data = pickle.load( open("./top250_processed_data.pickle", "rb") )

print( data[0] )