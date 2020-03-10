#pragma once

#include <string>
#include <vector>

class Furniture {
private:
    std::string _material;
    bool _sit;
public:
    Furniture(std::string material);

    std::string getMaterial();
    bool sit();

    void sitDown();
    void standUp();

};