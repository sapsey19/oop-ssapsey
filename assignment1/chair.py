from typing import Sequence
from leg import Leg

class Chair:
    def __init__(self, wood : str, length : float = Leg.DEFAULT_LENGTH):
        self.legs : Sequence[Leg] = (Leg(length), Leg(length))
        self.wood : str = wood
        