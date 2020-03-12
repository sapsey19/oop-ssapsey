#include "beanbag.h" //
#include "gtest/gtest.h"

using namespace std;

TEST(BeanBag, Specifics) {
    BeanBag bb = BeanBag("cloth", 50.0);
    ASSERT_EQ(bb.getDiameter(), 50.0);
    ASSERT_EQ(bb.getMaterial(), "cloth");
}

// TEST(Chair, Breaking) {
//     int numLegs = 3;
//     string materialType = "Wood";
//     float length = 22.5;
//     Chair stool = Chair(numLegs, materialType, length);
//     ASSERT_EQ(stool.isBroken(), false);
//     stool.sit(225);
//     ASSERT_EQ(stool.isBroken(), false);
//     stool.sit(226);
//     ASSERT_EQ(stool.isBroken(), true);
// }

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}