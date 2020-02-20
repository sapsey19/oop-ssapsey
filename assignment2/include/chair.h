#pragma once
#include <string>
#include <vector>
#include "leg.h"

class Chair {
private:
    int _numLegs;
    std::string _material;
    float _length;
    std::vector<Leg> legs;
public: 
    Chair(int numLegs, std::string material, float length); 
    int getNumLegs() const; 
    float getLength() const; 
    std::string getMaterial() const;
    bool isBroken() const;
    void sit(float value);
};