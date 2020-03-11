#include <stdexcept>
#include "furniture.h"

Furniture::Furniture(std::string material) {
    _material = material;
    _sit = false;
}

std::string Furniture::getMaterial() const { return _material; }
bool Furniture::alreadySitting() const { return _sit; }

void Furniture::sitDown() {
    if(_sit)
        throw std::invalid_argument("Cannot sit! Already sitting.");
    _sit = true;
}

void Furniture::standUp() {
    _sit = false;
}