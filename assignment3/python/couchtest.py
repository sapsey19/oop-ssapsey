import unittest
from furniture import Furniture
from couch import Couch

class CouchTest(unittest.TestCase):
    def testDefaults(self):
        couch = Couch()
        self.assertEqual(couch.material, couch.DEFAULT_MATERIAL)
        self.assertEqual(couch.numCushions, couch.DEFAULT_NUM_CUSHIONS)

    def testGettersAndSetters(self):
        couch = Couch(material='Faux leather', numCushions=6)
        self.assertEqual(couch.material, 'Faux leather')
        self.assertEqual(couch.numCushions, 6)

    def testSit(self):
        couch = Couch(material = 'cloth', numCushions = 2)
        self.assertEqual(couch.sit, False)
        couch.sitDown()
        self.assertEqual(couch.sit, True)
        couch.standUp()
        self.assertEqual(couch.sit, False)

if __name__ == '__main__':
    unittest.main()