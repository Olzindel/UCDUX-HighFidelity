package TimotheeTHIBAULT.ui;

import java.util.Stack;

public class BackHistory {
    private static BackHistory ourInstance = new BackHistory();
    private Stack<BackHistoryNode> historyStack = new Stack<>();

    private BackHistory() {
    }

    public static BackHistory getInstance() {
        return ourInstance;
    }

    public void addInHisory(BackHistoryNode addedNode) {
        historyStack.add(addedNode);
    }

    public BackHistoryNode lastWindowState() {
        if (historyStack.empty()) {
            return null;
        }
        return historyStack.pop();
    }

    public boolean isEmpty() {
        return historyStack.isEmpty();
    }

    public void clear() {
        historyStack.clear();
    }
}
