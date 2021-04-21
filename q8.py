topVar = 5


def level1():
    oneVar = 6

    print(topVar + oneVar)

    def level2():

        twoVar = 9
        print(topVar+oneVar+twoVar)

        def level3():
            threeVar = 1
            print(topVar+oneVar+twoVar+threeVar)

        level3()
    level2()


level1()
