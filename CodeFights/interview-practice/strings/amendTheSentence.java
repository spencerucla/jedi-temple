String amendTheSentence(String s) {
    String[] split = s.split("(?=[A-Z])");
    return String.join(" ", split).toLowerCase();
}

