from write import Write  # importing Write class for updating stock file and writing invoices to text files





class Shop():  # creating a class Shop

    @staticmethod
    def rent_operations(prod_dict):
        '''args: product dictionary
        function: carries out renting operations
        returns: None'''

        rent_list = []  # creating a list to store products currently being rented

        '''this while loop carries out renting operations.
        it repeatedly asks user if they want to rent more, until they enter 'n'
        then it asks input for customer details,
        generates invoice,
        and writes the invoice to a new text file'''
        continue_renting = True  # setting a flag 
        while continue_renting == True:
            Shop.display_stock(prod_dict)  # displaying the info from the stock file

            prod_id = Rent.valid_prod_id(prod_dict)  # validating product ID input from user
            qty = Rent.valid_prod_qty(prod_dict, prod_id)  # validating product qty input from user
            rented_for = Rent.valid_rented_for()  # validating num of days rented for input from user

            rent_prod = Rent(prod_dict, prod_id, qty, rented_for)  # creating Rent object
            Product.update_stock(rent_prod,prod_dict)  # updating stock of the object
            rent_list.append(rent_prod)  # adding the product to the rent product list
            

            '''this if statement checks if no products are available
            if so, it directly breaks this while loop
            else it asks user if they want to rent more
            if yes, it restarts by again asking for product ID
            if not, it breaks this loop'''
            # getting rent choice from user
            prod_not_available = Shop.are_no_prods_available(prod_dict)  # setting a flag to check if products are available for rent
            if prod_not_available == True:  # if no products are available for renting
                continue_renting = False  # setting flag to false, breaking this while loop
            else:  # if products are available for renting
                rent_choice = Rent.get_rent_choice()  # validating input from user if they want to rent more
                if rent_choice == True:  # if user wants to rent more
                    continue_renting = True  # setting flag to true, continuing this while loop
                else:  # if user does not want to rent more
                    continue_renting = False  # setting flag to false, breaking this while loop

        # this section is related to invoice generation only
        Bill.print_invoice_message()  # printing message to inform user to enter customer details
        cust_name = Shop.get_cust_name()  # taking customer name input from user
        cust_num = Shop.get_cust_num()  # taking customer phone number input from user

        rent_bill = Rent.create_bill(rent_list,cust_name,cust_num)  # creating an invoice for rented products
        print(rent_bill)  # printing the invoice
        Write.rent_bill_to_file(rent_bill)  # writing the invoice to a new text file

    @staticmethod
    def return_operations(prod_dict):
        '''args: product dictionary
        function: carries out returning operations
        returns: None'''

        return_list = []  # creating a list to store products currently being returned

        '''this while loop carries out returning operations.
        it repeatedly asks user if they want to return more, until they enter 'n'
        then it asks input for customer details,
        generates invoice,
        and writes the invoice to a new text file'''
        continue_returning = True  # setting a flag 
        while continue_returning == True:
            Shop.display_stock(prod_dict)  # displaying the info from the stock file
            
            prod_id = Return.valid_prod_id(prod_dict)  # validating product ID input from user
            qty = Return.valid_prod_qty()  # validating product qty input from user
            days_rented = Return.valid_days_rented()  # validating num of days rented for input from user
            returned_after = Return.valid_returned_after()  # validating num of days returned after input from user


            return_prod = Return(prod_dict, prod_id, qty, days_rented, returned_after)  # creating product object
            Product.update_stock(return_prod, prod_dict)  # # updating stock of the product object
            return_list.append(return_prod)  # adding the product to the return product list

            '''this if statement asks user if they want to rent more
            if yes, it restarts by again asking for product ID
            if not, it breaks this loop'''            
            return_choice = Return.get_return_choice()  # validating input from user if they want to return more
            if return_choice == True:  # if user wants to rent more
                continue_returning = True  # setting flag to true, continuing this while loop
            else:  # if user does not want to rent more
                continue_returning = False  # setting flag to false, breaking this while loop

        # this section is related to invoice generation only
        Bill.print_invoice_message()  # printing message to inform user to enter customer details
        cust_name = Shop.get_cust_name()  # taking customer name input from user
        cust_num = Shop.get_cust_num()  # taking customer phone number input from user

        return_bill = Return.create_bill(return_list,cust_name,cust_num)  # creating an invoice for returned products
        print(return_bill)  # printing the invoice
        Write.return_bill_to_file(return_bill)  # writing the invoice to a new text file

    

   
    
    @staticmethod
    def show_info():
        '''args: None
        function: prints the shop details
        returns: None'''

        shop_name = "Shirshak's Rent-an-Equipment Shop"  # setting shop name
        shop_address = "Address: Maligaun 05, Kathmandu"  # setting shop address
        shop_number = "Phone: 9544443333"  # setting shop contact num
        shop_email = "Email: shirshak_rentalshop@gmail.com"  # setting shop email address

        shop_info = []  # creating a list to store shop details
        shop_info.append(shop_name)  # adding shop name to the list
        shop_info.append(shop_address)  # adding shop addrss to the list
        shop_info.append(shop_number)  # adding shop contact number to the list
        shop_info.append(shop_email)  # adding shop email address to the list

        num_of_equals_sign = 129  # setting num of equals sign to be printed
        equals_sign = Misc.print_equals_sign(num_of_equals_sign)  # setting equals sign

        centering_num = 129  # setting the num for centering the text

        # this for loop prints the shop information at the center of the screen
        print(equals_sign)  # printing equals sign
        for each_info in shop_info:
            print(each_info.center(centering_num))  # printing shop details
        print(equals_sign)  # printing equals sign

    @staticmethod
    def show_welcome_message():
        '''args: None
        function: prints a welcome message
        returns: None'''

        # setting a welcome message
        welcome_msg = "Welcome to Shirshak's Rent-an-Equipment Shop! Please see the instructions below to carry out your desired tasks!"

        num_of_dashes = 122  # setting num of dashes to be printed
        dashes = Misc.print_dashes(num_of_dashes)  # setting dashes

        print(dashes)  # printing dashes
        print(welcome_msg)  # printing welcome message
        print(dashes + "\n")  # printing dashes

    @staticmethod
    def show_options():
        '''args: None
        function: displays options to rent, return or exit
        returns: None'''

        opt1 = "[1] Press 1 to rent an equipment."  # setting message of rent option
        opt2 = "[2] Press 2 to return an equipment."  # setting message of return option
        opt3 = "[3] Press 3 to exit the program.\n"  # setting message of exit option

        option_list = []  # creating a list to store the 3 options
        option_list.append(opt1)  # adding option 1 to the list
        option_list.append(opt2)  # adding option 2 to the list
        option_list.append(opt3)  # adding option 3 to the list

        # displaying each option in the list
        for option in option_list:
            print(option)

    @staticmethod
    def display_stock(prod_dict):
        '''args: product dictionary
        functions: displays the info in the dictionary
        returns: None'''
        
        # creating a list that contains the list info of each product
        # to align its columns
        stock_list = [[item for item in each] for each in prod_dict.values()]
        header_row = ["Product","Brand","Price","Stock"]  # creating a header row
        stock_list.insert(0,header_row)  # adding header row to the list
        aligned_stock_list = Misc.align_2D_list(stock_list)  # aligning the list

        num_of_dashes = Misc.get_num_of_dashes(aligned_stock_list)  # setting num of dashes to be printed
        dashes = Misc.print_dashes(num_of_dashes)  # setting dashes

        #this section is for printing the header row
        print(dashes)  # printing dashes
        print("ID\t" + "".join(aligned_stock_list[0]))  # printing the header row
        print(dashes)  # printing dashes   

        # this for loop prints the product details from the list
        p_id = 1  # setting product ID
        for i in range(1,len(aligned_stock_list)):
            print(str(p_id) + "\t" + "".join(aligned_stock_list[i]))  # printing the product details
            p_id += 1  # increasing product ID by 1 each time

        print(dashes)  # printing dashes

    @staticmethod
    def show_exit_message():
        '''args: None
        function: prints an exit message after user exits main loop
        returns: None'''

        # printing the exit message
        print("\nThank you for using our application.")

    @staticmethod
    def valid_option(prod_dict):
        '''args: product dictionary
        function: validates user input for rent, return or exit
        returns: valid option number'''

        '''this while loop asks user input for rent, return or exit options
        and repeatedly asks for valid input unless user enters valid input
        here, invalid input being anything other than 1, 2 or 3
        it also displays an error message if no product is available for rent at all'''
        while True:
            try:
                option = int(input("Enter a number: ").replace(" ",""))  # asking user to input a number
                if option == 1:  # if user enters 1
                    no_prods_available = Shop.are_no_prods_available(prod_dict)
                    if no_prods_available == True:  # if no product is available for rent
                        print("Sorry, no equipment is available for rent right now!\n")  # printing error message
                    else:  # if products are available for rent
                        return option  # returning option
                    
                elif option == 2 or option == 3:  # if user enters 2 or 3
                    return option  # returning option
                    
                else:  # if user enters anything other than 1, 2 or 3
                    print("Invalid option; please input either 1, 2 or 3\n")  # printing an error message
            except ValueError:
                print("Invalid input; please enter the option in numbers, either 1, 2 or 3\n")
                
    @staticmethod
    def are_no_prods_available(prod_dict):
        '''args: product dictionary
        function: checks if no products are available for renting
        returns: True if no products are available, else False'''
        
        all_stock_sum = 0  # setting thesum to 0 to be added to

        # calculating the sum of stock nums of each product from the dictionary
        for each in prod_dict.values():
            all_stock_sum += int(each[-1])

        if all_stock_sum == 0:  # if no products are available
            return True  # returning True
        else:  # if products are available
            return False  # returning false

    @staticmethod
    def get_cust_name():
        '''args: None
        function: asks input for customer name
        returns: customer name'''

        '''this while loop asks input for customer name
        and repeatedly asks for valid input until user enters valid input
        here, invalid input means empty text (whitespaces do not count)'''
        while True:
            cust_name = input("Enter customer name: ").strip()  # asking user for customer name
            if len(cust_name) == 0:  # if user inputs empty string
                print("Invalid input; please enter the customer name\n")  # printing error message
            else:  # if user input is valid
                return cust_name  # returning customer name

    @staticmethod
    def get_cust_num():
        '''args: None
        function: asks input for customer phone number
        returns: customer phone number'''

        '''this while loop asks input for customer phone number
        and repeatedly asks for valid input until user enters valid input
        here, invalid input means empty text (whitespaces do not count)'''

        while True:
            cust_num = input("Enter customer phone number: ").strip()  # asking user for customer phone number
            if len(cust_num) == 0:  # if user inputs empty string
                print("Invalid input; please enter the customer's phone number\n")  # printing error message
            else:  # if user input is valid
                return cust_num  # returning customer phone number

    @staticmethod
    def get_details_for_bill():
        '''args: None
        function: sets the text containing shop details, to be printed in invoices
        returns: shop details'''

        num_of_dashes = 122  # setting num of dashes
        dashes = Misc.print_dashes(num_of_dashes)  # getting dashes

        centering_num = 129
        # setting shop details to be printed in invoices
        details_for_bill = "\n" + dashes + "\n"  # dashes
        details_for_bill += "Shirshak's Rent-an-Equipment Shop".center(centering_num) + "\n"  # shop name
        details_for_bill += "Address: Maligaun 05, Kathmandu".center(centering_num) + "\n"  # shop address
        details_for_bill += "Phone: 9544443333".center(centering_num) + "\n"  # shop contact num
        details_for_bill += "Email: shirshak_rentalshop@gmail.com".center(centering_num) + "\n"  # shop email address
        details_for_bill += dashes + "\n"  # dashes

        return details_for_bill  # returning details for bill







class Product():  # creating a class Product

    def __init__(self, prod_dict, prod_id, qty):
        '''args: product dictionary, product ID, product qty
        function: creates a Product object
        returns: None'''

        # using values from product dictionary
        self.ID = prod_id  # setting product ID
        self.name = prod_dict[prod_id][0]  # setting product name
        self.brand = prod_dict[prod_id][1]  # setting brand name
        self.price = prod_dict[prod_id][2] # setting product price
        self.stock = prod_dict[prod_id][3]  # setting product stock
        self.qty = qty  # setting product qty

    @staticmethod
    def get_grand_total(prod_list):
        '''args: list of products currently being rented/returned
        function: calculates grand total price
        returns: grand total price'''

        grand_total = 0  # setting a variable to store grand total price
        for each in prod_list:
            grand_total += each.total_price  # calculating grand total price
        return grand_total  # returning grand total price

    @staticmethod
    def update_stock(prod, prod_dict):
        '''args: rented/returned product, product dictionary
        function: updates stock of rented/returned product in the product dictionary, and writes the dictionary to stock file
        returns: None'''

        current_stock = int(prod.stock)  # setting current stock of product
        qty = prod.qty  # setting product qty
        updated_stock = 0  # setting updated product stock to be modified below

        '''this if statement calculates the updated stock
        if the product is an object of Rent class, it deducts the rented quantity from current stock
        else it adds the returned quantity to current stock'''
        if isinstance(prod,Rent):  # if product is rented
            updated_stock = current_stock - qty  # subtracting rented qty from current stock
        else:  # if product is returned
            updated_stock = current_stock + qty  # adding returned qty to current stock

        prod_dict[prod.ID][-1] = str(updated_stock)  # updating stock value in product dictionary
        Write.dict_to_file(prod_dict)  # writing updated stock to stock file


class Rent(Product):  # creating a class Rent that inherits Product class

    def __init__(self, prod_dict, prod_id, qty, rented_for):
        '''args: product dictionary, product ID, product qty, num of days rented for
        function: creates a Rent object by calling superclass init method
        returns: None'''

        # calling superclass init method
        super().__init__(prod_dict, prod_id, qty)

        self.rented_for = rented_for  # setting num of days product is being rented for

        price = prod_dict[prod_id][2]  # getting price from product dictiionary
        price_factor = Rent.get_price_factor(rented_for)  # setting price factor
        self.total_price = Rent.get_total_price(price, price_factor, qty)  # setting total price

    @staticmethod
    def get_price_factor(rented_for):
        '''args: num of days rented for
        function: calculates the price factor of the product
        returns: price factor of the product'''

        '''this if-else statement sets price factor of product
        if rented_for is divisible by 5, it sets price factor as rented_for / 5
        else it sets price factor as (rented_for // 5) + 1'''

        price_factor = 0 # setting a variable to store price factor

        if rented_for % 5 == 0:  # if rented_for is divisible by 5
            price_factor = rented_for/5
        else:  # if rented_for is not divisible by 5
            price_factor = (rented_for // 5) + 1

        return price_factor  # returning price factor

    @staticmethod
    def get_total_price(price, price_factor, qty):
        '''args: price, price factor
        function: calculates the total price the product
        returns: total price of the product'''
                
        # calculating total price
        total_price = price_factor * int(price.replace("$","")) * qty
        return total_price  # returning total price
 
    @staticmethod
    def valid_prod_id(prod_dict):
        '''args: product dictionary
        function: validates input for product ID
        returns: valid product ID'''

        '''this loop asks input for product ID
        and displays error messages if input is invalid
        here, invalid input being non-integer values and values not within 1 to 5
        it also displays error message if the product with input ID is unavailable'''
        while True:
            try:
                prod_id = int(input("Enter product ID (1 to 5): ").replace(" ",""))  # asking input for product ID

                if 1 <= prod_id <= len(prod_dict):  # checking if input is between 1 to the length of product dictionary
                    
                    if int(prod_dict[prod_id][-1]) == 0:  # checking if the product with that ID is not available
                        print("Sorry, this product is not available right now!\n")  # printing error message
                    else:  # if the product with that ID is available
                        return prod_id  # returning product ID
                
                else:  # if input is not between 1 to 5
                    print("Invalid product ID; please enter a number from 1 to 5\n")  # printing error message

            except ValueError:  # if input is a non-integer value
                print("Invalid input; please enter the product ID in numbers\n")  # printing error message

    @staticmethod
    def valid_prod_qty(prod_dict, prod_id):
        '''args: product dictionary, product ID
        function: validates input for product qty
        returns: valid product qty'''

        '''this loop asks input for product qty
        and displays error messages if input is invalid
        here, invalid input being non-integer values and values not within 1 and the available stock'''
        while True:
            try:
                qty = int(input("Enter how many items to rent: ").replace(" ",""))  # asking input for product qty               
                if 0 < qty <= int(prod_dict[prod_id][-1]):  # checking if input qty is available
                    return qty  # returning product qty  
                else:  # if input qty is not available
                    print("Invalid input; please enter a number within 1 and the available stock\n")  # printing error message
            except ValueError:  # if input is a non-integer value
                print("Invalid input; please enter the quantity in numbers\n")  # printing error message

    @staticmethod
    def valid_rented_for():
        '''args: None
        function: validates input for num of days rented for
        returns: valid num of days rented for'''

        '''this loop asks input for num of days rented for
        if the input is more than 0, it returns that value
        else it prints error message
        if input is not an integer, it prints error message'''
        while True:
            try:
                # asking input for num of days rented for
                rented_for = int(input("How many days is this product being rented for?: ").replace(" ",""))
                
                if rented_for > 0:  # if input is a positive number
                    return rented_for  # returning num of days rented for
                else:  # if input is 0 or a negative value
                    print("Invalid input; please enter a positive value for the number of days\n")  # printing error message

            except:  # if input is a non-integer value
                print("Invalid input; please enter the number of days in numbers\n")  # printing error message

    @staticmethod
    def get_rent_choice():
        '''args: None
        function: asks input for if user wants to rent more products
        returns: rent choice'''

        '''this loop asks input for if user wants to rent more products 
        if input is 'y', it returns True
        elif input is 'n', it returns False
        else it prints error message'''
        while True:
            # asking if user wants to rent more products
            rent_more = input("Do you want to rent more products? (y/n): ").lower().replace(" ","")

            if rent_more == "y":  # if user wants to rent more products
                return True  # returning True
            elif rent_more == "n":  # if user does not want to rent more products
                return False  # returning False
            else:  # if user enters anything but "y" or "n"
                print("Invalid answer; please enter either 'y' or 'n'\n")  # printing error message

    @staticmethod
    def create_bill(rent_list, cust_name, cust_num):
        '''args: list of currently rented products, customer name, customer phone number
        function: creates a rent invoice
        returns: rent invoice'''

        bill_text = Shop.get_details_for_bill()  # getting shop details to be printed in invoice
        bill_text += "\nInvoice ID: " + Rent.get_bill_id() + "\n"  # setting invoice ID
        bill_text += Bill.create_bill(rent_list, cust_name, cust_num) + "\n"  # creating rent invoice
        return bill_text  # returning rent invoice
    
    @staticmethod
    def get_bill_id():
        '''args: None
        function: sets unique invoice ID
        returns: unique invoice ID'''

        bill_id = "rent" + Write.get_unique_id()  # setting ID for rent invoice
        return bill_id  # returning the invoice ID


class Return(Product):  # creating a class Return that inherits Product class
    
    def __init__(self, prod_dict, prod_id, qty, days_rented, returned_after):
        '''args: product dictionary, product ID, product qty, num of days returned after
        function: creates a Return object by calling superclass init method
        returns: None'''

        # calling superclass init method
        super().__init__(prod_dict, prod_id, qty)

        self.days_rented = days_rented  # setting num of days rented for
        self.returned_after = returned_after  # setting num of days returned after

        price = prod_dict[prod_id][2]  # getting price from product dictionary

        price_factor_for_days_rented = Rent.get_price_factor(days_rented)  # getting price factor for days_rented
        base_price = Rent.get_total_price(price,price_factor_for_days_rented,qty)  # getting base price of the product
        
        self.fine = Return.get_fine(price, days_rented, returned_after, qty)  # setting fine
        self.total_price = base_price + self.fine  # setting total price

    @staticmethod
    def get_fine(price, days_rented, returned_after, qty):
        '''args: price, days rented, days returned after
        function: calculates the fine
        returns: the fine'''

        # getting price factor for days rented
        price_factor_for_days_rented = Rent.get_price_factor(days_rented)
        # getting price factor for days returned after
        price_factor_for_returned_after = Rent.get_price_factor(returned_after)

        '''this if statement checks if price factor for days rented and days returned after is same
        if they are same, it sets the fine to 0
        else it sets the fine as the product of the extra days and price for 5 days'''
        fine = 0  # setting a variable to store the fine
        if price_factor_for_days_rented >= price_factor_for_returned_after:  # if price factor is same
            fine = 0  # setting fine to 0
        else:  # if price factor is different
            fine_days = returned_after - (price_factor_for_days_rented * 5)  # calculating num of days to be fined for
            fine = (int(price.replace("$",""))/5) * fine_days * qty  # calculating fine

        return round(fine,2)  # returning fine

    @staticmethod
    def valid_prod_id(prod_dict):
        '''args: None
        function: validates input for product ID
        returns: valid product ID'''

        '''this loop asks input for product ID
        and displays error messages if input is invalid
        here, invalid input being non-integer values and values not within 1 to 5'''
        while True:
            try:
                prod_id = int(input("Enter product ID (1 to 5): ").replace(" ",""))  # asking input for product ID
                if 1 <= prod_id <= len(prod_dict):  # checking if input is between 1 to 5
                    return prod_id  # returning product ID
                else:  # if input is not between 1 to 5
                    print("Invalid product ID; please enter a number from 1 to 5\n")  # printing error message
            except ValueError:  # if input is a non-integer value
                print("Invalid input; please enter the product ID in numbers\n")  # printing error message
                
    @staticmethod
    def valid_prod_qty():
        '''args: None
        function: validates input for product qty
        returns: valid product qty'''

        '''this loop asks input for product qty
        and displays error messages if input is invalid
        here, invalid input being 0, and negative and non-integer values'''
        while True:
            try:
                qty = int(input("Enter how many items to return: ").replace(" ",""))  # asking input for product qty
                if qty > 0:  # checking if input is a positive value
                    return qty  # returning product qty
                else:  # if input is 0 or negative
                    print("Invalid input; please enter a number greater than 0\n")  # printing error message
            except ValueError:  # if input is a non-integer value
                print("Invalid input; please enter the quantity in numbers\n")  # printing error message
                
    @staticmethod
    def valid_days_rented():
        '''args: None
        function: validates the num of days rented
        returns: valid num of days rented'''

        '''this while loop asks input for num of days rented
        if input is more than 0, it returns that value
        else it prints error message
        if input is not an integer, it prints error message'''
        while True:
            try:
                # asking input for num of days rented
                days_rented = int(input("How many days was this product rented for?: ").replace(" ",""))

                if days_rented > 0:  # if input is more than 0
                    return days_rented  # returning the value
                else:  # if input is 0 or less
                    print("Invalid input; please enter a number greater than 0\n")  # printing error message
            except:  # if input is not an integer
                print("Invalid input; please enter the number of days in numbers\n")  # printing error message

    @staticmethod
    def valid_returned_after():
        '''args: None
        function: validates input for num of days returned after
        returns: valid num of days returned after'''

        '''this loop asks input for num of days returned after
        and displays error messages if input is invalid
        here, invalid input being negative and non-integer values'''
        while True:
            try:
                # asking input for num of days returned after
                returned_after = int(input("How many days is this product being returned after?: ").replace(" ",""))
                
                if returned_after > 0:  # if input is a positive value
                    return returned_after  # returning num of days returned after
                else:  # if input is 0 or a negative value
                    print("Invalid input; please enter a non-negative value\n")  # printing error message

            except:  # if input is a non-integer value
                print("Invalid input; please enter the number of days in numbers\n")  # printing error message

    @staticmethod
    def get_return_choice():
        '''args: None
        function: asks input for if user wants to return more products
        returns: return choice'''

        '''this while loop asks input for if user wants to return more producs 
        and repeatedly asks for valid input until user enters valid input
        here, invalid input being any text other than 'y' or 'n' '''
        while True:
            # asking if user wants to return more products
            return_more = input("Do you want to return more products? (y/n): ").lower().replace(" ","")
            if return_more == "y":  # if user wants to return more products
                return True  # returning True
            elif return_more == "n":  # if user does not want to return more products
                return False  # returning False
            else:  # if the user enters anything but "y" or "n"
                print("Invalid answer; please enter either 'y' or 'n'\n")  # printing error message

    @staticmethod
    def create_bill(return_list, cust_name, cust_num):
        '''args: list of currently returned products, customer name, customer phone number
        function: creates a return invoice
        returns: return invoice'''

        bill_text = Shop.get_details_for_bill()  # getting shop details to be printed in invoice
        bill_text += "\nInvoice ID: " + Return.get_bill_id() + "\n"  # setting invoice ID
        bill_text += Bill.create_bill(return_list, cust_name, cust_num) + "\n"  # creating return invoice
        return bill_text  # returning return invoice
    
    @staticmethod
    def get_bill_id():
        '''args: None
        function: sets unique invoice ID
        returns: unique invoice ID'''

        bill_id = "return" + Write.get_unique_id()  # setting ID for return invoice
        return bill_id  # returning the invoice ID


class Bill():  # creating a class Bill

    @staticmethod
    def get_aligned_bill_list(prod_list):
        '''args: list of currently rented/returned products
        function: creates a list of aligned items to be printed in the invoice
        returns: the list of aligned items'''

        bill_list = []  # creating a list to store the product details from the arg list

        #this loop adds a list of product details of each product in the arg list
        for each in prod_list:
            if isinstance(each,Rent):  # if the list is of rented products
                bill_list.append([
                    str(each.ID),  # product ID
                    each.name,  # product name
                    each.brand,  # brand name
                    each.price,  # product price
                    str(each.qty),  # product qty
                    str(each.rented_for),  # num of days product is being rented for
                    "$" + str(each.total_price)  # total price
                ])
            else:  # if the list is of returned products
                bill_list.append([
                    str(each.ID),  # product ID
                    each.name,  # product name
                    each.brand,  # brand name
                    each.price,  # product price
                    str(each.qty),  # product qty
                    str(each.days_rented),  # num of days rented for
                    str(each.returned_after),  # num of days returned after
                    "$" + str(each.fine),  # fine
                    "$" + str(each.total_price)  # total price
                ])

        header_row = []  # setting a variable to store header row
        if isinstance(prod_list[0],Rent):  # if the list is of rented products
            header_row = Bill.get_rent_bill_header_row()  # setting the rent invoice header row
        else:  # if the list is of returned products
            header_row = Bill.get_return_bill_header_row()  # setting the return invoice header row
        
        bill_list.insert(0,header_row)  # inserting the header row of the invoice to the bill list
        aligned_bill_list = Misc.align_2D_list(bill_list)  # aligning the bill list

        return aligned_bill_list  # returning the aligned bill list
    
    @staticmethod
    def get_bill_prod_details(aligned_bill_list):
        '''args: list of invoice items
        function: sets each row of product details with a serial number
        returns: each row of product details with a serial number'''

        bill_prod_details = ""  # setting the variable as an empty string to add to
        sn = 1  # initializing sn as the serial number

        # this loop sets each row of product details with a serial number
        for i in range(1,len(aligned_bill_list)):
            bill_prod_details += str(sn) + "\t" + "".join(aligned_bill_list[i]) + "\n"
            sn += 1  # increasing sn by 1 each time

        return bill_prod_details  # returning the modified rows of product details

    @staticmethod
    def get_bill_cust_details(cust_name,cust_num):
        '''args: customer name, customer phone number
        function: prints the customer name and phone number
        returns: the customer name and phone number'''

        bill_cust_details = "\nCustomer name: " + cust_name # printing customer name
        bill_cust_details += "\nCustomer phone number: " + cust_num + "\n"  # printing customer phone number
        return bill_cust_details  # returning the customer details

    @staticmethod
    def get_bill_grand_total(grand_total):
        '''args: grand total price
        function: sets the grand total price as a string with the '$' sign
        returns: the grand total price as a string with the '$' sign'''

        # setting the grand total price as a string with the '$' sign
        bill_grand_total = "Grand total price: $" + str(round(grand_total,2)) + "\n"
        return bill_grand_total  # returning the grand total price as a string with the '$' sign
    
    @staticmethod
    def bill_header_row(aligned_bill_list):
        '''args: list of invoice items
        function: sets the header row of the invoice with a serial number column header
        returns: the header row of the invoice with a serial number column header'''

        # setting the header row of the invoice with a serial number column header
        bill_header = "SN\t" + "".join(aligned_bill_list[0]) + "\n"
        return bill_header  # returning the header row

    @staticmethod
    def get_rent_bill_header_row():
        '''args: None
        function: sets the header row for rent invoice
        returns: the header row for rent invoice'''

        # setting header row for rent invoice
        header_row = ["ID","Product","Brand","Price","Qty","Rented For","Total"]
        return header_row  # returning header row
    
    @staticmethod
    def get_return_bill_header_row():
        '''args: None
        function: sets the header row for return invoice
        returns: the header row for return invoice'''

        # setting header row for return invoice
        header_row = ["ID","Product","Brand","Price","Qty","Rented For", "Returned After","Fine","Total"]
        return header_row  # returning header row
    
    @staticmethod
    def print_invoice_message():
        '''args: None
        function: prints a message to inform user to enter customer details
        returns: None'''

        print("\nFor generating invoice: ")  # printing the invoice message

    @staticmethod
    def create_bill(prod_list, cust_name, cust_num):
        '''args: list of currently rented/returned products, customer name, customer phone number
        function: creates an invoice
        returns: the invoice'''

        grand_total = Product.get_grand_total(prod_list)  # getting grand total price in string form

        aligned_bill_list = Bill.get_aligned_bill_list(prod_list)  # aligning the items to be printed in the invoice

        num_of_dashes = Misc.get_num_of_dashes(aligned_bill_list)  # setting num of dashes to be printed

        bill_text = Write.get_current_date()  # getting current date
        bill_text += Write.get_current_time()  # getting current time

        bill_text += Misc.print_dashes(num_of_dashes) + "\n"  # printing dashes
        bill_text += Bill.bill_header_row(aligned_bill_list)  # printing header row of invoice
        bill_text += Misc.print_dashes(num_of_dashes) + "\n"  # printing dashes

        bill_text += Bill.get_bill_prod_details(aligned_bill_list)  # printing product details in the invoice
        bill_text += Bill.get_bill_cust_details(cust_name,cust_num)  # printing customer name and phone number

        bill_text += Misc.print_dashes(num_of_dashes) + "\n"  # printing dashes
        bill_text += Bill.get_bill_grand_total(grand_total)  # printing grand total price
        bill_text += Misc.print_dashes(num_of_dashes) + "\n"  # printing dashes

        return bill_text  # returning the invoice








class Misc():  # creating a class Misc

    @staticmethod
    def align_2D_list(list_2D):
        '''args: a 2D list
        function: aligns the items inside every list in the 2D list
        returns: the aligned form of the arg 2D list'''

        #calculating the number of spaces to left-justify each column with in the 2D list
        space_l = [max(len(each[i]) for each in list_2D) for i in range(len(list_2D[0]))]

        padding = 3  # setting the padding between each column

        # aligning the items inside each list in the 2D list
        for each in list_2D:
            for i in range(len(list_2D[0])):
                each[i] = each[i].ljust(space_l[i] + padding)

        return list_2D  # returning the aligned 2D list

    @staticmethod
    def get_num_of_dashes(list_2D):
        '''args: a 2D list
        function: calculates the num of dashes to print for decorating a 2D list
        returns: the num of dashes'''

        # creating a list to store the total lengths of items for each list in the 2D list
        len_of_each_row = []

        # adding those lengths to the list above
        for i in range(len(list_2D)):
            len_of_each_row.append(sum(len(item) for item in list_2D[i]))

        # setting the maximum length from the list above as the num of dashes
        num_of_dashes = max(len_of_each_row)

        return num_of_dashes  # returning the number of dashes

    @staticmethod
    def print_dashes(num_of_dashes):
        '''args: num of dashes
        function: prints that many dashes
        returns: that many dashes'''

        surplus = 7  # setting the surplus number of dashes when necessary
        dashes = "-" * (num_of_dashes + surplus)  # printing the required number of dashes
        return dashes  # returning the required amount of dashes
    
    @staticmethod
    def print_equals_sign(num_of_sign):
        '''args: num of equals signs
        function: prints that many equals signs above and below the shop details
        returns: that many equals signs'''

        surplus = 0  # setting the surplus number of equals signs when necessary
        equals = "=" * (num_of_sign + surplus)  # printing the required number of equals signs
        return equals  # returning the required amount of equals signs
