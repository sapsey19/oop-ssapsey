#include "couch.h"

Couch::Couch(std::string material, int numCushions) : Furniture(material) {
    _numCushions = numCushions;
}

int Couch::getNumCushions() const { return _numCushions; }