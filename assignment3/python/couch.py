from furniture import Furniture

class Couch(Furniture):
    DEFAULT_MATERIAL : str = 'leather'
    DEFAULT_NUM_CUSHIONS : int = 4
    def __init__(self, material : str = DEFAULT_MATERIAL, numCushions : int = DEFAULT_NUM_CUSHIONS):
        super(Couch, self).__init__(material)
        self._numCushions = numCushions
    
    @property
    def numCushions(self) -> int:
        return self._numCushions
