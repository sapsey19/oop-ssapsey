#pragma once

class Leg { 
private:
    float _length;
    bool _broken;
public:
    static const float DEFAULT_LENGTH;
    static const float MAX_WEIGHT;
    
    Leg(float _length = DEFAULT_LENGTH);

    float getLength() const; //{ return _length; }
    bool isBroken() const; //{ return _broken; }
    void setBroken(bool broken); //{ _broken = broken; }
};