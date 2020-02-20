#include <stdexcept>
#include "leg.h"

Leg::Leg(float length) {
    Leg::_length = length;
    Leg::_broken = false;
    if(length < 0)
        throw std::invalid_argument("Length must be > 0");
}

float Leg::getLength() const { return _length; }
bool Leg::isBroken() const { return _broken; } 

void Leg::setBroken(bool broken) {
    Leg::_broken = broken;
}
