from chair import Chair

chair = Chair(numLegs=4, material="Oak", length=15)

print('Chair is broken:', chair.isBroken())
print('Chair is made of: ', chair.getMaterial())

chair.sit(500)

print('Chair is broken: ', chair.isBroken())

stool = Chair(numLegs=3, material="Birch", length=23)

stool.sit(301)
print('Stool is broken: ', stool.isBroken())
