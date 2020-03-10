import unittest
from chair import Chair
from leg import Leg

class ChairTest(unittest.TestCase):
    def testDefaults(self):
        chair = Chair()
        leg = Leg()
        self.assertEqual(chair.numLegs, chair.DEFAULT_NUM_LEGS)
        self.assertEqual(chair.material, chair.DEFAULT_MATERIAL)
        self.assertEqual(chair.length, leg.DEFAULT_LENGTH)

    def testSpecifics(self):
        numLegs : int = 4
        materialType : str = 'Metal'
        length : float = 17.0
        chair = Chair(numLegs, materialType, length)
        self.assertEqual(chair.numLegs, numLegs)
        self.assertEqual(chair.material, materialType)
        self.assertEqual(chair.length, length)

    def testBreaking(self):
        stool = Chair(numLegs=3, material='Wood', length=20)
        self.assertEqual(stool.broken, False)
        
        stool.sit(225)
        self.assertEqual(stool.broken, False)
        stool.sit(226)
        self.assertEqual(stool.broken, True)

if __name__ == '__main__':
    unittest.main()