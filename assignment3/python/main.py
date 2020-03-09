from chair import Chair

chair = Chair(numLegs=4, material="Oak", length=15)

print('Chair is broken:', chair.broken)
print('Chair is made of:', chair.material)

chair.sit(500)

print('Chair is broken:', chair.broken)

stool = Chair(numLegs=3, material="Plastic", length=23)

stool.sit(250)
print('Stool is broken:', stool.broken)
print('Stool is made of:', stool.material)