#include <vector>
#include "furniture.h"
#include "beanbag.h"
#include "couch.h"
#include "gtest/gtest.h"

using namespace std;

TEST(Furniture, MixedSitting) {
    vector<Furniture> comfy;
    BeanBag bb = BeanBag("leather", 40.0);
    Couch couch = Couch("faux leather", 3);

    for(auto obj : comfy) 
        obj.sitDown();
    for(int i = 0; i < comfy.size(); ++i)
        ASSERT_EQ(comfy[i].alreadySitting(), true);
    for(auto obj : comfy)
        obj.standUp();
    for(int i = 0; i < comfy.size(); ++i)
        ASSERT_EQ(comfy[i].alreadySitting(), false);
}

int main(int argc, char** argv) {
    ::testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}