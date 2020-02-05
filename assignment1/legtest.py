import unittest
from leg import Leg

class LegTest(unittest.TestCase):
    
    def defaultTest(self):
        leg = Leg()
        self.assertEqual(leg.length(), leg.DEFAULT_LENGTH)
        self.assertEqual(leg.MAX_HEIGHT, 20)
        self.assertEqual(leg.MAX_WEIGHT, 300)
    

    

if __name__ == '__main__':
    unittest.main()