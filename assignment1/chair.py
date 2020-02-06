from typing import Sequence
from leg import Leg

class Chair:
    def __init__(self, numLegs : int, material : str, length : float = Leg.DEFAULT_LENGTH):
        self.legs : Sequence[Leg] = []
        for _ in range (0, numLegs):
            self.legs.append(Leg(length))
        
        self.numLegs = numLegs
        self.material : str = material
        
    def getMaterial(self):
        return self.material
    
    def getLength(self):
        return self.legs[0].getLength()
    
    def getNumLegs(self): 
        return self.numLegs
        
    def isBroken(self):
        return self.legs[0].isBroken()

    def sit(self, value : float):
        if self.legs[0].isBroken():
            raise ValueError("Chair is broken! Cannot sit.")
        if value > Leg.MAX_WEIGHT*self.numLegs:
            self.legs[0].setBroken(True)