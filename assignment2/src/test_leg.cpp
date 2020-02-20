#include "leg.h"
#include "gtest/gtest.h"

using namespace std;

TEST(Leg, Defualts) {
    Leg leg = Leg(20);
    ASSERT_EQ(leg.getLength(), Leg::DEFAULT_LENGTH);
    ASSERT_EQ(75.0, Leg::MAX_WEIGHT);
}