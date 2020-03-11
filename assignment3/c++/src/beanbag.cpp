#include "beanbag.h"

BeanBag::BeanBag(std::string material, double diameter) : Furniture(material) {
    BeanBag::_material = material;
    BeanBag::_diameter = diameter;
}

double BeanBag::getDiameter() const { return _diameter; }