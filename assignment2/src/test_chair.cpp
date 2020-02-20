#include "chair.h"
#include "gtest/gtest.h"

using namespace std;

TEST(Chair, Specifics) {
    int numLegs = 4;
    string materialType = "Plastic";
    float length = 17.0;
    Chair chair = Chair(numLegs, materialType, length);
    ASSERT_EQ(chair.getNumLegs(), numLegs);
    ASSERT_EQ(chair.getMaterial(), materialType);
    ASSERT_EQ(chair.getLength(), length);
}

TEST(Chair, Breaking) {
    int numLegs = 3;
    string materialType = "Wood";
    float length = 22.5;
    Chair stool = Chair(numLegs, materialType, length);
    ASSERT_EQ(stool.isBroken(), false);
    stool.sit(225);
    ASSERT_EQ(stool.isBroken(), false);
    stool.sit(226);
    ASSERT_EQ(stool.isBroken(), true);
}

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}