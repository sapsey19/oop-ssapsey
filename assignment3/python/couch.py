from furniture import Furniture
from leg import Leg

class Couch(Furniture):
    DEFAULT_MATERIAL : str = 'leather'
    DEFAULT_NUM_CUSHIONS : int = 4
    def __init__(self, material : str = DEFAULT_MATERIAL, numCushions : int = DEFAULT_NUM_CUSHIONS):
        super(Couch, self).__init__(material)
        self._numCushions = numCushions
    
    @property
    def numCushions(self):
        return self._numCushions
