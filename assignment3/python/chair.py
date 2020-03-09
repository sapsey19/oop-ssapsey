#from typing import Sequence
from leg import Leg
from furniture import Furniture

class Chair(Furniture):
    def __init__(self, numLegs : int, material : str, length : float = Leg.DEFAULT_LENGTH):
        super(Chair, self).__init__(material)
        if numLegs < 3:
            raise ValueError('Cannot create a chair with less than 3 legs.')
        self._numLegs : int = numLegs
        self._legs : List[Leg] = []
        for _ in range (0, numLegs):
            self._legs.append(Leg(length))
    
    @property
    def numLegs(self) -> int: 
        return self._numLegs
    
    @property
    def length(self) -> float:
        return self._legs[0].length

    @property    
    def broken(self):
        return self._legs[0].broken

    #override
    def sit(self, value : float):
        if self._legs[0].broken:
            raise ValueError("Chair is broken! Cannot sit.")
        if value > Leg.MAX_WEIGHT*self._numLegs:
            self._legs[0].broken = True