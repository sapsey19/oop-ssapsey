#pragma once

class Leg { 
private:
    float _length;
    bool _broken;
public:
    const float DEFAULT_LENGTH = 20.0;
    const float MAX_WEIGHT = 75.0;
    
    Leg(float length, bool broken) { 
        _length = length;
        _broken = broken;
    }

    float getLength() { return _length; }
    bool getBroken() { return _broken; }
    void setBroken(bool broken) { _broken = broken; }
};