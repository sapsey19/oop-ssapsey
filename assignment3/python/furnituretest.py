import unittest

from chair import Chair
from beanbag import BeanBag
from couch import Couch

from typing import List, cast

class FurnitureTest(unittest.TestCase):
    def testChair(self):
        chair = Chair(numLegs = 4, material = 'wood', length = 20.0)
        self.assertEqual(chair.numLegs, 4)
        self.assertEqual(chair.broken, False)
        self.assertEqual(chair.material, 'wood')
        self.assertEqual(chair.length, 20.0)
        chair.sit(400)
        self.assertEqual(chair.broken, True)

    def testMixed(self):
        comfy : List[Furniture] = []
        bb = BeanBag()
        couch = Couch(material = 'leather', numCushions = 4)
        comfy.append(bb)
        comfy.append(couch)
        
        self.assertEqual(bb.size, bb.DEFAULT_DIAMETER)
        self.assertEqual(couch.numCushions, 4)

if __name__ == '__main__':
    unittest.main()