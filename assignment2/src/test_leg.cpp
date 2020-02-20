#include "leg.h"
#include "gtest/gtest.h"

using namespace std;

TEST(Leg, Defaults) {
    Leg leg = Leg(20);
    ASSERT_EQ(leg.getLength(), Leg::DEFAULT_LENGTH);
    ASSERT_EQ(75.0, Leg::MAX_WEIGHT);
    ASSERT_EQ(leg.isBroken(), false);
}

TEST(Leg, Specifics) {
    float testLength = 12.0;
    Leg leg = Leg(testLength);
    ASSERT_EQ(leg.getLength(), testLength);
    ASSERT_EQ(leg.isBroken(), false);
    leg.setBroken(true);
    ASSERT_EQ(leg.isBroken(), true);
}

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}