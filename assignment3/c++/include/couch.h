#include "furniture.h"

class Couch : public Furniture {
private:
    std::string _material;
    int _numCushions;
public:
    Couch(std::string material, int numCushions);

    int getNumCushions() const;
};