import unittest
from furniture import Furniture
from beanbag import BeanBag

from typing import cast

class BeanBagTest(unittest.TestCase):
    def testDefaults(self):
        bb = BeanBag()
        self.assertEqual(bb._diameter, BeanBag.DEFAULT_DIAMETER)
        self.assertEqual(bb.material, 'foam')
    
    def testFurnitureSit(self):
        furniture : Furniture = BeanBag()
        bb : BeanBag = cast(BeanBag, furniture)
        self.assertEqual(furniture.sit, False)
        bb.sit()
        self.assertEqual(furniture.sit, True)
        bb.stand()
        self.assertEqual(furniture.sit, False)

if __name__ == '__main__':
    unittest.main()