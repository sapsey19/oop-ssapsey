#pragma once
#include "furniture.h"

class BeanBag : public Furniture {
private:
    std::string _material;
    double _diameter;
public:
    static const double DEFAULT_DIAMETER = 48.0; 

    BeanBag(std::string material, double diameter = DEFAULT_DIAMETER);

    double getDiameter() const;
};