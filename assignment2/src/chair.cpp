#include <stdexcept>
#include "chair.h"

Chair::Chair(int numLegs, std::string material, float length) {
    Chair::_numLegs = numLegs;
    Chair::_material = material;
    for(int i = 0; i < numLegs; i++)
        legs.push_back(Leg(length));
}

int Chair::getNumLegs() const { return _numLegs; }
float Chair::getLength() const { return Chair::legs[0].getLength(); } //come back tot his
std::string Chair::getMaterial() const { return _material; }
bool Chair::isBroken() const { return legs[0].isBroken(); }

void Chair::sit(float weight) {
    if (legs[0].isBroken())
        throw std::invalid_argument("Cannot sit, chair leg is broken.");
    if(weight > legs[0].MAX_WEIGHT*_numLegs)
        legs[0].setBroken(true);
}
