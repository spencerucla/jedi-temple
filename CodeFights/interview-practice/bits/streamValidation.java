boolean streamValidation(int[] stream) {
    int left = 0;
    for (int b : stream) {
        if (left == 0) {
            if ((0x80 & b) == 0x0) {
                // left = 0
            } else if ((0xE0 & b) == 0xC0) {
                left = 1;
            } else if ((0xF0 & b) == 0xE0) {
                left = 2;
            } else if ((0xF8 & b) == 0xF0) {
                left = 3;
            } else {
                return false;
            }
        } else {
            if ((0xC0 & b) == 0x80) {
                left--;
            } else {
                return false;
            }
        }
    }
    return (left == 0);
}

