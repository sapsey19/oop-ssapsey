from chair import Chair

chair = Chair(4, 20.0, 'oak')

print('Chair is broken:', chair.isBroken())
print('Chair is made of: ', chair.getWood())

chair.sit(500)

print('Chair is broken: ', chair.isBroken())

stool = Chair(numLegs=3, length=15, wood='Birch')

stool.sit(301)
print('Stool is broken: ', stool.isBroken())
