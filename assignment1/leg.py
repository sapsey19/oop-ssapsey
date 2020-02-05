class Leg:
    DEFAULT_LENGTH : float = 20.0 # inches
    MAX_WEIGHT : float = 300 # pounds
    MAX_HEIGHT : float = 50 # inches

    def __init__(self, length : float = DEFAULT_LENGTH):
        self.length = length
        self.broken : bool = False
    
    @property
    def length(self) -> float:
        return self.length

    @length.setter
    def length(self, value : float) -> None:
        if value <= 0:
            raise ValueError("Leg length must be greater than 0")
        self.length = value
    
    @property
    def broken(self) -> bool:
        return self.broken

    def sit(self, weight):
        if weight > self.MAX_WEIGHT:
            self.broken = True
    
