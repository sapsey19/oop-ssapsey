class Leg:
    DEFAULT_LENGTH : float = 20.0 # inches
    MAX_WEIGHT : float = 75 # pounds per leg

    def __init__(self, length : float = DEFAULT_LENGTH):
        self._length = length
        self._broken = False
    
    @property 
    def length(self) -> float:
        return self._length

    @property
    def broken(self) -> bool:
        return self._broken
    
    @broken.setter
    def broken(self, value : bool) -> None:
        self._broken = value
