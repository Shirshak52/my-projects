


class Read():  # creating a class Read

    @staticmethod
    def file_to_dict():
        '''args: None
        function: reads the stock file and returns the info in a dictionary
        returns: a dictionary with the info in the stock file'''

        stock_file = open("stockfile.txt", "r")  # opening the stock file
        data = stock_file.read()  # reading the stock file
        data = data.split("\n")  # splitting the data per each new line

        prod_dict = {}  # creating a dictionary to store the data
        c = 1  # setting the counter for the dictionary keys

        # this loop adds the list of details of each product to the dictionary
        for i in range(len(data)):
            prod_dict[c] = data[i].split(",")
            c += 1  # increasing the counter by 1 each time

        stock_file.close()  # closing the stock file

        return prod_dict  # returning prod_dict




