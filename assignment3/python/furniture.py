class Furniture:
    def __init__(self, material : str):
        self._material : str = material
        self._sit = False
    
    @property
    def material(self) -> str:
        return self._material

    @property
    def sit(self) -> bool:
        return self._sit
    
    def sit(self) -> None:
        if self._sit == True:
            raise ValueError("Cannot sit! Already sitting.")
        self._sit = True
        
    def stand(self) -> None:
        self._sit = False
