int centuryFromYear(int year) {
    return (year / 100) + ((year % 100 == 0) ? 0 : 1);
}

