#include "beanbag.h" 
#include "gtest/gtest.h"

using namespace std;

TEST(BeanBag, Specifics) {
    BeanBag bb = BeanBag("cloth", 50.0);
    ASSERT_EQ(bb.getDiameter(), 50.0);
    ASSERT_EQ(bb.getMaterial(), "cloth");
}

TEST(BeanBag, Sit) {
    BeanBag bb = BeanBag("leather", 40.5);
    ASSERT_EQ(bb.alreadySitting(), false);
    bb.sitDown();
    ASSERT_EQ(bb.alreadySitting(), true);
    bb.standUp();
    ASSERT_EQ(bb.alreadySitting(), false);
}

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}