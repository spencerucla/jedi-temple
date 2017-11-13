String findProfession(int level, int pos) {
    return findProfession(level-1, pos-1, Job.ENGINEER);
}

enum Job {
    ENGINEER,
    DOCTOR;
    Job toggle() {
        if (this.equals(ENGINEER)) {
            return DOCTOR;
        } else {
            return ENGINEER;
        }
    }
    public String toString() {
        if (this.equals(ENGINEER)) {
            return "Engineer";
        } else {
            return "Doctor";
        }
    }
};

String findProfession(int level, int pos, Job cur) {
    if (level == 0) {
        return cur.toString();
    }
    int half = (int) Math.pow(2, level-1);
    if (pos < half) {
        return findProfession(level-1, pos, cur);
    } else {
        return findProfession(level-1, pos-half, cur.toggle());
    }
}
