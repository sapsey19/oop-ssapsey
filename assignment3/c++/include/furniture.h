#pragma once

#include <string>
#include <vector>

class Furniture {
private:
    std::string _material;
    bool _sit;
public:
    Furniture(std::string material);

    std::string getMaterial() const;
    bool alreadySitting() const;

    void sitDown();
    void standUp();

};