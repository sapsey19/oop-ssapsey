import unittest

from furniture import Furniture
from chair import Chair
from beanbag import BeanBag
from couch import Couch

from typing import List, cast

class FurnitureTest(unittest.TestCase):
    
    def testChair(self):
        chair = Chair()
        self.assertEqual(chair.numLegs, 4)
        self.assertEqual(chair.broken, False)
        self.assertEqual(chair.material, 'wood')
        self.assertEqual(chair.length, 20.0)
        chair.sit(400)
        self.assertEqual(chair.broken, True)

    def testMixed(self):
        comfy : List[Furniture] = []
        bb = BeanBag()
        couch = Couch()
        comfy.append(bb)
        comfy.append(couch)
        
        for obj in comfy:
            obj.sitDown()
        for i in range(len(comfy)):
            self.assertEqual(comfy[i].sit, True)
        for obj in comfy:
            obj.standUp()
        for i in range(len(comfy)):
            self.assertEqual(comfy[i].sit, False)

if __name__ == '__main__':
    unittest.main()