from typing import Sequence
from leg import Leg

class Chair:
    def __init__(self, numLegs : int, material : str, length : float = Leg.DEFAULT_LENGTH):
        self._legs : Sequence[Leg] = []
        if numLegs < 3:
            raise ValueError('Cannot create a chair with less than 3 legs.')
        for _ in range (0, numLegs):
            self._legs.append(Leg(length))
        
        self._numLegs = numLegs
        self._material : str = material

    @property    
    def material(self) -> str:
        return self._material

    @property
    def length(self) -> float:
        return self._legs[0].length

    @property
    def numLegs(self) -> int: 
        return self._numLegs

    @property    
    def broken(self):
        return self._legs[0].broken

    def sit(self, value : float):
        if self._legs[0].broken:
            raise ValueError("Chair is broken! Cannot sit.")
        if value > Leg.MAX_WEIGHT*self._numLegs:
            self._legs[0].broken = True