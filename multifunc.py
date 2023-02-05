# Ajouter des programmes avec des valeur custom
# import matplotlib.pyplot as plt


while True:
    print("[Choisissez une opération. \n")
    print("1. km/h -> m/s \n")

    #prendre la valeur
    choice = input("Saisissez votre choix (1): \n")

    if choice in ('1'):
        num1 = float(input("Entrer la valeur en Km/h : "))

        if choice == "1":
            print(num1, "/ 3.6 =", num1 / 3.6, "m/s")

        # check if user wants another calculation
        # break the while loop if answer is no
        next_calculation = input("\n Faire un autre calcul ? (y/n): ")
        if next_calculation == "n":
          break

    else:
        print("Invalid Input")