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
    Chair() {}
    Chair(int numLegs, std::string material, float length) {
        _numLegs = numLegs;
        _material = material;
        _length = length;

        for(int i = 0; i < numLegs; i++)
            legs.push_back(Leg(length, false));
    }

    int getNumLegs() {
        return _numLegs;
    }

    float getLength() {
        return legs[0].getLength();
    }

    std::string getMaterial() {
        return _material;
    }

    bool getBroken() { return legs[0].getLength(); }

    void sit(float value) {
        if (legs[0].getBroken())
            std::cout << "Cannot sit, chair leg is broken." << std::endl;
        else if(value > legs[0].MAX_WEIGHT*_numLegs)
            legs[0].setBroken(true);
        
    }

};