'''

Estimate_Calculator utility created for Caruso Bros. Inc by Andrew Caruso MODIFIED: 7/28/16
At the request of owners Mike and Dom, Caruso Bros. wanted a simple utility where they can broadly estimate
material and labor costs for asphalt driveway jobs for their business. Much of their estimate comes from
how difficult a job will be (how deep the driveway is, if there are corners, and many other factors), with
this, to accurately simulate how Mike and Dom estimate a lot of the variability in price ranges in the price per square
foot of material. An easier job will have a lower price, but a more difficult job will increase the price. The general
price per square foot of material is 3.5-6.0 dollars according to Dom, but the utility will take in any
integer for calculations. Also, according to Dom and Mike they mainly wanted a broad estimate to give to customers
which is why on the programming side simple ints in this program will suffice. A lot of the final price is calculated
once the job is done, with any unseen issues resolved into the final price. If there was a call for more precision,
the decimal module would likely be used.

'''

# two global numbers used for final estimation calculation
laborFinal = 0
materialFinal = 0

def material_Estimate():

    # getting dimensions of the job site
    # variability in dimensions will be reflected in pricePerSquareFoot per owner's request
    print("What is the length of the area?")
    length = int(input())

    print("What is the width of the area?")
    width = int(input())

    area = (length * width)

    # getting price per square foot of job (will fluctuate based on difficulty of job
    print("What is the price per square foot? [3.50 - 6.00 dollars]")
    pricePerSquareFoot = int(input())

    materialEstimate = area * pricePerSquareFoot

    print("Your material estimate is %d" % materialEstimate)

    # for material and labor estimate
    global materialFinal
    materialFinal = materialEstimate

    return

def labor_Estimate():

    # getting workers per day, hours per day worked, and total days
    print("How many workers will you have per day?")
    workers = int(input())

    print("How many hours per day do you expect them to work")
    hoursWorked = int(input())

    print("What is the labor rate per day? [dollars per hour]")
    laborRate = int(input())

    laborEstimate = workers * hoursWorked * laborRate

    print("The estimate for these parameters is %d" % laborEstimate)

    # global variable used with material estimate for total estimate
    global laborFinal
    laborFinal = laborEstimate

    return

def total_Estimate():

    totalEstimate = materialFinal + laborFinal

    print("The total estimate is %d dollars" % totalEstimate)

    return


def main():

    # main method used for calculations

    material_Estimate()


    print("Would you like to estimate labor? [y/n]")
    continueForLabor = input()

    if continueForLabor is "y":

        labor_Estimate()

    '''
    Asked to continue after labor estimate because owner Dom says labor costs may sometimes be
    included in the price per square foot. Owners may disregard a separate labor estimate in favor of
    simply increasing price per square foot. The option to continue with a separate estimate is still here
    as needed.
    '''

    print("Would you like to see your total estimate in dollars [y/n]")
    continueForTotal = input()

    if continueForTotal is "y":

        total_Estimate()

    return

# calling main function to run entire estimate utility

main()
