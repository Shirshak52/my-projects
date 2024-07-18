import datetime  # importing datetime library for generating unique file names for invoices


class Write():  # creating a class Write

    @staticmethod
    def dict_to_file(prod_dict):
        '''args: product dictionary
        function: updates the stock file with the info in the dictionary
        returns: None'''

        updated_info = ""  # setting an empty string to store the updated product info

        # this loop adds each list of the updated product details to updated_info
        for value in prod_dict.values():
            updated_info += ",".join(value) + "\n"

        updated_info = updated_info.rstrip("\n")  # removing the trailing newline from the last line

        stock_file = open("stockfile.txt","w")  # opening the stock file in write mode
        stock_file.write(updated_info)  # writing the updated product information to the
        stock_file.close()  # closing the stock file

    @staticmethod
    def rent_bill_to_file(bill_text):
        '''args: rent invoice
        function: writes the rent invoice to a new text file
        returns: None'''

        file_name = Write.get_rent_invoice_file_name()  # setting the file name

        new_rent_file = open(file_name,"w")  # creating a new file with the unique name
        new_rent_file.write(bill_text)  # writing the bill to the file
        new_rent_file.close()  # closing the file
 
    @staticmethod
    def return_bill_to_file(bill_text):
        '''args: return invoice
        function: writes the return invoice to a new text file
        returns: None'''

        file_name = Write.get_return_invoice_file_name()  # setting the file name

        new_rent_file = open(file_name,"w")  # creating a new file with the unique name
        new_rent_file.write(bill_text)  # writing the bill to the file
        new_rent_file.close()  # closing the file

    @staticmethod
    def get_unique_id():
        '''args: None
        function: creates a unique ID using the current date and time
        returns: the unique ID'''

        year = str(datetime.datetime.now().year)  # storing the current year in a variable
        month = str(datetime.datetime.now().month)  # storing the current month in a variable
        day = str(datetime.datetime.now().day)  # storing the current day in a variable

        hour = str(datetime.datetime.now().hour)  # storing the current hour in a variable
        minute = str(datetime.datetime.now().minute)  # storing the current minute in a variable
        second = str(datetime.datetime.now().second)  # storing the current second in a variable
        
        unique_id = year + month + day + "_" + hour + minute + second  # setting the unique ID

        return unique_id  # returning the unique ID
    
    @staticmethod
    def get_rent_invoice_file_name():
        '''args: None
        function: creates a unique file name for the text file for rent invoices
        returns: the unique file name'''

        file_id = Write.get_unique_id()  # setting a unique ID for the file name
        unique_file_name = "Rent Invoices/rent" + file_id + ".txt"  # setting the file name
        return unique_file_name  # returning the unique file name
    
    @staticmethod
    def get_return_invoice_file_name():
        '''args: None
        function: creates a unique file name for the text file for return invoices
        returns: the unique file name'''
    
        file_id = Write.get_unique_id()  # setting a unique ID for the file name
        unique_file_name = "Return Invoices/return" + file_id + ".txt"  # setting the file name
        return unique_file_name  # returning the unique file name

    @staticmethod
    def get_current_date():
        '''args: None
        function: gets the current date
        returns: the current date'''

        # getting the current date
        current_date = "Date: " + str(datetime.datetime.now().date()) + "\t"
        return current_date  # returning the current date

    @staticmethod
    def get_current_time():
        '''args: None
        function: gets the current time
        returns: the current time'''

        # getting the current time
        current_time = "Time: " + str(datetime.datetime.now().time().replace(microsecond=0)) + "\n"
        return current_time  # returning the current time
