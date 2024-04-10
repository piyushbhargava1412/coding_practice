package main.java.leetcode.common;

public class PriorityHeap {
    int[] array;
    int priority;
    final static int MIN_PRIORITY = -1;
    final static int MAX_PRIORITY = 1;

    public PriorityHeap(int[] array, int priority) {
        this.array = array;
        this.priority = priority;
    }

    public void createHeap(int len) {
        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(i, len);
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public void printTree() {
        int numLevels = array.length / 2 - 1;
        int levelCounter = 0;
        int nodesPrinted = 0;
        while (nodesPrinted < array.length) {
            int numNodes = (int) Math.pow(2, levelCounter);
            int gapWidth = numNodes == 1 ? 0 : (int) Math.pow(2, numLevels - levelCounter) - 1;
            int paddingWidth = (int) Math.pow(2, numLevels - levelCounter - 1) - 1;
            for (int i = 0; i < paddingWidth; i++)
                System.out.print("  ");
            for (int i = 0; i < numNodes; i++) {
                System.out.printf("%02d", array[nodesPrinted + i]);
                if (i + nodesPrinted == array.length - 1) {
                    nodesPrinted += i + 1;
                    break;
                }
                if (i != numNodes - 1) {
                    for (int j = 0; j < gapWidth; j++)
                        System.out.print("  ");
                }
            }
            for (int i = 0; i < paddingWidth; i++)
                System.out.print("  ");
            nodesPrinted += numNodes;
            levelCounter++;
            System.out.println();
            System.out.println();
            if (levelCounter >= numLevels) break;
        }
    }

    public void sort(int len) {
        if (len == 1) return;

        // create priority heap for the given length
        createHeap(len);

        // pop top element and put it at the end of the array
        int max = array[0];
        array[0] = array[len - 1];
        array[len - 1] = max;

        // call sort again for remaining elements
        sort(len - 1);
    }

    private void heapify(int i, int len) {
        int priorityIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (priority == MAX_PRIORITY) {
            if (leftIndex < len && array[leftIndex] > array[priorityIndex])
                priorityIndex = leftIndex;
            if (rightIndex < len && array[rightIndex] > array[priorityIndex])
                priorityIndex = rightIndex;
        } else {
            if (leftIndex < len && array[leftIndex] < array[priorityIndex])
                priorityIndex = leftIndex;
            if (rightIndex < len && array[rightIndex] < array[priorityIndex])
                priorityIndex = rightIndex;
        }

        if (priorityIndex != i) {
            int temp = array[priorityIndex];
            array[priorityIndex] = array[i];
            array[i] = temp;

            heapify(priorityIndex, len);
        }
    }

    public static void main(String[] args) {
        int[] nums = {13, 10, 9, 1, 3, 5, 4, 6, 8, 15, 17};
        final PriorityHeap priorityHeap = new PriorityHeap(nums, MAX_PRIORITY);

//        priorityHeap.createHeap(nums.length);
//        priorityHeap.printTree();

        priorityHeap.sort(nums.length);
        priorityHeap.printArray();
    }
}
