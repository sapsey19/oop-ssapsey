#include <iostream>
#include "chair.h"

using namespace std;

int main() {
    Chair chair = Chair(4, "Wood", 10);
    cout << chair.getLength() << " " << chair.getMaterial() << " " << chair.getNumLegs() << endl;
    return 0;
}