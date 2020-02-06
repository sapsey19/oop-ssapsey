class Leg:
    DEFAULT_LENGTH : float = 20.0 # inches
    MAX_WEIGHT : float = 75 # pounds per leg

    def __init__(self, length : float = DEFAULT_LENGTH):
        self.length = length
        self.broken = False
    
    def getLength(self) -> float:
        return self.length

    def isBroken(self) -> bool:
        return self.broken
    
    def setBroken(self, value : bool) -> None:
        self.broken = value
