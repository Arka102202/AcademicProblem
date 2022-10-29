import java.util.Arrays;

public class SlidingWindowMaximum {
    static int idx = 0;
    public static int[] maxSlidingWindow0(int[] nums, int k) {
        idx = -1;
        int[] r = new int[nums.length-k+1];
        int i = 0, l = 0, max = Integer.MIN_VALUE;

        for(int p = 0; p<nums.length; p++){
            int num = nums[p];
            if (num > max) {
                max = num;
                idx = p;
            }
            i++;
            if(i == k){
                r[l] = max;
                int n = nums[l++];
                if(max == n) {
                    max = Integer.MIN_VALUE;
                    int temp = idx+1;
                    for (; temp <=p; temp++) {
                        if (nums[temp] > max) {
                            max = nums[temp];
                            idx = temp;
                        }
                    }
                }
                i--;
            }
        }

        return r;
    }

    public static int[] maxSlidingWindow(int[] nums, int k){

        AVLBstWithDuplicates<Integer> tree = new AVLBstWithDuplicates<>();
        int[] r = new int[nums.length-k+1];
        int l =0;

        for(int num:nums){
            tree.add(num);
            if(tree.size == k){
                r[l] = tree.getMAx();
                tree.remove(nums[l++]);
            }
        }

        return r;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{3,3,3,3,3,3,3,3,3}, 3)));

        System.out.println(Arrays.toString(maxSlidingWindow0(new int[]{1577, 6060, 798, 4891, -8433, -2566, -3468, 3674, 727, -5527, -9284, 8259, 6726, -4393, -3427, -4485, 9101, -9267, 9791, -407, 5641, -8368, -6034, -6536, 6159, -1976, 7054, 9923, -8678, 9384, -1440, 7542, 3165, -9427, -5212, 1, 5345, 4037, 7905, -4802, 9359, 2107, 2978, 966, -7690, -7818, 4448, -6806, -1726, 7811, -9819, -1276, -2809, 7822, -4490, 6499, 9186, -6724, -5485, 2775, -2293, 5472, -3017, -5753, -9772, -9090, -667, -358, -2819, -1516, -7939, -6285, 4646, 8942, 3689, 9534, 8065, -3807, -4369, -6984, 7130, -2525, -6208, 1077, -2882, -2468, -7587, -9251, 7635, 1091, -3317, -9413, -6055, 8859, -9407, 2752, 5010, 315, -2013, 931, 800, -8270, -1621, 8162, 8134, -2478, 7383, -3328, -6887, -4306, 877, -6417, 535, -6703, 2666, 5452, 1294, -96, 1537, -2517, 7725, 2410, 8978, -7711, 4613, 7374, -1953, -8084, 9499, -83, 6550, 5762, 2451, -2670, 7682, -5660, 6915, -2800, -9506, 1240, 2260, 2927, 9319, -6856, -7230, -6473, 6053, -5454, 3650, -6511, 4447, 9872, -9435, 3711, 1306, 4030, -9344, -9822, -671, 9878, -5920, 5256, 6492, -6461, -157, -3644, -5437, 5207, -7897, 777, 3067, 7, -616, 4372, -4745, -401, 5447, 9181, -1367, -4778, -2284, 9981, 2348, 6470, -9556, 1304, 9809, -345, 8061, 7835, 6345, 7693, -4775, -4806, 305, -256, -1494, 8583, 4454, -8972, 8096, 463, 1822, 6693, -1615, 6522, 2015, 1367, 3169, -3579, -1307, -9657, -4177, -1453, 9750, 270, -6144, 3333, 8036, 4661, 3522, -6196, 1718, -5214, 2980, 6508, -5773, -5778, 4245, -7866, 8898, 2512, 1410, 6903, -619, 1275, -9303, 9844, -2106, -5328, 1538, -1616, -1024, -3160, 2635, 7205, 7088, 681, -7167, -3312, 8839, -1677, 463, -1317, -7458, 227, 5269, 3301, -9642, -2444, 3683, 3293, 1996, 7322, -1131, 8560, -3339, -1272, 6255, 7908, -9289, 8596, 9697, -6235, -5060, 2280, -6387, 7442, 2146, 679, -8274, -8977, -5739, 9703, -3879, -9932, -7639, 7239, -2559, -9968, -6752, -1998, -7589, 2678, -6589, -5572, -8019, 6263, 7661, -5273, -221, -7521, -4972, -3915, 2189, 4364, -603, 6714, -9149, 7213, -9899, 6067, -9223, -514, -3906, 7163, -9329, -8396, 7015, -1175, -9899, -5850, -8492, -9674, -4708, 452, 3967, -5981, -4451, 3578, -1582, 2489, 5557, -8790, -522, -1621, -4696, -6723, -4631, -4880, 6958, -2367, 4247, -8429, 6929, 8206, -3873, -9443, 3095, -997, -5521, 6524, 7429, -6778, 9256, -8940, -7287, -9131, -3073, 5151, 7731, 3058, -8079, 2707, 3362, -1087, 1095, 6633, 3179, 6438, 5214, -1373, 9218, -3031, -9690, 4221, -1835, -2170, 6833, 8819, 4083, -55, 4715, 7495, 3676, 4564, 4619, 8418, -6466, -8940, -2573, 3274, -4188, -1303, 999, -9249, 2813, 4598, -5275, -3811, -4419, -8181, 1637, -2276, 1085, -2469, 2763, -4877, -3771, 5721, 7703, 7127, 4110, -3201, 3424, 6831, -3160, 2019, -7006, 3541, 3042, 8446, 8913, -8786, -4931, -9583, 5188, 5416, 4864, 8235, 5807, 5236, 7888, 3272, 1813, -7359, -8419, -1546, 4568, -5429, -2314, -1832, 3310, -3123, -8029, 8703, -8654, 8548, -6332, -4429, -1457, -9564, -2506, 3463, -6818, 2951, 9022, 2079, 7975, -6116, 6102, 3039, -7499, -2714, -94, 5427, 1393, 7668, -1987, -4247, 9574, -1341, 4408, 4884, -6707, -2094, 6509, -1740, 2928, 8951, 4231, -9922, 6323, 2490, -201, 2590, 1407, 2017, 6674, 5751, 1122, 7363, 88, -7949, 2824, 5943, 9647, 2201, -6872, 1236, 3217, -9817, -1413, 515, 4563, -3037, 7670, 703, 1391, -6963, 7124, -6374, 1166, -2727, -9474, -878, 9364, 4922, 4440, -4516, 1265, -9742, 6708, 1815, 1310, 7873, -610, 2963, 60, 5286, -4475, 637, 66, 1933, -475, 5761, 7837, -5166, -1491, 7082, -449, 8856, -5833, 7779, 6148, -5138, 127, 2839, -2469, 8850, 3814, -4067, 9975, -8488, 2685, 2834, 3249, 3339, 2309, 5980, 684, 4168, -3224, 6685, -4291, -3636, 3270, -7650, 6943, -1469, -7210, 2743, 9376, -5568, -4591, 1970, 9172, 6710, 6208, 6540, 9388, 8197, 5116, 5042, 2410, 9127, -9463, -5554, -3274, 6956, 6988, 9439, 8555, -8025, -3383, -4829, -5809, -4466, -7646, 6337, 6753, -9792, -8642, -7084, 6795, -9321, 4341, -3336, -850, -9527, 7839, 8622, -6009, 7186, 880, -1128, 7717, 2011, 3658, -8597, -9127, 7174, -7707, 7537, -2415, -6682, -6996, -3155, -9445, -8328, 6777, 2653, 1461, -3520, -8684, -2589, 3104, -2444, -3137, 2716, -742, -8511, 7564, -8609, 3221, -7640, -3548, -6483, 2421, 771, 1948, -3579, 7057, -6342, -4135, -1472, -8031, -3480, 2669, 6039, -797, -2161, -1031, -2683, 8066, 7413, 6142, -2013, 4203, 8123, 4411, -4044, -5737, -8392, 6819, 2909, -9813, -2457, 8911, 1440, 37, 3868, 4677, -3094, 9724, 1359, 3764, -8057, 3160, -7466, -1095, -8617, 326, 6816, -8473, -2733, 6118, -3570, 2005, -5726, 7931, 1541, -2619, -3025, 7372, -7657, -1732, -6734, -14, 3390, -8349, 5229, 9725, -9492, 2071, 6250, -9478, 6218, -969, -4075, -6181, -2136, -9545, 6267, -215, 6301, 863, -5122, 6160, 16, -1974, -7713, 3871, -5995, 8576, -2377, 4565, 6271, 8865, -8391, 2080, -7419, 1925, -4815, -6637, -3066, -4000, -2656, -9934, -1913, 8065, -4384, -3197, -3047, 4795, -1706, 8822, 1593, 1183, 1952, 7703, 6853, 5277, -3847, -4932, -4966, -5171, -5874, -2186, 2044, 9085, -9990, -9115, -3863, 4178, -8420, -7093, 883, -3413, 2136, -1874, 2548, -3861, -8072, 5365, -6045, -2066, -7850, 5220, -7446, -9914, 1608, -9131, -8047, -518, 7189, -2383, 5491, 1740, 7493, -4706, -3809}
                , 434)));

        System.out.println(Arrays.toString(maxSlidingWindow0(new int[]{-6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7}, 7)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7157, 9172, 7262, -9146, 3087, 5117, 4046, 7726, -1071, 6011, 5444, -48, -1385, -7328, 3255, 1600, 586, -5160, -371, -5978, 9837, 3255, -6137, 8587, -3403, 9775, 260, 6016, 9797, 3371, 2395, 6851, 2349, -7019, 9318, 1211, -3110, 8735, -7507, 1784, 7400, -5799, 3169, -7696, -8991, -2222, -9434, -4490, 4034, -831, -9656, 5488, -4395, 9339, 4104, -9058, -4072, -1172, 1758, 6878, -5570, -6380, 9550, -9389, 1411, 2298, 3516, 551, 9196, 5215, -237, -4146, 1682, 4418, -4639, 7759, 9593, -9588, 3041, 9208, -7331, -797, -2529, 7738, -2944, 4351, 5091, -9448, -5404, 6200, -1425, -3983, 678, 8456, -8085, 5162, 7165, 4692, -494, -9249, 8514, 521, -8835, 6745, -5775, -575, 1876, -5464, 5053, 5567, 3456, 5873, 1965, 4316, 2126, 9462, -59, 6544, -1547, 7015, -8928, -3903, -3020, 5865, -9479, 6723, 9214, 5705, 5136, 7725, 945, -1995, -2288, 4579, 7103, 9938, 4495, -730, -3180, 7717, 6824, 794, -894, -1439, -1641, -4577, 9362, -8817, -6035, -7980, -1278, -1928, -5390, -2342, 1189, -2340, 4788, -1814, 5927, 3115, 9017, 6801, 7884, -5719, 5992, 7477, -486, -2734, -1557, 3169, 5288, -8295, -5651, 2491, -3394, 8302, -8822, 5638, 7654, 7350, 9884, -5392, 881, -4874, 5582, 8309, -8514, 2682, -6081, 5602, 4963, 3538, 9558, -6401, -2641, 6223, -7107, -2772, 5873, 78, -7934, -7641, 7872, 7901, 7436, -3815, -1540, -3387, 3558, -8030, -6637, 9609, 8594, 83, 7984, -3286, 7211, 5877, -8655, 6700, 9855, -7521, 903, 1024, 4051, 4044, 4044, 8650, -2932, -134, -8167, -5338, -1014, 391, 1913, -9914, -9100, 7108, -9250, 1705, 5615, 641, 6809, 6619, 7782, 9062, 3030, 603, -2528, -5493, -1237, 8428, 1231, 6701, 202, 641, -5351, -5366, -3347, 7659, -3953, 5518, 1575, -3514, 999, -6631, -934, -1119, 1749, -9533, -8528, -9425, -9138, -6498, -1546, -8501, 7668, -8135, -6234, 7236, 1722, -7690, 7339, -5205, 698, 3680, 7741, -9067, 8739, -7658, -2518, 3967, -128, 620, -4571, 780, 5989, -6220, -1932, 6629, -733, -6978, -68, -3295, 9075, -297, 7648, -7645, 2301, -4641, -8443, 6935, -6257, 7067, -9046, 5474, 6833, 6924, 8516, -213, -9210, -9605, -5798, 4710, -9258, -7736, 944, 5194, -7465, 5978, -6840, 3735, 4392, 9218, -5571, 2944, -5864, 2995, -5234, 5036, -4999, -9883, 5493, 4646, 9574, 3528, 291, -4799, -3099, 7639, 5144, -2560, -7573, 433, 2464, -3484, 4673, 3283, -6459, -1194, 8122, 7314, -3389, -1899, 8362, -1046, -1751, -2140, 7642, -6274, -8056, 3925, -397, 1641, 5762, 8099, -9683, 2533, 1333, 3295, 7413, -8538, -8585, 8412, 1958, -8487, 7248, 4987, -6079, 9427, -6207, -7873, 688, 224, 6792, -4150, 3345, 826, 1885, 6463, -5269, 3068, 9649, -1354, 3159, 4975, 514, -3071, -4355, -1615, 9427, 8343, 978, 7914, -1876, 1160, -898, -8431, 6245, 8760, 8514, 9857, 9505, -3602, -4124, -4124, 209, 855, -253, -7232, -7598, 6813, -565, -8739, 2886, 3289, -4339, 7846, -3820, 3001, -3235, -3146, -2535, -1444, 8976, -8434, 8190, -4185, 5847, -1020, -6020, -3935, -4267, 2030, 6882, -7707, -5213, 5284, -2061, -325, 2911, 2346, 1080, -2111, -4929, -9101, 1548, -4817, -7526, 2688, -3589, -4414, 6269, -1423, -6735, -7204, -6624, -7561, 7775, -2650, -6843, 735, 3824, 4592, -5199, -1922, 1757, 5662, -1272, 4208, 400, 2883, 720, 9179, 1056, 3310, -7095, -3834, -2683, 4422, -2599, -6124, 1449, -5001, -5874, -7396, 9158, 2926, 4281, -9423, 8492, -1542, 1197, 6023, -9627, 4970, 28, 7002, 5204, 5292, 3901, 4640, 2994, -4487, -2102, -4481, -5347, 1164, 6773, 6277, 5759, -4250, -3920, 4843, 7763, -791, 8478, -7750, 7243, -4640, 6252, 8699, 2001, 9799, -5555, -3183, -6124, 4787, 1378, -4618, 3349, -5561, -2392, -1764, 9774, -5698, 1775, -9616, -6353, -3622, -4907, 1356, 5728, -1902, -3203, 5268, 4414, 1096, -1268, -940, 179, -7824, 9845, 6093, 9096, -163, 3713, -297, 6100, 6544, 6167, 6209, -5476, 4519, 6391, 289, 1823, 7256, 5528, 9069, -4861, 2571, -5339, 2657, -1383, -3771, -4709, -1915, -8712, -816, 2266, -8078, -2451, -6189, -5910, -8027, 4915, -5900, -2979, 2028, 4015, -2885, 8665, 3121, 8692, -2479, -2824, -5047, -3116, -5621, -7248, -1462, 1114, -907, 5481, 6605, 8767, -506, 3412, -7848, 7333, -634, 3219, -3273, 3031, -1867, 1765, 1522, -7747, -7195, -9110, 6320, -3756, 5207, 1190, 6370, -3143, 6745, -2833, 1926, -985, -3126, -9019, 9744, -9202, 8817, -3722, -2002, 8111, 4457, 4973, 4275, 7125, 3828, -3613, -3104, 6544, 6764, 6585, -4240, -3961, -2756, -5445, -1143, -9788, -6964, 3690, -1158, -6795, 9726, 7048, 8414, -4774, 8405, -8837, 3163, -9265, 877, -6371, -5901, 5427, 243, -8247, -2653, -2356, -1228, -3403, -9628, 4430, 1937, -8435, 3876, -9615, -1366, -8793, 2136, 496, 3957, -1316, 822, 7134, -8320, -8789, -33, 1803, -2617, 4625, -4334, -46, 6870, -9895, -3381, -6536, 7742, 6356, -1725, 2283, -2267, 532, -3571, 4288, -40, 4714, 2145, -8173, -9782, -2821, 8418, 7097, -7187, -2945, 830, -1110, 7886, -821, -3453, -4313, -7945, 7020, -2473, -4510, 4867, -1992, 3770, 1031, 6714, 9721, -1399, -5297, -3545, -767, -2432, -8088, -6801, 1689, 7271, 673, 9178, 7565, 8263, -213, 6693, 843, 940, 9793, 7536, -1742, 266, 9280, -402, 8335, 5091, -3019, -3904, -6956, -7393, 1053, 9830, -403, 6191, 7652, -5990, -7726, 741, -7996, -3664, -5601, 9598, 6603, 3714, 8336, 5228, -3757, 7069, -371, -9984, 2625, -5485, -14, 8394, 7757, 4705, -5743, -3141, 6589, 8246, 7689, 5709, 9201, 9740, -5969, -3092, -5806, -1012, -7508, -9508, -9229, -6246, -5063, -8889, -4678, -7761, -4711, 3076, -2699, 224},
                45)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

}
