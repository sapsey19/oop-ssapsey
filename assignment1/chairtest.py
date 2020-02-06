import unittest
from chair import Chair

class ChairTest(unittest.TestCase):
    
    def testSpecifics(self):
        numLegs : int = 4
        materialType : str = 'Metal'
        length : float = 17.0
        chair = Chair(numLegs, materialType, length)
        self.assertEqual(chair.getNumLegs(), numLegs)
        self.assertEqual(chair.getMaterial(), materialType)
        self.assertEqual(chair.getLength(), length)
    
    def testBreaking(self):
        stool = Chair(numLegs=3, material='Wood', length=20)
        self.assertEqual(stool.isBroken(), False)
        stool.sit(225)
        self.assertEqual(stool.isBroken(), False)
        stool.sit(226)
        self.assertEqual(stool.isBroken(), True)

    


if __name__ == '__main__':
    unittest.main()