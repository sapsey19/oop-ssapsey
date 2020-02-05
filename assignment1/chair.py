from typing import Sequence
from leg import Leg

class Chair:
    MAX_WEIGHT : float = 100 #pounds per leg
    

    def __init__(self, wood : str, numLegs : int, length : float = Leg.DEFAULT_LENGTH):
        self.legs : Sequence[Leg] = (Leg(length), Leg(length), Leg(length), Leg(length))
        self.wood : str = wood
        self.broken = False
        self.numLegs = numLegs
    
    def getWood(self):
        return self.wood
    
    def getLength(self):
        return self.legs[0].getLength()
    
    def getNumLegs(self): 
        return self.numLegs
        
    def isBroken(self):
        return self.broken

    def sit(self, value : float):
        if value > self.MAX_WEIGHT*self.numLegs:
            self.broken = True