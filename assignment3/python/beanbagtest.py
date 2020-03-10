import unittest
from furniture import Furniture
from beanbag import BeanBag

from typing import cast

class BeanBagTest(unittest.TestCase):
    
    def testDefaults(self):
        bb = BeanBag()
        self.assertEqual(bb.material, bb.DEFAULT_MATERIAL)
        self.assertEqual(bb.size, bb.DEFAULT_DIAMETER)
        
    def testFurnitureSit(self):
        furniture : Furniture = BeanBag()
        bb : BeanBag = cast(BeanBag, furniture)
        self.assertEqual(furniture.sit, False)
        bb.sitDown()
        self.assertEqual(furniture.sit, True)
        bb.standUp()
        self.assertEqual(furniture.sit, False)

if __name__ == '__main__':
    unittest.main()