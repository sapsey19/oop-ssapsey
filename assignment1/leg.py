class Leg:
    DEFAULT_LENGTH : float = 20.0 # inches

    def __init__(self, length : float = DEFAULT_LENGTH):
        self.length = length
    
    def getLength(self) -> float:
        return self.length
