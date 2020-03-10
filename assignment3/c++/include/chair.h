#pragma once
#include <string>
#include <vector>
#include "leg.h"
#include "furniture.h"

class Chair : public Furniture {
private:
    int _numLegs;
    std::string _material;
    std::vector<Leg> legs;
public: 
    Chair(int numLegs, std::string material, float length); 
    int getNumLegs() const; 
    float getLength() const; 
    std::string getMaterial() const;
    bool isBroken() const;
    void sit(float value);
};