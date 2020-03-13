#pragma once
#include <vector>
#include "leg.h"
#include "furniture.h"

class Chair : public Furniture {
private:
    int _numLegs;
    std::vector<Leg> legs;
public: 
    Chair(int numLegs, std::string material, float length); 
    int getNumLegs() const; 
    float getLength() const; 
    bool isBroken() const;
    void sit(float value);
};