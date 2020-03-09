from furniture import Furniture
from leg import Leg

class Couch(Furniture):
    def __init__(self, material : str, numCushions : int):
        super(Couch, self).__init__(material)
        self._numCushions = numCushions
    
    @property
    def numCushions(self):
        return self._numCushions
