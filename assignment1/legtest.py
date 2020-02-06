import unittest
from leg import Leg

class LegTest(unittest.TestCase):
    
    def testDefaults(self):
        leg = Leg()
        self.assertEqual(leg.getLength(), leg.DEFAULT_LENGTH)
        self.assertEqual(75, leg.MAX_WEIGHT)
        self.assertEqual(leg.isBroken(), False)
    
    def testSpecifics(self):
        testLength : float = 12.0
        leg = Leg(length = testLength)
        self.assertEqual(leg.getLength(), testLength)
        self.assertEqual(leg.isBroken(), False)
        leg.setBroken(True)
        self.assertEqual(leg.isBroken(), True)

if __name__ == '__main__':
    unittest.main()