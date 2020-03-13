#include "couch.h" 
#include "gtest/gtest.h"

using namespace std;

TEST(Couch, Constructor) {
    Couch couch = Couch("leather", 4);
    ASSERT_EQ(couch.getMaterial(), "leather");
    ASSERT_EQ(couch.getNumCushions(), 4);
}

TEST(Couch, Sit) {
    Couch couch = Couch("Cloth", 2);
    ASSERT_EQ(couch.alreadySitting(), false);
    couch.sitDown();
    ASSERT_EQ(couch.alreadySitting(), true);
    couch.standUp();
    ASSERT_EQ(couch.alreadySitting(), false);
}

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}