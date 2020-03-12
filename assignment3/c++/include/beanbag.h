#pragma once
#include "furniture.h"

class BeanBag : public Furniture {
private:
    std::string _material;
    double _diameter;
public:
    BeanBag(std::string material, double diameter);

    double getDiameter() const;
};