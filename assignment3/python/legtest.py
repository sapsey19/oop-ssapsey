import unittest
from leg import Leg

class LegTest(unittest.TestCase):
    
    def testDefaults(self):
        leg = Leg()
        self.assertEqual(leg.length, leg.DEFAULT_LENGTH)
        self.assertEqual(75, leg.MAX_WEIGHT)
        self.assertEqual(leg.broken, False)
    
    def testSpecifics(self):
        testLength : float = 12.0
        leg = Leg(length = testLength)
        self.assertEqual(leg.length, testLength)
        self.assertEqual(leg.broken, False)
        leg.broken = True
        self.assertEqual(leg.broken, True)

if __name__ == '__main__':
    unittest.main()