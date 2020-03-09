from furniture import Furniture

class BeanBag(Furniture): 
    DEFAULT_DIAMETER : float = 48.0 #inches
    def __init__(self, diameter : float = DEFAULT_DIAMETER):
        super(BeanBag, self).__init__(material = 'foam')
        self._diameter = diameter
        
    @property
    def size(self):
        return self._diameter