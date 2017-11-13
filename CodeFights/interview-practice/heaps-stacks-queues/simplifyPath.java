String simplifyPath(String path) {
    LinkedList<String> list = new LinkedList<String>();
    String[] dirs = path.split("/");
    for (String dir : dirs) {
        System.out.println(dir);
        if (dir.equals(".") || dir.equals("")) {
            continue;
        } else if (dir.equals("..")) {
            if (!list.isEmpty()) {
                list.removeLast();
            }
        } else {
            list.addLast(dir);
        }
    }
    if (list.isEmpty()) {
        return "/";
    }
    StringBuilder sb = new StringBuilder();
    while (!list.isEmpty()) {
        System.out.println(list.peekFirst());
        sb.append("/").append(list.removeFirst());
    }
    return sb.toString();
}

