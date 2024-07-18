from operations import Shop  # importing Shop class for renting and returning functions, and displaying shop information, 
                             # welcome message, stock information and the 3 options
from read import Read  # importing Read class for reading stock file to convert the info into a dictionary


class Main():  # creating a class Main

    Shop.show_info()  # displaying shop details
    Shop.show_welcome_message()  # displaying welcome message

    prod_dict = Read.file_to_dict()  # storing product info from stock file in a dictionary

    '''this loop is the main loop of the whole program, 
    and is exited only when option 3 is selected'''
    exit_program = False  # setting a flag
    while exit_program == False:
        Shop.show_options()  # displaying the rent, return and exit options
        option = Shop.valid_option(prod_dict)  # asking input for the options and validating it 

        '''this if statement checks input value of option
        if input is 1, it carries out renting operations
        elif input is 2, it carries out returning operations
        else it breaks the while loop and exits the program'''
        if option == 1:  # if user wants to rent a product
            Shop.rent_operations(prod_dict)  # carrying out the rent operations

        elif option == 2:  # if user wants to return a prouct
            Shop.return_operations(prod_dict)  # carrying out the return operations

        else:  # if user wants to exit the program
            exit_program = True  # setting flag to false, breaking the main loop

    Shop.show_exit_message()  # printing exit message after user exits the program



