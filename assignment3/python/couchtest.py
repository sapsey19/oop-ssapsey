import unittest
from furniture import Furniture
from couch import Couch

class CouchTest(unittest.TestCase):
    def testConstructor(self):
        couch = Couch(material = 'leather', numCushions = 4)
        self.assertEqual(couch.material, 'leather')
        self.assertEqual(couch.numCushions, 4)
    
    def testSit(self):
        couch = Couch(material = 'cloth', numCushions = 2)
        self.assertEqual(couch.sit, False)
        couch.sit()
        self.assertEqual(couch.sit, True)
        couch.stand()
        self.assertEqual(couch.sit, False)