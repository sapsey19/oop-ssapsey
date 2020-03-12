#include "beanbag.h"

static const double DEFAULT_DIAMETER = 48.0;

BeanBag::BeanBag(std::string material, double diameter = DEFAULT_DIAMETER) : Furniture(material) {
    BeanBag::_material = material;
    BeanBag::_diameter = diameter;
}

double BeanBag::getDiameter() const { return _diameter; }